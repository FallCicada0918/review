import java.io.*;
import java.util.*;
import java.util.stream.*;

class Student implements Comparable<Student> {
    private String id;
    private String name;
    private int age;
 
    public Student() {}
 
    public Student(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
 
    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
 
    @Override
    public String toString() {
        return id + "," + name + "," + age;
    }
 
    @Override
    public int compareTo(Student other) {
        int nameComp = this.name.compareTo(other.name);
        if (nameComp != 0) {
            return nameComp;
        }
        int ageComp = Integer.compare(other.age, this.age); // 降序比较年龄
        if (ageComp != 0) {
            return ageComp;
        }
        return this.id.compareTo(other.id); // 学号升序
    }
}
 
public class StudentWriter {
/**
 * 主程序入口
 * 该方法用于接收用户输入的学生信息，排序并写入文件
 * @param args 命令行参数
 */
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("请输入数据（格式：学号,姓名,年龄），输入'quit'结束：");
        while (true) {
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("quit")) {
                break;
            }
            String[] parts = line.split("\\.");
            if (parts.length == 3) {
                String id = parts[0];
                String name = parts[1];
                int age = Integer.parseInt(parts[2]);
                students.add(new Student(id, name, age));
            }
        }
    
        // 按名字升序、年龄降序、学号升序排序
        Collections.sort(students);
    
        // 验证排序
        for (Student student : students) {
            System.out.println(student);
        }
    
        // 写入文件
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("./student.txt"))) {
            for (Student student : students) {
                writer.write(student.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




