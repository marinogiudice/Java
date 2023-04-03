/**
 * Abstract superclass for our ElectricDevice hierarchy. An electric device
 * has a name and a certain power in watts.
 *
 * @author Carsten Fuhs
 */
public abstract class ElectricDevice {

    /** The name of the device. Always non-null. */
    private String name;

    /** The power in watts of the device. Always greater than 0. */
    private double watts;

    /**
     * Constructs a new electric device with a name and a given power in watts.
     *
     * @param name the name of the device; must not be null
     * @param watts the power in watts of the device; must be greater than zero
     */
    public ElectricDevice(String name, double watts) {
        if (name == null) {
            throw new IllegalArgumentException("name must not be null!");
        }
        if (! (watts > 0)) {
            throw new IllegalArgumentException("powerInWatts must be positive, found: " + watts);
        }
        this.name = name;
        this.watts = watts;
    }

    /**
     * @return the name of the electric device, non-null
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return the power in watts of the electric device
     */
    public double getWatts() {
        return this.watts;
    }

    /**
     * @return the voltage with which the device is operating internally
     */
    public abstract double getOperatingVoltage();

    @Override
    public String toString() {
        return "*** " + this.getClass().getName()
                + " ***\nName: " + this.getName()
                + "\nWatts: " + this.getWatts()
                + "\nOperating Voltage: " + this.getOperatingVoltage();
    }
}
