import java.util.Map;
import java.util.HashMap;
/**
 * A Substitution represents a mapping of finitely many Variables to
 * Expressions. One can construct an empty Substitution, update a Substitution
 * by adding/replacing/forgetting mappings of Variables to Expressions, and
 * query Substitutions for the value to which they map a variable, whether they
 * have a mapping for a specific variable, and for a String representation.
 *
 * @author Carsten Fuhs
 * @author Marino Giudice
 */
 
 /**
 * the instance variable substitutions maps the value of the substitution for each variable
 * that it contains.
 * So it's implemented by a map, which takes the name of the variable as key
 * and the related expression as value.
 *
 */
 
public class Substitution {
	private Map<String,Expression> substitutions;

    /**
     * Constructs an empty Substitution (i.e., a Substitution that does not
     * hold mappings for any variables).
     */
    public Substitution() {
        substitutions = new HashMap<String,Expression> ();
    }

    /* Mutators */

    /**
     * Associates the specified Expression with the specified Variable in this
     * Substitution. If the Substitution previously contained a mapping for the
     * Variable, the old Expression is replaced.
     *
     * @param var
     *            the Variable with which exp is to be associated
     * @param exp
     *            the Expression to which var is to be mapped
     * @return the Expression to which var was mapped so far, or null if var did
     *         not yet have a mapping in this Substitution
     * @throws NullPointerException
     *             if var or exp is null
     */
    public Expression put(Variable var, Expression exp) {
        if (var == null || exp == null) {
            throw new NullPointerException("Variable and Expression must be not null!");
        }
        String s = var.getName();
        return substitutions.put(s,exp); 
    }

    /**
     * Forgets the mapping for the specified Variable. Does not modify this
     * Substitution if it does not have a mapping for the specified Variable.
     *
     * @param var
     *            the Variable for which we want to forget the mapping
     * @return whether a mapping for var was forgotten due to the method call
     * @throws NullPointerException
     *             may be thrown if var is null
     */
    public boolean forget(Variable var) {
        if (var == null) {
            throw new NullPointerException("Variable must be not null!");
        }
        if(this.hasMappingFor(var)) {
            substitutions.remove(var.getName());
            return true;
        }
        return false;
    }

    /* Accessors */

    /**
     * Returns the value to which the specified Variable is mapped, or null if
     * this Substitution contains no mapping for the specified Variable.
     * 
     * @param var
     *            the variable for which we want the corresponding Expression to
     *            which it is mapped
     * @return the Expression to which this Substitution maps var, or var if
     *         this Substitution does not have a mapping for var
     * @throws NullPointerException
     *             may be thrown if var is null
     */
    public Expression get(Variable var) {
        if(var == null) {
            throw new NullPointerException("Var must be not null!");
        }
        return substitutions.get(var.getName());
    }

    /**
     * Returns whether this Substitution has an explicit mapping of var to an
     * Expression.
     *
     * @param var
     *            the Variable for which we want to know if this Substitution
     *            has a mapping
     * @return whether this Substitution has an explicit mapping of var to an
     *         Expression
     * @throws NullPointerException
     *             may be thrown if the parameter is null
     */
    public boolean hasMappingFor(Variable var) {
        if(var == null) {
            throw new NullPointerException("Var must be not null!");
        }
        return(substitutions.containsKey(var.getName()) && substitutions.get(var.getName()) !=null);
    }

    /**
     * Returns a string representation of this Substitution. The string
     * representation consists of a list of Variable-Expression mappings in
     * unspecified order, enclosed in square brackets ("[]"). Adjacent mappings
     * are separated by the characters ", " (comma and space). Each
     * Variable-Expression mapping is rendered as the Variable followed by a
     * colon and an equals sign (":=") followed by the associated Expression.
     * Variables and Expressions are converted to strings as by
     * String.valueOf(Object).
     *
     * For example, the mapping of X to 2 and of Y to 5 may be represented by
     * either one of "[X:=2, Y:=5]" or "[Y:=5, X:=2]".
     *
     * @return a String representation of this Substitution
     */
    @Override
    public String toString() {
        // TODO
        return null;
    }
}
