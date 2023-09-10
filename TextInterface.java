import java.io.*;  
import java.util.*;
import java.time.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Utilities.*;

public class TextInterface {
    static cabinet home = new cabinet();
    static int menu = 0;
    static int medCabinet = 1;
    static int medActive = 2;
    static int replacement = 3;
    static int expired = 4;
    static int empty = 5;
    static int add = 6;
    static int notifications = 7;


    static int pageState = menu;
    
    

    public static void main(String[] args)
    {
        intro();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("");
            System.out.println("Menu:");
            System.out.println("");
            System.out.println("Welcome to The Menu! From Here You Can View:");
            System.out.println("1: What's In My Medicine Cabinet?");
            System.out.println("2: What Meds Am I Actively Taking?");
            System.out.println("3: My Restock/Replace List");
            System.out.println(" ----- 4: My Expired Meds that Need Replacement");
            System.out.println(" ----- 5: My Nearly Empty Meds that Need Replacement");
            System.out.println("6: Add Medicine to Cabinet");
            System.out.println("7: Mark a Med As Active");
            System.out.println("8: Take a Medicine");
            System.out.println("9: Exit");
            System.out.print("Enter your choice: ");

            // Read user's choice
            choice = scanner.nextInt();

            // Process user's choice
            switch (choice) {
                case 1:
                    
                    System.out.println("Viewing Your Medicine Cabinet");
                    if(home.size() !=0){System.out.println("You are currently taking " + home.medNames());}
                    else{System.out.println("None Yet!");}                                   
                    returnMenu(scanner);
                    break;
                case 2:
                    
                    System.out.println("Viewing Meds You're Actively Taking");
                    if(home.sizeActive() !=0){ System.out.println(home.medActiveNames());}
                    else{System.out.println("None Yet!");}
                    returnMenu(scanner);
                    break;
                case 3:
                    
                    System.out.println("Viewing Your Restock/Replace List");
                    if(home.sizeEmpty() == 0 && home.sizeExpired() != 0){
                       System.out.println("Replace "+ home.medExpiredNames());
                    }

                    else if(home.sizeEmpty() != 0 && home.sizeExpired() == 0){
                       System.out.println("Replace "+ home.medEmptyNames());
                    }
                    
                    else if(home.sizeEE() !=0){
                       System.out.println("Replace "+ home.medExpiredNames() + "," + home.medEmptyNames());
                    }

                    else{System.out.println("None Yet!");}
                    returnMenu(scanner);
                    break;
                case 4:
                    
                    System.out.println("Viewing Expired Meds, Need Replacement");
                    if(home.sizeExpired() !=0){
                       System.out.println("Replace "+ home.medExpiredNames());
                    }
                    else{System.out.println("None Yet!");}

                    returnMenu(scanner);
                    break;
                case 5:
                    
                    System.out.println("Viewing Empty Meds, Need Replacment");
                    if(home.sizeEmpty() !=0){
                       System.out.println("Replace "+ home.medEmptyNames());
                    }
                    else{System.out.println("None Yet!");}
                    
                    returnMenu(scanner);
                    break;
                case 6:
                    System.out.println("");
                    System.out.println("Add a Medicine");

                    System.out.print("Insert Name of Medicaton:  ");
                    String nameTemp = scanner.nextLine();
                    while(nameTemp.isEmpty()){nameTemp = scanner.nextLine();}

                    System.out.print("What Month (1-12) Will This Expire In:  ");
                    int monTemp = scanner.nextInt();
                    while(monTemp == 0){monTemp = scanner.nextInt();}

                    System.out.print("What Year (20--) Will This Expire In:  ");
                    int yrTemp = scanner.nextInt();
                    while(yrTemp == 0){yrTemp = scanner.nextInt();}

                    System.out.print("How Many Pills Are in Your " + nameTemp + " Bottle?  ");
                    int pillTemp = scanner.nextInt();
                    while(pillTemp == 0){pillTemp = scanner.nextInt();}

                    System.out.print("How Many Pills Are a Single Dose?  ");
                    int doseTemp = scanner.nextInt();
                    while(doseTemp == 0){doseTemp = scanner.nextInt();}

                    System.out.print("How Many Doses Can you Safely Take in a Day?  ");
                    int dailyTemp = scanner.nextInt();
                    while(dailyTemp == 0){dailyTemp = scanner.nextInt();}

                    home.addMed(nameTemp, monTemp, yrTemp, pillTemp, doseTemp, dailyTemp);

                    System.out.println("Medication added to Medication Cabinet!");
                    
                    returnMenu(scanner);
                    break;
                case 7: //Isn't Working Correctly
                    System.out.println("Mark Medication as Active:");
                    System.out.println("");
                    
                    if(home.sizeActive() !=0){
                        System.out.println("You have " + home.medNames() + " in your Medicine Cabinet.");
                        System.out.print("Insert Name of Medicaton to Add to Active List:  ");
                        String nameTemp2 = scanner.nextLine();
                        while(nameTemp2.isEmpty()){nameTemp2 = scanner.nextLine();}
                        home.setActive(nameTemp2);   
                    }
                    else
                    {
                        System.out.println("None Yet");
                    }            
                    returnMenu(scanner);
                    break;
                case 8:
                    System.out.print("Which medicine do you want to take?  ");
                    String nameTemp3 = scanner.nextLine();
                    while(nameTemp3.isEmpty()){nameTemp3 = scanner.nextLine();}
                    System.out.print("How many pills did you take?  ");
                    int takenTemp = scanner.nextInt();
                    while(takenTemp == 0){takenTemp = scanner.nextInt();}
                    home.takeMedicine(nameTemp3, takenTemp);
                    System.out.println(takenTemp +" Pills removed from " + nameTemp3 + "!");
                    returnMenu(scanner);
                    break;
                case 9:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 9);

        scanner.close();
    }
    

    public static void intro()
    {
        System.out.println("Welcome to Your Virtual Medical Cabinet!");
        System.out.println("I am here to help you keep track of your active meds, etc.");
        System.out.println("You will now be directed to our text menu. Navigate via keyboard inputs.");
        System.out.println("Have a Lovely Day!");
        minWait(9000);
        
    }
    public static void returnMenu(Scanner scanner)
    {
        System.out.println("");
        System.out.println("Select M to Return to Menu");
        String choice2 = scanner.nextLine();
        while(!choice2.equalsIgnoreCase("M")){
            choice2 = scanner.nextLine();
            if (choice2.equalsIgnoreCase("M"))
            {
                break;
            }
        }
        
    }
    public static void waitUntilResponse(String passIn)
    {
        while(passIn.isEmpty()){}
    }
    public static void minWait(long ti)
	{
		try {
				Thread.sleep(ti);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
