package com.lambdaExpression;

public class ClosuresExample {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		//b=15; //throw compile time error
		doProcess(a, i -> {System.out.println(i + b);}); //variables used in lambda should be final or effective final.

	}
	
	
	public static void doProcess(int i, Process p) {
		p.process(i);
	}

}

interface Process {
	void process(int i);
}
