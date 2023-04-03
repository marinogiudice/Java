/**
 * Represents an Expression of the form e1 * e2.
 * Instances of this class are immutable.
 * 
 * @author Carsten Fuhs
 * @author Marino Giudice
 */
public class TimesExpression extends BinaryExpression {

    /**
     * Constructs a TimesExpression with left and right as direct
     * subexpressions.
     *
     * @param left
     *            the left subexpression; non-null
     * @param right
     *            the right subexpression; non-null
     */
    public TimesExpression(Expression left, Expression right) {
        super(left, right, "*");
    }

    @Override
    public int computeValue() {
        return getLeft().computeValue() * getRight().computeValue(); 
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TimesExpression)) {
            return false;
        }
        return super.equals(o);
    }
	
	@Override
    public Expression applySubstitution(Substitution s) {
        return new TimesExpression(this.getRight().applySubstitution(s),this.getLeft().applySubstitution(s));
    }
}
