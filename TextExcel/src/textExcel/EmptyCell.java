package textExcel;

public class EmptyCell implements Cell {

	public EmptyCell() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String abbreviatedCellText() {
		//10 spaces
		return "          ";
	}

	@Override
	public String fullCellText() {
		return "";
	}

}
