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
	}

