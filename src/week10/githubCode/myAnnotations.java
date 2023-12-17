package week10.githubCode;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@OOPStudent(name = "beg")
public class myAnnotations {
    @OOPStudent(name = "begler beg")
    private static String name;
    @OOPStudent //it will return default
    private String saySomething()
    {
        return "Becir";
    }
}
class Start {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        myAnnotations instance = new myAnnotations();

        for (Field f : instance.getClass().getDeclaredFields()) {
            if (f.isAnnotationPresent(OOPStudent.class)) { //&& field.getName().equals("name") - zavisi šta se traži
                OOPStudent annotation = f.getAnnotation(OOPStudent.class);
                System.out.println(annotation.name());
            }

        }
        for(Method m : instance.getClass().getDeclaredMethods())
        {
            if(m.isAnnotationPresent(OOPStudent.class) && m.getName().equals("saySomething")) {
                OOPStudent annotation2 = m.getAnnotation(OOPStudent.class);
                System.out.println(annotation2.name());
                m.setAccessible(true);
                System.out.println(m.invoke(instance));
            }

        }
        OOPStudent annotation3=myAnnotations.class.getAnnotation(OOPStudent.class);
        //hvatanje anotacije iznad klase- naziv klase.class.getAnnotation
        System.out.println(annotation3.name());

    }
}
//U mnogim slučajevima, pristupačnost polja se postavlja na true samo kada pokušavate čitati ili pisati vrijednosti privatnih polja,
//a ne kada pristupate anotacijama.
//Nije potrebno postavljati pristupačnost polja na true. Refleksija će raditi sa anotacijama bez obzira na pristupačnost polja.