//Sierra Liu
// 19 December 2017
//APCS 2
//FracCalc with Objects
package fracCalc;

import java.util.Scanner;

public class frac_calc {
		    public static void main(frac_calc[] args) {
		    	//ask the user for expressions to calculate
		        boolean done = false;
		        String userExpr;
		        Scanner input = new Scanner(System.in);
		        while(!done){
		        	//loops until the user types quit
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
    	String number1 = splitString[0];
    	String operator = splitString[1];
    	String number2 = splitString[2];
    	int [] operand1 = new int[3];
    	int [] operand2 = new int[3];
    	int []result = new int[2];
    	//Set the whole number, numerator, and denominator into an int Array
    	operand1 = parseOperands(number1);
    	operand2 = parseOperands(number2);
    	//Change the int arrays into improper fractions, also int array
    	int []improperFrac1 = toImproperFrac(operand1[0], operand1[1], operand1[2]);
    	int []improperFrac2 = toImproperFrac(operand2[0], operand2[1], operand2[2]);
    	//Check the operators to call different methods
    	if(operator.equals("/")){
    		result = divideAnswer(improperFrac1[0], improperFrac1[1], improperFrac2[0], improperFrac2[1]);
    	}else if(operator.equals("*")){
    		result = multiplyAnswer(improperFrac1[0], improperFrac1[1], improperFrac2[0], improperFrac2[1]);
    	} else if(operator.equals("+")){
    		result = addAnswer(improperFrac1[0], improperFrac1[1], improperFrac2[0], improperFrac2[1]);
    	} else{
    		result = subtractAnswer(improperFrac1[0], improperFrac1[1], improperFrac2[0], improperFrac2[1]);
    	}
    	//Use the result and change it into a mixed number
    	int[] mixedNum = toMixedNum(result[0], result[1]);
    	//Return result to main, if the whole number is 0, just return numerator and denominator
    	if(mixedNum[0] == 0){
    		return simplifyResult(mixedNum[1], mixedNum[2]);
    	}else{
    		//String concatenation
    		String wholeNum = mixedNum[0] + "";
    		//check for the 0 result
    		if(simplifyResult(mixedNum[1], mixedNum[2]).equals("0")){
    			return wholeNum;
    		}else{
    			return wholeNum + "_" + simplifyResult(mixedNum[1], mixedNum[2]);
    		}
    	}	
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    public static int[] parseOperands(String operand){
    	String [] splitFraction = operand.split("_");
    	String wholeNum;
    	String num; 
    	String dem;
    	//Make new int array ahead of time
    	int []arrayForFraction = new int[3];
    	if(splitFraction.length == 2){
    		wholeNum = splitFraction[0];
    		String[] splitAgain = splitFraction[1].split("/");
    		if(splitAgain.length == 1){
    			//If the length is one, then that means no denominator. So just set it to one
    			num = splitAgain[0];
    			dem = "1"; 
    		}else{
    			//otherwise, set num and dem to parts of a string array
    			num = splitAgain[0];
    			dem = splitAgain[1];
    		}
    	} else{
    		//Set whole Num to 0 because there is no whole Num
    		wholeNum = "0";
    		String[] splitAgain = splitFraction[0].split("/"); 
    		if(splitAgain.length == 1){
    			num = splitAgain[0];
    			//no denominator, sets to 1
    			dem = "1"; 
    		}else{
    			num = splitAgain[0];
    			dem = splitAgain[1];
    		}
    	}
    	//changes each of the strings to an int
    	arrayForFraction[0] = Integer.parseInt(wholeNum);
    	arrayForFraction[1] = Integer.parseInt(num);
    	arrayForFraction[2] = Integer.parseInt(dem);
    	//sets to int array and returns it
    	return arrayForFraction;
    	
    }
    public static int[] toImproperFrac(int wholeNum, int num, int dem){
    	// if the wholeNum is negative, have to subtract numerator instead of adding it
    	if(wholeNum < 0){
    		num = wholeNum*dem - num;
    	}else{
    		num = (wholeNum*dem) + num;
    	}
    	//int array to store results
		int [] numAndDem = new int[2];
		numAndDem[0] = num;
		numAndDem[1] = dem;
		return numAndDem;
	}
    public static int[] addAnswer(int num1, int dem1, int num2, int dem2){
    	int[] numAndDem = new int[2];
    	int finalDem;
    	int finalNum;
    	//test to see if denominators are same, easier to add
    	if(dem1 != dem2){
    		finalDem = dem1*dem2;
    		finalNum = num1*dem2 + num2*dem1;
    	} else{
    		finalDem = dem1;
    		finalNum = num1 + num2;
    	}
    	numAndDem[0] = finalNum;
    	numAndDem[1] = finalDem;
    	return numAndDem;
    }

    public static int[] subtractAnswer(int num1, int dem1, int num2, int dem2){
    	//Change the sign
    	dem2 = dem2*-1;
    	return addAnswer(num1, dem1, num2, dem2);
    }
    public static int[] multiplyAnswer(int num1, int dem1, int num2, int dem2){
    	//Multiply numerators and denominators
    	int[] numAndDem = new int[2];
    	int finalDem = dem1*dem2;
    	int finalNum = num1*num2;
    	numAndDem[0] = finalNum;
    	numAndDem[1] = finalDem;
    	return numAndDem;
    }
    public static int[] divideAnswer(int num1, int dem1, int num2, int dem2){
    	//Temp for original numerator 2
    	int temp = num2;
    	num2 = dem2;
    	dem2 = temp;
    	//Call multiply answer with the reciprical of the second fraction 
    	return multiplyAnswer(num1, dem1, num2, dem2);
    }
    public static int greatestCommonFactor(int num1, int num2){
    	// absolute value of the numerator
    	int biggerNum;
    	int smallerNum;
    	//Check which is larger
    	if(num1 < 0){
    		num1 = num1*-1;
    	}
    	if(num2 < 0){
    		num2 = num2*-1;
    	}
    	if(num1 < num2){
    		biggerNum = num2;
    		smallerNum = num1;
    	} else{
    		biggerNum = num1;
    		smallerNum = num2;
    	}
    	if(biggerNum % smallerNum == 0){
    		return smallerNum;
    	}else{
    		return greatestCommonFactor(smallerNum, biggerNum % smallerNum);
    	}
    }
    public static String simplifyResult(int numerator, int denominator){
    	//Check if the numerator is 0, simplifies whole equation
    	if(numerator == 0){
    		return "0";
    	} 
        //Call gcf
    	int gcf = greatestCommonFactor(numerator, denominator);
    	numerator = numerator/gcf;
    	denominator = denominator/gcf;
    	if(denominator == 1){
    		return numerator + "";
    		//otherwise, return both numerator and denominator
    	}else{
    		return numerator + "/" + denominator;
    	}
    }
    public static int[] toMixedNum(int numerator, int denominator){
    	int wholeNumber = numerator/denominator;
    	numerator = numerator%denominator;
    	//Bunch of tests to check that there are no multiple negatives in the answer, such as a negative in both numerator and denominator
    	if(wholeNumber < 0 && numerator < 0){
    		numerator = numerator*-1;
    	}
    	if(wholeNumber < 0 && denominator < 0){
    		denominator = denominator*-1;
    	}
    	if(numerator < 0 && denominator < 0){
    		denominator = denominator * -1;
    		numerator = numerator * -1;
    	}
    	//also makes sure that if answer is negative, the negative goes before whole number or numerator if there is no whole num
    	if(denominator < 0){
    		denominator = denominator * -1;
    		numerator = numerator * -1;
    	}
    	int[] mixedNum = {wholeNumber, numerator, denominator};
    	return mixedNum;
    }
    }
