package week13.github.lab.task5;

public class YellowLightState implements TrafficLightState{
    @Override
    public void transitionToRed() {
        System.out.println("Switching to red state");
    }

    @Override
    public void transitionToGreen() {
        System.out.println("Switching to green");
    }

    @Override
    public void transitionToYellow() {
        System.out.println("Already in yellow state");
    }
}
