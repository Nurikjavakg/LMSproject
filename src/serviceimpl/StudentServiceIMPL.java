package serviceimpl;

import Classes.*;
import enums.Gender;
import interfaces.Studentable;

import java.util.List;

public class StudentServiceIMPL implements Studentable {

    private DataBase dataBase;

    public StudentServiceIMPL(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void addStudentToGroup(String groupName, String firstName, String lastName, String email, String password, Gender gender) {
        boolean groupFound = false;
        try {
            for (Group g: dataBase.getGroups()) {
                if(g.getName().equals(groupName)){
                    g.getStudents().add(new Student(firstName,lastName,email,password,gender));
                    groupFound=true;
                }

            }
              if(groupFound){
                  throw new MyException("Group not found!");
              }

        }catch (MyException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public Student updateStudent(String password2, String newFirstName, String newLastName, String newEmail, String newPassword, Gender gender) {
        for (Group g:dataBase.getGroups()){
            for (Student s: g.getStudents()) {
                if(s.getPassword().equals(password2)){
                    s.setFirstName(newFirstName);
                    s.setLastName(newLastName);
                    s.setEmail(newEmail);
                    s.setPassword(newPassword);
                    s.setGender(gender);
                    return s;
            }
        }
        }return null;
    }
    @Override
    public void findStudentByFirstName(String name) {
        for (Group g: dataBase.getGroups()) {
            for (Student st:g.getStudents()) {
             if(st.getLastName().equalsIgnoreCase(name)){
                 System.out.println(st);
               }
            }
        }
    }
    @Override
    public void getAllStudentsByGroupName(String groupName) {
        for (int i = 0; i <dataBase.getGroups().size(); i++) {
            if(dataBase.getGroups().get(i).getName().equalsIgnoreCase(groupName)){

                System.out.println(dataBase.getGroups().get(i).getStudents().get(i));
            }

        }
    }

    @Override
    public void getAllStudentsLesson() {
        for (Group g: dataBase.getGroups()) {
            System.out.println(  g.getStudents());
            System.out.println(g);

        }

    }

    @Override
    public void deleteStudent(String groupName,String lastName) {

        for (int i = 0; i < dataBase.getGroups().size(); i++) {
            if(dataBase.getGroups().get(i).getName().equalsIgnoreCase(groupName))
            if(dataBase.getGroups().get(i).getStudents().get(i).getLastName().equalsIgnoreCase(lastName)){
                dataBase.getGroups().get(i).getStudents().remove(dataBase.getGroups().get(i).getStudents().get(i));

                System.out.println("Student is succesfully deleted!");
                break;


        }

        }
        }

    }

