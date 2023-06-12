package serviceimpl;

import Classes.DataBase;
import Classes.Group;
import Classes.Lesson;

import Classes.MyException;
import interfaces.Lessonable;

import java.util.List;

public class LessonServiceIMPL implements Lessonable {
    private DataBase dataBase;

    public LessonServiceIMPL(DataBase dataBase) {
        this.dataBase = dataBase;
    }



    @Override
    public void addNewLessonToGroup(String groupName, String lesson) {


            try {
                boolean groupFound = false;
                for (Group g:dataBase.getGroups()) {
                    if(g.getName().equals(groupName)){
                        g.getLessons().add(new Lesson(lesson));
                        groupFound = true;
                }



                }if(!groupFound){
                    throw new MyException("Not found group!");


                }
            } catch (MyException e) {
                System.out.println(e.getMessage());


            }
        }


    @Override
    public Lesson getLessonByName(String lessonName) {
        try {
            for (int i = 0; i < dataBase.getGroups().size(); i++) {
                if (dataBase.getGroups().get(i).getLessons().get(i).getName().equalsIgnoreCase(lessonName)) {
                    dataBase.getGroups().get(i).getLessons().get(i);
                    System.out.println(dataBase.getGroups().get(i).getLessons().get(i));
                    break;
                }
                if (!dataBase.getGroups().get(i).getLessons().get(i).getName().equalsIgnoreCase(lessonName)) {
                    throw new MyException("Not found lesson!");
                }
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());

        }return null;
    }


    @Override
    public List<Lesson> getAllLessonByGroupName(String groupName) {
        for (int i = 0; i < dataBase.getGroups().size(); i++) {
            if(dataBase.getGroups().get(i).getName().equalsIgnoreCase(groupName)){
                dataBase.getGroups().get(i).getLessons();
                System.out.println( dataBase.getGroups().get(i).getLessons());
            }

        }
        return null;
    }

    @Override
    public void deleteLesson(String lessonName) {
        for (int i = 0; i < dataBase.getGroups().size(); i++) {
            if(dataBase.getGroups().get(i).getLessons().get(i).getName().equalsIgnoreCase(lessonName)){
                dataBase.getGroups().get(i).getLessons().remove(dataBase.getGroups().get(i).getLessons().get(i));
                System.out.println("Lesson is successfully deleted!");
                break;
            }

        }

    }
}
