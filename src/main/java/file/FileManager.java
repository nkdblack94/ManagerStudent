package file;

import student.Student;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class FileManager {

    public void writeFile(List<Student> students){
        try {
            FileOutputStream fos = new FileOutputStream("student.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            System.out.println("Write file successfully");
        }catch (Exception e){
            System.out.println("File writing failed");
        }
    }

    public List<Student> readFile(){
        List<Student> students = null;
        try {
            FileInputStream fis = new FileInputStream("student.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List<Student>)ois.readObject();
            for (Student s : students){
                System.out.println("ID: " + s.getID()
                        + ", Họ Tên: " + s.getFullName()
                        + ", Tuổi: " + s.getAge()
                        + ", Sinh viên năm: " + s.getStudentYear()
                        + ", Số điện thoại: " + s.getPhoneNumber()
                        + ", Địa chỉ: " + s.getAddress());
            }
            ois.close();
        }catch (Exception e){
            System.out.println("File not found");
        }
        return students;
    }
}
