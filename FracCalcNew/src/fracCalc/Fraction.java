package fracCalc;

public class Fraction {

	    private int wholeNumber;
	    private int numerator;
	    private int denominator;
	    public Fraction(String operand) {
		}

	    
	   
	    public int getWhole(){
	        return wholeNumber;
	    }
	    public int getNume(){
	        return numerator;
	    }
	    public int getDenom(){
	        return denominator;}
	    
	    public void setDenominator(int denominator) {
	    		this.denominator = denominator;
	    }
	    	
	    public void setWhole(int whole) {
	    		this.wholeNumber = whole;
	    	}
	    	
	    public void setNumerator(int numerator) {
	    		this.numerator = numerator;
	    }
	}