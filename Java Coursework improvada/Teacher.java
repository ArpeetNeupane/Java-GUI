public class Teacher
{
    
    private int teacher_id;
    private String teacher_name;
    private String address;                        //instance variables
    private String working_type;
    private String employment_status;
    private int working_hours;

    public Teacher(int teacher_id, String teacher_name, String address, String working_type, String employment_status) //Constructor
    {
        this.teacher_id = teacher_id;
        this.teacher_name = teacher_name; 
        this.address = address;
        this.working_type = working_type;
        this.employment_status = employment_status;
    }

    public int getTeacher_id()             //accessor method for teacher_id
    {
        return this.teacher_id;
    }
    
    public String getTeacher_name()        //accessor method for teacher_name
    {
        return this.teacher_name;
    }
    
    public String getAddress()              //accessor method for address
    {
        return this.address;
    }
    
    public String getWorking_type()        //accessor method for working_type
    {
        return this.working_type;
    }
    
    public String getEmployment_status()       //accessor method for employment_status
    {
        return this.employment_status;
    }
    
    public int getWorking_hours()             //accessor method for working hours
    {
        return this.working_hours;
    }
    
    public void setWorking_Hours(int working_hours)       //mutator method for working_hours
    {
        this.working_hours = working_hours;
    }
    
    public String display()       //creatinng an empty string and adding all the strings to be returned to it and then returning it
    {
        String message = "";  
        message+= "\n   Id: " + this.getTeacher_id() + "\n   Name: " + this.getTeacher_name() + "\n   ";
        message+= "Address: " + this.getAddress() + "\n   Employment Status: " + this.getEmployment_status() + "\n   ";
        message+= "Working Type: " + this.getWorking_type() + "\n   Working Hour: " + this.getWorking_hours() + "\n   ";
        return message;
    }
}
