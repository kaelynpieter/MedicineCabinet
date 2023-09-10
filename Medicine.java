package Utilities;
//import java.time.*;
import java.util.*;

//Create medicine class
public class Medicine {
    public String name;
    public String symptom;
    public double exp_year;
    public double exp_month;
    public double bottleCount; // How many pills are in a bottle
    public double dosage; //How many pills take in a dose
    public double dailyDose; //How many doses per day
    public double goodMonth; // Good months left
    public double goodYear; // Good years left
    boolean expired = false;
    boolean active = false;

    //Create an instance of medicine

    public Medicine(String name, double mon, double yr, double bottleCount, double dosage, double dailyDose)
    {
        this.name = name;
        this.exp_month = mon;
        this.exp_year = yr;

        this.bottleCount = bottleCount;
        this.dosage = dosage;
    }

   

    //Medicine Name

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Number of Pills

    public double getBottleCount(){
        return bottleCount;
    }

    public void setBottleCount(double count){
        this.bottleCount = count;
    }

    //Dosage Amount (Pills Per Dose)
    
    public double getDosage() {
        return dosage;
    }
    
    public void setDosage(double dosage) {
        this.dosage = dosage;
    }

    //Dosage Frequency 
    public double getDaily() {
        return dailyDose;
    }
    
    public void setDaily(double daily) {
        this.dailyDose = daily;
    }

    // Symptom Treated
    public String getSymptom() {
        return symptom;
    }
    
    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    // Expiration Date
    
    public String getExpirationDate() {
        String expirationDate = Double.toString(exp_month) + "-" + Double.toString(exp_year);
        return expirationDate;
    }
    
    public void setExpirationDate(double mon, double yr) {
        this.exp_month = mon;
        this.exp_year = yr;
    }
    
    //Check current date compared to expiration
    public void updateTimeTillExpire()
    {
        goodMonth = exp_month-(Calendar.getInstance().get(Calendar.MONTH)+1);
        goodYear = exp_year-(Calendar.getInstance().get(Calendar.YEAR));
    }

     public double getDailyDosesLeft(){ //Tells Use How Many Days worth of Meds are Left
        double totalDaysLeft = this.bottleCount / (this.dosage * this.dailyDose);
        return totalDaysLeft;
    }
    

}