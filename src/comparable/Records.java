package comparable;

import java.util.ArrayList;
import java.util.Collections;

public class Records {
    public static void main(String[] args) {
        ArrayList<Student> studentRecords = new ArrayList<>();
        ArrayList<Staff> staffRecords = new ArrayList<>();

        studentRecords.add(new Student("Ishana", 500));
        studentRecords.add(new Student("Ishitha", 200));
        studentRecords.add(new Student("Ishu", 300));
        studentRecords.add(new Student("Ishani", 400));

        Collections.sort(studentRecords);
        System.out.println("Student Records:\n");
        studentRecords.forEach(System.out::println);

        staffRecords.add(new Staff("Payal", 99));
        staffRecords.add(new Staff("Ananya", 33));

        Collections.sort(staffRecords, (s1, s2) -> {
            return s1.id - s2.id;
        });
        System.out.println("\nStaff Records:\n");
        staffRecords.forEach(System.out::println);
    }
}