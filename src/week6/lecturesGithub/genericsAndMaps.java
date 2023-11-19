package week6.lecturesGithub;

import java.io.Serializable;
import java.util.List;

public class genericsAndMaps {
    public class Animal
    {
        private int numOfLegs;

        public void setNumOfLegs(int numOfLegs)
        {
            this.numOfLegs=numOfLegs;
        }
        public void eat()
        {
            System.out.println("Animal eating");
        }
    }
    public class Tiger extends Animal
    {
        private String name;

        public String getName()
        {
            return name;
        }
        public void setName(String name)
        {
            this.name=name;
        }
        @Override
        public void eat()
        {
            System.out.println("Tiger eating");
        }
    }
    class Printer<T,K>      //T,K types that this class may use
    {
        private T thingToPrint;   //Generic type, anything we want
        private K anotherThing;

        public Printer(T thingToPrint)
        {
            this.thingToPrint=thingToPrint;
        }
        public T getThingToPrint()
        {
            return thingToPrint;
        }
        public void setThingToPrint(T thingToPrint)
        {
            this.thingToPrint=thingToPrint;
        }
        public K getAnotherThing()
        {
            return anotherThing;
        }
        public void setAnotherThing(K anotherThing)
        {
            this.anotherThing=anotherThing;
        }
        public void print()
        {
            System.out.println(this.thingToPrint);
        }
        public static <T,K> void shout(T thingToSayLoud, K oneMoreThingToSayLoud){  //generics methods without returning
        System.out.println(thingToSayLoud + " " + oneMoreThingToSayLoud + "!!");
    }
        public static <T,K> T returnFirstGeneric(T thingToReturn, K thingToPrint)  //generics method with returning type
        {
            System.out.println(thingToPrint + "????????");
            return thingToReturn;
        }
        // Java wildcard generics, accepts the list of any type and prints its values
        public static void printListWrongWay(List<Object> objects){
            System.out.println(objects);
        }

        public static void printList(List<?> objects){
            System.out.println(objects);
        }

        public static void printListSpecific(List<? extends Animal> objects){
            System.out.println(objects);
        }
    }
    class specificPrinter<T extends Animal> // Bounded generic

        {
            private T thingToPrint;
        public specificPrinter(T thingToPrint)
            {
                this.thingToPrint = thingToPrint;
                thingToPrint.eat();      //and we are able to call the methods on the T object related to the T
            }
            public T getThingToPrint ()
            {
                return thingToPrint;
            }
            public void setThingToPrint (T thingToPrint)
            {
                this.thingToPrint = thingToPrint;
            }
            public void print ()
            {
                System.out.println(this.thingToPrint);
            }
        }
    // Bounded generic on the interfaces - same go with INTERFACE - word EXTENDS
    public class SpecificInterfacePrinter<T extends Serializable> {
        private T thingToPrint; // Totally unaware what T will become

        // Generic type, anything we want
        public SpecificInterfacePrinter(T thingToPrint) {
            this.thingToPrint = thingToPrint;
        }

        public T getThingToPrint() {
            return thingToPrint;
        }

        public void setThingToPrint(T thingToPrint) {
            this.thingToPrint = thingToPrint;
        }

        public void print() {
            System.out.println(this.thingToPrint);
        }
    }
    //now lets do the both, generic extends CLASS and INTERFACE
    public class SpecificAndInterfacePrinter<T extends Animal & Serializable> {  //JUST ONE CLASS (which comes FIRST) and can be many interfaces
        private T thingToPrint; // Totally unaware what T will become

        // Generic type, anything we want
        public SpecificAndInterfacePrinter(T thingToPrint) {
            this.thingToPrint = thingToPrint;
        }

        public T getThingToPrint() {
            return thingToPrint;
        }

        public void setThingToPrint(T thingToPrint) {
            this.thingToPrint = thingToPrint;
        }

        public void print() {
            System.out.println(this.thingToPrint);
        }
    }

}


