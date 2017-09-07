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
    
    public static int toMixedNum (int a, int b) {
    	if {
    public static int foil (int a, int b, int c, int d, String n) {
        return (a*n*c*n+a*n*d+);}
