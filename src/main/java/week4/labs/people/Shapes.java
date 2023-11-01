package week4.labs.people;

class Shape
{
    private String color;
    private FillType filled;
    public Shape(String color, FillType filled)
    {
        this.color=color;
        this.filled=filled;
    }
    public void displayInfo()
    {
        System.out.println("Color: " + color);
        System.out.println("Filled: " + filled);

    }
    public double getArea()
    {
        return 0;
    }
}

enum FillType
{
    FILLED, NOT_FILLED;
}
class Circle extends Shape
{
    private double radius;
    public Circle(FillType filled, String color, double radius)
    {
        super(color,filled);
        this.radius=radius;
    }
    public double getRadius() //MORA ICI GETTER ZBOG POZIVANJA METODE U MAINU
    {
        return radius;
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + getArea());
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
    public double calculateCircumference(double PI, double r)
    {
        return 2 * PI * r;
    }
    public double calculateCircumference(double r)
    {
        double PI=Math.PI;
        return calculateCircumference(PI,r);
    }
}
class Rectangle extends Shape
{
    private double width;
    private double height;
    public Rectangle(FillType filled, String color, double width, double height)
    {
        super(color, filled);
        this.width=width;
        this.height=height;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Width: " + width);
        System.out.println(("Height: " + height));
        System.out.println(("Area: " + getArea()));
    }

    @Override
    public double getArea() {
        return width * height;
    }

    }
    class Start {
    public static void main(String[] args) {
        System.out.println("Circle: ");
        Circle circle = new Circle( FillType.FILLED, "blue", 5);
        circle.displayInfo();

        double circumference = circle.calculateCircumference(circle.getRadius());
        System.out.println("Circumference: " + circumference);

        System.out.println("Rectangle: ");
        Rectangle rectangle = new Rectangle(FillType.NOT_FILLED, "green", 4, 6);
        rectangle.displayInfo();
    }
}