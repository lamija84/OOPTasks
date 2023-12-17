package week11;

import java.util.Optional;

public class lab11 {
    public class Student {
        private int id;
        private String name;
        private String university;
        private String department;
        private double GPA;

        public Student(int id, String name, String university, String department, double GPA) {
            this.id = id;
            this.name = name;
            this.university = university;
            this.department = department;
            this.GPA = GPA;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getUniversity() {
            return university;
        }

        public String getDepartment() {
            return department;
        }

        public double getGPA() {
            return GPA;
        }

        @Override
        public String toString() {
            return "Student Name: " + name;
        }
    }
    public class EmptyStudentListException extends RuntimeException {
        public EmptyStudentListException(String message) {
            super(message);
        }
    }

    public class StudentNotFoundException extends Exception {
        public StudentNotFoundException(String message) {
            super(message);
        }
    }


}
