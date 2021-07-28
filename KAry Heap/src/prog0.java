import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author mishawnlolis, mlolis1@lsu.edu, 89-127-3262
 * @author Kaden Wyble, kwyble3@lsu.edu, 89-924-0787
 */

public class prog0 {

	public static void main(String[] args) throws FileNotFoundException {
	
		//inputScanner
		System.out.println("Please choose the file you would like to use for import");
		Scanner inputScanner = GetInputFile(null); 
		//outputScanner
		System.out.println("Please choose the file you would like to use for export");
		PrintWriter output = GetOutputFile(null); 
		
		Scanner sizeScanner = inputScanner;
		
		//Timer Start
		long start = System.nanoTime();
		
		
		//int count = getListCount (inputScanner);
		heap karyArray = new heap(500000);
		
		//Input
		while(inputScanner.hasNextLine()) { 
			
			//Getting String, Function + Number
			String toDo = inputScanner.next().trim(); 

			//Adding Process
			if (toDo.equalsIgnoreCase("in")){
				int toAdd = inputScanner.nextInt();
				//System.out.println("Adding : " + toAdd);
				heap.insert(toAdd);
			}
			//Extract Process
			else if (toDo.equalsIgnoreCase("ex")){
				output.println("Extracting Min: " + heap.extractMin());
			}
		}
		
		//Timer End
        long end = System.nanoTime();
        output.println("Time: "+((end - start)/1000) + " Microseconds");
        

		//Print it
		
		//Done
		System.out.println("Complete, Thank you!");
		output.close();
	}
	
/**
 * Gets the count of List for array
 * @param inputScanner
 * @return
 */
	public static int getListCount (Scanner in) {
		int count = 0;
		while(in.hasNext()) { 
			//Getting String, Function + Number
			String toDo = in.next().trim(); 

			//Adding Process
			if (toDo.equalsIgnoreCase("in")){
				count++;
			}
			//Extract Process
			else {
				//Nothing
			}
		}
		
		
		
		return count;
	}
	
/**
 * Gets Input File	
 * @param UserPrompt
 * @return
 * @throws FileNotFoundException
 */
	public static Scanner GetInputFile(String UserPrompt) throws FileNotFoundException {
		//variable Initialization
		Scanner input = new Scanner(System.in); //Scanner that will be returned
		String inputString; //The string used to store variables
		File file; // The file
		System.out.println("Enter input filename: ");//Enter file
		inputString = input.nextLine();
		file = new File(inputString);//Making file

			try {
				Scanner inputScan = new Scanner(file);
				return inputScan;
			}
			catch (FileNotFoundException e){
				System.out.println("File specified '"+ inputString + "' does not exist. Would you like to continue? <Y/N>");
				String choice = input.nextLine();
				while (true) {
					if (choice.equalsIgnoreCase("Y")) {
						return GetInputFile(null);
					}
					else if (choice.equalsIgnoreCase("N")) {
						throw e;
					}
					else {
						System.out.println("Please choose 'Y/N'");
						choice = input.nextLine();
					}
				}
			}
	}

/**
 * Gets Output File
 * @param UserPrompt
 * @return
 * @throws FileNotFoundException
 */
	public static PrintWriter GetOutputFile(String UserPrompt) throws FileNotFoundException {
		//variable Initialization
		Scanner input = new Scanner(System.in); 
		String OutputWriter;
		File file; 
		//Enter file
		System.out.println("Enter Output filename: ");
		OutputWriter = input.nextLine();
		file = new File(OutputWriter);
		//Making File
			try {
				PrintWriter OutputWrite = new PrintWriter(file);
				return OutputWrite;
			}
			catch (FileNotFoundException e){
				System.out.println("File specified '"+ OutputWriter + "' does not exist. Would you like to continue? <Y/N>");
				String choice = input.nextLine();
				while (true) {
					if (choice.equalsIgnoreCase("Y")) {
						return GetOutputFile(null);
					}
					else if (choice.equalsIgnoreCase("N")) {
						throw e;
					}
					else {
						System.out.println("Please choose 'Y/N'");
						choice = input.nextLine();
					}
				}
			}
	}	
}