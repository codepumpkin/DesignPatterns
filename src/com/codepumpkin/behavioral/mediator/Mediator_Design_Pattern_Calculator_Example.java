package com.codepumpkin.behavioral.mediator;

import java.util.HashSet;

public class Mediator_Design_Pattern_Calculator_Example {

	public static void main(String[] args) {

		CalculatorMediator calculatorMediator = new CalculatorMediator();
		Operation add = new Operation("Add",calculatorMediator){
			double performOperation(double operand1, double operand2)
			{
				return operand1 + operand2;
			}
		};
		
		Operation sub = new Operation("Sub",calculatorMediator){
			double performOperation(double operand1, double operand2)
			{
				return operand1 - operand2;
			}
		};
		
		Operation mul = new Operation("Mul",calculatorMediator){
			double performOperation(double operand1, double operand2)
			{
				return operand1 * operand2;
			}
		};
		
		// 1 + 30  = 31 
		add.performOperation(1);
		add.performOperation(30);
		
		// previous result - 3 = 28
		sub.performOperation(3);
		
		// previous result * 3 = 84
		mul.performOperation(3);
		
		System.out.println("Answer is : " + calculatorMediator.previousResult);
	}

}


class CalculatorMediator {

	
	HashSet<Operation> operations = new HashSet<>();
	double previousResult = 0;


	public void notifyMediator(Operation operation) {
		this.previousResult = operation.getResult();
	}
}


abstract class Operation {

	private String operationName;
	private double result;
	private CalculatorMediator calculatorMediator;
	
	
	
	public double getResult() {
		return result;
	}

	Operation(String operationName, CalculatorMediator calculatorMediator) {
		this.operationName = operationName;
		this.calculatorMediator = calculatorMediator;
	}

	public void performOperation(double operand)
	{
		result =  performOperation(calculatorMediator.previousResult, operand);
		calculatorMediator.notifyMediator(this);
	}
	
	abstract double performOperation(double operand1, double operand2);
	
}

