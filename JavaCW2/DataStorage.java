/**
 * Classes implementing the interface DataStorage provide a method that
 * return the capacity in bytes that the object has to store data.
 *
 * @author Carsten Fuhs
 */
public interface DataStorage {

    /**
     * @return the capacity in bytes for this DataStorage
     */
    long getCapacityInBytes();
}
