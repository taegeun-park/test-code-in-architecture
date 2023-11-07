package org.example.sample;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertThrows;

public class CalculationRequestTest {
    @Test
    public void 유효한_숫자를_파싱할_수_있다() {
        //given
        String[] parts = new String[]{"2", "+", "3"};


        //when
        CalculationRequest calculationRequest = new CalculationRequest(parts);

        // then
        assertEquals(2, calculationRequest.getNum1());
        assertEquals("+", calculationRequest.getOperator());
        assertEquals(3, calculationRequest.getNum2());
    }

    @Test
    public void 세자리_수자가_넘어가는_유효한_숫자를_파싱할_수_있다() {
        //given
        String[] parts = new String[]{"232", "+", "123"};

        //when
        CalculationRequest calculationRequest = new CalculationRequest(parts);

        // then
        assertEquals(232, calculationRequest.getNum1());
        assertEquals("+", calculationRequest.getOperator());
        assertEquals(123, calculationRequest.getNum2());
    }

    @Test
    public void 유효한_길이의_숫자가_들어오지_않으면_에러를_던진다() {
        //given
        String[] parts = new String[]{"232", "+"};

        //when
        // then
        assertThrows(BadRequestException.class, () -> {
            new CalculationRequest(parts);
        });
    }

    @Test
    public void 유효하지_않은_연산자가_들어오면_에러를_던진다() {
        //given
        String[] parts = new String[]{"232", "x", "2"};

        //when
        // then
        assertThrows(InvalidOperationException.class, () -> {
            new CalculationRequest(parts);
        });
    }

    @Test
    public void 유효하지_않은_길이의_연산자가_들어오면_에러를_던진다() {
        //given
        String[] parts = new String[]{"232", "x---", "2"};

        //when
        // then
        assertThrows(InvalidOperationException.class, () -> {
            new CalculationRequest(parts);
        });
    }
}
