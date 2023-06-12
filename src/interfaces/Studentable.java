package interfaces;

import Classes.Group;
import Classes.Lesson;
import Classes.Student;
import enums.Gender;

import java.util.List;

public interface Studentable {

    void addStudentToGroup(String groupName,String firstName, String lastName, String email, String password, Gender gender);
    Student updateStudent(String password2, String newFirstName, String newLastName, String newEmail, String newPassword, Gender gender);
    void findStudentByFirstName(String name);
    void getAllStudentsByGroupName(String groupName);
    void getAllStudentsLesson();
    void deleteStudent(String groupName,String lastName);

}
