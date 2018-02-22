//Sierra Liu     
//APCS 2
//MS. Dreyer
//11/13/17
//FracCalc Parts a fraction

package fracCalc;
//FracCalc1
import java.util.Scanner;

	public class FracCalc {
		public static void main(String[] args){
		//Boolean variable to make loop run until user enters quit
			boolean testForWhile = true;
			String userInput = "";
			Scanner scan = new Scanner(System.in);
			while(testForWhile){
				System.out.println("What's your equation?");
				userInput = scan.nextLine();
			//check if the userinput is quit
				if(userInput.equals("quit")){
					testForWhile = false;
				}else{
					System.out.println(produceAnswer(userInput));
			}
		}
	}
	public static String produceAnswer(String input){ 
		//Split the string based on the spaces
    	String[] splitString = input.split(" ");
    	//Sets each operand and operator to a variable
    	String firstOperand = splitString[0];
    	String operator = splitString[1];
    	String secondOperand = splitString[2];
    	int [] operandOne = new int[3];
    	int [] operandTwo = new int[3];
    	int [] result = new int[2];
    	//Sets the whole number, numerator, and denominator into an int Array
    	//Order: whole number, numerator, denominator
    	operandOne = parseOperands(firstOperand);
    	operandTwo = parseOperands(secondOperand);
    	//change the int arrays into improper fractions, also int array
    	int []improperFracOperandOne = toImproperFrac(operandOne[0], operandOne[1], operandOne[2]);
    	int []improperFracOperandTwo = toImproperFrac(operandTwo[0], operandTwo[1], operandTwo[2]);
    	//check the operators to call different methods
    	if(operator.equals("/")){
    		result = divideAnswer(improperFracOperandOne[0], improperFracOperandOne[1], improperFracOperandTwo[0], improperFracOperandTwo[1]);
    	}else if(operator.equals("*")){
    		result = multiplyAnswer(improperFracOperandOne[0], improperFracOperandOne[1], improperFracOperandTwo[0], improperFracOperandTwo[1]);
    	} else if(operator.equals("+")){
    		result = addAnswer(improperFracOperandOne[0], improperFracOperandOne[1], improperFracOperandTwo[0], improperFracOperandTwo[1]);
    	} else{
    		result = subtractAnswer(improperFracOperandOne[0], improperFracOperandOne[1], improperFracOperandTwo[0], improperFracOperandTwo[1]);
    	}
    	//Uses the result and change it into a mixed number
    	int[] mixedNum = toMixedNum(result[0], result[1]);
    	//Returns result to main, if the whole number is 0, just return numerator and denominator
    	if(mixedNum[0] == 0){
    		return simplifyResult(mixedNum[1], mixedNum[2]);
    	}else{
    		//String
    		String wholeNum = mixedNum[0] + "";
    		//Checks for the 0 result
    		if(simplifyResult(mixedNum[1], mixedNum[2]).equals("0")){
    			return wholeNum;
    		}else{
    			return wholeNum + "_" + simplifyResult(mixedNum[1], mixedNum[2]);
    		}
    	}
    		
    }

    public static int[] parseOperands(String operand){
    	String [] splitFraction = operand.split("_");
    	String wholeNum;
    	String numerator; 
    	String denominator;
    	//makes new int array ahead of time
    	int []arrayForFraction = new int[3];
    	if(splitFraction.length == 2){
    		wholeNum = splitFraction[0];
    		String[] splitAgain = splitFraction[1].split("/");
    		if(splitAgain.length == 1){
    			//If the length is one, then that means no denominator. So just set it to one
    			numerator = splitAgain[0];
    			denominator = "1"; 
    		}else{
    			//otherwise, set num and dem to parts of a string array
    			numerator = splitAgain[0];
    			denominator = splitAgain[1];
    		}
    	} else{
    		//sets whole Num to 0 because there is no whole Num
    		wholeNum = "0";
    		String[] splitAgain = splitFraction[0].split("/"); 
    		if(splitAgain.length == 1){
    			numerator = splitAgain[0];
    			//no denominator, automatically sets to 1
    			denominator = "1"; 
    		}else{
    			numerator = splitAgain[0];
    			denominator = splitAgain[1];
    		}
    	}
    	//changes each of the strings to an int
    	arrayForFraction[0] = Integer.parseInt(wholeNum);
    	arrayForFraction[1] = Integer.parseInt(numerator);
    	arrayForFraction[2] = Integer.parseInt(denominator);
    	//sets to int array and returns it
    	return arrayForFraction;
    	
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
		return numAndDem;
	}
    public static int[] addAnswer(int num1, int dem1, int num2, int dem2){
    	int[] numAndDem = new int[2];
    	int finalDem;
    	int finalNum;
    	//tests to see if denominators are same, easier to add
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
    	//changes the second number to opposite sign of whatever it originally was, then calls addAnswer with the new denominator
    	dem2 = dem2*-1;
    	return addAnswer(num1, dem1, num2, dem2);
    }
    public static int[] multiplyAnswer(int num1, int dem1, int num2, int dem2){
    	//multiply numerators and denominators together
    	int[] numAndDem = new int[2];
    	int finalDem = dem1*dem2;
    	int finalNum = num1*num2;
    	numAndDem[0] = finalNum;
    	numAndDem[1] = finalDem;
    		return numAndDem;
    }
    public static int[] divideAnswer(int num1, int dem1, int num2, int dem2){
    	//Placeholder to keep original numerator 2, used in later algorithm
    	if ( num1!= num2) {
    		int tempSecondNumerator = num2;
    		num2 = dem2;
    		dem2 = tempSecondNumerator;}
    	//calls multiply answer with the reciprical of the second fraction 
    	return multiplyAnswer(num1, dem1, num2, dem2);
    }
    
    
    public static int greatestCommonFactor(int num1, int num2){
    	//first takes absolute value of the numerator
    	int biggerNum;
    	int smallerNum;
    	//then checks for which is bigger
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
    		//keeps calling this method with smaller factors until there is no remainder.
    		return greatestCommonFactor(smallerNum, biggerNum % smallerNum);
    	}
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
    
    public static int[] toMixedNum(int numerator, int denominator){
    	int wholeNumber = numerator/denominator;
    	numerator = numerator%denominator;
    	//Tests to check that there are no multiple negatives in the answer, 
    	//such as a negative in both numerator and denominator
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
    	//also makes sure that if answer is negative, 
    	//the negative goes before whole number or numerator if there is no whole num
    	if(denominator < 0){
		denominator = denominator * -1;
		numerator = numerator * -1;
    	}
    	int[] mixedNum = {wholeNumber, numerator, denominator};
    		return mixedNum;
    }
	
	public static void error (int denominator, String operator) {
		//Handling "0" for denominator
		if (denominator == 0) {
			System.out.println("ERROR: Cannot divide by zero.");
		}
		if (operator != "+") {
		if (operator != "-") {
		if (operator != "*") {
		if (operator != "/") {
			System.out.println("ERROR: Input is in an invalid format.");
		}	}	}	}   }
	}
	
	