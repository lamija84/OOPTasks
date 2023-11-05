package week5;

import java.util.ArrayList;
import java.util.List;

public interface ToBeStored {
    double weight();
}
 class Book implements ToBeStored
{
    private String writer;
    private String name;
    private double weight;
    public Book(String writer, String name, double weight)
    {
        this.writer=writer;
        this.name=name;
        this.weight=weight;
    }

    @Override
    public double weight() {
        return weight;
    }

    @Override
    public String toString() {         //weight ne treba biti included u ispisu
        return writer + ": " + name;
    }
}
class CD implements ToBeStored
{
    private String artist;
    private String title;
    private int publishingYear;
    public CD (String artist, String title, int publishingYear)
    {
        this.artist=artist;
        this.title=title;
        this.publishingYear=publishingYear;
    }

    @Override
    public double weight() {
        return 0.1;
    }

    @Override
    public String toString() {
        return artist + ": " + title + " (" + publishingYear + ")";    //weight ne treba biti included u ispisu
    }
    public static void main(String[] args) {
        Box box = new Box(10);

        box.add(new Book("Fedor Dostojevski", "Crime and Punishment", 2));
        box.add(new Book("Robert Martin", "Clean Code", 1));
        box.add(new Book("Kent Beck", "Test Driven Development", 0.7));

        box.add(new CD("Pink Floyd", "Dark Side of the Moon", 1973));
        box.add(new CD("Wigwam", "Nuclear Nightclub", 1975));
        box.add(new CD("Rendezvous Park", "Closer to Being Here", 2012));

        System.out.println(box);
    }
}
class Box implements ToBeStored
{
    private double maxWeight;
    private List<ToBeStored> items;
    public Box(double maxWeight)
    {
        this.maxWeight=maxWeight;
        this.items=new ArrayList<>();
    }
    public double getTotalWeight()    //This method calculates the total weight of the items currently stored in the box.
    {
        double totalWeight=0;
        for(ToBeStored item : items)
        {
            totalWeight+= item.weight();
        }
        return totalWeight;
    }
    public void add(ToBeStored item)   //This method is used to add items to the box.
    // It checks if adding the item would exceed the maximum weight capacity.
    // If not, it adds the item to the list of items in the box.
    {
        if(getTotalWeight() + item.weight()<=maxWeight)
        {
            items.add(item);
        }
    }

    @Override
    public double weight() {
        return getTotalWeight();
    }
    public String toString()
    {
        return "Box: " + items.size() + " things, total weight " + getTotalWeight() + "kg";
    }
}


