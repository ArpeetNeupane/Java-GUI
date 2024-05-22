public class Tutor extends Teacher
{
    private double salary;
    private String specialization;
    private String academic_qualifications;              //instance variables   
    private int performance_index;
    private boolean is_certified;

    public Tutor(int teacher_id, String teacher_name, String address, String working_type, String employment_status, int working_hours, double salary, String specialization, String academic_qualifications, int performance_index)
    {                                                       //^Constructor
        super(teacher_id, teacher_name, address, working_type, employment_status);
        this.setWorking_Hours(working_hours);
        this.salary = salary;
        this.specialization = specialization;
        this.academic_qualifications = academic_qualifications;
        this.performance_index = performance_index;
        this.is_certified = false;
    }
    
    public double getSalary()           //accessor method for salary
    {
        return this.salary;
    }
    
    public String getSpecialization()           //accessor method for specialization
    {
        return this.specialization;
    }
    
    public String getAcademic_qualifications()           //accessor method for academic_qualifications
    {
        return this.academic_qualifications;
    }
    
    public int getPerformance_index()           //accessor method for performance_index
    {
        return this.performance_index;
    }
    
    public boolean getIs_certified()           //accessor method for is_certified....get is used instead of typical naming convention as "is"
    {                                          //is already in name
        return this.is_certified;
    }

    public String setSalary(double new_salary, int new_performance_index)       //mutator method for salary
    {
        String updatedSalary = "";
        if (new_performance_index > 5 && this.getWorking_hours() > 20) { 
            if (new_performance_index <= 7) {
                updatedSalary += String.valueOf( new_salary + ( (0.05) * new_salary) ); //we have a string type storing variable so converting salary to string type
            }
            
            else if (new_performance_index <= 9) {
                updatedSalary += String.valueOf( new_salary + ( (0.1) * new_salary) );
            }
            
            else if(new_performance_index == 10) {
                updatedSalary += String.valueOf( new_salary + ( (0.2) * new_salary) );
            }
            else {
                updatedSalary += "Keep the performance index value between 5-10.";
            }
        }
        
        else if (new_performance_index < 5) {
            updatedSalary += "The performance index value should be between 5-10.";
        }
        
        else {
            updatedSalary += "The tutor's working hour is not sufficient.";
        }
        this.salary = new_salary;
        this.performance_index = new_performance_index;
        
        return updatedSalary;
    }
    
    public String display()
    { //overriding method from teacher class, creatinng an empty string and adding all the strings to be returned to it and then returning it
        String message = super.display(); 
        
        message+= "Salary: " + this.getSalary() + "\n   Specialization: " + this.getSpecialization() + "\n   Academic Qualification: " + this.getAcademic_qualifications() + "\n   Performance Index is: " + this.getPerformance_index() + "\n\n\n";
        return message;
    }
}
