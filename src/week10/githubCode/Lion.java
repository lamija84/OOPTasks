package week10.githubCode;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@VeryImportant
record Lion(String name){
    @RunImmediately
        public void saySomething()
        {
            System.out.println("Lion method saySomething");
        }
        public void saySomethingButDontRun() {
            System.out.println("Lion method saySomethingButDontRun");
        }
        @RunImmediatelyNTimes(times = 3)
    public void runMultipleTimes(){
        System.out.println("Multiple times");
    }
    }
class Fox{
    @ImportantString
    private String name;
    private int numOfLegs;

    public Fox(String name, int numOfLegs) {
        this.name = name;
        this.numOfLegs = numOfLegs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfLegs() {
        return numOfLegs;
    }

    public void setNumOfLegs(int numOfLegs) {
        this.numOfLegs = numOfLegs;
    }
}
class startAnnotations
{
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException
    {
       @SuppressWarnings("unused")
               Lion myLion=new Lion("Leonel");
        System.out.println(myLion.getClass().isAnnotationPresent(VeryImportant.class));

        for(Method method : myLion.getClass().getDeclaredMethods())
        {
            if(method.isAnnotationPresent(RunImmediately.class))
            {
                System.out.println("Method name is: " + method.getName());
                method.invoke(myLion);
            }
            else if(method.isAnnotationPresent(RunImmediatelyNTimes.class))
            {
                RunImmediatelyNTimes annotation=method.getAnnotation(RunImmediatelyNTimes.class); //dohvaćanje informacije o atributu metode
                for(int i=0; i< annotation.times(); i++)
                {
                    method.invoke(myLion);
                }
            }
            //pravimo instancu anotacije RunImmediatelyNTimes kako bismo dohvatili vrednost atributa times.
            // Anotacije same po sebi nisu objekti koje možemo instancirati u klasičnom smislu,
            // ali Java omogućava dohvatanje vrednosti atributa anotacije pomoću refleksije.
            // Dakle, ovaj deo koda koristi refleksiju da bi dohvatio anotaciju sa metode i iz nje dobio informaciju o tome
            // koliko puta treba izvršiti određenu metodu.
        }
        Fox myFox=new Fox("Foxy", 4);
        for(Field f : myFox.getClass().getDeclaredFields())
        {
            if(f.isAnnotationPresent(ImportantString.class))
            {
                f.setAccessible(true);
                Object value=f.get(myFox);  //dohvaćamo vrijednost iz myFox instance
                if(value instanceof String myFoxName) // String myFoxName = (String) value, je lokalna promenljiva koja se koristi kako bismo referisali na vrednost polja name
                    // nakon što smo je dohvatili pomoću refleksije.
                    // Ovdje provjeravamo da li je ta vrijednost String
                    System.out.println("The field name is: " + f.getName() + " and its value in uppercase is:  "+ myFoxName.toUpperCase());

            }
        } // Ovaj dio koda koristi refleksiju kako bi pristupio privatnom polju name klase Fox, proverio
        // da li je vrednost tog polja tipa String i, ako jeste, ispisao informacije o tom polju.
        // Ovo je primjer kako se refleksija može koristiti za dinamičko istraživanje i manipulaciju sa objektima i njihovim svojstvima,
        // u ovom slučaju, proveravajući tip vrednosti polja.
    }
}
//f.setAccessible(true);
//Object value = f.get(myFox);
//if (value instanceof String) {
// System.out.println("The field name is: " + f.getName() + " and its value in uppercase is:  " + ((String) value).toUpperCase());
//}
// U ovom slučaju, umesto myFoxName, direktno koristimo value gde nam je potrebno. Ono što je promenjeno
// je korišćenje (String) value kako bismo eksplicitno kastovali vrednost na tip String prilikom pozivanja toUpperCase().
// Ova zamena može učiniti kod malo manje čitljivim,
// ali suštinski obavlja istu stvar - ispisuje informacije o polju name ako je tip vrednosti String.



