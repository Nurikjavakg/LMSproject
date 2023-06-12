package Classes;

import enums.Gender;

public class Student {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Gender gender;
    private static Long idCounter = 0L;

    public Student(String firstName, String lastName, String email, String password, Gender gender) {
        this.id = generateUniqueId();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.gender = gender;
    }
        private synchronized Long generateUniqueId () {
            idCounter++; // Increment the ID counter
            return idCounter;
        }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student:" +
                "id:" + id +
                " firstName:" + firstName +
                " lastName:" + lastName +
                " email:" + email +
                " password:" + password +
                " gender:" + gender ;
    }
}

