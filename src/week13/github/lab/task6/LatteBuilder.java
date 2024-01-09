package week13.github.lab.task6;

public class LatteBuilder implements CoffeeBuilder{
    private Coffee coffee;

    public LatteBuilder()
    {
        this.coffee=new Coffee();
    }

    @Override
    public void buildType() {
        coffee.setType("Latte");
    }

    @Override
    public void buildSize() {
        coffee.setSize("Small");
    }

    @Override
    public void buildToppings() {
        coffee.addTopping("Cream");
    }

    @Override
    public Coffee getResult() {
        return coffee;
    }
}
