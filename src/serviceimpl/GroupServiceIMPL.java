package serviceimpl;

import Classes.*;
import interfaces.Groupable;

import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GroupServiceIMPL implements Groupable {
    private DataBase dataBase;

    public GroupServiceIMPL(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public DataBase getDataBase() {
        return dataBase;
    }

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void time() {
        int time = ZonedDateTime.now().getHour()+ZonedDateTime.now().getMinute();

        if (time <= 12 && time >= 6) {
            System.out.println("Good morning!" + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute());
        } else if (time>=13 && time<=18) {
            System.out.println("Good afternoon!"+LocalTime.now().getHour()+":"+LocalTime.now().getMinute());
        }else if(time<=24 && time>=19){
            System.out.println("Good evening!" + LocalTime.now().getHour()+ ":"+ LocalTime.now().getMinute());

        }else if(time>=1 && time<=7){
            System.out.println("Good Night!" + ZonedDateTime.now().getHour()+":"+ ZonedDateTime.now().getMinute());
        }
    }
        @Override
        public void addNewGroup (String groupName, List<Student>students, List<Lesson>lessons){
            try {
                boolean groupFound = false;
                for (Group group : dataBase.getGroups()) {
                    if (group.getName().equals(groupName)) {
                        throw new MyException("Group with the same name already exists! Please try with another name.");
                    }
                }
                dataBase.getGroups().add(new Group(groupName, students, lessons));
                System.out.println(dataBase.getGroups());
                groupFound = true;

            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        }

        @Override
        public Group getGroupByName (String name) {
            try {
                boolean groupName = false;
                for (Group group : dataBase.getGroups()) {
                    if (group.getName().equalsIgnoreCase(name)) {
                        return group;

                    }

                }
                if (!groupName) {
                    throw new MyException("Group with the name not exists!");
                }

            } catch (MyException e) {
                System.out.println(e.getMessage());
            }return null;
        }
    @Override
    public Group updateGroupByName(String oldName, String newName) {
        try {
            boolean updateName = false;
            for (Group g : dataBase.getGroups()) {
                if (g.getName().equalsIgnoreCase(oldName)) {
                    g.setName(newName);
                    return g;
                }

            }
            if (!updateName) {
                throw new MyException("Group with the name not exists!");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }return null;
    }

    @Override
    public List<Group> getAllGroups() {

        for (Group group: dataBase.getGroups()) {

        }return dataBase.getGroups();
    }

    @Override
    public void deleteGroup(String groupName) {
        try {
            boolean group = false;

            for (int i = 0; i < dataBase.getGroups().size(); i++) {
                if (dataBase.getGroups().get(i).getName().equalsIgnoreCase(groupName)) {
                    dataBase.getGroups().remove(dataBase.getGroups().get(i));
                    System.out.println("null");

                }
            }
            if (!group) {
                throw new MyException("Group with the name not exists!");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }}
