import java.util.Scanner;
import java.util.ArrayList;

abstract class student {
    private String studentID;
    private String name;
    private int age;
    private String address;
    String St_method;
    String course_id = "Not Assigned !!";

    public student(String studentID, String name, int age, String address , String stm) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.address = address;
        this.St_method = stm;
    }

    public String getName() {return name;}
    public int getAge() {return age;}
    public String getAddr() {return address;}
    public String getID() {return studentID;}
    public String getcourse() {return course_id;}


    public void setName(String name) {this.name = name;}
    public void setAge(int age) {this.age = age;}
    public void setAddr(String address) {this.address = address;}
    public void setID(String studentID) {this.studentID = studentID;}
    public void setcourse(String course_id) {this.course_id = course_id;}

    abstract public void display();
}

class Online_STd extends student{

    private String Online_ID;

    public Online_STd(String stID ,String name, int age, String address , String stm , String Online_ID) {
        super(stID ,name, age, address, stm);
        this.Online_ID = Online_ID;
    }

    public String getOnline_ID() {return Online_ID;}
    public void setOnline_ID(String online_ID) {Online_ID = online_ID;}


    @Override
    public void display() {
        System.out.println("Name: " + getName());
        System.out.println("Student ID : " + getID());
        System.out.println("Age: " + getAge());
        System.out.println("Address: " + getAddr());
        System.out.println("Study Method: " + St_method);
        System.out.println("Online ID: " + Online_ID);
        System.out.println("Course ID: " + getcourse());
    }
}

class Pys_STd extends student{

    private String Branch;

    public Pys_STd(String stid , String name, int age, String address , String stm , String Branch) {
        super(stid ,name, age, address, stm);
        this.Branch = Branch;
    }

    public String getbarnch() {return Branch;}
    public void setbarnch(String Branch) {this.Branch = Branch;}

    @Override
    public void display() {
        System.out.println("Name: " + getName());
        System.out.println("Student ID : " + getID());
        System.out.println("Age: " + getAge());
        System.out.println("Address: " + getAddr());
        System.out.println("Study Method: " + St_method);
        System.out.println("Branch : " + Branch);
        System.out.println("Course ID: " + getcourse());
    }
}

abstract class course {
    private String courseName;
    private String courseCode;
    private int duration;
    private String courseType;

    public course(String courseName, String courseCode, int duration , String courseType) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.duration = duration;
        if (duration <= 6) {
            this.courseType = "Short-term";
        } else if (duration <= 12) {
            this.courseType = "Medium-term";
        } else {
            this.courseType = "Long-term";
        }
    }

    public String getCourseName() {return courseName;}
    public String getCourseCode() {return courseCode;}
    public int getDuration() {return duration;}
    public String getCourseType() {return courseType;}

    public void setCourseName(String courseName) {this.courseName = courseName;}
    public void setCourseCode(String courseCode) {this.courseCode = courseCode;}
    public void setDuration(int duration) {this.duration = duration;}
    public void setCourseType(String courseType) {this.courseType = courseType;}

    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Course Code: " + courseCode);
        System.out.println("Duration: " + duration + " months");
        System.out.println("Course Type: " + courseType);
    }

    abstract public void StartCourse();

}

class pys_course extends course {

    private String branch;
    private int Max_Students;

    public pys_course(String courseName, String courseCode, int duration , String courseType , String branch , int Max_Students) {
        super(courseName, courseCode, duration, courseType);
        this.branch = branch;
        this.Max_Students = Max_Students;
    }

    public String getBranch() {return branch;}
    public int getMax_Students() {return Max_Students;}

    public void setBranch(String branch) {this.branch = branch;}
    public void setMax_Students(int max_Students) {Max_Students = max_Students;}

    @Override
    public void displayCourseDetails() {
        super.displayCourseDetails();
        System.out.println("Branch: " + branch);
    }
    @Override
    public void StartCourse() {
        System.out.println("The course " + getCourseName() + " has started.");
    }
}

class online_course extends course {

    private String platform;

    public online_course(String courseName, String courseCode, int duration , String courseType , String platform) {
        super(courseName, courseCode, duration, courseType);
        this.platform = platform;
    }

    public String getPlatform() {return platform;}

    public void setPlatform(String platform) {this.platform = platform;}

    @Override
    public void displayCourseDetails() {
        super.displayCourseDetails();
        System.out.println("Platform: " + platform);
    }
    
    @Override
    public void StartCourse() {
        System.out.println("The online course " + getCourseName() + " has started on " + platform + ".");
    }
}

abstract class staff {
    private String st_id;
    private String name;
    private String position;
    private int experience;
    
    public staff(String st_id, String name, String position, int experience) {
        this.st_id = st_id;
        this.name = name;
        this.position = position;
        this.experience = experience;
    }

    public String getName() {return name;}
    public String getPosition() {return position;}
    public int getExperience() {return experience;}
    public String getSt_id() {return st_id;}

    public void setName(String name) {this.name = name;}
    public void setPosition(String position) {this.position = position;}
    public void setExperience(int experience) {this.experience = experience;}
    public void setSt_id(String st_id) {this.st_id = st_id;}

    abstract public void displayStaffDetails();
}

class academic_staff extends staff {

    private String subject;

    public academic_staff(String st_id, String name, String position, int experience , String subject) {
        super(st_id, name, position, experience);
        this.subject = subject;
    }

    public String getSubject() {return subject;}
    public void setSubject(String subject) {this.subject = subject;}

    @Override
    public void displayStaffDetails() {
        System.out.println("Staff ID: " + getSt_id());
        System.out.println("Name: " + getName());
        System.out.println("Position: " + getPosition());
        System.out.println("Experience: " + getExperience() + " years");
        System.out.println("Subject: " + subject);
    }
}

class non_academic_staff extends staff {

    private String department;

    public non_academic_staff(String st_id, String name, String position, int experience , String department) {
        super(st_id, name, position, experience);
        this.department = department;
    }

    public String getDepartment() {return department;}
    public void setDepartment(String department) {this.department = department;}

    @Override
    public void displayStaffDetails() {
        System.out.println("Staff ID: " + getSt_id());
        System.out.println("Name: " + getName());
        System.out.println("Position: " + getPosition());
        System.out.println("Experience: " + getExperience() + " years");
        System.out.println("Department: " + department);
    }
}

public class SmartCoureseEnrollmentSystem {

    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            for (int i = 0; i < 50; i++) System.out.println();
        }

        System.out.println("----- Welcome To Smart Course Enrollment System -----");
        System.out.println("               NextGen Devs @ 2025");
        System.out.println("----------------------------------------------------- \n \n\n");
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        ArrayList<Pys_STd> listPyStudents = new ArrayList<>();
        ArrayList<Online_STd> listOnStudents = new ArrayList<>();
        ArrayList<pys_course> listPyCourse = new ArrayList<>();
        ArrayList<online_course> listOnCourse = new ArrayList<>();
        ArrayList<academic_staff> listAcStaff = new ArrayList<>();
        ArrayList<non_academic_staff> listNonAcStaff = new ArrayList<>();

        listNonAcStaff.add(new non_academic_staff("STF01", "Admin", "Admin",00, "Admin"));
        listAcStaff.add(new academic_staff("STF02", "John", "Admin",5, "Computer Science"));
        listOnStudents.add(new Online_STd("S01", "Alice", 20, "123 Street", "Online", "Zoom_01"));
        listPyStudents.add(new Pys_STd("S02", "Bob", 22, "456 Avenue", "Pyscle", "CSE"));
        listOnCourse.add(new online_course("Java Programming", "ONC01", 3, "Short-term", "Coursera"));
        listPyCourse.add(new pys_course("Data Structures", "PYC01", 6, "Medium-term", "CSE", 30));

        clearScreen();

        while(true){
            

            System.out.println("...... Login ...... \n");
            System.out.println("Login As ..");
            System.out.println("1. Student");
            System.out.println("2. Staff");
            System.out.println("3. Create New Account(Student)");
            System.out.println("0. Exit");
            System.out.println("\nEnter An Option");
            int choice = sc.nextInt();
            sc.nextLine();
            
            if(choice == 1){
                System.out.println("Enter Student ID ::");
                    String studentID = sc.nextLine();
                    boolean found = false;
                    Online_STd foundStudent1 = null;
                    Pys_STd foundStudent2 = null;

                    for (Online_STd student : listOnStudents) {
                        if (student.getID().equals(studentID)) {
                            found = true;
                            foundStudent1 = student;
                            break;
                        }
                    }

                    if (!found) {
                        for (Pys_STd student : listPyStudents) {
                            if (student.getID().equals(studentID)) {
                                found = true;
                                foundStudent2 = student;
                                break;
                            }
                        }
                    }

                    if (!found) {
                        System.out.println("Student not found!");
                        continue;
                    }
                out:
                while(found) {
                    clearScreen();
                    System.out.println("\n1.Start Course ::");
                    System.out.println("2.View My Details ::");
                    System.out.println("3.View Course Details ::");
                    System.out.println("Select Option (0 - Main Menu) ::");
                    int studentChoice = sc.nextInt();
                    sc.nextLine();

                    switch (studentChoice) {
                        case 1:
                            if (foundStudent1 != null) {
                                System.out.println("Starting course for Online Student...");
                                for (online_course course : listOnCourse) {
                                    if (course.getCourseCode().equals(foundStudent1.getcourse())) {
                                        course.StartCourse();
                                        break;
                                    }
                                }
                            } else if (foundStudent2 != null) {
                                System.out.println("Starting course for Physical Student...");
                                for (pys_course course : listPyCourse) {
                                    if (course.getCourseCode().equals(foundStudent2.getcourse())) {
                                        course.StartCourse();
                                        break;
                                    }
                                }
                            } else {
                                System.out.println("No course assigned to the student!");
                            }
                            break;
                        case 2:
                            if (foundStudent1 != null) {
                                foundStudent1.display();
                            } else if (foundStudent2 != null) {
                                foundStudent2.display();
                            }
                            break;
                        case 3:
                            System.out.println("Online Courses:");
                            for (online_course course : listOnCourse) {
                                course.displayCourseDetails();
                                System.out.println("-------------------------");
                            }
                            System.out.println("Physical Courses:");
                            for (pys_course course : listPyCourse) {
                                course.displayCourseDetails();
                                System.out.println("-------------------------");
                            }
                            break;
                        default:
                            System.out.println("Invalid Option!");
                            break out;
                    }
                    String ads = sc.nextLine();
                }

            }else if (choice == 2){
                System.out.println("\nEnter Staff ID ::");
                String staffID = sc.nextLine();
                System.out.println("Enter Password ::");
                String password = sc.nextLine();
                boolean found = false;
                academic_staff foundStaff1 = null;
                non_academic_staff foundStaff2 = null;

                for (academic_staff staff : listAcStaff) {
                    if (staff.getSt_id().equals(staffID)) {
                        staff.displayStaffDetails();
                        found = true;
                        foundStaff1 = staff;
                        break;
                    }
                }

                if (!found) {
                    for (non_academic_staff staff : listNonAcStaff) {
                        if (staff.getSt_id().equals(staffID)) {
                            staff.displayStaffDetails();
                            found = true;
                            foundStaff2 = staff;
                            break;
                        }
                    }
                }

                if (!found) {
                    System.out.println("Staff not found!");
                    continue;
                }

                if (found&&password.equals("staff123")) {
                        outer:
                        while (found) {
                        clearScreen();
                        System.out.println("\n\n1. Add Staff Member  ::");
                        System.out.println("2. Remove Staff Member  ::");
                        System.out.println("3. Assign Course To Student::");
                        System.out.println("4. Remove Course From Student::");
                        System.out.println("5. Add Course ::");
                        System.out.println("6. Remove Course ::");
                        System.out.println("7. View Staff Details ::");
                        System.out.println("8. View Course Details ::");
                        System.out.println("9. View Student Details ::");
                        System.out.println("\nEnter Option (0 - Main Menu) ::");
                        int staffChoice = sc.nextInt();
                        sc.nextLine(); 
                        switch (staffChoice) {
                            case 1:
                                System.out.println("Enter Staff ID ::");
                                String newStaffID = sc.nextLine();
                                System.out.println("Enter Staff Name ::");
                                String newStaffName = sc.nextLine();
                                System.out.println("Enter Staff Position(Academic/Non-Academic) ::");
                                String position = sc.nextLine();
                                System.out.println("Enter Staff Experience (in years) ::");
                                int experience = sc.nextInt();
                                sc.nextLine(); 
                                System.out.println("Enter Subject/Department ::");
                                String subjectOrDepartment = sc.nextLine();

                                if (position.equalsIgnoreCase("Academic")) {
                                    listAcStaff.add(new academic_staff(newStaffID, newStaffName, position, experience, subjectOrDepartment));
                                    System.out.println("Academic Staff Added Successfully!");
                                } else if (position.equalsIgnoreCase("Non-Academic")) {
                                    listNonAcStaff.add(new non_academic_staff(newStaffID, newStaffName, position, experience, subjectOrDepartment));
                                    System.out.println("Non-Academic Staff Added Successfully!");
                                } else {
                                    System.out.println("Invalid Position!");
                                }
                                break;
                            case 2:
                                System.out.println("Enter Staff ID to Remove ::");
                                String removeStaffID = sc.nextLine();
                                for (academic_staff staff : listAcStaff) {
                                    if (staff.getSt_id().equals(removeStaffID)) {
                                        listAcStaff.remove(staff);
                                        System.out.println("Academic Staff Removed Successfully!");
                                        break;
                                    }
                                }
                                break;
                            case 3:
                                System.out.println("Enter Student ID to Assign Course ::");
                                String studentIDToAssign = sc.nextLine();
                                boolean studentFound = false;
                                for (Online_STd student : listOnStudents) {
                                    if (student.getID().equals(studentIDToAssign)) {
                                        System.out.println("Enter Course Code to Assign ::");
                                        String courseCode = sc.nextLine();
                                        student.setcourse(courseCode);
                                        System.out.println("Course Assigned Successfully to Online Student!");
                                        studentFound = true;
                                        break;
                                    }
                                }
                                if (!studentFound) {
                                    for (Pys_STd student : listPyStudents) {
                                        if (student.getID().equals(studentIDToAssign)) {
                                            System.out.println("Enter Course Code to Assign ::");
                                            String courseCode = sc.nextLine();
                                            student.setcourse(courseCode);
                                            System.out.println("Course Assigned Successfully to Physical Student!");
                                            studentFound = true;
                                            break;
                                        }
                                    }
                                }
                                if (!studentFound) {
                                    System.out.println("Student not found!");
                                }
                                break;
                            case 4:
                                System.out.println("Enter Student ID to Remove Course ::");
                                String studentIDToRemove = sc.nextLine();
                                boolean studentFoundForRemoval = false;
                                for (Online_STd student : listOnStudents) {
                                    if (student.getID().equals(studentIDToRemove)) {
                                        student.setcourse("Not Assigned !!");
                                        System.out.println("Course Removed Successfully from Online Student!");
                                        studentFoundForRemoval = true;
                                        break;
                                    }
                                }
                                if (!studentFoundForRemoval) {
                                    for (Pys_STd student : listPyStudents) {
                                        if (student.getID().equals(studentIDToRemove)) {
                                            student.setcourse("Not Assigned !!");
                                            System.out.println("Course Removed Successfully from Physical Student!");
                                            studentFoundForRemoval = true;
                                            break;
                                        }
                                    }
                                }   
                                if (!studentFoundForRemoval) {
                                    System.out.println("Student not found!");
                                }
                                break;
                            case 5:
                                System.out.println("Enter Course Name ::");
                                String courseName = sc.nextLine();
                                System.out.println("Enter Course Code ::");
                                String courseCode = sc.nextLine();
                                System.out.println("Enter Course Duration (in months) ::");
                                int duration = sc.nextInt();
                                sc.nextLine();
                                System.out.println("Enter Course Type (Online/Pyscle) ::");
                                String courseType = sc.nextLine();
                                if (courseType.equalsIgnoreCase("Online")) {
                                    System.out.println("Enter Platform ::");
                                    String platform = sc.nextLine();
                                    listOnCourse.add(new online_course(courseName, courseCode, duration, courseType, platform));
                                    System.out.println("Online Course Added Successfully!");
                                } else if (courseType.equalsIgnoreCase("Pyscle")) {
                                    System.out.println("Enter Branch ::");
                                    String branch = sc.nextLine();
                                    System.out.println("Enter Max Students ::");
                                    int maxStudents = sc.nextInt();
                                    sc.nextLine(); 
                                    listPyCourse.add(new pys_course(courseName, courseCode, duration, courseType, branch, maxStudents));
                                    System.out.println("Physical Course Added Successfully!");
                                } else {
                                    System.out.println("Invalid Course Type!");
                                }
                                break;
                            case 6:
                                System.out.println("Enter Course Code to Remove ::");
                                String removeCourseCode = sc.nextLine();
                                for (online_course course : listOnCourse) {
                                    if (course.getCourseCode().equals(removeCourseCode)) {
                                        listOnCourse.remove(course);
                                        System.out.println("Online Course Removed Successfully!");
                                        break;
                                    }
                                }
                                for (pys_course course : listPyCourse) {
                                    if (course.getCourseCode().equals(removeCourseCode)) {
                                        listPyCourse.remove(course);
                                        System.out.println("Pyscle Course Removed Successfully!");
                                        break;
                                    }
                                }

                                break;
                            case 7:
                                System.out.println("Academic Staff Members:");
                                for (academic_staff staff : listAcStaff) {
                                    staff.displayStaffDetails();
                                    System.out.println("-------------------------");
                                }

                                System.out.println("Non-Academic Staff Members:");
                                for (non_academic_staff staff : listNonAcStaff) {
                                    staff.displayStaffDetails();
                                    System.out.println("-------------------------");
                                }
                                break;
                            case 8:
                                System.out.println("Online Courses:");
                                for (online_course course : listOnCourse) {
                                    course.displayCourseDetails();
                                    System.out.println("-------------------------");
                                }
                                System.out.println("Physical Courses:");
                                for (pys_course course : listPyCourse) {
                                    course.displayCourseDetails();
                                    System.out.println("-------------------------");
                                }
                                break;
                            case 9:
                                System.out.println("Online Students:");
                                for (Online_STd student : listOnStudents) {
                                    student.display();
                                    System.out.println("-------------------------");
                                }
                                System.out.println("Physical Students:");
                                for (Pys_STd student : listPyStudents) {
                                    student.display();
                                    System.out.println("-------------------------");
                                }
                                break;
                            default:
                                System.out.println("Invalid Option!");
                                break outer;
                        }
                        String ads = sc.nextLine();
                    }
                        
                }else {
                    System.out.println("Invalid Staff ID or Password!");
                }
            }else if (choice == 3){
                System.out.println("Create New Account ::::");
                System.out.println("Enter Admin Password ::");
                String adminPassword = sc.nextLine();

                if(adminPassword.equalsIgnoreCase("admin123")) {
                    System.out.println("Enter Student ID ::");
                    String studentID = sc.nextLine();
                    System.out.println("Enter Student Name ::");
                    String name = sc.nextLine();
                    System.out.println("Enter Student Age ::");
                    int age = sc.nextInt();
                    sc.nextLine(); 
                    System.out.println("Enter Student Address ::");
                    String address = sc.nextLine();
                    System.out.println("Enter Study Method (Online/Pyscle) ::");
                    String studyMethod = sc.nextLine();

                    if (studyMethod.equalsIgnoreCase("Online")) {
                        System.out.println("Enter Online ID ::");
                        String onlineID = sc.nextLine();
                        listOnStudents.add(new Online_STd(studentID, name, age, address, studyMethod, onlineID));
                        System.out.println("Online Student Account Created Successfully!");
                    } else if (studyMethod.equalsIgnoreCase("Pyscle")) {
                        System.out.println("Enter Branch ::");
                        String branch = sc.nextLine();
                        listPyStudents.add(new Pys_STd(studentID, name, age, address, studyMethod, branch));
                        System.out.println("Physical Student Account Created Successfully!");
                    } else {
                        System.out.println("Invalid Study Method!");
                    }
                }
            }else if (choice == 0) {
                System.out.println("Exiting the system. Goodbye!");
                clearScreen();
                break;
            } else {
                System.out.println("Invalid choice! Please try again.");
            }
            clearScreen();
        }
        sc.close();
    }

}