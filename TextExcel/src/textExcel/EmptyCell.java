package textExcel;
/*Sierra Liu
 * APCS 2 
 * 3/21/18
 */
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
