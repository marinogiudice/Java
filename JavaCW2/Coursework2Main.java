/**
 * "Driver class" to exercise some of the functionalities provided by the
 * ElectricDevice and DataStorage hierarchy.
 *
 * @author Carsten Fuhs
 */
public class Coursework2Main {

    /* Some helper methods to generate test objects */

    /**
     * @return an exemplary SolarRadio with 2 bands
     */
    public static SolarRadio mkSolarRadio1() {
        String[] bands = { "AM", null, "FM" };
        return new SolarRadio("Sunny Radio", 2, bands);
    }

    /**
     * @return an exemplary SolarRadio with 3 bands
     */
    public static SolarRadio mkSolarRadio2() {
        String[] bands = { "AM", "FM", "LW" };
        SolarRadio result = new SolarRadio("Solar Waves", 3, bands);
        bands[0] = null; // should /not/ affect the SolarRadio object!
        return result;
    }

    /**
     * @return an exemplary USBDrive
     */
    public static USBDrive mkUSBDrive() {
        return new USBDrive("Data Holder", 0.02, 16000000000L);
    }

    /**
     * @return an exemplary USBDrive with zero capacity
     */
    public static USBDrive mkUSBDriveBad() {
        return new USBDrive("Data Storer", 0.01, 0);
    }

    /**
     * @return an exemplary MainsDevice
     */
    public static MainsDevice mkMainsDevice() {
        return new MainsDevice("BBK Fridge", 500, 120);
    }

    /**
     * @return an exemplary RechargeableDevice
     */
    public static RechargeableDevice mkRechargeableDevice() {
        return new RechargeableDevice("Cordless Drill", 15, 240, 12);
    }

    /**
     * @return an exemplary JPod
     */
    public static JPod mkJPod() {
        return new JPod(240, 32000000000L);
    }

    /**
     * Main method for exercising classes from the ElectricDevice hierarchy.
     *
     * @param args ignored
     */
    public static void main(String[] args) {
        // exercise classes
        ElectricDevice[] devices = {
            mkSolarRadio1(),
            mkSolarRadio2(),
            mkUSBDrive(),
            mkMainsDevice(),
            mkRechargeableDevice(),
            mkJPod()
        };
        for (ElectricDevice d : devices) {
            System.out.println(d);
            System.out.println();
        }

        // exercise SolarRadio
        SolarRadio radio = mkSolarRadio1();
        String[] bands = radio.getBands();
        bands[0] = "Visual spectrum!";
        System.out.println(radio);
        System.out.println();

        // exercise interface implementations
        DataStorage[] dataStorages = {
            mkJPod(),
            mkUSBDrive()
        };
        System.out.println("*** Data Storages ***");
        for (DataStorage storage : dataStorages) {
            System.out.println("Capacity: " + storage.getCapacityInBytes());
        }
        System.out.println();

        // exercise exceptions
        try {
            USBDrive ud = mkUSBDriveBad();
            System.out.println(ud);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        System.out.println();
        try {
            ElectricDevice[] noDataStorageDevices = {
                mkSolarRadio1(),
                null,
                mkMainsDevice()
            };
            ElectricDeviceHelper.getTotalStorageCapacity(noDataStorageDevices);
        } catch (InsufficientDataStorageException e) {
            System.out.println(e);
        }
    }

/*

*** SolarRadio ***
Name: Sunny Radio
Watts: 2.0
Operating Voltage: 4.5
Frequency bands: [AM, FM]

*** SolarRadio ***
Name: Solar Waves
Watts: 3.0
Operating Voltage: 4.5
Frequency bands: [AM, FM, LW]

*** USBDrive ***
Name: Data Holder
Watts: 0.02
Operating Voltage: 5.0
Capacity in bytes: 16000000000

*** MainsDevice ***
Name: BBK Fridge
Watts: 500.0
Operating Voltage: 120.0
Mains voltage: 120.0

*** RechargeableDevice ***
Name: Cordless Drill
Watts: 15.0
Operating Voltage: 12.0
Mains voltage: 240.0
Battery Voltage: 12.0

*** JPod ***
Name: JPod
Watts: 20.0
Operating Voltage: 3.0
Mains voltage: 240.0
Battery Voltage: 3.0
Capacity in bytes: 32000000000

*** SolarRadio ***
Name: Sunny Radio
Watts: 2.0
Operating Voltage: 4.5
Frequency bands: [AM, FM]

*** Data Storages ***
Capacity: 32000000000
Capacity: 16000000000

java.lang.IllegalArgumentException: capacityInBytes must be positive, found: 0

InsufficientDataStorageException: No DataStorage found!

 */
}
