
package textExcel;

public class Spreadsheet implements Grid
{
	private Cell[][] Excel = new Cell [getRows()][getCols()];
	
	public Spreadsheet(){
		newSheet();
	}
	
	@Override
	public String processCommand(String command)
	{
		//checks if the input is nothing
		if(command.length() == 0 || command.equals("quit")){
			return "";
		}
		
		//splits to 3 because the value assigned or trying to be assigned to cell may have spaces. 
		//e.g (A1 = "Hello")
		String[] arr = command.split(" ", 3);
		
		//gets rid of lowercase or uppercase
		arr[0]=arr[0].toUpperCase();
		
		//checks if the input is only 3 or less which could only be a cell and returns the value
		if(arr.length == 3){
			setCellValue(arr[0], arr[2]);
			return getGridText();
		
		// checks for clearing c
		}else if(arr[0].toLowerCase().contains("clear")){
			
			// clears only one cell
			if(arr.length == 2){
				clearOneCell(arr[1]);
				//returns the new grid 
				return getGridText();
	
			}else{
				
				//clears the entire grid by making an entirely new grid
				newSheet();
				return getGridText();
			}
			
		}else{
			//returns the value of the cell
			return inspectCell(arr[0]);
		}			
	}

	@Override
	public int getRows() //setting of 20 rows and 12 cols
	{
		return 20;
	}

	@Override
	public int getCols()
	{
		return 12;
	}

	@Override
	public Cell getCell(Location loc)
	{
		// uses spreadsheet location to find the location 
		return Excel[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText() {
		
		String gridText = "   |";
		for (int i = 65; i <= 76; i++) {
			gridText += (char)i + "         |";	
		}
		//skips to a new line after each row is finished
		gridText += "\n";
		for(int i=0; i < Excel.length; i++) {
			gridText+=i+1;
			if(i < 9) 
			{
				gridText +=  "  |";
				for(int j=0; j<Excel[i].length; j++) {
		// displays 10 characters
					gridText += Excel[i][j].abbreviatedCellText() + "|";
				}
			} else{ 
				//double digit numbers only have one space afterwards
				gridText += " |";
				for(int j=0; j<Excel[i].length; j++) {
					//should only display 10 characters
					gridText += Excel[i][j].abbreviatedCellText() + "|";
				}
			}
			gridText += "\n";
		}
		return gridText;
	}
	
	public String inspectCell(String cellName){
		//creates an instance of spreadsheetLocation to use 
		//the getRow and getCol methods
		SpreadsheetLocation loc = new SpreadsheetLocation(cellName);
		//returns the full value of the cell
		return (getCell(loc).fullCellText());
	}
	
		//clears the entire cell empty
	public void clearCell(){
		for(int i = 0; i < 12; i++){
			for(int j = 0; j < 20; j++){
				Excel [i][j] = new EmptyCell();
			}
		}
	}
		
	public void clearOneCell(String location) {
		//creating an instance of spreadsheetLocation to use 
		SpreadsheetLocation loc = new SpreadsheetLocation(location);
		//remakes the cell into an empty cell to get rid of the value it had
		Excel[loc.getRow()][loc.getCol()] = new EmptyCell();
	}
	public void newSheet(){
		//creates a new grid to make everything empty
		for(int i = 0; i < Excel.length; i++){
			for( int j = 0; j < Excel[i].length; j++){
				Excel[i][j] = new EmptyCell();
			}
		}
	}
	
	public void setCellValue(String loc, String value){
		//creates an instance of spreadsheetLocation
		//the getRow and getCol methods
		//calls different cell classes 
		SpreadsheetLocation area = new SpreadsheetLocation(loc);
		//checks for quotes
		if(value.contains("\"")){
			Excel[area.getRow()][area.getCol()] = new TextCell(value);
			//checks for percentage
		}else if(value.contains("%")){
			Excel[area.getRow()][area.getCol()] = new PercentCell(value);
			
			//checks for parenthesis
		}else if(value.endsWith(")")){
			Excel[area.getRow()][area.getCol()] = new FormulaCell(value, Excel);
			
			//if there isn't anything then it has to be a value cell
		}else{
			Excel[area.getRow()][area.getCol()] = new ValueCell(value);
		}
		
	}
	
	
}
