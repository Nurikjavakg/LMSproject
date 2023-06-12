import Classes.*;
import enums.Gender;
import serviceimpl.GroupServiceIMPL;
import serviceimpl.LessonServiceIMPL;
import serviceimpl.StudentServiceIMPL;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Group> groups = new ArrayList<>();
        List<Lesson> lessons = new ArrayList<>();
        List<Student> students = new ArrayList<>();

        List<Admin> admins = new ArrayList<>(
                List.of(new Admin("James", "Arthu", 33, "james@gmail.com", "abc123")));


        DataBase dataBase = new DataBase( groups, admins);

        GroupServiceIMPL groupServiceIMPL = new GroupServiceIMPL(dataBase);
        LessonServiceIMPL lessonServiceIMPL = new LessonServiceIMPL(dataBase);
        StudentServiceIMPL studentServiceIMPL = new StudentServiceIMPL(dataBase);

        groupServiceIMPL.time();


        boolean loggedIn = false;
        while (true) {

            System.out.println("If have account tip on 1, if you have forgot your password tip on 2 (two time)!");

            int number = new Scanner(System.in).nextInt();

            switch (number) {



            case 1:
                    Scanner scanner11 = new Scanner(System.in);
                    System.out.println("Write your email:");
                    String emaiil = scanner11.nextLine();
                    System.out.println("Write your password:");
                    String passworrd = scanner11.nextLine();
                    for (int i = 0; i < dataBase.getAdmins().size(); i++) {
                        if (dataBase.getAdmins().get(i).getEmail().equals(emaiil)) {
                            if (dataBase.getAdmins().get(i).getPassword().equals(passworrd)) {
                                loggedIn=true;
                                System.out.println("Welcome to Peaksoft LMS!");
                            } else {
                                System.out.println("If you forgot your password tip on 2!");
                            }
                        } else {
                            System.out.println("Such email not found! Try again or try again!");
                        }
                    }



                    if (loggedIn) {

                        while (loggedIn) {

                            System.out.println("1. Create new group:                8. Search student  by last name:");
                            System.out.println("2. Get group by name:               9. Get all student by group name:");
                            System.out.println("3. Update group by name:            10. Get all student's lesson:");
                            System.out.println("4. Get all groups:                  11. Delete student last name:");
                            System.out.println("5. Delete group by name:            12. Add lesson to group:");
                            System.out.println("6. Add student to group:            13. Get lesson by name:");
                            System.out.println("7. Update student by password:      14. Get all lesson by group name:");
                            System.out.println("                                    15. Delete lesson by name:");
                            System.out.println("Choose one number please!");

                            int number1 = new Scanner(System.in).nextInt();
                            switch (number1) {

                                case 1: {
                                    List<Student> students1= new ArrayList<>();
                                    System.out.println("Create new group:");
                                    Scanner scannerl = new Scanner(System.in);
                                    String groupName = scannerl.nextLine();
                                    groupServiceIMPL.addNewGroup(groupName, students1, lessons);
                                    break;
                                }
                                case 2: {
                                    System.out.println("Get group by name:");
                                    Scanner scanner2 = new Scanner(System.in);
                                    String groupName1 = scanner2.nextLine();
                                    System.out.println(groupServiceIMPL.getGroupByName(groupName1));
                                    break;
                                }
                                case 3:{
                                    System.out.println("Update group by name:");
                                    Scanner scanner3 = new Scanner(System.in);
                                    String oldName = scanner3.nextLine();
                                    System.out.println("Write new group name!");
                                    String newName = scanner3.nextLine();
                                    System.out.println(groupServiceIMPL.updateGroupByName(oldName, newName));

                                    break;}

                                case 4:{
                                    System.out.println("Get all groups:");
                                    System.out.println(groupServiceIMPL.getAllGroups());
                                    break;}
                                case 5:{
                                    System.out.println("Delete group by name:");
                                    Scanner scanner4 = new Scanner(System.in);
                                    String nameGroup = scanner4.nextLine();
                                    groupServiceIMPL.deleteGroup(nameGroup);
                                    System.out.println("Group is succesfully deleted!");
                                    break;}
                                case 6: {
                                    System.out.println("Add student to group:");
                                    Scanner scanner5 = new Scanner(System.in);
                                    System.out.println("Write group Name:");
                                    String groupNamee = scanner5.nextLine();
                                    System.out.print("Write first name:");
                                    String firstNamee = scanner5.nextLine();
                                    System.out.print("Write last name please!");
                                    String lastNamee = scanner5.nextLine();
                                    System.out.print("Write email please!");
                                    String emaile = scanner5.nextLine();
                                    System.out.print("Write password please!");
                                    String passworde = scanner5.nextLine();
                                    System.out.print("Write gender please!");
                                    Gender gender1;
                                    String genderStr = scanner5.nextLine();
                                    switch (genderStr.toLowerCase()) {
                                        case "male":
                                            gender1 = Gender.MALE;
                                            break;
                                        case "female":
                                            gender1 = Gender.FEMALE;
                                            break;
                                        default:
                                            gender1 = Gender.UNKNOWN;
                                            break;
                                    }
                                    studentServiceIMPL.addStudentToGroup(groupNamee, firstNamee, lastNamee, emaile, passworde, gender1);
                                    System.out.println("Student is successfully added!");
                                    break;
                                }
                                case 7: {
                                    System.out.println("Update student by password:");
                                    Scanner scanner6 = new Scanner(System.in);
                                    System.out.println("If you want update student, write please student's password!");
                                    String password2 = scanner6.nextLine();
                                    System.out.println("Write first name:");
                                    String newFirstName = scanner6.nextLine();
                                    System.out.println("Write last name:");
                                    String newLastName = scanner6.nextLine();
                                    System.out.println("Write email:");
                                    String newEmail = scanner6.nextLine();
                                    String newPassword = scanner6.nextLine();
                                    System.out.println("Write gender:");
                                    Gender gender1;
                                    String gender3 = scanner6.nextLine();
                                    switch (gender3.toLowerCase()) {
                                        case "male":
                                            gender1 = Gender.MALE;
                                            break;
                                        case "female":
                                            gender1 = Gender.FEMALE;
                                            break;
                                        default:
                                            gender1 = Gender.UNKNOWN;
                                            break;
                                    }

                                    System.out.println(studentServiceIMPL.updateStudent(password2, newFirstName, newLastName, newEmail, newPassword, gender1));
                                    System.out.println("Student is successfully updated!");
                                    break;
                                }
                                case 8:{
                                    System.out.println("Search student  by last name!");
                                    System.out.println("Write student last name:");
                                    Scanner scanner7 = new Scanner(System.in);
                                    String name = scanner7.nextLine();
                                    studentServiceIMPL.findStudentByFirstName(name);
                                    break;}
                                case 9:{
                                    System.out.println("Get all student by group name:");
                                    String groupName3 = new Scanner(System.in).nextLine();
                                    studentServiceIMPL.getAllStudentsByGroupName(groupName3);
                                    break;}
                                case 10:{
                                    System.out.println("Get all students lesson:");
                                    studentServiceIMPL.getAllStudentsLesson();
                                    break;}
                                case 11:{
                                    Scanner scanner111 = new Scanner(System.in);
                                    System.out.println("Delete student last name:");
                                    System.out.println("Write group name:");
                                    String grouName = scanner111.nextLine();
                                    String lastname = scanner111.nextLine();
                                    studentServiceIMPL.deleteStudent(grouName,lastname);
                                    break;}
                                case 12:{
                                    Scanner scanner8 = new Scanner(System.in);
                                    System.out.println("Add lesson to group:");
                                    System.out.println("Write group name:");
                                    String nameGroupe = scanner8.nextLine();
                                    System.out.println("Write lesson name:");
                                    String nameLesson = scanner8.nextLine();
                                    System.out.println("Write id:");
                                    Long idd = scanner8.nextLong();
                                    lessonServiceIMPL.addNewLessonToGroup(nameGroupe, nameLesson);
                                    System.out.println("Lesson is seccussfully added!");
                                    break;}
                                case 13:{
                                    System.out.println("Get lesson by name:");
                                    Scanner scanner9 = new Scanner(System.in);
                                    System.out.println("Write lesson name:");
                                    String lessonName = scanner9.nextLine();
                                    lessonServiceIMPL.getLessonByName(lessonName);
                                    break;}
                                case 14:{
                                    Scanner scanner10 = new Scanner(System.in);
                                    System.out.println("Get all lesson by group name:");
                                    String groupNameee = scanner10.nextLine();
                                    lessonServiceIMPL.getAllLessonByGroupName(groupNameee);
                                    break;}
                                case 15:{
                                    System.out.println("Delete lesson by name:");
                                    Scanner scanner12 = new Scanner(System.in);
                                    System.out.println("Write lesson name:");
                                    String lesssonName = scanner12.nextLine();
                                    lessonServiceIMPL.deleteLesson(lesssonName);

                            }}


                        }
                    }

            }
            int number3 = new Scanner(System.in).nextInt();
            switch (number3){
                case 2:
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.println("Write email:");
                    String email = scanner1.nextLine();
                    System.out.println("Write password:");
                    String password = scanner1.nextLine();
                    for (int i = 0; i < dataBase.getAdmins().size(); i++) {
                        if(dataBase.getAdmins().get(i).getEmail().equals(email)){
                            if(password.length()>=6){
                                loggedIn= true;

                            }else{
                                    System.out.println("Password must be from '6' symbol");
                            }
                        }else {
                            System.out.println("Write correct your email please!");
                        }
                    }




                    if (loggedIn) {
                        System.out.println("Your new password is successfully saved!\n");
                        System.out.println("\nWelcome to Peaksoft LMS!");
                        while (loggedIn) {

                            System.out.println("1. Create new group:                8. Search student  by last name:");
                            System.out.println("2. Get group by name:               9. Get all student by group name:");
                            System.out.println("3. Update group by name:            10. Get all student's lesson:");
                            System.out.println("4. Get all groups:                  11. Delete student last name:");
                            System.out.println("5. Delete group by name:            12. Add lesson to group:");
                            System.out.println("6. Add student to group:            13. Get lesson by name:");
                            System.out.println("7. Update student by password:      14. Get all lesson by group name:");
                            System.out.println("                                    15. Delete lesson by name:");
                            System.out.println("Choose one number please!");
                            int number1 = new Scanner(System.in).nextInt();
                            switch (number1) {


                                case 1: {
                                    System.out.println("Create new group:");
                                    Scanner scannerl = new Scanner(System.in);
                                    String groupName = scannerl.nextLine();
                                    groupServiceIMPL.addNewGroup(groupName, students, lessons);
                                    break;
                                }

                                case 2: {
                                    System.out.println("Get group by name:");
                                    Scanner scanner2 = new Scanner(System.in);
                                    String groupName1 = scanner2.nextLine();
                                    System.out.println(groupServiceIMPL.getGroupByName(groupName1));
                                    break;
                                }
                                case 3: {
                                    System.out.println("Update group by name:");
                                    Scanner scanner3 = new Scanner(System.in);
                                    String oldName = scanner3.nextLine();
                                    String newName = scanner3.nextLine();
                                    System.out.println(groupServiceIMPL.updateGroupByName(oldName, newName));
                                    System.out.println("Group is succesfully updated!");
                                    break;
                                }

                                case 4: {
                                    System.out.println("Get all groups:");
                                    System.out.println(groupServiceIMPL.getAllGroups());
                                    break;
                                }
                                case 5: {
                                    System.out.println("Delete group by name:");
                                    Scanner scanner4 = new Scanner(System.in);
                                    String nameGroup = scanner4.nextLine();
                                    groupServiceIMPL.deleteGroup(nameGroup);
                                    System.out.println("Group is succesfully deleted!");
                                    break;
                                }
                                case 6: {
                                    System.out.println("Add student to group:");
                                    Scanner scanner5 = new Scanner(System.in);
                                    System.out.println("Write group Name:");
                                    String groupNamee = scanner5.nextLine();
                                    System.out.print("Write first name:");
                                    String firstNamee = scanner5.nextLine();
                                    System.out.print("Write last name please!");
                                    String lastNamee = scanner5.nextLine();
                                    System.out.print("Write email please!");
                                    String emaile = scanner5.nextLine();
                                    System.out.print("Write password please!");
                                    String passworde = scanner5.nextLine();
                                    System.out.println("Write long id:");
                                    Long id = scanner5.nextLong();
                                    System.out.print("Write gender please!");
                                    Gender gender1;
                                    String genderStr = scanner5.nextLine();
                                    switch (genderStr.toLowerCase()) {
                                        case "male":
                                            gender1 = Gender.MALE;
                                            break;
                                        case "female":
                                            gender1 = Gender.FEMALE;
                                            break;
                                        default:
                                            gender1 = Gender.UNKNOWN;
                                            break;
                                    }
                                    studentServiceIMPL.addStudentToGroup(groupNamee, firstNamee, lastNamee, emaile, passworde, gender1);
                                    System.out.println("Student is successfully added!\n");
                                    break;
                                }
                                case 7: {
                                    System.out.println("Update student by password:");
                                    Scanner scanner6 = new Scanner(System.in);
                                    System.out.println("If you want update student, write please student's password!");
                                    String password2 = scanner6.nextLine();
                                    System.out.println("Write first name:");
                                    String newFirstName = scanner6.nextLine();
                                    System.out.println("Write last name:");
                                    String newLastName = scanner6.nextLine();
                                    System.out.println("Write email:");
                                    String newEmail = scanner6.nextLine();
                                    System.out.println("Write password:");
                                    String newPassword = scanner6.nextLine();
                                    System.out.println("Write gender:");
                                    Gender gender1;
                                    String gender3 = scanner6.nextLine();
                                    switch (gender3.toLowerCase()) {
                                        case "male":
                                            gender1 = Gender.MALE;
                                            break;
                                        case "female":
                                            gender1 = Gender.FEMALE;
                                            break;
                                        default:
                                            gender1 = Gender.UNKNOWN;
                                            break;
                                    }

                                    System.out.println(studentServiceIMPL.updateStudent(password2, newFirstName, newLastName, newEmail, newPassword, gender1));
                                    System.out.println("Student is successfully updated!");
                                    break;
                                }
                                case 8: {
                                    Scanner scanner7 = new Scanner(System.in);
                                    System.out.println("Search student  by last name!");
                                    System.out.println("Write student last name:");
                                    String name = scanner7.nextLine();
                                    studentServiceIMPL.findStudentByFirstName(name);
                                    break;
                                }
                                case 9: {
                                    System.out.println("Get all student by group name:");
                                    String groupName3 = new Scanner(System.in).nextLine();
                                    studentServiceIMPL.getAllStudentsByGroupName(groupName3);
                                    System.out.println();
                                    break;
                                }
                                case 10: {
                                    System.out.println("Get all students lesson:");
                                    studentServiceIMPL.getAllStudentsLesson();
                                    break;
                                }
                                case 11: {
                                    Scanner scanner13 = new Scanner(System.in);
                                    System.out.println("Delete student by last name:");
                                    System.out.println("Write group name:");
                                    String grouName = scanner13.nextLine();
                                    System.out.println("Write student last name:");
                                    String lastname = scanner13.nextLine();
                                    studentServiceIMPL.deleteStudent(grouName, lastname);
                                    System.out.println("Student is successfully deleted!\n");
                                    break;
                                }
                                case 12: {
                                    Scanner scanner8 = new Scanner(System.in);
                                    System.out.println("Add lesson to group:");
                                    System.out.println("Write group name:");
                                    String nameGroupe = scanner8.nextLine();
                                    System.out.println("Write lesson name:");
                                    String nameLesson = scanner8.nextLine();

                                    lessonServiceIMPL.addNewLessonToGroup(nameGroupe, nameLesson);
                                    System.out.println("Lesson is seccussfully added!");
                                    break;
                                }
                                case 13: {
                                    System.out.println("Get lesson by name:");
                                    Scanner scanner9 = new Scanner(System.in);
                                    System.out.println("Write lesson name:");
                                    String lessonName = scanner9.nextLine();
                                    lessonServiceIMPL.getLessonByName(lessonName);
                                    break;
                                }
                                case 14: {
                                    Scanner scanner10 = new Scanner(System.in);
                                    System.out.println("Get all lesson by group name:");
                                    String groupNameee = scanner10.nextLine();
                                    lessonServiceIMPL.getAllLessonByGroupName(groupNameee);
                                    break;
                                }
                                case 15: {
                                    System.out.println("Delete lesson by name:");
                                    Scanner scanner12 = new Scanner(System.in);
                                    System.out.println("Write lesson name:");
                                    String lesssonName = scanner12.nextLine();
                                    lessonServiceIMPL.deleteLesson(lesssonName);
                                    System.out.println("Lesson is successfully deleted!");

                                }
                            }


                        }
                    }


            }
        }}}




