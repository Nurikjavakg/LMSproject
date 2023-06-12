package Classes;

import java.util.List;

public class Group {
    private Long id;
    private String name;
    private List<Student> students;
    private List<Lesson> lessons;
    private static Long idCounter = 0L;

    public Group( String name, List<Student> students, List<Lesson> lessons) {
        this.id = generateUniqueId();
        this.name = name;
        this.students = students;
        this.lessons = lessons;
    }
    private synchronized Long generateUniqueId() {
        idCounter++; // Increment the ID counter
        return idCounter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    @Override
    public String toString() {
        return "\nGroup: " +
                "id:" + id +
                " name:" + name +
                "\nstudents:" + students +
                "\nlessons:" + lessons ;
    }
}