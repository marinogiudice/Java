import java.util.Arrays;
import java.util.ArrayList;

/**
 * A SolarRadio is a radio that gets its electricity from photovoltaic (solar)
 * cells. It supports certain frequency bands and it has a fixed operating
 * voltage of 4.5 volts.
 *
 * @author Marino Giudice
 */
public class SolarRadio extends ElectricDevice {
	/** 
     * The list of the bands supported of the radio. We use ArrayList because we don't know how many values the passed array contains.
     * Null values are not added to this ArrayList.
     */
    private ArrayList<String> bands;

    /**
     * Constructs a SolarRadio object according to the parameters.
     *
     * @param name the name of the device; must not be null
     * @param watts the power in watts of the device; must be greater than zero
     * @param bands the frequency bands supported by the radio; the argument array
     *  must not be null, but may contain null; the argument array may be modified
     *  by the caller after object creation without affecting this SolarRadio
	 * @throws NullPointerException if the array parameter bands is null
     */
    public SolarRadio(String name, double watts, String[] bands) {
        super(name,watts);
        if (bands == null) {
            throw new NullPointerException("bands must not be null!");
        }
        this.bands = new ArrayList<String>();
        for (String b : bands) {
            if (!(b == null)) {
                this.bands.add(b);
            }
        }   
    }
	
	/**
     * Method getBands
	 *
     * @return an Array of type String, containing the bands supported of the radio. Doesn't contain
     *  null references because null values were not added to the ArrayList this.bands on object creation. 
     */
    
    public String[] getBands() {
        int listSize = this.bands.size();
        String[] result = new String[listSize];
        this.bands.toArray(result);
        return result;  
    }

    @Override
	public double getOperatingVoltage() {
        return (double)4.5;
    }

    @Override
    public String toString() {
        return super.toString() + "\nFrequency bands: " + Arrays.toString(this.getBands());
    }
}
