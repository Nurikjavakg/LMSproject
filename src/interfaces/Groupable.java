package interfaces;

import Classes.Group;
import Classes.Lesson;
import Classes.Student;

import java.util.List;

public interface Groupable {
    void time();
    void addNewGroup(String groupName, List<Student>students, List<Lesson>lessons);
    Group getGroupByName(String name);
    Group updateGroupByName(String oldName,String newName);
    List<Group>getAllGroups();
    void deleteGroup(String groupName);

}
