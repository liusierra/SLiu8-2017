/*Sierra Liu
 * September 6, 2017
 * This is the runner for the calculate library.
 * It is used to test the math in calculate
 */
public class DoMath {

	public static void main(String[] args) {
		System.out.println(Calculate.square(5));
		System.out.println(Calculate.cube(2));
		System.out.println(Calculate.average(10,20));
		System.out.println(Calculate.average(10,20,30));
		System.out.println(Calculate.toDegrees(3.14));
		System.out.println(Calculate. toRadians(180));
		System.out.println(Calculate. discriminate(10,5,1));
		System.out.println(Calculate. toImproperFrac(3,1,2));
		System.out.println(Calculate. toMixedNum(7,2));
		System.out.println(Calculate. foil(2, 3, 6, -7, "n"));	
		System.out.println(Calculate. isDivisbleBy	(4,2));		
		System.out.println(Calculate. adsValue (-1.0));
		System.out.println(Calculate. max (-1,-2));
		System.out.println(Calculate. max (-1,-2,-3));
		System.out.println(Calculate. min (-1,-2));
		System.out.println(Calculate. round2(-1.0134));
		System.out.println(Calculate. exponent (3.0,4));
		System.out.println(Calculate. factorial(1));
		}
}
