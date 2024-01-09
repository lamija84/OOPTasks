package week13.github.lab.task6;

import java.util.ArrayList;
import java.util.List;

public class Coffee {
    private String type;
    private String size;
    private List<String> toppings;

    public Coffee(String type, String size)
    {
        this.type=type;
        this.size=size;
        this.toppings=new ArrayList<>();
    }
    public void setType(String type) {
        this.type = type;
    }

    public void setSize(String size) {
        this.size = size;
    }
    public void addTopping(String topping)
    {
        this.toppings.add(topping);
    }
    @Override
    public String toString() {
        return "Coffee{" +
                "type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", toppings=" + toppings +
                '}';
    }
}
