import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.Dimension;

public class TeacherGUI {
    //creating an arraylist of type Teacher
    ArrayList<Teacher> listOfTeacher = new ArrayList<Teacher>();
    
    //components of main frame
    private JFrame buttonsFrame;
    private JPanel mainPanel, leftPanel, rightPanel;
    private JLabel welcomeLabel;
    private JButton addLecturerButton, addTutorButton, gradeButton, setSalaryButton, removeTutorButton, exitButton;
    
    //components of Lecturer frame
    private JFrame lecturerFrame;
    private JPanel lPanel;
    private JLabel lHeader, lIdLabel, lNameLabel, lAddressLabel, lWorkingTypeLabel, lEmploymentStatusLabel, lDepartmentLabel, lExperienceLabel,  lWorkingHoursLabel;
    private JLabel lGradedScoreLabel;
    private JTextField lId, lName, lAddress, lWorkingType, lEmploymentStatus, lDepartment, lExperience,  lWorkingHours, lGradedScore;
    private JButton lDisplayButton, lClearButton, lAddButton, lBackButton;
    
    //components of Tutor frame
    private JFrame tutorFrame;
    private JPanel tPanel;
    private JLabel tHeader, tIdLabel, tNameLabel, tAddressLabel, tWorkingTypeLabel, tEmploymentStatusLabel, tWorkingHoursLabel, tSalaryLabel, tSpecializationLabel;
    private JLabel tQualificationLabel, tPerformanceLabel;
    private JTextField tId, tName, tAddress, tWorkingType, tEmploymentStatus, tWorkingHours, tSalary,  tSpecialization, tQualification, tPerformance;
    private JButton tDisplayButton, tClearButton, tAddButton, tBackButton;
    
    //components of Grade Assignment frame
    private JFrame gradeFrame;
    private JPanel gPanel;
    private JLabel gHeader, gIdLabel, gDepartmentLabel, gGradedScoreLabel,  gExperienceLabel;
    private JTextField gId, gDepartment, gExperience, gGradedScore;
    private JButton gGradeButton, gClearButton, gBackButton;
    
    //components of Set Salary frame
    private JFrame salaryFrame;
    private JPanel sPanel;
    private JLabel sHeader, sSalaryLabel, sPerformanceLabel, sIdLabel;
    private JTextField sSalary, sPerformance, sId;
    private JButton sSetSalaryButton, sClearButton, sBackButton;
    
    //components of Remove Tutor frame
    private JFrame removeFrame;
    private JPanel rPanel;
    private JLabel rIdLabel, rHeader;
    private JTextField rId;
    private JButton rRemoveButton, rBackButton;
    
    //components of lDisplay Frame
    private JFrame lDisplayFrame;
    private JPanel lDisplayPanel;
    private JLabel dlHeader, dlIdLabel, dlNameLabel, dlAddressLabel, dlWorkingTypeLabel, dlEmploymentStatusLabel, dlDepartmentLabel, dlExperienceLabel,  dlWorkingHoursLabel, dlGradedScoreLabel;
    private JLabel lIdData, lNameData, lAddressData, lWorkingTypeData, lEmploymentStatusData, lDepartmentData, lExperienceData,  lWorkingHoursData, lGradedScoreData;
    private JButton dlBackButton;
    
    //components of tDisplay Frame
    private JFrame tDisplayFrame;
    private JPanel tDisplayPanel;
    private JLabel dtHeader, dtIdLabel, dtNameLabel, dAddressLabel, dtWorkingTypeLabel, dtEmploymentStatusLabel, dtWorkingHoursLabel, dtSalaryLabel, dtSpecializationLabel, dtQualificationLabel, dtPerformanceLabel;
    private JButton dtBackButton;
    
    public TeacherGUI() {
        
        //creating frame
        buttonsFrame = new JFrame("Teacher Management System");
        buttonsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //terminates JVM when close button is clicked
        buttonsFrame.setSize(600, 400); //setting size of frame
        buttonsFrame.setLocationRelativeTo(null); //centers the frame when program runs
        
        //creating panels
        //creating the top panel
        mainPanel = new JPanel(null);
        //creating the left side panel
        leftPanel = new JPanel(null);
        leftPanel.setBounds(0, 90, 300, 250);
        //creating the right side panel
        rightPanel = new JPanel(null);
        rightPanel.setBounds(300, 90, 300, 250);
        
        //creating labels
        welcomeLabel = new JLabel("Welcome!");
        welcomeLabel.setBounds(250, 20, 200, 60); //setting bounds (x-axis, y-axis, width, height)
        
        //creating buttons
        //for adding lecturer
        addLecturerButton = new JButton("Add Lecturer");
        addLecturerButton.setBounds(75, 65, 150, 30);
        //for adding tutor
        addTutorButton = new JButton("Add Tutor");
        addTutorButton.setBounds(75, 65, 150, 30);
        //for grading assignment
        gradeButton = new JButton("Grade Assignment");
        gradeButton.setBounds(75, 125, 190, 30);
        //for setting salary
        setSalaryButton = new JButton("Set Salary");
        setSalaryButton.setBounds(75, 125, 150, 30);
        //for removing tutor
        removeTutorButton = new JButton("Remove Tutor");
        removeTutorButton.setBounds(75, 185, 150, 30);
        //exiting frame
        exitButton = new JButton("Exit");
        exitButton.setBounds(125, 185, 100, 30);
        
        //creating secondary frames:
        //creating another frame when add Lecturer button is clicked
        lecturerFrame = new JFrame("Add Lecturer");
        lecturerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //different from exit on close; runs in the background
        lecturerFrame.setSize(820, 550);
        lecturerFrame.setLocationRelativeTo(buttonsFrame); //lays the frame relative to buttonsFrame
        
        //creating another frame when add Tutor button is clicked
        tutorFrame = new JFrame("Add Tutor");
        tutorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //different from exit on close; runs in the background
        tutorFrame.setSize(820, 550);
        tutorFrame.setLocationRelativeTo(buttonsFrame); //lays the frame relative to buttonsFrame
        
        //creating another frame when grade assignment button is clicked
        gradeFrame = new JFrame("Grade Assignment");
        gradeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //different from exit on close; runs in the background
        gradeFrame.setSize(650, 500);
        gradeFrame.setLocationRelativeTo(buttonsFrame); //lays the frame relative to buttonsFrame
        
        //creating another frame when setSalary is clicked
        salaryFrame = new JFrame("Set Salary");
        salaryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //different from exit on close; runs in the background
        salaryFrame.setSize(600, 450);
        salaryFrame.setLocationRelativeTo(buttonsFrame); //lays the frame relative to buttonsFrame
        
        //creating another frame when removeTutor is clicked
        removeFrame = new JFrame("Remove Tutor");
        removeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //different from exit on close; runs in the background
        removeFrame.setSize(600, 400);
        removeFrame.setLocationRelativeTo(buttonsFrame); //lays the frame relative to buttonsFrame
        
        //creating display frame for when display button is clicked
        lDisplayFrame = new JFrame("Display Lecturer Details");
        lDisplayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //different from exit on close; runs in the background
        lDisplayFrame.setSize(700, 500);
        lDisplayFrame.setLocationRelativeTo(buttonsFrame); //lays the frame relative to buttonsFrame
        
        //creating display frame for when display button is clicked
        tDisplayFrame = new JFrame("Display Tutor Details");
        tDisplayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //different from exit on close; runs in the background
        tDisplayFrame.setSize(700, 500);
        tDisplayFrame.setLocationRelativeTo(buttonsFrame); //lays the frame relative to buttonsFrame
        
        //adding actionListeners
        addLecturerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lecturerFrame.setVisible(true); //makes lecturerFrame visible
                buttonsFrame.setVisible(false); //and buttonsFrame invisible
                lecturersFrame(); //lecturersFrame is a method implemented outside of constructor and is being called here
            }
        });
        
        addTutorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tutorFrame.setVisible(true);
                buttonsFrame.setVisible(false);
                tutorsFrame();
            }
        });
        
        gradeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gradeFrame.setVisible(true);
                buttonsFrame.setVisible(false);
                gradesAssignment();
            }
        });
        
        setSalaryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salaryFrame.setVisible(true);
                buttonsFrame.setVisible(false);
                setsSalary();
            }
        });
        
        removeTutorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeFrame.setVisible(true);
                buttonsFrame.setVisible(false);
                removesTutor();
            }
        });
        
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        //changing the font size
        //of welcomeLabel
        Font welcomeFont = welcomeLabel.getFont();
        welcomeFont = welcomeFont.deriveFont(welcomeFont.getSize() * 2f); //increase font size by 200%
        welcomeLabel.setFont(welcomeFont);
        
        //increasing font size for buttons
        Font buttonsFont = addLecturerButton.getFont();
        buttonsFont = buttonsFont.deriveFont(addLecturerButton.getFont().getSize() * 1.2f);
        addLecturerButton.setFont(buttonsFont);
        addTutorButton.setFont(buttonsFont);
        gradeButton.setFont(buttonsFont);
        setSalaryButton.setFont(buttonsFont);
        removeTutorButton.setFont(buttonsFont);
        exitButton.setFont(buttonsFont);
        
        //setting text color
        welcomeLabel.setForeground(Color.WHITE); //setting text color to white
        
        //setting background color
        mainPanel.setBackground(new Color(47, 79, 79)); //setting background to grey of top panel
        leftPanel.setBackground(new Color(47, 79, 79)); //setting bg color of left panel
        rightPanel.setBackground(new Color(47, 79, 79)); //setting bg color of right panel
        
        addLecturerButton.setBackground(new Color(211, 211, 211));
        addTutorButton.setBackground(new Color(211, 211, 211));
        gradeButton.setBackground(new Color(211, 211, 211));     //setting grey bgcolor to buttons
        setSalaryButton.setBackground(new Color(211, 211, 211));
        removeTutorButton.setBackground(new Color(211, 211, 211));
        exitButton.setBackground(new Color(211, 211, 211));
        
        //adding to panel
        //adding labels to panel
        mainPanel.add(welcomeLabel);
        //adding buttons to panel
        leftPanel.add(addLecturerButton);
        leftPanel.add(gradeButton);
        leftPanel.add(removeTutorButton);
        rightPanel.add(addTutorButton);
        rightPanel.add(setSalaryButton);
        rightPanel.add(exitButton);
        
        //combining panels
        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);
         
        //adding the main panel to the frame's content pane
        buttonsFrame.getContentPane().add(mainPanel);
        
        tutorFrame.setVisible(false);
        lecturerFrame.setVisible(false);
        gradeFrame.setVisible(false);
        salaryFrame.setVisible(false);
        removeFrame.setVisible(false);
        lDisplayFrame.setVisible(false);
        tDisplayFrame.setVisible(false);
        buttonsFrame.setVisible(true); //finally, setting visiblity to true
    }
    
    //creating a method where all components of frame (where lecturer is added) is implemented
    public void lecturersFrame() {
        lPanel = new JPanel(null);
        lPanel.setBackground(new Color(47, 79, 79)); //giving bgcolor
        
        //creating labels and setting bounds
        lHeader = new JLabel("Enter Lecturer Details ");
        lHeader.setBounds(290, 30, 290, 60);
        lIdLabel = new JLabel("Id: ");
        lIdLabel.setBounds(30, 150, 50, 20);
        lNameLabel = new JLabel("Name: ");
        lNameLabel.setBounds(30, 200, 70, 20);
        lAddressLabel = new JLabel("Address: ");
        lAddressLabel.setBounds(30, 250, 100, 20);
        lWorkingTypeLabel = new JLabel("Working Type: ");
        lWorkingTypeLabel.setBounds(30, 300, 150, 20);
        lGradedScoreLabel = new JLabel("Graded Score: ");
        lGradedScoreLabel.setBounds(30, 350, 150, 20);
        lDepartmentLabel = new JLabel("Department: ");
        lDepartmentLabel.setBounds(420, 150, 100, 20);
        lExperienceLabel = new JLabel("Experience(Years): ");
        lExperienceLabel.setBounds(420, 200, 150, 20);
        lWorkingHoursLabel = new JLabel("Working Hours: ");
        lWorkingHoursLabel.setBounds(420, 250, 190, 20);
        lEmploymentStatusLabel = new JLabel("Employment Status: ");
        lEmploymentStatusLabel.setBounds(420, 300, 170, 20);
        
        //creating text-fields
        lId = new JTextField();
        lId.setBounds(150, 150, 170, 25);
        lName = new JTextField();
        lName.setBounds(150, 200, 170, 25);
        lAddress = new JTextField();
        lAddress.setBounds(150, 250, 170, 25);
        lWorkingType = new JTextField();
        lWorkingType.setBounds(150, 300, 170, 25);
        lGradedScore = new JTextField();
        lGradedScore.setBounds(150, 350, 170, 25);
        lDepartment = new JTextField();
        lDepartment.setBounds(593, 150, 180, 25);
        lExperience = new JTextField();
        lExperience.setBounds(593, 200, 180, 25);
        lWorkingHours = new JTextField();
        lWorkingHours.setBounds(593, 250, 180, 25);
        lEmploymentStatus = new JTextField();
        lEmploymentStatus.setBounds(593, 300, 180, 25);
        
        //creating buttons
        lAddButton = new JButton("Add to list");
        lAddButton.setBounds(160, 440, 130, 33);
        lDisplayButton = new JButton("Display");
        lDisplayButton.setBounds(360, 440, 120, 33);
        lClearButton = new JButton("Clear");
        lClearButton.setBounds(550, 440, 120, 33);
        lBackButton = new JButton("<-Back-");
        lBackButton.setBounds(20, 20, 90, 25);
        
        //number format listener try-catch block
        lAddButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent a)
            {
                try {
                    //trim() function removes extra whitespaces behind and in front of input
                    if(lId.getText().trim().equals("") || lName.getText().trim().equals("") || lAddress.getText().trim().equals("") || lWorkingType.getText().trim().equals("") || lExperience.getText().trim().equals("") || lDepartment.getText().trim().equals("") || lWorkingHours.getText().trim().equals("") || lEmploymentStatus.getText().trim().equals("") || lGradedScore.getText().trim().equals("")) {
                        JOptionPane.showMessageDialog(lecturerFrame, "Empty Fields Found! Please fill all text areas. ", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    
                    else {
                        //checking if id is available or not
                        int lIdAvailable = (int)Double.parseDouble(lId.getText()); //creating a variable and putting lecturer id on it
                        boolean isAdded = true;
                        for(int i=0; i<listOfTeacher.size(); i++) 
                        {   //iterating throughout the array
                            if ( (lIdAvailable == listOfTeacher.get(i).getTeacher_id()) && (listOfTeacher.get(i) instanceof Lecturer) ) {
                                isAdded = false;
                            }
                        }
                        
                        //adding only when lecturer id is available
                        if (isAdded == true) {
                            int num1 = (int)(Double.parseDouble(lId.getText().trim()));
                            //trim function removes un-needed whitespaces in front of and behind inputs
                            int num2 = (int)(Double.parseDouble(lExperience.getText().trim()));
                            int num3 = (int)(Double.parseDouble(lWorkingHours.getText().trim()));
                            int num4 = (int)(Double.parseDouble(lGradedScore.getText().trim()));
                            String str1 = lName.getText().trim();
                            String str2 = lAddress.getText().trim();
                            String str3 = lDepartment.getText().trim();
                            String str4 = lWorkingType.getText().trim();
                            String str5 = lEmploymentStatus.getText().trim();
                            
                            //adding to arrayList, upcasting Lecturer values to Teacher type
                            listOfTeacher.add(new Lecturer(num1, str1, str2, str4, num3, str5, str3,  num2, num4));
                            //showing msg that addition of lecturer was successful
                            JOptionPane.showMessageDialog(lecturerFrame, "Successfully Added!");
                            
                            //clearing all fields after adding successfully
                            lId.setText("");
                            lName.setText("");
                            lAddress.setText("");
                            lWorkingType.setText("");
                            lDepartment.setText("");
                            lExperience.setText("");
                            lWorkingHours.setText("");
                            lEmploymentStatus.setText("");
                            lGradedScore.setText("");
                        }
                        
                        else {
                            JOptionPane.showMessageDialog(lecturerFrame, "Id is already in use!! Try another lecturer id.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }catch(NumberFormatException e) {
                    JOptionPane.showMessageDialog(lecturerFrame, "Number Format Exception. Enter number only in number-required fields.");
                }
            }
        });
        
        //clearing all fields, action listener
        lClearButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent b)
            {
                if(!lId.getText().equals("") || !lName.getText().equals("") || !lAddress.getText().equals("") || !lWorkingType.getText().equals("") || !lDepartment.getText().equals("") || !lExperience.getText().equals("") || !lWorkingHours.getText().equals("") || !lEmploymentStatus.getText().equals("") || !lGradedScore.getText().equals("")){
                    int confirmation = JOptionPane.showConfirmDialog(lecturerFrame, "Do you really want to clear all fields?", "Clear", JOptionPane.WARNING_MESSAGE);
                    if (confirmation == JOptionPane.YES_OPTION) {
                        lId.setText("");
                        lName.setText("");
                        lAddress.setText("");
                        lWorkingType.setText("");
                        lDepartment.setText("");
                        lExperience.setText("");
                        lWorkingHours.setText("");
                        lEmploymentStatus.setText("");
                        lGradedScore.setText("");
                    }
                }
            }
        });
        
        //opens new Frame to display entered tutors
        lDisplayButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent c)
            {
                lecturerFrame.setVisible(false);
                lDisplayFrame.setVisible(true); //makes only the displaying frame visible
                displaysLecturerList(); //code for this method which shows up in the frame is implemented below
            }
        });
        
        //goes back to main frame(buttonsFrame)
        lBackButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent d)
            {
                lecturerFrame.setVisible(false);
                
                //clears all of its fields after clicking the back button to avoid issues with exception handeling
                lId.setText("");
                lName.setText("");
                lAddress.setText("");
                lWorkingType.setText("");
                lDepartment.setText("");
                lExperience.setText("");
                lWorkingHours.setText("");
                lEmploymentStatus.setText("");
                lGradedScore.setText("");
                
                buttonsFrame.setVisible(true); //makes main frame visible
            }
        });
        
        //changing font size for all labels except lHeader
        Font labelFont = lIdLabel.getFont();
        labelFont = labelFont.deriveFont(Font.BOLD, 16);
        lIdLabel.setFont(labelFont);
        lNameLabel.setFont(labelFont);
        lAddressLabel.setFont(labelFont);
        lWorkingTypeLabel.setFont(labelFont);
        lDepartmentLabel.setFont(labelFont);
        lExperienceLabel.setFont(labelFont);
        lWorkingHoursLabel.setFont(labelFont);
        lEmploymentStatusLabel.setFont(labelFont);
        lGradedScoreLabel.setFont(labelFont);
        
        //increasing font size for lHeader
        Font headerFont = lHeader.getFont();
        headerFont = headerFont.deriveFont(lHeader.getFont().getSize() * 1.8f); //increasing by 80%
        lHeader.setFont(headerFont);
        
        //increasing font size for buttons
        Font buttonFont = lClearButton.getFont();
        buttonFont = buttonFont.deriveFont(lClearButton.getFont().getSize() * 1.2f); //increasing button's font size by 20%
        lAddButton.setFont(buttonFont);
        lClearButton.setFont(buttonFont);
        lDisplayButton.setFont(buttonFont);
        lBackButton.setFont(buttonFont);

        lHeader.setForeground(Color.WHITE);
        lIdLabel.setForeground(Color.WHITE);
        lNameLabel.setForeground(Color.WHITE);    
        lAddressLabel.setForeground(Color.WHITE);
        lWorkingTypeLabel.setForeground(Color.WHITE);     //setting white text color to labels
        lDepartmentLabel.setForeground(Color.WHITE);
        lExperienceLabel.setForeground(Color.WHITE);
        lWorkingHoursLabel.setForeground(Color.WHITE);
        lEmploymentStatusLabel.setForeground(Color.WHITE);
        lGradedScoreLabel.setForeground(Color.WHITE);
        
        lDisplayButton.setBackground(new Color(211, 211, 211));
        lClearButton.setBackground(new Color(211, 211, 211));     //setting grey bgcolor to buttons
        lAddButton.setBackground(new Color(211, 211, 211));
        lBackButton.setBackground(new Color(211, 211, 211));
        
        //adding to panel
        lPanel.add(lHeader);
        lPanel.add(lIdLabel);
        lPanel.add(lNameLabel);
        lPanel.add(lAddressLabel);
        lPanel.add(lWorkingTypeLabel);
        lPanel.add(lDepartmentLabel);
        lPanel.add(lExperienceLabel);
        lPanel.add(lWorkingHoursLabel);
        lPanel.add(lEmploymentStatusLabel);
        lPanel.add(lGradedScoreLabel);
        
        lPanel.add(lId);
        lPanel.add(lName);
        lPanel.add(lAddress);
        lPanel.add(lWorkingType);
        lPanel.add(lDepartment);
        lPanel.add(lExperience);
        lPanel.add(lWorkingHours);
        lPanel.add(lEmploymentStatus);
        lPanel.add(lGradedScore);
        
        lPanel.add(lDisplayButton);
        lPanel.add(lClearButton);
        lPanel.add(lAddButton);
        lPanel.add(lBackButton);
        
        //adding to frame
        lecturerFrame.getContentPane().add(lPanel);
    }
    
    public void displaysLecturerList() {
        lDisplayPanel = new JPanel(null);
        lDisplayPanel.setBackground(new Color(47, 79, 79));//creating labels and text-fields, setting bounds
        
        //creating labels
        dlHeader = new JLabel("List of Available Lecturers");
        dlHeader.setBounds(212, 80, 300, 35);
        
        //creating textarea
        JTextArea displayArea = new JTextArea(10, 10);
    
        String message = "";
        for(int i=0; i<listOfTeacher.size(); i++) 
        {   //iterating throughout the arraylist
            if ( (listOfTeacher.get(i) instanceof Lecturer) ) {
                message += listOfTeacher.get(i).display() ;
            }
        }
        
        //checking if user has inputted any data and displaying according to result
        if (message.equals("")) {
            displayArea.setText("There is currently no data here.\n Please input and try again.");
            displayArea.setFont(displayArea.getFont().deriveFont(16.0f)); //changing font of displayed text
        }
        else {
            displayArea.setText(message);
            displayArea.setFont(displayArea.getFont().deriveFont(16.0f)); //changing font of displayed text
        }
        //making it so that when display button is clicked, text area view starts from beginning
        displayArea.setCaretPosition(0);
        
        //creating scrollPane
        JScrollPane scrollingPanel = new JScrollPane(displayArea);
        scrollingPanel.setBounds(170, 180, 350, 220);
        
        //creating buttons
        dlBackButton = new JButton("<-Back-");
        dlBackButton.setBounds(20, 20, 90, 25);
        
        //increasing font size for dHeader
        Font headerFont = dlHeader.getFont();
        headerFont = headerFont.deriveFont(dlHeader.getFont().getSize() * 1.8f); //increase by 80%
        dlHeader.setFont(headerFont);
    
        //giving white color to labels
        dlHeader.setForeground(Color.WHITE);
        
        //changing button bg color
        dlBackButton.setBackground(new Color(211, 211, 211));
        
        //action listener
        //goes back to Lecturer's frame
        dlBackButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent b)
            {
                lDisplayFrame.setVisible(false);
                lecturerFrame.setVisible(true); //when back button is clicked, it goes back to previous frame
            }
        });
        
        //adding to panel
        lDisplayPanel.add(dlHeader);
        lDisplayPanel.add(dlBackButton);
        lDisplayPanel.add(scrollingPanel);
        
        //adding to frame
        lDisplayFrame.getContentPane().add(lDisplayPanel);
    }
    
    public void displaysTutorList() {
        tDisplayPanel = new JPanel(null);
        tDisplayPanel.setBackground(new Color(47, 79, 79));//creating labels and text-fields, setting bounds
        
        //creating labels
        dtHeader = new JLabel("List of Available Tutors");
        dtHeader.setBounds(225, 80, 300, 35);
        
        //creating textarea
        JTextArea displayArea = new JTextArea(10, 10);
    
        String message = "";
        for(int i=0; i<listOfTeacher.size(); i++) 
        {   //iterating throughout the arraylist
            if ( (listOfTeacher.get(i) instanceof Tutor) ) {
                message += listOfTeacher.get(i).display() ;
            }
        }
        
        //checking if user has inputted any data and displaying according to result
        if (message.equals("")) {
            displayArea.setText("There is currently no data here. Please input and try again.");
            displayArea.setFont(displayArea.getFont().deriveFont(16.0f)); //changing font of displayed text
        }
        else {
            displayArea.setText(message);
            displayArea.setFont(displayArea.getFont().deriveFont(16.0f)); //changing font of displayed text
        }
        //making it so that when display button is clicked, text area view starts from beginning
        displayArea.setCaretPosition(0);
        
        //creating scrollPane
        JScrollPane scrollingPanel = new JScrollPane(displayArea);
        scrollingPanel.setBounds(170, 180, 350, 220);
        
        //creating buttons
        dtBackButton = new JButton("<-Back-");
        dtBackButton.setBounds(20, 20, 90, 25);
        
        //increasing font size for dHeader
        Font headerFont = dtHeader.getFont();
        headerFont = headerFont.deriveFont(dtHeader.getFont().getSize() * 1.8f); //increase by 80%
        dtHeader.setFont(headerFont);
    
        //giving white color to labels
        dtHeader.setForeground(Color.WHITE);
        
        //changing button bg color
        dtBackButton.setBackground(new Color(211, 211, 211));
        
        //action listener
        //goes back to Tutor's frame
        dtBackButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent b)
            {
                tDisplayFrame.setVisible(false);
                tutorFrame.setVisible(true); //when back button is clicked, it goes back to previous frame
            }
        });
        
        //adding to panel
        tDisplayPanel.add(dtHeader);
        tDisplayPanel.add(dtBackButton);
        tDisplayPanel.add(scrollingPanel);
        
        //adding to frame
        tDisplayFrame.getContentPane().add(tDisplayPanel);
    }
    
    public void tutorsFrame() {
        tPanel = new JPanel(null);
        tPanel.setBackground(new Color(47, 79, 79)); //giving bgcolor
        
        //creating labels and setting bounds
        tHeader = new JLabel("Enter Tutor Details ");
        tHeader.setBounds(300, 30, 260, 60);
        tIdLabel = new JLabel("Id: ");
        tIdLabel.setBounds(30, 150, 50, 20);
        tNameLabel = new JLabel("Name: ");
        tNameLabel.setBounds(30, 200, 70, 20);
        tAddressLabel = new JLabel("Address: ");
        tAddressLabel.setBounds(30, 250, 100, 20);
        tWorkingTypeLabel = new JLabel("Working Type: ");
        tWorkingTypeLabel.setBounds(30, 300, 150, 20);
        tSpecializationLabel = new JLabel("Specialization: ");
        tSpecializationLabel.setBounds(30, 350, 150, 20);
        tPerformanceLabel = new JLabel("Performance Index: ");
        tPerformanceLabel.setBounds(420, 150, 180, 20);
        tSalaryLabel = new JLabel("Salary: ");
        tSalaryLabel.setBounds(420, 200, 100, 20);
        tWorkingHoursLabel = new JLabel("Working Hours: ");
        tWorkingHoursLabel.setBounds(420, 250, 190, 20);
        tEmploymentStatusLabel = new JLabel("Employment Status: ");
        tEmploymentStatusLabel.setBounds(420, 300, 170, 20);
        tQualificationLabel = new JLabel("Qualification: ");
        tQualificationLabel.setBounds(420, 350, 170, 20);
        
        //creating text-fields
        tId = new JTextField();
        tId.setBounds(150, 150, 170, 25);
        tName = new JTextField();
        tName.setBounds(150, 200, 170, 25);
        tAddress = new JTextField();
        tAddress.setBounds(150, 250, 170, 25);
        tWorkingType = new JTextField();
        tWorkingType.setBounds(150, 300, 170, 25);
        tSpecialization = new JTextField();
        tSpecialization.setBounds(150, 350, 170, 25);
        tPerformance = new JTextField();
        tPerformance.setBounds(593, 150, 180, 25);
        tSalary = new JTextField();
        tSalary.setBounds(593, 200, 180, 25);
        tWorkingHours = new JTextField();
        tWorkingHours.setBounds(593, 250, 180, 25);
        tEmploymentStatus = new JTextField();
        tEmploymentStatus.setBounds(593, 300, 180, 25);
        tQualification = new JTextField();
        tQualification.setBounds(593, 350, 180, 25);
        
        //creating buttons
        tAddButton = new JButton("Add to list");
        tAddButton.setBounds(160, 440, 130, 33);
        tDisplayButton = new JButton("Display");
        tDisplayButton.setBounds(360, 440, 120, 33);
        tClearButton = new JButton("Clear");
        tClearButton.setBounds(550, 440, 120, 33);
        tBackButton = new JButton("<-Back-");
        tBackButton.setBounds(20, 20, 90, 25);
        
        //number format listener try-catch block
        tAddButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent a)
            {
                try {
                    if( (tId.getText().trim().equals("")) || (tName.getText().trim().equals("")) || (tAddress.getText().trim().equals("")) || (tWorkingType.getText().trim().equals("")) || (tSalary.getText().trim().equals("")) || (tQualification.getText().trim().equals("")) || (tWorkingHours.getText().trim().equals("")) || (tEmploymentStatus.getText().trim().equals("")) || (tSpecialization.getText().trim().equals("")) || (tPerformance.getText().trim().equals(""))) {
                        JOptionPane.showMessageDialog(tutorFrame, "Empty Fields Found! Please fill all text areas. ", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    
                    else {
                        int tIdAvailable = Integer.parseInt(tId.getText());
                        boolean isAdded = true;
                        for(int i=0; i<listOfTeacher.size(); i++) {
                            if ( (tIdAvailable == listOfTeacher.get(i).getTeacher_id()) && (listOfTeacher.get(i) instanceof Tutor) ) {
                                isAdded = false;
                            }
                        }
                        
                        //adding only when tutor id is available
                        if (isAdded == true) {
                            int num1 = (int)(Double.parseDouble(tId.getText().trim()));
                            //trim function removes un-needed whitespaces in front of and behind inputs
                            int num2 = (int)(Double.parseDouble(tPerformance.getText().trim()));
                            int num3 = (int)(Double.parseDouble(tSalary.getText().trim()));
                            int num4 = (int)(Double.parseDouble(tWorkingHours.getText().trim()));
                            String str1 = tName.getText().trim();
                            String str2 = tAddress.getText().trim();
                            String str3 = tSpecialization.getText().trim();
                            String str4 = tWorkingType.getText().trim();
                            String str5 = tEmploymentStatus.getText().trim();
                            String str6 = tQualification.getText().trim();
                            
                            //adding to arrayList, upcasting Tutor values to Teacher type
                            listOfTeacher.add(new Tutor(num1, str1, str2, str4,  str5, num4, num3, str3, str6, num2));
                            //showing msg that addition of tutor was successful
                            JOptionPane.showMessageDialog(tutorFrame, "Successfully Added!");
                            
                            //clearing all fields after adding successfully
                            tId.setText("");
                            tName.setText("");
                            tAddress.setText("");
                            tWorkingType.setText("");
                            tSalary.setText("");
                            tSpecialization.setText("");
                            tWorkingHours.setText("");
                            tEmploymentStatus.setText("");
                            tPerformance.setText("");
                            tQualification.setText("");
                        }
                        
                        else {
                            JOptionPane.showMessageDialog(tutorFrame, "Id is already in use!! Try another tutor id.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }catch(NumberFormatException e) {
                    JOptionPane.showMessageDialog(tutorFrame, "Number Format Exception. Enter number only in number-required fields.");
                }
            }
        });
        
        //clearing all fields, action listener
        tClearButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent b)
            {
                if((!tId.getText().equals("")) || (!tName.getText().equals("")) || (!tAddress.getText().equals("")) || (!tWorkingType.getText().equals("")) || (!tSalary.getText().equals("")) || (!tQualification.getText().equals("")) || (!tWorkingHours.getText().equals("")) || (!tEmploymentStatus.getText().equals("")) || (!tSpecialization.getText().equals("")) || (!tPerformance.getText().equals(""))) {
                    int confirmation = JOptionPane.showConfirmDialog(tutorFrame, "Do you really want to clear all fields?", "Clear", JOptionPane.WARNING_MESSAGE);
                    if (confirmation == JOptionPane.YES_OPTION) {
                        tId.setText("");
                        tName.setText("");
                        tAddress.setText("");
                        tWorkingType.setText("");
                        tSpecialization.setText("");
                        tSalary.setText("");
                        tWorkingHours.setText("");
                        tEmploymentStatus.setText("");
                        tQualification.setText("");
                        tPerformance.setText("");
                    }
                }
            }
        });
        
        //opens new Frame to display entered tutors
        tDisplayButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent c)
            {
                tutorFrame.setVisible(false);
                tDisplayFrame.setVisible(true); //makes only the displaying frame visible
                displaysTutorList(); //code for this method which shows up in the frame is implemented above
            }
        });
        
        //goes back to main frame(buttonsFrame)
        tBackButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent d)
            {
                tutorFrame.setVisible(false);
                
                //clears all of its fields after clicking the back button to avoid issues with exception handeling
                tId.setText("");
                tName.setText("");
                tAddress.setText("");
                tWorkingType.setText("");
                tSpecialization.setText("");
                tSalary.setText("");
                tWorkingHours.setText("");
                tEmploymentStatus.setText("");
                tQualification.setText("");
                tPerformance.setText("");
                
                buttonsFrame.setVisible(true);
            }
        });
        
        //changing font size for all labels except tHeader
        Font labelFont = tIdLabel.getFont();
        labelFont = labelFont.deriveFont(Font.BOLD, 16);
        tIdLabel.setFont(labelFont);
        tNameLabel.setFont(labelFont);
        tAddressLabel.setFont(labelFont);
        tWorkingTypeLabel.setFont(labelFont);
        tSpecializationLabel.setFont(labelFont);
        tPerformanceLabel.setFont(labelFont);
        tWorkingHoursLabel.setFont(labelFont);
        tEmploymentStatusLabel.setFont(labelFont);
        tSalaryLabel.setFont(labelFont);
        tQualificationLabel.setFont(labelFont);
        
        //increasing font size for tHeader
        Font headerFont = tHeader.getFont();
        headerFont = headerFont.deriveFont(tHeader.getFont().getSize() * 1.8f); //increasing by 80%
        tHeader.setFont(headerFont);
        
        //increasing font size for buttons
        Font buttonFont = tClearButton.getFont();
        buttonFont = buttonFont.deriveFont(tClearButton.getFont().getSize() * 1.2f);
        tAddButton.setFont(buttonFont);
        tClearButton.setFont(buttonFont);
        tDisplayButton.setFont(buttonFont);
        tBackButton.setFont(buttonFont);

        tHeader.setForeground(Color.WHITE);
        tIdLabel.setForeground(Color.WHITE);
        tNameLabel.setForeground(Color.WHITE);    
        tAddressLabel.setForeground(Color.WHITE);
        tWorkingTypeLabel.setForeground(Color.WHITE);     //setting white text color to labels
        tSpecializationLabel.setForeground(Color.WHITE);
        tSalaryLabel.setForeground(Color.WHITE);
        tWorkingHoursLabel.setForeground(Color.WHITE);
        tEmploymentStatusLabel.setForeground(Color.WHITE);
        tPerformanceLabel.setForeground(Color.WHITE);
        tQualificationLabel.setForeground(Color.WHITE);
        
        tDisplayButton.setBackground(new Color(211, 211, 211));
        tClearButton.setBackground(new Color(211, 211, 211));     //setting grey bgcolor to buttons
        tAddButton.setBackground(new Color(211, 211, 211));
        tBackButton.setBackground(new Color(211, 211, 211));
        
        //adding to panel
        tPanel.add(tHeader);
        tPanel.add(tIdLabel);
        tPanel.add(tNameLabel);
        tPanel.add(tAddressLabel);
        tPanel.add(tWorkingTypeLabel);
        tPanel.add(tSalaryLabel);
        tPanel.add(tSpecializationLabel);
        tPanel.add(tWorkingHoursLabel);
        tPanel.add(tEmploymentStatusLabel);
        tPanel.add(tPerformanceLabel);
        tPanel.add(tQualificationLabel);
        
        tPanel.add(tId);
        tPanel.add(tName);
        tPanel.add(tAddress);
        tPanel.add(tWorkingType);
        tPanel.add(tSpecialization);
        tPanel.add(tSalary);
        tPanel.add(tWorkingHours);
        tPanel.add(tEmploymentStatus);
        tPanel.add(tPerformance);
        tPanel.add(tQualification);
        
        tPanel.add(tDisplayButton);
        tPanel.add(tClearButton);
        tPanel.add(tAddButton);
        tPanel.add(tBackButton);
        
        //adding to frame
        tutorFrame.getContentPane().add(tPanel);
    }
    
    public void gradesAssignment() {
        gPanel = new JPanel(null);
        gPanel.setBackground(new Color(47, 79, 79)); //giving bgcolor
        
        //creating labels and setting bounds
        gHeader = new JLabel("Enter Details ");
        gHeader.setBounds(250, 80, 260, 60);
        gIdLabel = new JLabel("Id: ");
        gIdLabel.setBounds(160, 170, 50, 20);
        gDepartmentLabel = new JLabel("Department: ");
        gDepartmentLabel.setBounds(160, 220, 120, 20);
        gGradedScoreLabel = new JLabel("Graded Score: ");
        gGradedScoreLabel.setBounds(160, 270, 130, 20);
        gExperienceLabel = new JLabel("Experience: ");
        gExperienceLabel.setBounds(160, 320, 120, 20);
        
        //creating text-fields and setting bounds
        gId = new JTextField();
        gId.setBounds(300, 170, 170, 25);
        gDepartment = new JTextField();
        gDepartment.setBounds(300, 220, 170, 25);
        gGradedScore = new JTextField();
        gGradedScore.setBounds(300, 270, 170, 25);
        gExperience = new JTextField();
        gExperience.setBounds(300, 320, 170, 25);
        
        //creating buttons
        gGradeButton = new JButton("Grade");
        gGradeButton.setBounds(190, 390, 120, 33);
        gClearButton = new JButton("Clear");
        gClearButton.setBounds(340, 390, 120, 33);
        gBackButton = new JButton("<-Back-");
        gBackButton.setBounds(20, 20, 90, 25);
        
        //adding action listeners to buttons
        //grades according to score
        gGradeButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent a)
            {
                try 
                {
                    if( (gId.getText().trim().equals("")) || (gDepartment.getText().trim().equals("")) || (gGradedScore.getText().trim().equals("")) || (gExperience.getText().trim().equals("")) ) {
                        JOptionPane.showMessageDialog(gradeFrame, "Empty Field Found! Please fill required area. ", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    
                    else {
                        //grading code
                        String departmentCheck = gDepartment.getText().trim(); //trim function removes un-needed whitespaces in front of and behind inputs
                        int experienceCheck = (int)Double.parseDouble(gExperience.getText().trim());
                        int gradedScoreCheck = (int)Double.parseDouble(gGradedScore.getText().trim());
                        int idCheck = (int)Double.parseDouble(gId.getText().trim());
                        String resultingGrade = "";
                        
                        //iterating through the arraylist and checking if each is instance of lecturer
                        for(int i=0; i<listOfTeacher.size(); i++) {
                            if( (listOfTeacher.get(i).getTeacher_id() == idCheck) && (listOfTeacher.get(i) instanceof Lecturer) ) {
                                resultingGrade = ((Lecturer)listOfTeacher.get(i)).gradeAssignment(gradedScoreCheck, departmentCheck, experienceCheck );
                            }
                        }
                        
                        //checking if id exists
                        if(resultingGrade.equals("")) {
                            JOptionPane.showMessageDialog(gradeFrame, "Lecturer id doesn't exist. Input correct id.");
                        }
                        else {
                            //showing result and clearing only after grading successfully
                            if (resultingGrade.equals("A") || resultingGrade.equals("B") || resultingGrade.equals("C") || resultingGrade.equals("D") || resultingGrade.equals("E")) {
                                String gradedMessage = "You have scored " + resultingGrade + "!!";
                                JOptionPane.showMessageDialog(gradeFrame, gradedMessage);
                                gId.setText("");
                                gDepartment.setText("");
                                gExperience.setText("");
                                gGradedScore.setText("");
                            } 
                            else {
                                //if resultingGrade string doesn't have store grade then showing appropriate message, i.e, department or experience mismatch
                                JOptionPane.showMessageDialog(gradeFrame, resultingGrade);
                            }
                        }
                    }
                }
                catch(NumberFormatException e) {
                    JOptionPane.showMessageDialog(gradeFrame, "Number Format Exception. Enter number only in number-required fields.");
                }
            }
        });
        
        //clears all fields
        gClearButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent b)
            {
                if((!gId.getText().equals("")) || (!gDepartment.getText().equals("")) || (!gGradedScore.getText().equals("")) || (!gExperience.getText().equals(""))) {
                    int confirmation = JOptionPane.showConfirmDialog(gradeFrame, "Do you really want to clear all fields?", "Clear", JOptionPane.WARNING_MESSAGE);
                    if (confirmation == JOptionPane.YES_OPTION) {
                        gId.setText("");
                        gDepartment.setText("");
                        gGradedScore.setText("");
                        gExperience.setText("");
                    } 
                }
            }
        });
        
        //goes back to main frame(buttonsFrame)
        gBackButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent c)
            {
                gradeFrame.setVisible(false);
                
                //clears all of its fields after clicking the back button to avoid issues with exception handeling
                gId.setText("");
                gDepartment.setText("");
                gGradedScore.setText("");
                gExperience.setText("");
                
                buttonsFrame.setVisible(true);
            }
        });        
        
        //changing font size for all labels except gHeader
        Font labelFont = gIdLabel.getFont();
        labelFont = labelFont.deriveFont(Font.BOLD, 16);
        gIdLabel.setFont(labelFont);
        gDepartmentLabel.setFont(labelFont);
        gGradedScoreLabel.setFont(labelFont);
        gExperienceLabel.setFont(labelFont);
        
        //increasing font size for gHeader
        Font headerFont = gHeader.getFont();
        headerFont = headerFont.deriveFont(gHeader.getFont().getSize() * 1.8f); //increasing by 80%
        gHeader.setFont(headerFont);
        
        //increasing font size for buttons
        Font buttonFont = gClearButton.getFont();
        buttonFont = buttonFont.deriveFont(gClearButton.getFont().getSize() * 1.2f); //increasing by 20%
        gGradeButton.setFont(buttonFont);
        gClearButton.setFont(buttonFont);
        gBackButton.setFont(buttonFont);

        gHeader.setForeground(Color.WHITE);
        gIdLabel.setForeground(Color.WHITE);
        gDepartmentLabel.setForeground(Color.WHITE);    
        gGradedScoreLabel.setForeground(Color.WHITE);
        gExperienceLabel.setForeground(Color.WHITE);     //setting white text color to labels
        
        gGradeButton.setBackground(new Color(211, 211, 211));
        gClearButton.setBackground(new Color(211, 211, 211));     //setting grey bgcolor to buttons
        gBackButton.setBackground(new Color(211, 211, 211));
        
        //adding to panel
        gPanel.add(gHeader);
        gPanel.add(gIdLabel);
        gPanel.add(gDepartmentLabel);
        gPanel.add(gGradedScoreLabel);
        gPanel.add(gExperienceLabel);
        gPanel.add(gId);
        gPanel.add(gDepartment);
        gPanel.add(gGradedScore);
        gPanel.add(gExperience);
        gPanel.add(gGradeButton);
        gPanel.add(gClearButton);
        gPanel.add(gBackButton);
        
        //adding to frame
        gradeFrame.getContentPane().add(gPanel);
    }
    
    public void setsSalary() {
        sPanel = new JPanel(null);
        sPanel.setBackground(new Color(47, 79, 79)); //giving bgcolor
        
        //creating labels and setting bounds
        sHeader = new JLabel("Enter Details ");
        sHeader.setBounds(225, 80, 260, 60);
        sIdLabel = new JLabel("Id: ");
        sIdLabel.setBounds(160, 170, 50, 20);
        sPerformanceLabel = new JLabel("Performance: ");
        sPerformanceLabel.setBounds(160, 220, 140, 20);
        sSalaryLabel = new JLabel("Salary: ");
        sSalaryLabel.setBounds(160, 270, 130, 20);
        
        //creating text-fields and setting bounds
        sId = new JTextField();
        sId.setBounds(280, 170, 170, 25);
        sPerformance = new JTextField();
        sPerformance.setBounds(280, 220, 170, 25);
        sSalary = new JTextField();
        sSalary.setBounds(280, 270, 170, 25);
        
        //creating buttons
        sSetSalaryButton = new JButton("Set");
        sSetSalaryButton.setBounds(230, 345, 60, 33);
        sClearButton = new JButton("Clear");
        sClearButton.setBounds(320, 345, 80, 33);
        sBackButton = new JButton("<-Back-");
        sBackButton.setBounds(20, 20, 90, 25);
        
        //adding action listeners to buttons
        //grades according to score
        sSetSalaryButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent a)
            {
                try {
                    if( sId.getText().trim().equals("") || sPerformance.getText().trim().equals("") || sSalary.getText().trim().equals("") ) {
                        JOptionPane.showMessageDialog(salaryFrame, "Empty Field Found! Please fill required area. ", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    
                    else {
                        //setting salary code
                        int idCheck = (int)Double.parseDouble(sId.getText().trim());
                        double salaryCheck = Double.parseDouble(sSalary.getText().trim());
                        int performanceCheck = (int)Double.parseDouble(sPerformance.getText().trim());
                        String updatedSalary = "";
                        
                        //iterating through the arraylist and checking if each is instance of lecturer
                        for(int i=0; i<listOfTeacher.size(); i++) {
                            if( (listOfTeacher.get(i).getTeacher_id() == idCheck) && (listOfTeacher.get(i) instanceof Tutor) ) {
                                updatedSalary = ((Tutor)listOfTeacher.get(i)).setSalary(salaryCheck, performanceCheck);
                            }
                        }
                        
                        if(updatedSalary.equals("")) {
                            JOptionPane.showMessageDialog(salaryFrame, "Tutor id doesn't exist. Input correct id.");
                        }
                        else {
                            if(performanceCheck > 10) {
                                JOptionPane.showMessageDialog(salaryFrame, updatedSalary);
                            }
                            else {
                                String salaryMessage = "The tutor's updated salary is " + updatedSalary;
                                JOptionPane.showMessageDialog(salaryFrame, salaryMessage);
                                
                                //clearing field after setting salary successfully
                                sId.setText("");
                                sPerformance.setText("");
                                sSalary.setText("");
                            }
                        }
                    }
                }catch(NumberFormatException e) {
                    JOptionPane.showMessageDialog(salaryFrame, "Number Format Exception. Enter number only in number-required fields.");
                }
            }
        });
        
        //clears all fields
        sClearButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent b)
            {
                if( !sId.getText().equals("") || !sPerformance.getText().equals("") || !sSalary.getText().equals("") ) {
                    int confirmation = JOptionPane.showConfirmDialog(salaryFrame, "Do you really want to clear all fields?", "Clear", JOptionPane.WARNING_MESSAGE);
                    if (confirmation == JOptionPane.YES_OPTION) {
                        sId.setText("");
                        sPerformance.setText("");
                        sSalary.setText("");
                    }
                }
            }
        });
        
        //goes back to main frame(buttonsFrame)
        sBackButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent c)
            {
                salaryFrame.setVisible(false);
                
                //clears all of its fields after clicking the back button to avoid issues with exception handeling
                sId.setText("");
                sPerformance.setText("");
                sSalary.setText("");
                
                buttonsFrame.setVisible(true);
            }
        });        
        
        //changing font size for all labels except sHeader
        Font labelFont = sIdLabel.getFont();
        labelFont = labelFont.deriveFont(Font.BOLD, 16);
        sIdLabel.setFont(labelFont);
        sPerformanceLabel.setFont(labelFont);
        sSalaryLabel.setFont(labelFont);
        
        //increasing font size for sHeader
        Font headerFont = sHeader.getFont();
        headerFont = headerFont.deriveFont(sHeader.getFont().getSize() * 1.8f); //increasing by 80%
        sHeader.setFont(headerFont);
        
        //increasing font size for buttons
        Font buttonFont = sClearButton.getFont();
        buttonFont = buttonFont.deriveFont(sClearButton.getFont().getSize() * 1.2f); //increasing by 20%
        sSetSalaryButton.setFont(buttonFont);
        sClearButton.setFont(buttonFont);
        sBackButton.setFont(buttonFont);

        sHeader.setForeground(Color.WHITE);
        sIdLabel.setForeground(Color.WHITE);
        sPerformanceLabel.setForeground(Color.WHITE);    
        sSalaryLabel.setForeground(Color.WHITE);     //setting white text color to labels
        
        sSetSalaryButton.setBackground(new Color(211, 211, 211));
        sClearButton.setBackground(new Color(211, 211, 211));     //setting grey bgcolor to buttons
        sBackButton.setBackground(new Color(211, 211, 211));
        
        //adding to panel
        sPanel.add(sHeader);
        sPanel.add(sIdLabel);
        sPanel.add(sPerformanceLabel);
        sPanel.add(sSalaryLabel);
        sPanel.add(sId);
        sPanel.add(sPerformance);
        sPanel.add(sSalary);
        sPanel.add(sSetSalaryButton);
        sPanel.add(sClearButton);
        sPanel.add(sBackButton);
        
        //adding to frame
        salaryFrame.getContentPane().add(sPanel);
    }
    
    public void removesTutor() {
        rPanel = new JPanel(null);
        rPanel.setBackground(new Color(47, 79, 79));
        
        //creating labels and text-fields, setting bounds
        rHeader = new JLabel("Enter Id");
        rHeader.setBounds(250, 90, 460, 60);
        rIdLabel = new JLabel("Id: ");
        rIdLabel.setBounds(190, 200, 50, 20);
        rId = new JTextField();
        rId.setBounds(230, 200, 150, 25);
        
        //creating buttons
        rRemoveButton = new JButton("Remove");
        rRemoveButton.setBounds(250, 260, 100, 33);
        rBackButton = new JButton("<-Back-");
        rBackButton.setBounds(20, 20, 90, 25);
        
        //changing font size for id label
        Font labelFont = rIdLabel.getFont();
        labelFont = labelFont.deriveFont(Font.BOLD, 16);
        rIdLabel.setFont(labelFont);
        
        //increasing font size for rHeader
        Font headerFont = rHeader.getFont();
        headerFont = headerFont.deriveFont(rHeader.getFont().getSize() * 1.8f); //increase by 80%
        rHeader.setFont(headerFont);
        
        //increasing font size for buttons
        Font buttonFont = rRemoveButton.getFont();
        buttonFont = buttonFont.deriveFont(rRemoveButton.getFont().getSize() * 1.2f);
        rRemoveButton.setFont(buttonFont);
        rBackButton.setFont(buttonFont);
    
        //giving white color to labels
        rHeader.setForeground(Color.WHITE);
        rIdLabel.setForeground(Color.WHITE);
        
        //changing button bg color
        rRemoveButton.setBackground(new Color(211, 211, 211));
        rBackButton.setBackground(new Color(211, 211, 211));
        
        //action listener
        //number format exception
        rRemoveButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent a)
            {
                try {
                    if( rId.getText().trim().equals("") ) {
                        JOptionPane.showMessageDialog(removeFrame, "Empty Field Found! Please fill required area. ", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    
                    else {
                        //removing code
                        int rid = Integer.parseInt(rId.getText().trim());
                        boolean isRemoved = false;
                        for(int i=0; i<listOfTeacher.size(); i++) {
                            if ( rid == listOfTeacher.get(i).getTeacher_id() && listOfTeacher.get(i) instanceof Tutor ) {
                                listOfTeacher.remove(i);
                                isRemoved = true;
                            }
                        }
                        
                        if(isRemoved == true) {
                            //showing message to user that the tutor has been removed successfully
                            JOptionPane.showMessageDialog(removeFrame, "The tutor has been removed successfully");
                            //clearing field after removing successfully
                            rId.setText("");
                        }
                        
                        else {
                            //showing message to user that the tutor has not been removed; failed to remove
                            JOptionPane.showMessageDialog(removeFrame, "Enter valid Tutor Id.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }catch(NumberFormatException e) {
                    JOptionPane.showMessageDialog(removeFrame, "Number Format Exception. Enter number only in number-required fields.");
                }
            }
        });
        
        //goes back to main frame(buttonsFrame)
        rBackButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent b)
            {
                removeFrame.setVisible(false);
                
                //clears its fields after clicking the back button to avoid issues with exception handeling
                sId.setText("");
                
                buttonsFrame.setVisible(true);
            }
        });
        
        //adding to panel
        rPanel.add(rHeader);
        rPanel.add(rIdLabel);
        rPanel.add(rId);
        rPanel.add(rRemoveButton);
        rPanel.add(rBackButton);
        
        //adding to frame
        removeFrame.getContentPane().add(rPanel);
    }
    
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TeacherGUI();
            }
        });  
    }
}