/**
 * A RechargeableDevice is a MainsDevice with rechargeable batteries.
 * The rechargeable batteries have a specific voltage. The operating
 * voltage of the rechargeable device is the voltage of the batteries.
 * 
 * @author Marino Giudice
 */
public class RechargeableDevice extends MainsDevice {

    /** The battery Voltage of the device. Always greater than 0. */
    private double batteryVoltage;

    /**
     * Constructs a new RechargeableDevice according to the parameters.
     *
     * @param name the name of the device; must not be null
     * @param watts the power in watts of the device; must be greater than zero
     * @param mainsVoltage the voltage that the device takes from the mains; must be greater than zero
     * @param batteryVoltage the battery voltage of the device; must be greater than zero
	 * @throws IllegalArgumentException if batteryVoltage is not greater than zero
     */
    public RechargeableDevice(String name, double watts, double mainsVoltage, double batteryVoltage) {
        super(name,watts,mainsVoltage);
		if (! (batteryVoltage > 0)) {
            throw new IllegalArgumentException("batteryVoltage must be greater than 0, found: " + batteryVoltage);
        }
        this.batteryVoltage = batteryVoltage;
    }
	
	 /**
     * Method getBatteryVoltage
     *
     * @return The batteryVoltage of this RechargeableDevice
     *  always greater than zero
     */
    public double getBatteryVoltage() {
        return this.batteryVoltage;
    }
	
	//A RechargeableDevice operates at the voltage of its battery.
	@Override 
	public double getOperatingVoltage() {
        return this.getBatteryVoltage();
    }

    @Override
    public String toString() {
        return super.toString() + "\nBattery Voltage: " + this.getBatteryVoltage();
    }
}
