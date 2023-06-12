package Classes;

import org.w3c.dom.css.Counter;



public class Lesson {
    private static Long idCounter = 0L;
    private String name;
    private Long id;

    public Lesson(String name) {
        this.name = name;
        this.id = generateUniqueId(); // Assign a unique ID
    }

    private synchronized Long generateUniqueId() {
        idCounter++; // Increment the ID counter
        return idCounter;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Lesson:" +
                "name:" + name +
                "id:" + id ;
    }
}