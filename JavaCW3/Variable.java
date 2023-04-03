import java.util.Set;

/**
 * A variable is a symbolic expression that stands for a value that has not yet
 * been fixed. A variable has a name of the format
 * 
 * letter (letter | digit)^*
 *
 * (where '(letter | digit)^*' stands for 'a string of length 0 or more that
 * contains only letters and digits').
 *
 * Here the class methods Character.isLetter(char) and
 * Character.isLetterOrDigit(char) determine whether a character is
 * a letter/a letter or a digit, respectively.
 *
 * For example, the following names are legal:<br>
 * - "AbC"<br>
 * - "e2e4"<br>
 * - "BBK"<br>
 * - "x"
 *
 * The following names are not legal:<br>
 * - "" (no start letter)<br>
 * - "2e4e" (no start letter)<br>
 * - "a/b" (illegal character '/')<br>
 * - "a_b" (illegal character '_')
 *
 * Instances of this class are immutable.
 *
 * @author Carsten Fuhs
 * @author Marino Giudice
 */
public class Variable implements Expression {

    /**
     * Name of this Variable. Non-null, of the format
     *
     * letter (letter | digit)*
     */
    private String name;

    /**
     * Constructs a new Variable with the specified name.
     *
     * @param name
     *            must not be null; must be a String of the format letter
     *            (letter | digit)^*
	 * @throw NullPointerException if the parameter is null
	 * @throw IllegalArgumentException if name is of length 0
	 * @throw IllegalArgumentException if name starts with a digit
	 * @throw IllegalArgumentException if name contains illegal characters
     */
    public Variable(String name) {
        if (name == null) {
            throw new NullPointerException("Name must be not null");
        }
        int length = name.length();
        if(length <= 0) {
            throw new IllegalArgumentException("Variable name can't be empty");
        }
        if(Character.isDigit(name.charAt(0))) {
            throw new IllegalArgumentException("Variable name can't start with a digit");
        }
        for(int i=0;i<length;i++) {
            if(!(Character.isLetterOrDigit(name.charAt(i)))) {
                throw new IllegalArgumentException("Illegal name for Variable! Illegal Character: " +name.charAt(i));
            }
        }
        this.name = name;
    }
	
	/**
     * The method returns the name of a Variable    
     * 
     */
	public String getName() {
        return this.name;
    }

    @Override
    public int numberOfNodes() {
        return 1;
    }

    @Override
    public int computeValue() {
        throw new UnsupportedOperationException("Cannot compute the value of a variable without a substitution!"); 
    }

    @Override
    public Expression applySubstitution(Substitution s) {
		if (s == null) {
            throw new NullPointerException("s must be not null");
        }
        return s.get(this);
    }

    @Override
    public void collectVariables(Set<Variable> vars) {
        // TODO
    }

    @Override
    public boolean isVariableFree() {
        return false;
    }

    @Override
    public String toString() {
        return "" +this.name;
    }

    /**
     * The method returns true if o is an instance of class Variable
     * whose name is equal to the name of this Variable; otherwise it
     * returns false.
     * 
     * @return whether this Variable and Object o are equal
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Variable)) {
            return false;
        }
        Variable other = (Variable) o;
        return name.equals(other.name);
    }
}
