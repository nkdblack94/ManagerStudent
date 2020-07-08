package student;

import file.FileManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    List<Student> studentList = new ArrayList<Student>();

    Scanner scanner = new Scanner(System.in);

    public void showStudentList() {
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println("ID: " + studentList.get(i).getID()
                    + ", Họ Tên: " + studentList.get(i).getFullName()
                    + ", Tuổi: " + studentList.get(i).getAge()
                    + ", Sinh viên năm: " + studentList.get(i).getStudentYear()
                    + ", Số điện thoại: " + studentList.get(i).getPhoneNumber()
                    + ", Địa chỉ: " + studentList.get(i).getAddress());
        }
    }

    public boolean addNewStudent(String ID, String fullName, int age, int studentYear, String phoneNumber, String address) {
        studentList.add(new Student(ID, fullName, age, studentYear, phoneNumber, address));
        return true;
    }

    public boolean deleteStudentByID(String ID) {
        for (Student s : studentList) {
            if (s.getID().equals(ID)) {
                studentList.remove(s);
                return true;
            }
        }
        return false;
    }

    public boolean editStudentByID(String id, String fullName, int age, int studentYear, String phoneNumber, String address) {
        for (Student s : studentList) {
            if (s.getID().equals(id)) {
              s.setFullName(fullName);
              s.setAge(age);
              s.setStudentYear(studentYear);
              s.setPhoneNumber(phoneNumber);
              s.setAddress(address);
                return true;
            }
        }
        return false;
    }

    public boolean searchName(String name) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getFullName().contains(name)) {
                System.out.println("ID: " + studentList.get(i).getID()
                        + ", Họ Tên: " + studentList.get(i).getFullName()
                        + ", Tuổi: " + studentList.get(i).getAge()
                        + ", Sinh viên năm thứ: " + studentList.get(i).getStudentYear()
                        + ", Số điện thoại: " + studentList.get(i).getPhoneNumber()
                        + ", Địa chỉ: " + studentList.get(i).getAddress());
            }
        }
        return true;
    }

    public void writeFile(){
        FileManager fileManager = new FileManager();
        fileManager.writeFile(studentList);
    }

    public void readFile(){
        FileManager fileManager = new FileManager();
        List<Student> list =fileManager.readFile();
        studentList.clear();
        studentList.addAll(list);
    }

    public boolean isExistID(String ID){
        for (Student s : studentList){
            if (s.getID().equals(ID)){
                return true;
            }
        }
        return false;
    }

}
