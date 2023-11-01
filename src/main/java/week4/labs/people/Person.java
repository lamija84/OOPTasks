package week4.labs.people;
import java.util.ArrayList;
import java.util.List;
public class Person {
    /*public static void printDepartment(List<Person> people) {
        for(Person p : people)
        {
            System.out.println(p);
        }
    }
    public static void main(String[] args) {
        Person lamsa=new Person("Lamija", "Behdžeta M.");
        System.out.println(lamsa);
        Teacher ado=new Teacher("Becir","Aleja lipa",4000);
        System.out.println(ado);
        List<Person> people = new ArrayList<Person>();
        people.add( new Teacher("Dzelila", "Korsontie Street 1 03100 Vantaa", 1200) );
        people.add( new Student("Kerim", "Ida Albergintie Street 1 00400 Helsinki") );


        printDepartment(people);
    }

     */

    private String name;
    private String address;
    private int age;
    private String country;
    public Person(String name, String address)
    {
        this.name=name;
        this.address=address;
    }
    public int getAge()
    {
        return age;
    }
    public void setAge(int age)
    {
        this.age=age;
    }
    public String getCountry()
    {
        return country;
    }
    public void setCountry(String country)
    {
        this.country=country;
    }

    @Override
    public String toString() {
        return this.name + "\n\t" + this.address;
    }
    /*public static void main(String[] args) {
        Person pekka = new Person("Pekka Mikkola", "Korsontie Street 1 03100 Vantaa");
        Person esko = new Person("Esko Ukkonen", "Mannerheimintie Street 15 00100 Helsinki");
        System.out.println(pekka);
        System.out.println(esko);*/
    }

class Student extends Person
{
private int credits;
private int student_id;
private List<Integer> grades;
public Student(String name, String address)
{
    super(name,address);
    this.credits=0;
    this.grades=new ArrayList<>();
}
public int getStudent_id()
{
    return this.student_id;
}
public void setStudent_id(int student_id)
{
    this.student_id=student_id;
}
public List<Integer> getGrades() //pristupanje listi ocjena
{
    return this.grades;
}
public void addGrade(int grade)
{
if(grade>=0 && grade<=100)
{
    this.grades.add(grade);
}
else
{
    System.out.println("Invalid grade.");
}
}
public int credits() {
    return this.credits;
}
public void study()
{
    this.credits++;
}

    @Override
    public String toString() {
        return super.toString() + "\n\tcredits " + this.credits;
    }
    /*
    public static void main(String[] args) {
        Student olli = new Student("Olli", "Ida Albergintie Street 1 00400 Helsinki");
        System.out.println(olli);
      System.out.println("credits " + olli.credits());
       olli.study();
        System.out.println("credits "+ olli.credits());

    }
*/
}
class Teacher extends Person
{
    private int salary;
    public Teacher(String name,String address, int salary)
    {
        super(name,address);
        this.salary=salary;
    }

    @Override
    public String toString() {
        return super.toString() + "\n\tsalary " + this.salary + " euros/month";
    }
    /*
    public static void main(String[] args) {
        Teacher pekka = new Teacher("Pekka Mikkola", "Korsontie Street 1 03100 Vantaa", 1200);
        Teacher esko = new Teacher("Esko Ukkonen", "Mannerheimintie 15 Street 00100 Helsinki", 5400);
        System.out.println( pekka );
        System.out.println( esko );


        Student olli = new Student("Olli", "Ida Albergintie 1 Street 00400 Helsinki");
        for ( int i=0; i < 25; i++ ) {
            olli.study();
        }
        System.out.println( olli );

     */
    }







