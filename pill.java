package Utilities;

public class pill {
    double dosage;
    String name;
    String comment;
    boolean liquid = true;
    boolean pill = false;
    boolean state = pill;
   
    public pill(double dose, String nameT)
	{
		dosage = dose;
        name = nameT;
	}

    public double getDosage()
    {
        return dosage;
    }
    public void changeDose(double dose)
    {
        dosage = dose;
    }

    public void addComment(String stuff2Say)
    {
        comment += " " + stuff2Say;
    }
    public void setType(boolean type)
    {
        state = type;
    }
    public String getMedType()
    {
        if(state == pill)
        {
            return "Pill"; 
        }
        else
        {
            return "Liquid"; 
        }

    }
}
