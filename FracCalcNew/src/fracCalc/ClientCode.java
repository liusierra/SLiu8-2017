package fracCalc;

import java.util.Scanner;

	public class ClientCode {
	    public static void main(ClientCode[] args) {
	    	//ask the user for expressions to calculate
	        boolean done = false;
	        String userExpr;
	        Scanner input = new Scanner(System.in);
	        while(!done){//loops until the user types quit
	            System.out.println("Enter your expression: ");
	            userExpr = input.nextLine();
	            if(!(userExpr.equals("quit"))){
	                System.out.println(produceAnswer(userExpr));
	            }else{
	                done = true;
	            }
	        }
	    }
	    
	    public static String produceAnswer(String input){ 
			//split the string based on the spaces
	    	String[] splitString = input.split(" ");
	    	//Sets each operand and operator to a variable
	    	String firstOperand = splitString[0];
	    	String operator = splitString[1];
	    	String secondOperand = splitString[2];
	    	int [] operand1 = new int[3];
	    	int [] operand2 = new int[3];
	    	int []result = new int[2];
	    	//Sets the whole number, numerator, and denominator into an int Array
	    	//Order is whole number first, then numerator, then denominator
	    	operand1 = parseOperands(firstOperand);
	    	operand2 = parseOperands(secondOperand);
	    	//change the int arrays into improper fractions, also int array
	    	int []improperFrac1 = toImproperFrac(operand1[0], operand1[1], operand1[2]);
	    	int []improperFrac2 = toImproperFrac(operand2[0], operand2[1], operand2[2]);
	    	//check the operators to call different methods
	    	if(operator.equals("/")){
	    		result = divideAnswer(improperFrac1[0], improperFrac1[1], improperFrac2[0], improperFrac2[1]);
	    	}else if(operator.equals("*")){
	    		result = multiplyAnswer(improperFrac1[0], improperFrac1[1], improperFrac2[0], improperFrac2[1]);
	    	} else if(operator.equals("+")){
	    		result = addAnswer(improperFrac1[0], improperFrac1[1], improperFrac2[0], improperFrac2[1]);
	    	} else{
	    		result = subtractAnswer(improperFrac1[0], improperFrac1[1], improperFrac2[0], improperFrac2[1]);
	    	}
	    	//Uses the result and change it into a mixed number
	    	int[] mixedNum = toMixedNum(result[0], result[1]);
	    	//Returns result to main, if the whole number is 0, just return numerator and denominator
	    	if(mixedNum[0] == 0){
	    		return simplifyResult(mixedNum[1], mixedNum[2]);
	    	}else{
	    		//String concatenation
	    		String wholeNum = mixedNum[0] + "";
	    		//checks for the 0 result
	    		if(simplifyResult(mixedNum[1], mixedNum[2]).equals("0")){
	    			return wholeNum;
	    		}else{
	    			return wholeNum + "_" + simplifyResult(mixedNum[1], mixedNum[2]);
	    		}
	    	}
	    		
	    }
	    public static int[] toImproperFrac(int wholeNum, int numerator, int denominator){
	    	// if the wholeNum is negative, have to subtract numerator instead of adding it
	    	if(wholeNum < 0){
	    		numerator = wholeNum*denominator - numerator;
	    	}else{
	    		numerator = (wholeNum*denominator) + numerator;
	    	}
	    	//int array to store results
			int [] numAndDem = new int[2];
			numAndDem[0] = numerator;
			numAndDem[1] = denominator;
			return numAndDem;}
	    
	    //returns the greatest common factor
	     public static int gcf(int num1, int num2){
	    	 @SuppressWarnings("unused")
	    	 boolean numb = true;
	    	 if(numb = Calculate.isDivisibleBy(num1, num2)){
	    		 return num2;
	    	 }
	    	 if(num2 == 0){
	    		 return num2;
	    	 }else{
	    		 return gcf(num2, num1%num2);
			}
	}
	     private static int[] parseOperands(String operand){
		    	//Pass and parse the input to change to first operand, operator, and second operand
		        String wholeNumber = "";
		        String numerator = "";
		        String denominator = "";
		        int[] result = new int[3];//Storing 
		        String[] slash;
		        String[] splitUnderscore = operand.split("_");
		        //split the input by underscore
		        if(splitUnderscore.length == 2){
		        	//if the input is a mixed number
		            wholeNumber = splitUnderscore[0];
		            //set the first element to wholeNumber
		            slash = splitUnderscore[1].split("/");
		            //split at slash to find numerator/denominator
		            if(slash.length == 2){
		                numerator = slash[0];
		                denominator = slash[1];
		            }
		        }else{
		        	//if there is no wholeNumber
		            slash = operand.split("/");
		            if(slash.length == 2){
		                wholeNumber = "0";
		                numerator = slash[0];
		                denominator = slash[1];
		            }else{
		                wholeNumber = splitUnderscore[0];
		                numerator = "0";
		                denominator = "1";
		            }
		        }
		        result[0] = Integer.parseInt(wholeNumber);
		        result[1] = Integer.parseInt(numerator);
		        result[2] = Integer.parseInt(denominator);
		        return result;
		        
		    }
	     //returns the square root of a number
	     public static double sqrt(double a){
	    	 if(a < 0){
	    		 throw new IllegalArgumentException("Input is negative");
	    	 }
	    	 double num;
		 
	    	 	double squareRoot = a / 2;
	 
	    	 	do {
	    	 		num = squareRoot;
			squareRoot = (num + (a / num)) / 2;
	    	 	} while ((num - squareRoot) != 0);
	 
	    	 	return squareRoot;
	     }
	     
	    public static String simplifyResult(int numerator, int denominator){
	    	//first checks if the numerator is 0, simplifes whole equation
	    	if(numerator == 0){
	    		return "0";
	    	} 
	    	//calls gcf and divides both num and dem by it
	    	int gcf = greatestCommonFactor(numerator, denominator);
	    	numerator = numerator/gcf;
	    	denominator = denominator/gcf;
	    	if(denominator == 1){
	    		//String concatenates answer, if denominator is 1, just return the numerator
	    		return numerator + "";
	    		//otherwise, return both numerator and denominator
	    	}else{
	    		return numerator + "/" + denominator;
	    	}
	    }
