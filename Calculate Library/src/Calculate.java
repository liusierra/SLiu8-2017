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
	
	//accepts a double and returns a double.
	//Converts an angle measure given in radians into degrees 	
	public static double toDegrees (double operand) {
	    return (operand*3.14159/180);}

	//Converts an angle measure given in radians into degrees.
	//Accepts a double and returns a double
    public static double toRadians  (double operand) {
        return (operand*180/3.14159);}
    
    //Provides the coefficients of a quadratic equation in standard form (a, b and c) 
    //and returns the value of the discriminant
    public static double discriminate (double a, double b, double c) {
    	return (b*b-4*a*c);}
    
    //Converts mixed number into an improper fraction
    //Accepts three integers and returns a string
    public static int toImproperFrac (int number, int numberb, int numberc) {
    	return (number*numberc+numberb/numberc);}
    
    //Converts an improper fraction into a mixed number. 
    //Accepts a two integers and returns a String
    public static String toMixedNum (int top, int bottom) {
    	return (top/bottom) + "_" + (top%bottom) + "/" + (bottom);
    }
    	
    //Converts a binomial multiplication of the form (ax+b)(cx+d)
    //into a quadratic equation of the form ax^2+ bx + c.
    public static String foil (int a, int b, int c, int d, String n) {
    	return (a*n * a*n + b*n +c);
    }
    
    //Determines whether or not one integer is evenly divisible by another
    public static boolean isDivisbleBy (int number1, int number2) {
      if (number1 % number2 == 0); {
    	  return true;}
    }
    
    //Returns the absolute value of the number passed
    public static double adsValue (double a){
      if ( a>= 0)
    	  return a;
      if (a < 0)
    	  return (a--a--a);}
     
    //Returns the larger of the doubles passed
    public static double max (double a, double b){
      if (a >= b)
         return (a);
     if (a <= b);
         return (b);}
    
     //Accepts three doubles and returns the largest double
     public static double max (double numbera, double numberb, double numberc){
    	 if (numbera >  numberb && numbera > numberc)
    		 return (numbera) ;
     }else if (numberb > numbera && numberb > numberc ) {
    		 return (numberb) ;
     } else {
        	 return numberc;
     }

     //Returns the smaller value of the integers passed
     public static int min (int a, int b) {
    	 if (a>b) 
    		 return a;
      else if  (b>a)
    		 return b;	 
      else if ( a==b)
    	  return (a=b);
     }
    	 
     //Rounds a double correctly to 2 decimal places and returns a double
     public static double round2 (double orig) {
    	 double result = 0.0;
    	 
    	 int tempInt = (int) (orig * 1000);
    	 int roundNum = tempInt % 10;
    	 tempInt = tempInt / 10;
    	 if ( roundNum >= 5 && tempInt < 0)
    		 tempInt++;
    	 else if (roundNum <= -5 && tempInt < 0)
    		 tempInt --;
    	 result = tempInt /100.0;
    	 return result;
     }
      
     //Raises a value to a positive integer power
     public static double exponent (double a, double i) {
    	  return Math.pow (a,i);
     }
     
     //Factorial returns the factorial of the value passed 
     public static int factorial (int number) {
    	 if (number == 0) {
             return 1;
         }
         int fact = 1; // this  will be the result
         for (int i = 1; i <= number; i++) {
             fact *= i;
         }
         return fact;
     }
     
     
     //isPirme determines whether or not an integer is prime
    	 public static boolean isPrime (int number) { 
    		 int sqrt = (int) Math.sqrt(number) + 1; 
    		 for (int i = 2; i < sqrt; i++) { 
    			 if (number % i == 0) { 
    				 // number is perfectly divisible - no prime return false
    				 return false;		 
    			 }else {
    			 return true;}
    		 }
    	 }

    		
     
     //Finds the greatest common factor of two integers
     public static int gcf (int numbera, int numberb) {
    	 for(int i = 1; i <= numbera && i <= numberb; ++i)
             // Checks if i is factor of both integers
             if(numbera % i==0 && numberb % i==0)
                 return i;
         }
    
     //sqrt returns an approximation of the square root of the value passed
     //rounds to two decimal places
     public static double sqrt (double number) {
        if (number< 0) {
        	throw new IllegalAgrumentException();
        }else {
        double guess =0;
        double sqrt  =0.1;
           while
        }
     
     }
     }
     
     