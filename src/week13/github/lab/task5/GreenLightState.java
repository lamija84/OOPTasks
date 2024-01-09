package week13.github.lab.task5;

public class GreenLightState implements TrafficLightState{
    @Override
    public void transitionToRed() {
        System.out.println("Switching to red");
    }

    @Override
    public void transitionToGreen() {
        System.out.println("Already in green state");
    }

    @Override
    public void transitionToYellow() {
        System.out.println("Switching to yellow");
    }
}
