package textExcel;

import java.util.Scanner;

public class textExcel
{
	
	
	public static void main(String[] args)
	{
		/*
		TestsALL.Helper th = new TestsALL.Helper();
		Spreadsheet s = new Spreadsheet();
		System.out.println(th.getText());
		System.out.println(s.getGridText());
	}
		*/
		Scanner userInput = new Scanner (System.in);
		boolean go;
		System.out.println("Hello! Enter your command.");
	    // Add your command loop here
		while(go = true) {
			Spreadsheet sheet = new Spreadsheet();
			System.out.println(sheet.processCommand(userInput.next()));
			if(userInput.next().equals("quit"))
			{
				go = false;
				System.out.println("Thank you!");
			}
		}
		userInput.close();
	}
}

	
