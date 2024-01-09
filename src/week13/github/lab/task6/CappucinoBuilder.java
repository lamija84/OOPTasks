package week13.github.lab.task6;

public class CappucinoBuilder implements CoffeeBuilder{

        private Coffee coffee;

        public CappucinoBuilder() {
            this.coffee = new Coffee();
        }

        @Override
        public void buildType() {
            coffee.setType("Cappuccino");
        }

        @Override
        public void buildSize() {
            coffee.setSize("Large");
        }

        @Override
        public void buildToppings() {
            coffee.addTopping("Whipped Cream");
        }

        @Override
        public Coffee getResult() {
            return coffee;
        }
    }

