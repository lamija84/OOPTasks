package week13.github.lab.task4;

public class Main {
    public static void main(String[] args)
    {
        testDeviceAdapter();
    }

    private static void testDeviceAdapter() {
        OldDevice oldDevice = new OldDeviceImpl();
        NewDevice adapter = new DeviceAdapter(oldDevice);

        adapter.operateNewFunction(2, "Complex action");
        adapter.operateNewFunction(1,"something");
    }
}
