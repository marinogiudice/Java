/**
 * A MainsDevice is an ElectricDevice that one can connect to the power mains.
 * It has a mains voltage. The mains voltage of a MainsDevice is also its
 * operating voltage.
 *
 * @author Marino Giudice
 */
public class MainsDevice extends ElectricDevice {

    /** The Voltage that the device takes from the main. Always greater than 0. */
    private double mainsVoltage;

    /**
     * Constructs a new MainsDevice according to the parameters.
     *
     * @param name the name of the device; must not be null
     * @param watts the power in watts of the device; must be greater than zero
     * @param mainsVoltage the voltage that the device takes from the mains; must be greater than zero
	 * @throws IllegalArgumentException if mainsVoltage is not greater than zero
     */
	 
    public MainsDevice(String name, double watts, double mainsVoltage) {
        super(name,watts);
        if (! (mainsVoltage > 0)) {
            throw new IllegalArgumentException("mainsVoltage must be positive, found: " + mainsVoltage);
        }
		this.mainsVoltage = mainsVoltage;	
    }
	
	/**
     * Method getMainsVoltage
     *
     * @return The main voltage of the main devices - greater than 0
     */
    
	public double getMainsVoltage() {
        return this.mainsVoltage;
    }
	
	/**
     * Method getOperatingVoltage
     *
	 * The method overrides the getOperatingVoltage method of the super class
	 * ElectricDevice
     * @return The operating voltage of a MainDevice
	 * 
     */
    
	@Override
    public double getOperatingVoltage() {
        return this.getMainsVoltage();
    }

    @Override
    public String toString() {
        return super.toString() + "\nMains voltage: " + this.getMainsVoltage();
    }
}
