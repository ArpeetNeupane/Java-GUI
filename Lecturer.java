public class Lecturer extends Teacher         //inheritance
{
    private String department;
    private int years_of_experience;
    private int graded_score;               //instance variables.
    private boolean has_graded;

    public Lecturer(int teacher_id, String teacher_name, String address, String working_type, int working_hours, String employment_status, String department, int years_of_experience, int graded_score)
    {                                                                     //constructor^
        super(teacher_id, teacher_name, address, working_type, employment_status);
        this.setWorking_Hours(working_hours);
        this.department = department;
        this.years_of_experience = years_of_experience;
        this.graded_score = graded_score;
        this.has_graded = false;
    }

    public String getDepartment()           //accessor method for department
    {
        return this.department;
    }

    public int getYears_of_experience()       //accessor method for years of experience
    {
        return this.years_of_experience;
    }
 
    public int getGraded_score()       //accessor method for graded_score
    {
        return this.graded_score;
    }

    public boolean isHas_graded()        //accessor method for has_graded
    {
        return this.has_graded;
    }
    
    public void setGraded_Score(int graded_score)         //mutator method for graded_score
    {
        this.graded_score = graded_score;        
    }

    public String gradeAssignment(int graded_score, String department, int years_of_experience)          //method gradeAssignment
    {
        String resultingGrade = "";
        if(years_of_experience>=5 && this.department.equals(department) ) {
            if(graded_score >= 70) {
                resultingGrade += "A";        //returning grades according to marks obtained
            }
            
            else if(graded_score >= 60) {
                resultingGrade += "B";
            }
            
            else if(graded_score >= 50) {
                resultingGrade += "C";
            }
            
            else if(graded_score >= 40) {
                resultingGrade += "D";
            }
            
            else {
                resultingGrade += "E";
            }
            this.has_graded = true;
            this.setGraded_Score(graded_score);
            this.years_of_experience = years_of_experience;
        }
        
        else {             //option in case if statement isn't fulfilled.
            if(years_of_experience<5 && !(this.department.equals(department)) ) {
                resultingGrade += "The lecturer's experience is not enough and department mismatch.";
            }
            
            else if(years_of_experience<5) {
                resultingGrade += "The lecturer's experience is not enough." ;
            }
            
            else {
                resultingGrade += "Department Mismatch.";
            }
        }
        return resultingGrade;
    }
    
    public String display()//Overriding display method from teacher class, creatinng an empty string and adding all the strings to be returned to it and then returning it
    {
        String message = super.display();
        message+= "Department: " + this.getDepartment() + "\n   Years of Experience: " + this.getYears_of_experience() + "\n   Graded Score: " + this.getGraded_score() + ".\n\n\n";
        return message;
    }
}
