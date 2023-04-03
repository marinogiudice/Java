/**
 * A USBDrive is a data storage device with a certain capacity in bytes.
 * It can be connected to the USB port of a computer. It operates at
 * the standard voltage of the USB port (5 volts).
 *
 * @author Marino Giudice
 */
public class USBDrive extends ElectricDevice implements DataStorage {

    /** The storege capacity of the device. Always greater or equal than zero. */
    private long capacityInBytes;

    /**
     * Constructs a new USB drive according to the parameters.
     *
     * @param name the name of the device; must not be null
     * @param watts the power in watts of the device; must be greater than zero
     * @param capacityInBytes the data storage capacity of this USB drive;
     *  must be greater than zero
	 * @throws IllegalArgumentException if capacityInBytes is less than zero
     */
    public USBDrive(String name, double watts, long capacityInBytes) {
        super(name,watts);
        if (! (capacityInBytes > 0)) {
            throw new IllegalArgumentException("capacityInBytes must be greater than zero, found: " + capacityInBytes);
        }
        this.capacityInBytes = capacityInBytes;
    }

	@Override
	public double getOperatingVoltage() {
        return (double)5;
    }
	
	@Override
	public long getCapacityInBytes() {
        return this.capacityInBytes;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nCapacity in bytes: " + this.getCapacityInBytes();
    }
}
