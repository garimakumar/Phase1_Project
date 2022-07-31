package com.Company.Lockers;

import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Scanner;

    public class LockedMe {

	static final String Projectpath="D:\\MyFirstProject";     //File Directory
	// main method===>
	public static void main(String[] args) {

		Scanner obj=new Scanner(System.in);// Taking input from the user
    int i;
	do {
	    DisplayAppMenu();                                    //Calling DisplayAppMenu() method
	      
        System.out.println("Enter your choice:");
        i=Integer.parseInt(obj.nextLine());
        
        //Using Switch Statement to choose your option:
	switch(i) {
	case 1:DisplayAllFiles();
	break;
	case 2:AddingFiles();
	break;
	case 3:DeleteFiles();
	break;
	case 4:SearchFiles();
	break;
	case 5:System.exit(0);
    break;
	default:System.out.println("Invalid Option selected");
	break;
	          }                                             // closing switch statement
       } 
	while(i>0);   
	                                }                       //closing main method
	
	public static void DisplayAppMenu() {
		
		//Code to display the Welcome Screen
		System.out.println("============================================================================");
		System.out.println("\tWelcome to Company Lockers Pvt.Ltd");
		System.out.println("============================================================================");
		System.out.println("\tApplication Name: LockedMe.com");
		System.out.println("\tDeveloper Details:Garima Kumar");
		System.out.println("============================================================================");
		
		//Code to accept the user input to select one of the options listed below:
		System.out.println("\t1:Display all files from the directory");
		System.out.println("\t2:Adding a file to the existing directory ");
		System.out.println("\t3:Deleting a file from the existing directory ");
		System.out.println("\t4:Searching a file from the existing directory");
		System.out.println("\t5:Exit from the application");	
	}
	
	//Method for retrieving file names in the ascending order
	public static void DisplayAllFiles() {
		
		File[] ListOfFiles=new File(Projectpath).listFiles();
        if((ListOfFiles.length)==0)
        
        	System.out.println("File not found");
        else 
        {
        	for(File L:ListOfFiles)
        	{
        		System.out.println(L.getName());
        	}
        	
        }
	                                         } 
	//Method for adding a file to the existing directory
	public static void AddingFiles() {
		
		try {	
		Scanner obj=new Scanner(System.in);
		String Filename;                                //User specified file to be added
		int Linescount;                                 //Used to add number of lines in the file
		
		System.out.println("Enter file name to be added");
		Filename=obj.nextLine();
		
        FileWriter fw=new FileWriter(Projectpath+"\\"+Filename);

		System.out.println("How many lines you want to add in your file");
        Linescount=Integer.parseInt(obj.nextLine());
		
		for(int i=1;i<=Linescount;i++) {
			
			System.out.println("Enter content of file");
			fw.write(obj.nextLine() +"\n");
		}                       //closing for loop
		System.out.println("File created successfully");
	    	fw.close();
	       }                        //closing try block
		catch (Exception Ex) {
		System.out.println("An error has occurred");
		}                       //closing catch block
	}
	
	//Method for deleting a file from the existing directory
	public static void DeleteFiles() {
		
		try {
		String Filename;
		Scanner obj=new Scanner (System.in);
		System.out.println("Enter the file you want to delete");
		Filename=obj.nextLine();
		
		File FL=new File(Projectpath+"\\"+Filename);

		if(FL.exists())
		{
            FL.delete();
			System.out.println("File deleted successfully");
		}
		else
		{
			System.out.println("File does not exist in the directory");

		}
	       }                   //closing try block
		
		catch(Exception Ex) {
			System.out.println("An error has occurred");
		}                   //closing catch block
		
	}
	//Method for searching a file from the existing directory
	public static void SearchFiles() {
			
		try {
			String Filename;
			
		Scanner obj=new Scanner(System.in);
	    System.out.println("Enter file name to be searched");
	    Filename=obj.nextLine();
		
	    LinkedList <String> Filenames=new LinkedList<String>();
		File[] ListOfFiles=new File(Projectpath).listFiles();
		
        for(File L:ListOfFiles) {
        	
        	Filenames.add(L.getName());
                                }      //closing for loop
        	if(Filenames.contains(Filename))
        	{
        		System.out.println("File has found");
        	}
        	else {
        		System.out.println("File has not found");
        	     }        
		   }                   //closing try block 
	    catch(Exception Ex) {
		
		System.out.println("An error has occurred");
	                        }      //closing catch block
		
	}
}                                      //closing public class LockedMe