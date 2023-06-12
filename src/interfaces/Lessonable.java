package interfaces;

import Classes.Group;
import Classes.Lesson;

import java.util.List;

public interface Lessonable {

     void addNewLessonToGroup(String groupName, String lesson);
     Lesson getLessonByName(String lessonName);
     List<Lesson>getAllLessonByGroupName(String groupName);
     void deleteLesson(String lessonName);
}
