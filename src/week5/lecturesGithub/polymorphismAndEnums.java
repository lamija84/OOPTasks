package week5.lecturesGithub;

public class polymorphismAndEnums {
    public enum Colors
    {
        WHITE, BLACK, RED, GREEN
    }
    public class Animal
    {
        private String name;
        private Colors color;

        public void eat()
        {
            System.out.println("Mljac");
        }
        public void eat(String eatingSound)
        {
            System.out.println(eatingSound);
        }
        // We have multiple methods with exactly the same name with different parameters
        // This is called a method overloading and it is a form of polymorphism
        public String getName()
        {
            return name;
        }
        public void setName(String name)
        {
            this.name=name;
        }
        public Colors getColor()
        {
            return color;
        }
        public void setColor(Colors color)
        {
            this.color=color;
        }
    }
    public class Tiger extends Animal
    {
        private int numOfTeeth;

        @Override
        public void eat() {
            System.out.println("Tiger mljac");
        }
        // This method is overridden, so it means we are providing the different implementation
        // of the method we have inherited from the parent Animal class.
        // Because of this, we are doing the same thing (eating) in a different form and
        // that is actually a polymorphism. Our Tiger class eats in a DIFFERENT FORM than
        // our Animal class do.
        public int getNumOfTeeth()
        {
            return numOfTeeth;
        }
        public void setNumOfTeeth(int numOfTeeth)
        {
            this.numOfTeeth=numOfTeeth;
        }

    }
    public class Turtle extends Animal
    {
        private String breed;

        @Override
        public void eat() {
            System.out.println("Turtle mljac");
        }
        public String getBreed()
        {
            return breed;
        }
        public void setBreed(String breed)
        {
            this.breed=breed;
        }
//////////////////////////////////////////////////////////////////////////////////////////////////
    }
    }
   /* public class Start {
        /**
         * Polymorphism means many shapes. Class can do the same thing in different ways.
         * There are two types of polymorphism in Java
         * 1. Compile time polymorphism - method overloading
         *  - Which method to call is decided by the compiler
         * 2. Run time polymorphism - method overriding
         *  - Which method to call is decided by the JVM in the run tine
         * */
       /* public static void main(String[] args) {
            Animal animal = new Animal();
            animal.eat();

            // This is possible because of the inheritance
            Tiger tiger = new Tiger();
            tiger.eat();

            Turtle turtle = new Turtle();
            turtle.eat();

            // We are doing the same things in three different forms (eat method in three classes)
            // Method overloading and method overriding are the forms of polymorphism

            // Upcasting is done by Java implicitly
            // This means that every Tiger is an (IS A) animal as it is a Tiger is child class of Animal
            // Java allows you to treat an object of subclass as an object of its parent type
            Animal myTiger = new Tiger();
            System.out.println(myTiger);

            // myTiger.sayTigerHello(); // Not works as this is an Animal

            // Not allowed as the child class reference variable cannot instantiate the super / parent class object
            // Tiger mySecondTiger = new Animal();

            // Any subclass of Animal is allowed to be passed as a parameter
            // In combination with method overriding it will call the appropriate objects eat method
            // Without this upcasting for each object you would have to create a separate method
            doSomeAnimalStuff(tiger);
            doSomeAnimalStuff(myTiger);
            doSomeAnimalStuff(turtle);
        }

        // Question is: Why do we need the upcasting at all?
        // In the method declared below we have the parameter animal of type Animal
        // But since both the Tiger and Turtle are the animals both of these are allowed
        // to be passed as a parameter
        // The type of the variable determines the methods you can call but the specific type of the object
        // that the variable is referring to is determines which specific implementation of the method
        // will be used when called
        public static void doSomeAnimalStuff(Animal animal){
            animal.eat();

            // Downcasting is different and it does not happen automatically
            // We are saying to Java, this animal passed as the parameter is the Tiger and threat it as
            // it is the Tiger. YOU HAVE TO BE CAREFUL AS IT WILL THROW AN EXCEPTION IF YOU MISS THE CASTING
            // You can add the instanceof check

            if(animal instanceof Tiger) {
                Tiger myLocalTiger = (Tiger) animal;
                myLocalTiger.getNumOfTeeth();
            }

        }
    }
}

        */

