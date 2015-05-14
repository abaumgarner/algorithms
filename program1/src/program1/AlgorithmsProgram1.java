package program1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AlgorithmsProgram1 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner fin = openFile(args);

	}

	private static Scanner openFile(String[] args) throws FileNotFoundException {
		Scanner fin;
		
		// Checks to see if a file was passed into the program from command
		// line. If not prompt for the name.
		if (args.length == 0) {
			Scanner kb = new Scanner(System.in);

			System.out.println("No file passed in.");
			System.out
					.print("A file parameter was not passed in. Please specify the file name: ");

			String fname = kb.nextLine();
			fin = new Scanner(new File(fname));

		} else {
			System.out.println("File Passed in");
			fin = new Scanner(new File(args[0]));
		}

		return fin;
	}

}
