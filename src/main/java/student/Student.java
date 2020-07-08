package student;

import java.io.Serializable;

public class Student implements Serializable {
    private String ID;
    private String fullName;
    private int age;
    private int studentYear;
    private String phoneNumber;
    private String address;

    public Student(){}

    public Student(String ID, String fullName, int age, int studentYear, String phoneNumber, String address) {
        this.ID = ID;
        this.fullName = fullName;
        this.age = age;
        this.studentYear = studentYear;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getStudentYear() {
        return studentYear;
    }

    public void setStudentYear(int studentYear) {
        this.studentYear = studentYear;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
