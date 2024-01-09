package week13.github.lab.task4;

public class DeviceAdapter implements NewDevice{
    private OldDevice oldDevice;

    public DeviceAdapter(OldDevice oldDevice)
    {
        this.oldDevice=oldDevice;
    }
    @Override
    public void operateNewFunction(int level, String function) {
        System.out.println("Adapter translating to the new method at the level : " + level);
        oldDevice.operateOldFunction(function);


    }
}
