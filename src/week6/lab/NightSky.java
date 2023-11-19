package week6.lab;

import java.util.Random;

public class NightSky {
    private double density;
    private int width;
    private int height;
    private int starsInLastPrint;
    public NightSky(double density)
    {
        this(density, 20,10);
    }
    public NightSky(int width, int height) {
        this(0.1, width, height);  // chaining constructors (object properly initialized) - used when you have multiple constructors with different parameter lists, and you want to avoid duplicating code.
    }
    public NightSky(double density, int width, int height)
    {
        this.density=density;
        this.width=width;
        this.height=height;
        this.starsInLastPrint = 0;
    }
    public void printLine()
    {
        Random random=new Random();
        for(int i=0;i<this.width;i++)
        {
          if(random.nextDouble()<=this.density)
          {
              System.out.print("*");
              this.starsInLastPrint++;
          }
          else {
              System.out.print(" ");
          }
        }
    }
    public void print()
    {
        this.starsInLastPrint = 0;
        for(int i=0; i<=this.height;i++)
        {
            printLine();
        }

    }
    public int starsInLastPrint() {
        return this.starsInLastPrint;
    }
    public static void main(String[] args) {
        NightSky nightSky1 = new NightSky(0.1, 40, 10);
        nightSky1.print();
        System.out.println("Number of stars: " + nightSky1.starsInLastPrint());
        System.out.println();

        NightSky nightSky2 = new NightSky(0.2, 15, 6);
        nightSky2.print();
        System.out.println("Number of stars: " + nightSky2.starsInLastPrint());
    }

}
