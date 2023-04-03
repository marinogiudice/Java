/**
 * Helper class for the ElectricDevice hierarchy.
 *
 * @author Marino Giudice
 */
public class ElectricDeviceHelper {

    /**
     * Private constructor to ensure that no instances of this class are created
     * by users of the class.
     */
    private ElectricDeviceHelper() {}

    /**
     * Method to compute and return the sum of the capacities in bytes of those
     * electric devices in the parameter array that implement the DataStorage
     * interface. Throws an InsufficientDataStorageException if there are no
     * such devices in the array.
     *
     * @param devices an array of ElectricDevices whose total capacity we want
     *  to compute; must not be null, but may contain null
     * @return the sum of the storage capacities of the ElectricDevices that
     *  implement the DataStorage interface
     * @throws InsufficientDataStorageException if devices does not contain any
     *  instance of DataStorage
     * @throws NullPointerException if devices is null
     */
    public static long getTotalStorageCapacity(ElectricDevice[] devices) {
        if (devices == null) {
            throw new NullPointerException("devices must not be null!");
        }
		boolean flag = false;
        DataStorage d;
        long sum = 0;
		for(ElectricDevice el : devices) {
            if (el instanceof DataStorage) {
                flag = true;
                d = (DataStorage) el;
                sum += d.getCapacityInBytes();
            }
        }
		if (!(flag)) {
            throw new InsufficientDataStorageException("No DataStorage devices present in the array devices");
        }
        return sum;
    }
}
