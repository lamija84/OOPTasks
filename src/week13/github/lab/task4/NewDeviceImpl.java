package week13.github.lab.task4;

public class NewDeviceImpl implements NewDevice{
    @Override
    public void operateNewFunction(int level, String function) {
        System.out.println("Performing new function at level " + level + ": " + function);

    }
}
