package org.example.sample;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

public class CalculatorTest {
    @Test
    public void 덧셈_연산을_할_수_있다() {
        // given
        long num1 = 2;
        String operator = "+";
        long num2 = 3;
        Calculator calculator = new Calculator();

        //when
        long result = calculator.calculate(num1, operator, num2);

        //then
        assertEquals(5, result); // junit assertion
        assertThat(result).isEqualTo(5); // assertJ assertion
    }

    @Test
    public void 뺄샘_연산을_할_수_있다() {
        // given
        long num1 = 3;
        String operator = "-";
        long num2 = 2;
        Calculator calculator = new Calculator();

        //when
        long result = calculator.calculate(num1, operator, num2);

        //then
        assertEquals(1, result); // junit assertion
        assertThat(result).isEqualTo(1); // assertJ assertion
    }

    @Test
    public void 곱셈_연산을_할_수_있다() {
        // given
        long num1 = 4;
        String operator = "*";
        long num2 = 3;
        Calculator calculator = new Calculator();

        //when
        long result = calculator.calculate(num1, operator, num2);

        //then
        assertEquals(12, result); // junit assertion
        assertThat(result).isEqualTo(12); // assertJ assertion
    }

    @Test
    public void 나눗셈_연산을_할_수_있다() {
        // given
        long num1 = 4;
        String operator = "/";
        long num2 = 2;
        Calculator calculator = new Calculator();

        //when
        long result = calculator.calculate(num1, operator, num2);

        //then
        assertEquals(2, result); // junit assertion
        assertThat(result).isEqualTo(2); // assertJ assertion
    }
    @Test
    public void 잘못된_연산자가_요청으로_들어올_경우_에러가_난다() {
        // given
        long num1 = 4;
        String operator = "x";
        long num2 = 2;
        Calculator calculator = new Calculator();

        //when
        //then
        assertThrows(InvalidOperationException.class, () -> {
            calculator.calculate(num1, operator, num2);
        });
    }
}
