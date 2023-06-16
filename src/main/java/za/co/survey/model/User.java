package za.co.survey.model;

import java.time.LocalDate;

public class User {

    private int userId;
    private String surname;
    private String firstName;
    private String contactNumber;
    private int age;
    private LocalDate date;

    public User() {
    }

    public User(int userId, String surname, String firstName, String contactNumber, int age, LocalDate date) {
        this.userId = userId;
        this.surname = surname;
        this.firstName = firstName;
        this.contactNumber = contactNumber;
        this.age = age;
        this.date = date;
    }

    public User(String surname, String firstName, String contactNumber, int age, LocalDate date) {
        this.surname = surname;
        this.firstName = firstName;
        this.contactNumber = contactNumber;
        this.age = age;
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.userId;
        hash = 89 * hash + (this.surname != null ? this.surname.hashCode() : 0);
        hash = 89 * hash + this.age;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.userId != other.userId) {
            return false;
        }
        if (this.age != other.age) {
            return false;
        }
        if ((this.surname == null) ? (other.surname != null) : !this.surname.equals(other.surname)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", surname=" + surname + ", firstName=" + firstName + ", contactNumber=" + contactNumber + ", age=" + age + ", date=" + date + '}';
    }    
}
