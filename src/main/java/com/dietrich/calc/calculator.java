package com.dietrich.calc;

public class calculator {
    private final String operator;
    private final Double value1;
    private final Double value2;

    public calculator(String operator, Double value1, Double value2) {
        this.operator = operator;
        this.value1 = value1;
        this.value2 = value2;
    }

    public Double getResult() {
        return switch (operator) {
        case "+" -> value1 + value2;
        case "-" -> value1 - value2;
        case "*" -> value1 * value2;
        case "/" -> value1 / value2;
        default -> value1 + value2;
        };
    }

    public Double getValue2() {
        return value2;
    }

    public Double getValue1() {
        return value1;
    }

    public String getOperator() {
        return operator;
    }

}
