/**
 * An InsufficientDataStorageException can be thrown to indicate that there is
 * insufficient data storage space available for an operation.
 *
 * @author Marino Giudice
 */
public class InsufficientDataStorageException extends RuntimeException {
	/** Constructs a new InsufficientDataStorageException with no arguments. */
		
    public InsufficientDataStorageException() {
        super();
    }
    
	/** Constructs a new InsufficientDataStorageException we can pass 
	*   a message String as parameter.
	*/
    public InsufficientDataStorageException(String message) {
        super(message);
    }   
}
