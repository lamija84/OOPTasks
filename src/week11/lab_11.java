package week11;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.Optional;

public class lab_11 {


    public class StudentSystem {
        private List<lab11.Student> students;

        public StudentSystem(String filename) {
            try {
                this.students = readStudents(filename);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public List<lab11.Student> readStudents(String filename) throws IOException {
            List<lab11.Student> students = new ArrayList<>();

            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
                List<String> lines = bufferedReader.lines().collect(Collectors.toList());

                for (String line : lines) {
                    String[] parts = line.split(",");
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String university = parts[2];
                    String department = parts[3];
                    double GPA = Double.parseDouble(parts[4]);

                    students.add(new lab11.Student(id, name, university, department, GPA));
                }
            }

            return students;
        }

        public Optional<lab11.Student> getStudentById(int id) {
            return students.stream()
                    .filter(student -> student.getId() == id)
                    .findFirst();
        }

        public lab11.Student getHighestGPAStudent() {
            if (students.isEmpty()) {
                throw new lab11.EmptyStudentListException("List of students is empty.");
            }

            return students.stream()
                    .max(Comparator.comparingDouble(lab11.Student::getGPA))
                    .orElseThrow(NoSuchElementException::new);
        }

        public lab11.Student getLongestNameStudent() {
            if (students.isEmpty()) {
                throw new lab11.EmptyStudentListException("List of students is empty.");
            }

            return students.stream()
                    .max(Comparator.comparingInt(student -> student.getName().length()))
                    .orElseThrow(NoSuchElementException::new);
        }

        public static void main(String[] args) {
            StudentSystem system = new StudentSystem("students.csv");

            // Example: Find a student by ID
            try {
                Optional<lab11.Student> studentById = system.getStudentById(10);
                studentById.ifPresentOrElse(
                        student -> System.out.println("Found: " + student),
                        () -> System.out.println("Student not found.")
                );
            } catch (lab11.StudentNotFoundException e) {
                e.printStackTrace();
            }

            // Example: Get student with the highest GPA
            try {
                lab11.Student highestGPAStudent = system.getHighestGPAStudent();
                System.out.println("Student with the highest GPA: " + highestGPAStudent);
            } catch (lab11.EmptyStudentListException e) {
                e.printStackTrace();
            }

            // Example: Get student with the longest name
            try {
                lab11.Student longestNameStudent = system.getLongestNameStudent();
                System.out.println("Student with the longest name: " + longestNameStudent);
            } catch (lab11.EmptyStudentListException e) {
                e.printStackTrace();
            }
        }
    }
}
