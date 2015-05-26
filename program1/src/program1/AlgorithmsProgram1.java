package program1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class AlgorithmsProgram1 {

	public static void main(String[] args) throws FileNotFoundException,
			UnsupportedEncodingException {
		Scanner fin = openFile(args);
		int location = 0;
		BinaryHeap heap = new BinaryHeap();

		while (fin.hasNextInt()) {
			location++;
			heap.add(new Node(fin.nextInt(), location));
		}

		// printHeap(heap);
		printToFile(heap);
		fin.close();
	}

	private static void printToFile(BinaryHeap heap)
			throws FileNotFoundException, UnsupportedEncodingException {
		int ctr = 0;

		PrintWriter writer = new PrintWriter("richest.output", "UTF-8");
		while (heap.size > 0 && ctr != 10000) {
			writer.println(heap.remove().toString());
			ctr++;
		}

		writer.close();
	}

	private static void printHeap(BinaryHeap heap) {
		int ctr = 0;

		System.out.println("Index \tValue");
		while (heap.size > 0 && ctr != 10000) {
			System.out.println(heap.remove().toString());
			ctr++;
		}

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
			kb.close();

			fin = new Scanner(new File(fname));

		} else {
			System.out.println("File Passed in");
			fin = new Scanner(new File(args[0]));
		}

		return fin;
	}

}
