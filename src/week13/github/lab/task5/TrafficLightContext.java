package week13.github.lab.task5;

public class TrafficLightContext {
    private TrafficLightState state;

    public TrafficLightContext()
    {
        this.state=new RedLightState();
    }

    public void setState(TrafficLightState state)
    {
        this.state=state;
    }
    public void transitionToRed()
    {
        state.transitionToRed();
    }
    public void transitionToGreen() {
        state.transitionToGreen();
    }

    public void transitionToYellow() {
        state.transitionToYellow();
    }
}
