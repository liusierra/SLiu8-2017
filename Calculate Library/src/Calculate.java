/*Sierra Liu
 * September 6, 2017
 * Our self written math library...
 * It contain a series of methods to do basic math problems
 */
public class Calculate {
	//square the input
	public static int square (int operand) {
		return operand*operand;}
		
	public static int cube (int operand) {
		return operand*operand*operand;}
    
	public static double average (double operand,double number) {
		return (operand+number)/2;}

	public static double average (double numba, double number, double numbar) {
		return (numba+number+numbar)/3;}
	
	public static double toDegrees (double operand) {
	    return (operand*3.14159/180);}

    public static double toRadians  (double operand) {
        return (operand*180/3.14159);}
    
    public static double discriminate (double a, double b, double c) {
    	return (b*b-4*a*c);}
    
    public static int toImproperFrac (int a, int b, int c) {
    	return (a*c+b/c);}
    
    public static String toMixedNum (int top, int bottom) {
    	return (top/bottom) + "_" + (top%bottom) + "/" + (bottom);
    }
    	
    public static String foil (int a, int b, int c, int d, String n) {
    	return (a*n * a*n + b*n +c);
    }
    
    public static boolean isDivisbleBy (int number1, int number2) {
      if (number1 % number2 == 0); {
    	  return true;}
    }
    
    public static double adsValue (double a){
      return (+a);}
    
    public static double max (double a, double b){
      if (a >= b)
         return (a);
     if (a <= b);
         return (b);}
    
     public static double max (double a, double b, double c){
    	 if (a >  b && a > c)
    		 return (a) ;
    	 if (b > a && b > c )
    		 return (b) ;
         if (c > a && c > b )
        	 return (c);
     }

     public static int min (int a, int b) {
    	 if (a>b) 
    		 return a;
      else if  (b>a)
    		 return b;	 
      else if ( a==b)
    	  return (a=b);
     }
    	 
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
      
     public static double exponent (double a, double i) {
    	  return Math.pow (a,i);
    	  
     }
     public static int gcf (int a, int  b) {
    	 for(int i = 1; i <= a && i <= b; ++i)
         {
             // Checks if i is factor of both integers
             if(a % i==0 && b % i==0)
                 return i;
         }
     }
     
     public static double sqrt () {
     }