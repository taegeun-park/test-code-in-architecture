package org.example.sample;

public class CalculationRequest {

    // final을 통해 VO로 만들었음
    // VO의 특징 중 'VO 안의 변수들은 값이 항상 유효하다'를 만족시키기 위해 검증로직 필요
    private final long num1;
    private final long num2;
    private final String operator;

    public CalculationRequest(String[] parts) {
        if (parts.length != 3) {
            throw new BadRequestException();
        }
        String operator = parts[1];
        if (operator.length() != 1 || isInvalidOperator(operator)) {
            throw new InvalidOperationException();
        }

        this.num1 = Long.parseLong(parts[0]);
        this.num2 = Long.parseLong(parts[2]);
        this.operator = operator;
    }

    private static boolean isInvalidOperator(String operator) {
        return !operator.equals("+") &&
                !operator.equals("-") &&
                !operator.equals("*") &&
                !operator.equals("/");
    }

    public long getNum1() {
        return num1;
    }

    public long getNum2() {
        return num2;
    }

    public String getOperator() {
        return operator;
    }
}
