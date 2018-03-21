package textExcel;

import java.util.Scanner;

public class tectExcel {

	public static void main(String[] args)
	{

		Spreadsheet excel = new Spreadsheet();	
		
		Scanner input = new Scanner(System.in);
		String command = "";
		while(command.equals("quit") != true){
			System.out.println("Hi there, Enter Command: ");
			command = input.nextLine();
			System.out.println(excel.processCommand(command));
		}
	}
}
	
