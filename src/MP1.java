//MP1, Syeda Jaffery, CIS 340, online

import java.util.Scanner;

public class MP1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		// Declare and initialize variables
		int numberOfScores = 0;
		int quizNumber = 0;
		String choice = "";
		String sName = "";
		
		// Declare arrays
		String[] studentName;
		double[] quizScores;
		double[][] studentArray; 
		
		// Initialize studentName array
		studentName = new String[3];
		quizScores = new double[3];
		
		System.out.print("How many scores per student? ");
		numberOfScores = Integer.parseInt(scanner.nextLine());
		
		//initialize studentArray by user specified number of columns
		studentArray = new double [3][numberOfScores];
		
		//prompt user for names and store in studentName array
		for (int i = 0; i < studentName.length; i++)
		{			
			System.out.printf("\nEnter name for student %d: ", i+1);
			studentName[i] = scanner.nextLine();
			
			System.out.printf("\nEntering scores for %s ", studentName[i].toUpperCase());
			System.out.println();
			
			//prompt user for quiz score for each student and save in 2-d array
			for (int j = 0; j < numberOfScores; j++)
			{
				System.out.printf("Quiz %d: ", j+1);
				studentArray[i][j] = Double.parseDouble(scanner.nextLine());
			}
		}
		
		//use do while loop to show the menu atleast once
		do 
		{
			choice = showMenu();
		
		//**********************************	
			//choice 1. calculates class average
			if (choice.equals("1"))
			{
				System.out.printf("Class average for quizzes is %.2f", calculateClassAverage(studentArray));
			}//end if
		
			
		//**********************************
			//choice 2. asks user for student name and calculates student average
			else if (choice.equals("2"))
			{
				System.out.println("\nCalculating average by student.");
				System.out.print("Enter student name: ");			
				sName = scanner.nextLine();
								
				//call StudentFound method to check if student is in array
				if (!(studentFound(studentName, sName)))
					System.out.println("Student not found");
				
				else 
				{
					//loop through all elements in studentName array
					for (int i = 0; i < studentName.length; i++)
					{
					//check if the element at i is student name asked by user, regardless of the case
						if (studentName[i].equalsIgnoreCase(sName))
						{
							System.out.printf("%s's scores are: ", sName);
							for (int j= 0; j < studentArray[i].length; j++)
							{
								System.out.printf("%.2f ", studentArray[i][j]);
							}
							System.out.printf("\n%s's average is %.2f ", sName, calculateStudentAverage(studentArray[i]));
						}//end if
					}//end for
				}//end else
			}//end else if
			
		//************************************************
			//choice 3. asks user for quiz number and calculates quiz average for all students
			else if (choice.equals("3"))
			{
				System.out.println("\nCalculating average by Quiz Number");
				System.out.print("Enter Quiz number: ");
				quizNumber = Integer.parseInt(scanner.nextLine());
							
				//loop through all students 
				for (int i = 0; i < studentName.length; i++)
				{
					//get scores for quiz specified by user
					//offset quizNumber by 1 to get the right index number
					//store all quiz scores in array quizScore
					quizScores[i] = studentArray[i][quizNumber-1];
				}// end for
				
				System.out.printf("Quiz %d average is %.2f",
						quizNumber, claculateQuizAverage(quizScores));
			}// end else if
		}
		while (! choice.equalsIgnoreCase("x"));
	
		scanner.close();

	}//end main
	
	//method to show menu
	private static String showMenu()
	{
		String choice = "";
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n\n\n\n\n\t\t\t MENU");
		System.out.print("1. Class Average\n2. Student Average\n3. Quiz Average\n\n"
			+ "Enter choice number, or x to exit: ");
		choice = scanner.nextLine();
		return choice;
	}
	
	//method to calculate class average
	private static double calculateClassAverage(double[][] scoreArray)
	{
		int count = 0;
		double sum = 0.0;
		double average = 0.0;
		
		//loop thru all columns and rows in 2D array to calculate average
		for (int i = 0; i < scoreArray.length; i++)
		{
			for (int j = 0; j < scoreArray[i].length; j++)
				{	sum = sum + scoreArray[i][j]; //accumulated total
					count ++;
				}//end nested loop
		}//end for loop
		average = sum / count;
		return average;
	}
	
	//method to calculate student average
	private static double calculateStudentAverage(double sArray[])
	{
		int count = 0;
		double sum = 0.0;
		double average = 0.0;
		
		//loop thru array to add and calculate average
		for (int i = 0; i < sArray.length; i++)
		{
			sum = sum + sArray[i]; //accumulated total
			count ++;
		}
		average = sum / count;
		return average;
	}
	
	//method to calculate quiz average
	private static double claculateQuizAverage(double qArray[])
	{
		int count = 0;
		double sum = 0.0;
		double average = 0.0;
		
		//loop thru array to add and calculate average
		for (int i = 0; i < qArray.length; i++)
		{
			sum = sum + qArray[i];
			count ++;
		}
		average = sum / count;
		return average;
	}
	
	//method to find if student is in array
	private static boolean studentFound(String[] nameArray, String nameOfStudent)
	{
		boolean found = false; //return false if student is not in array
		
		for (int i = 0; i < nameArray.length; i++)
		{
			if (nameArray[i].equalsIgnoreCase(nameOfStudent))
				found = true;
		}//end for
		return found;
	}//return method

}// end class
