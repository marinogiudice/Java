/**
 * A JPod is a RechargeableDevice that can store data (and play music).
 * It has 20 watts power, and its battery voltage is at 3 volts. 
 *
 * @author Marino Giudice
 */
public class JPod extends RechargeableDevice implements DataStorage {
	
	/** The capacity in Bytes of a JPod device */
    private long capacityInBytes; 

    /**
     * Constructs a new JPod according to the parameters.
     *
     * @param mainsVoltage the voltage that the device takes from the mains; must be greater than zero
     * @param capacityInBytes the capacity in bytes; must be greater than zero
	 * @throws IllegalArgumentException if capacityInBytes is not greater than zero
     */
    public JPod(double mainsVoltage, long capacityInBytes) {
		//The constructor of the superclass is called with fixed parameters, matching the JPod specifications
        super("JPod",20,mainsVoltage,3);
        if (! (capacityInBytes > 0)) {
            throw new IllegalArgumentException("capacityInBytes must be greater than zero, found: " + capacityInBytes);
        }
        this.capacityInBytes = capacityInBytes;
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
