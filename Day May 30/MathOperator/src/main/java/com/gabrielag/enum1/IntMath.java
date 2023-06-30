/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.gabrielag.enum1;

/**
 *
 * @author Gabriela Gutierrez
 */
public class IntMath {
    public int calculate(MathOperator operator, int operand1, int operand2){
        switch(operator){
            case PLUS:
                return operand1 + operand2;
            case MINUS:
                return operand1 - operand2;
            case MULTIPLY:
                return operand1 * operand2;
            case DIVIDE:
                return operand1 / operand2;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
