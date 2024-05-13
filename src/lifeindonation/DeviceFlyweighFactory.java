package lifeindonation;

public class DeviceFlyweighFactory {
    
    public static void getDevice(String type){
        
        if(type.equalsIgnoreCase("need device list")){
            NeededDevice neededDevice = new NeededDevice();
            neededDevice.deviceList();
        }
        else if (type.equalsIgnoreCase("donated device list")){
            DonatedDevice donatedDevice = new DonatedDevice();
            donatedDevice.deviceList();
        }
    }
}
