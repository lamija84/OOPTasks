package week10;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
class Student {
    private String name;
    private int ID;
    private List<Integer> grades;

    public Student(String name, int ID, List<Integer> grades) {
        this.name = name;
        this.ID = ID;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public void setGrades(List<Integer> grades) {
        this.grades = grades;
    }

    public void printInfo() {
        System.out.println("Student Information:");
        System.out.println("Name: " + getName());
        System.out.println("ID: " + getID());
        System.out.println("Grades: " + getGrades());
    }
}
    class GradeAnalyzer {
        private List<Integer> grades;

        public GradeAnalyzer(List<Integer> grades) {
            this.grades = grades;
        }

        public double calculateAverageGrade() {
            int sum = 0;
            for (int grade : grades) {
                sum += grade;
            }
            return (double) sum / grades.size();
        }

        public void printGradeSummary() {
            System.out.println("Grade Summary:");
            System.out.println("Grades: " + grades);
            System.out.println("Average Grade: " + calculateAverageGrade());
        }
    }

    class Start {
        public static void main(String[] args) //throws IllegalAccessException, InvocationTargetException
        {
                try {
                    List<Integer> grades = Arrays.asList(5, 3, 5, 5);
                    Student student = new Student("Lamija", 21, grades);
                    GradeAnalyzer gradeAnalyzer = new GradeAnalyzer(grades);

                    Field[] fields = gradeAnalyzer.getClass().getDeclaredFields();
                    for (Field field : fields) {
                        if (field.getName().equals("grades")) {
                            field.setAccessible(true);
                            try {
                                System.out.println(field.getName() + ": " + field.get(gradeAnalyzer));
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    Method[] methods = gradeAnalyzer.getClass().getDeclaredMethods();
                    for (Method method : methods) {
                        if (method.getName().startsWith("calculate") || method.getName().startsWith("print")) {
                            try {
                                Object result=method.invoke(gradeAnalyzer);
                                if(result != null)
                                {
                                    System.out.println(method.getName() + ": " + result);
                                }
                                else {
                                    System.out.println(method.getName() + ": " + " does not return a value.");
                                }
                            } catch (IllegalAccessException | InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }







