package week10.githubCode;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Cat {
    private final String name;
    private int age;

    public Cat(String name, int age)
    {
        this.name=name;
        this.age=age;
    }
    public String getName()
    {
        return name;
    }
    public int getAge()
    {
        return age;
    }
    public void setAge(int age)
    {
        this.age=age;
    }
    public static void thisIsPublicStaticMethod() {
        System.out.println("I'm public and static");
    }
    public void meow() {
        System.out.println("meow");
    }
    public void saySomething(String something) {
        System.out.println("I said something ".concat(something));
    }
    private void heyThisIsPrivate() {
        System.out.println("How did you call this?");
    }
}
class startReflection
{
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException
    {
        Cat myCat=new Cat("Cicko", 5); //instance of object
        Field[] catFields=myCat.getClass().getDeclaredFields(); //get all fields from class, returns an array of type Field

        for(Field field : catFields)
        {
            System.out.println(field.getName());
        }
        //changing final and private variable
        for(Field field : catFields)
        {
            if(field.getName().equals("name"))
            {
                field.setAccessible(true);
                field.set(myCat, "Micko Cicko");
            }
        }
        System.out.println(myCat.getName());
        // This is also true for the methods, you can do a same things
        Method[] catMethods=myCat.getClass().getDeclaredMethods();

        for(Method method : catMethods)
        {
            System.out.println(method.getName());
            // We want to invoke (call) method meow
            if(method.getName().equals("meow"))
            {
                method.invoke(myCat);   //method on which object? no other parameters if its void.
            }
            else if (method.getName().equals("saySomething"))
            {
                method.invoke(myCat, "Grrrrr");  // Params are passed in order they are in the method signature
            }
            else if (method.getName().equals("heyThisIsPrivate"))
            {
                method.setAccessible(true);
                method.invoke(myCat); //this won't work if we previously didn't set accessability
            }
            else if (method.getName().equals("thisIsPublicStaticMethod")) {
                method.invoke(null); // Static methods does not need the object
            }
        }
    }

    /*
     * Why would you need this?
     *
     * 1. Heavily used in frameworks, Spring uses it to see the classes you defined and to create
     *    objects from those classes.
     *    Dependencies & Loads/Injects them dynamically based on Annotation Information.
     * 2. We would use it for testing purposes. Ex. There is a class with private attributes,
     *    we may want to change that private attribute in order to test how the program behaves.
     *
     * HOWEVER, BE CAREFUL WHEN USING IT. IT IS EASY TO BREAK EVERYTHING
     * */
}
