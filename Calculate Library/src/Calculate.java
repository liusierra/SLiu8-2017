/*Sierra Liu
 * September 6, 2017
 * Our self written math library...
 * It contain a series of methods to do basic math problems
 */

    //square the input
public class Calculate {
	public static int square (int operand) {
		return operand*operand;}
		
	//Cube takes in an integer and returns the integer cubed
	public static int cube (int operand) {
		return operand*operand*operand;}
    
	// takes in two doubles and returns their average
	public static double average (double operand,double number) {
		return (operand+number)/2;}
	
    //takes in three doubles and returns their average
	public static double average (double numba, double number, double numbar) {
		return (numba+number+numbar)/3;}
	
	//Converts an angle measure given in radians into degrees.
	//Accepts a double and returns a double
    public static double toDegrees  (double operand) {
        return (operand*180/3.141592653589793);}
    
    //accepts a double and returns a double.
  	//Converts an angle measure given in radians into degrees 	
  	public static double toRadians (double operand) {
  	    return (operand*3.14159265358/180);}
  	
    //Provides the coefficients of a quadratic equation in standard form (a, b and c) 
    //and returns the value of the discriminant
    public static double discriminant (double a, double b, double c) {
    	return (b*b-4*a*c);}
    
    //Converts mixed number into an improper fraction
    //Accepts three integers and returns a string
    public static String toImproperFrac (int num, int numberb, int numberc) {
    	return (num*numberc + numberb)+ "/" + (numberc);}
    
    //Converts an improper fraction into a mixed number. 
    //Accepts a two integers and returns a String
    public static String toMixedNum (int top, int bottom) {
    	return (top/bottom) + "_" + (top%bottom) + "/" + (bottom);
    }
    	
    //Converts a binomial multiplication of the form (ax+b)(cx+d)
    //into a quadratic equation of the form ax^2+ bx + c.
    public static String foil (int a, int b, int c, int d, String n) {
    	return (a*c)+n+"^2"+"+"+(a*d+b*c)+n+(b*d);
    }
    
    //Determines whether or not one integer is evenly divisible by another
    public static boolean isDivisibleBy (int number1, int number2) {
      if (number1 % number2 == 0); {
    	  return true;}
    }
    
    //Returns the absolute value of the number passed
    public static double absValue (double num){
      if ( num>= 0)
    	  return num;
    	  return num-num-num;}
    
     
    
    //Returns the larger of the doubles passed
    public static double max (double a, double b){
      if (a >= b)
         return (a);
     if (a <= b);
         return (b);}
    
     //Accepts three doubles and returns the largest double
     public static double max (double numbera, double numberb, double numberc){
    	 if ((numbera >  numberb) && (numbera > numberc))
    		 return (numbera) ;
    	 if (numberb > numbera && numberb > numberc ) 
    		 return (numberb) ;
        	 return numberc;
     }

     
     //Returns the smaller value of the integers passed
     public static int min (int num, int numb) {
    	 if (num>=numb) 
    		 return numb;
    		 return num;	
     }
    	

     public static double round2 (double numToBeRounded){
    	 int answer = ((int)(numToBeRounded * 100));
    	 if ((numToBeRounded * 100)-answer >= .5){
    		 double roundup = ((int)(numToBeRounded*100)+1)/100.00;
    		 return roundup;		
	 }
	 
    	 else {
		 double rounddown = (int)(numToBeRounded*100)/(100.00);
		 return rounddown;
	 }
}
     //returns value to a certain exponent
     public static double exponent(double base, double power){
    	 if(power < 0){
    		 throw new IllegalArgumentException("Input is negative");
    	 }
    	 	double answer = 1.0;
    	 	for(int i = 0; i < power; i++){
    	 	answer *= base;
    	 	}
    	 		return answer;
     }
     //returns factorial
     public static int factorial(int num1){
    	 int answer = 1;
    	 if(num1 < 0){
    		 throw new IllegalArgumentException("Input is negative");
    	 }
    	 for(int i = 1; i <= num1; i++){
		answer *= i;
	}
	return answer;
}
     //returns if a number is prime or not
     public static boolean isPrime(int number){
         int counter = 0;
         if(number <= 0){
             throw new IllegalArgumentException("Your input is 0 or a negative number");
         }
         else if(number > 0){//checks if the number is positive
             for(int i = 1; i <= number; i++){
                 if(isDivisibleBy(number, i)){
                     counter++;
                     //sets up a counter to keep track of the times the number is divisble by a number
                 }
             }
             if(counter == 2){
            	 //if the number is only divisible by 1 and itself
                 return true;
             }
             else{
                 return false;
             }
         }
         else{
        	 //if the number is 0 or negative
             return false;
         }
     }
     
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
     //returns the roots of a quadratic equation
     public static String quadForm(int a, int b, int c){
    	 double x = (double)(a);
    	 double y = (double)(b);
    	 double z = (double)(c);
    	 double solution1 = 0;
    	 double solution2 = 0;
    	 String returnValue = "";
    	 @SuppressWarnings("unused")
    	 String returnValue2 = "";
    	 //if discriminant is less than 0
    	 if(Calculate.discriminant(a, b, c) < 0){
    		 returnValue = "no real roots";
    		 	return returnValue;
    	 	} else if(Calculate.discriminant(a, b, c) == 0){
    	 		solution1 = -b/2*a;
    	 		solution1 = Calculate.round2(solution1);
    	 		returnValue = String.valueOf(solution1);
    	 		return returnValue;
    	 	} else{
		solution1 = Calculate.round2((-b - (Calculate.sqrt(Calculate.discriminant(x, y, z))))/(2*a));
		solution2 = Calculate.round2((-b + (Calculate.sqrt(Calculate.discriminant(x, y, z))))/(2*a));
		if(solution1>solution2){
			returnValue = String.valueOf(solution1);
			returnValue2 = String.valueOf(solution2);
			return solution2 + " and " + solution1;
		} else{
			return solution1 + " and " + solution2;
		}
	}
}
}

     
     