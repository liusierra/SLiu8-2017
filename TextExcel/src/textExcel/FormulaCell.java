package textExcel;

public class FormulaCell extends RealCell {
	Cell[][] Excel;
	//constructor
	public FormulaCell (String input, Cell[][] grid) {
		super(input);
		this.Excel = grid;
	}
	//10 spaces or more to be abbreviated 
	public String abbreviatedCellText() {
		String formulainput = getDoubleValue() + "";
		if (formulainput.length() > 10) {
			return formulainput.substring(0, 10); //only shows first ten
		} 
		else {
			return spaces(formulainput);
			//spaces method in real cell, adds spaces behind the value to fill the 10 spaces
		}
	}

	@Override
	public String fullCellText() {
		return getValue();
	}
	//calls get value
	
	public double getDoubleValue() {
		double dvalue = 0.0;
		String[] parts = getValue().split(" ");
	    //splits on spaces and checks for sum and avg command regardless of upper or lower case
		if(parts[1].toLowerCase().equals("sum") || parts[1].toLowerCase().equals("avg")) {
			String[] newCell= parts[2].split("-");
			//deals with stuff such as L14=(SUM B6-C12), splits the "to", and calls sumAndAvg
			dvalue = sumAndAvg(parts[1], newCell[0], newCell[1]);
	
		} else {
			//changes any cell identifier into the value of the cell
			for(int i=1; i<parts.length-1; i++) {
				if(Character.isLetter(parts[i].charAt(0))) {
					SpreadsheetLocation location = new SpreadsheetLocation(parts[i]);
					parts[i] = ((RealCell) Excel[location.getRow()][location.getCol()]).getDoubleValue()+"";	
				}
			}
			dvalue = Double.parseDouble(parts[1]);
			for(int i=2; i< parts.length-1; i++) {
				dvalue = calculate (dvalue, parts[i], parts[i+1]);
				i++;
			}
		}
		return dvalue;
	}
	//math operations
	public double calculate (double num1, String operator, String operand) {
		double result = 0.0;
		double num2 = Double.parseDouble(operand);
		if (operator.equals("+")) {
			result = num1 + num2;
		} else if (operator.equals("-")) {
			result = num1 - num2;
		} else if (operator.equals("*")) {
			result = num1 * num2;
		} else if (operator.equals("/")){
			result = num1 / num2;
		}
		return result;
		}
	
	//finds the sum or average from one cell to another
	public double sumAndAvg (String formula, String cell1, String cell2) {
		double sum = 0.0;
		int count = 0; //total numbers of cells that we went through
		SpreadsheetLocation loc1 = new SpreadsheetLocation(cell1);//e.g from A1 to B1
		SpreadsheetLocation loc2 = new SpreadsheetLocation(cell2);
		
		for(int i=loc1.getRow(); i<=loc2.getRow();i++) {
			for(int j=loc1.getCol(); j<=loc2.getCol(); j++) {
				sum+= ((RealCell)Excel[i][j]).getDoubleValue();	
				count++;
			}
		}
		
		if(formula.toLowerCase().equals("sum")) {
			return sum;
		} else { //avg
			return sum/(double)count; //sum divided by number of cells went through for avg
		}
	}
}

