package week13.github.lab.task6;

public class CoffeeDirector {
    public void constructCoffee(CoffeeBuilder builder)
    {
        builder.buildSize();
        builder.buildToppings();
        builder.buildType();
    }
}
