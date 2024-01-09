package week13.github.lab.task5;

public class TrafficLightController {
    public static void main(String[] args)
    {
        TrafficLightContext context=new TrafficLightContext();

        context.transitionToGreen();
        context.transitionToRed();
        context.transitionToYellow();
    }
}
