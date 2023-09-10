package Utilities;

import java.time.LocalDate;
import java.time.*;
import java.util.ArrayList;
import java.util.Scanner;

public class cabinet {
    // Define attributes or instance variables
    private ArrayList<Medicine> medicine_in_house = new ArrayList<>();
    private ArrayList<Medicine> expiredMedsList = new ArrayList<>();
    private ArrayList<Medicine> activeMedsList = new ArrayList<>();
    private ArrayList<Medicine> emptyMedsList = new ArrayList<>();
        
    // Constructor to initialize the attributes
    public cabinet(){
    }
    
    public void addMed(String name, double mon, double yr, double bottleCount, double dosage, double dailyDose)
    {
        medicine_in_house.add(new Medicine(name, mon, yr, bottleCount, dosage, dailyDose));
    }
    
    // Getter methods to access the attributes
    public ArrayList<Medicine> getMedicineInHouse() {
        return medicine_in_house;
    }

    public int size()
    {
        return medicine_in_house.size();
    }
    public int sizeActive()
    {
        return activeMedsList.size();
    }

    public int sizeEmpty()
    {
        return emptyMedsList.size();
    }

    public int sizeExpired(){
        return expiredMedsList.size();
    }

    public int sizeEE()
    {
        return emptyMedsList.size() + expiredMedsList.size();
    }
    public String medNames()
    {
        String temp = "";
        for(int i =0; i< size();i++)
        {
            temp +=medicine_in_house.get(i).name + ", ";
        }
        
        return temp.substring(0, temp.length() - 2);
    }
    public String medActiveNames()
    {
        String temp = "";
        for(int i =0; i< size();i++)
        {
            temp +=activeMedsList.get(i).name + ", ";
        }
        
        return temp.substring(0, temp.length() - 2);
    }
    public String medEmptyNames()
    {
        String temp = "";
        for(int i =0; i< size();i++)
        {
            temp +=emptyMedsList.get(i).name + ", ";
        }
        
        return temp.substring(0, temp.length() - 2);
    }
    public String medExpiredNames()
    {
        String temp = "";
        for(int i =0; i< size();i++)
        {
            temp +=expiredMedsList.get(i).name + ", ";
        }
        
        return temp.substring(0, temp.length() - 2);
    }
    // Method to display information about the cabinet
    public void displayCabinetInfo() {
        System.out.println("Cabinet Information:");
        System.out.println("Current Medicine Available: " + medicine_in_house);
    }

    public void findExpiredMeds() {
	//Store list of expired medicines
        //Get current date
        LocalDate currentDate = LocalDate.now();
        
        //Turn month and year into doubles for comparison
        double currentYear = currentDate.getYear(); 
        double currentMonth = currentDate.getMonth().getValue();

        
        for (Medicine med : medicine_in_house){
            //Compare current month and date to medicines in medicine cabinet 
            if(med.exp_month <= currentMonth && med.exp_year <= currentYear){
                //Add expired medicines to ArrayList
                med.expired = true;
                expiredMedsList.add(med);
            }
        }
    }

    // Compare and prompt user to remove expired medicines from current medicines
    public void removeExpiredMedicines() {

        for (Medicine expiredMedicine : expiredMedsList) {
            System.out.println(expiredMedicine.name + ", Expiration Date: " + expiredMedicine.exp_month + "/" + expiredMedicine.exp_year);

            // Prompt user to remove
            System.out.print("Have you removed this medicine from your cabinet? (yes/no)? ");
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine().trim().toLowerCase();
            
            //Remove expired medicine from cabinet
            if (userInput.equals("yes") && expiredMedicine.expired) {
                medicine_in_house.remove(expiredMedicine);
                System.out.println("Medicine removed from current medicines.");
            }
        }
    }

    public void findMedicine(String medName) {
        boolean found = false;
    
        for (Medicine med : medicine_in_house) {
            if (med.getName().equalsIgnoreCase(medName)) {
                System.out.println("You have " + med.getBottleCount() + " pill(s) left of " + med.getName() + " which expires on " + med.getExpirationDate() + ".");
                found = true;
                break; // Stop searching once found
            }
        }
    
            if (!found) {
                System.out.println("You do not have  " + medName + " in your cabinet.");
            }
    }
    public void takeMedicine(String medName, int num) {
        boolean found = false;
    
        for (Medicine med : medicine_in_house) {
            if (med.getName().equalsIgnoreCase(medName)) {
                System.out.println("You have " + (med.getBottleCount()-num) + " pill(s) left of " + med.getName() + " which expires on " + med.getExpirationDate() + ".");
                found = true;
                med.bottleCount-=num;
                break; // Stop searching once found
            }
        }
    
            if (!found) {
                System.out.println("You do not have  " + medName + " in your cabinet.");
            }
    }

    public void findEmptyMeds(){
        for (Medicine med : medicine_in_house){
            if (med.bottleCount <= (med.dosage * med.dailyDose * 2)){
                emptyMedsList.add(med);
            }
        }
    }

    
    
    public void setActive(String medName){
        for (Medicine med : medicine_in_house) {
                //If user is taking the medicine, mark it as active and add it to the active list w/ a confirm message
            if (med.getName().equalsIgnoreCase(medName)) {
                med.active = true;
                activeMedsList.add(med);
                System.out.println(medName + " was added to your Actively Taking List!");
            }
            //If the medicine is not in the cabinet, let user know that it is not there.
            else{
                    System.out.println(medName + " is not in your cabinet. Please add this medicine to your cabinet before taking it.");
            }
        }
        
    }

    public void updateBottleCount(String medName, int taken){
    
        for (Medicine med : activeMedsList){
            //If you have the medicine AND you have enough pills: modify new count
            if (med.getName().equalsIgnoreCase(medName) && med.getBottleCount() >= Double.valueOf(taken)){
                med.setBottleCount(med.bottleCount - Double.valueOf(taken));
                System.out.println("You now have " + med.getBottleCount() + " pills of " + medName + " left.");
                break; //Stop searching when found
            }
                    //If you have the medicine BUT do NOT have enough pills
            else if(med.getName().equalsIgnoreCase(medName) && med.getBottleCount() < Double.valueOf(taken)){
                System.out.println("You do not have enough pills to take. Please add more " + medName + " to your cabinet.");
                break;
            }
                    //If you DO NOT have the medicine --> promtped to add to actively taking list
            else{
                System.out.println("You have not marked " + medName + " as actively taking. Please add " + medName + " to your Actively Taking list then try again.");
            }
        }
        
    }
    
    
    public ArrayList<Medicine> viewActiveList(){
        return activeMedsList;
    }
    

    public boolean removeMedicine(String medicineName) {
        for (Medicine medicine : medicine_in_house) { 
            if (medicine.getName().equals(medicineName)) { 
                medicine_in_house.remove(medicine);
                return true; 
                }
        }
        return false; 
    }
}

