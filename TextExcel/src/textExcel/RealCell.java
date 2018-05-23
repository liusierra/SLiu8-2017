package textExcel;

public abstract class RealCell implements Cell {
	private String value;
	
	//constructor
	public RealCell(String input) {
		value = input;
	}
	public String getValue() {
		return value;
	}
	@Override
	public abstract String abbreviatedCellText();

	@Override
	public abstract String fullCellText();
	//to be overridden
	public double getDoubleValue() {
		return Double.parseDouble(value);
	}
	//spaces added for the rest of the cell that is under 10 spaces e.g 5.0
	public String spaces(String num) {
		while(num.length() < 10) {
			num += " ";
		}
		return num;
	}
}
