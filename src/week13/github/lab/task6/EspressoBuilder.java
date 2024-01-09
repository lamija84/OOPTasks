package week13.github.lab.task6;

public class EspressoBuilder implements CoffeeBuilder{
    private Coffee coffee;
    public EspressoBuilder()
    {
        this.coffee=new Coffee();
    }

    @Override
    public void buildType() {
        coffee.setType("Espresso");
    }
    @Override
    public void buildSize() {
        coffee.setSize("Small");
    }

    @Override
    public void buildToppings() {
        // No toppings for Espresso
    }

    @Override
    public Coffee getResult() {
        return coffee;
    }
}
