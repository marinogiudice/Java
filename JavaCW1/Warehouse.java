import java.util.ArrayList;

/**
 * A Warehouse holds zero or more Articles and can provide information about
 * the Articles. One can add Articles to a Warehouse during its lifetime,
 * reset the Warehouse, create a copy which contains Articles of at least a
 * certain value, and make various queries to the Warehouse. (Thus, the
 * number of Articles that will be stored by a Warehouse object is not yet
 * known when the new object is created, and it may grow and shrink over the
 * lifetime of a Warehouse object.)
 *
 * @author Marino Giudice
 */
public class Warehouse {
	/** The list of the Article objects contained in the Warehouse. It may be empty after object creation */
    private ArrayList<Article> list;

    /* Constructors */

    /**
     * Constructs a new Warehouse without any Articles.
     */
    public Warehouse() {
		this.list = new ArrayList<>();
    }

    /**
     * Constructs a new Warehouse containing the non-null Articles in articles.
     * The articles array may be modified by the caller afterwards without
     * affecting this Warehouse, and it will not be modified by this
     * constructor.
     *
     * @param articles must not be null; non-null elements are added to the
     *  constructed Warehouse
     */
    public Warehouse(Article[] articles) {
        this();
        if (!(articles == null)) {
            for (Article art : articles) {
                if (!(art == null)) {
                    this.list.add(art);
                }
            }
        }
    }

    /* Modifiers */

    /**
     * Adds an Article e to this Warehouse if e is not null; does not modify this
     * Warehouse otherwise. Returns true if e is not null, false otherwise.
     *
     * @param e an article to be added to this Warehouse
     * @return true if e is not null, false otherwise
     */
    public boolean add(Article e) {
        if (!(e == null)) {
            this.list.add(e);
            return true;
        } 
		else {
			return false;
		}
    }

    /**
     * Adds all non-null Articles in articles to this Warehouse.
     *
     * @param articles contains the Article objects to be added to
     *  this Warehouse; must not be null (but may contain null)
     * @return true if at least one element of articles is non-null;
     *  false otherwise
     */
    public boolean addAll(Article[] articles) {
        int flag = 0;
        if(!(articles == null)) {
            for (Article art : articles) {
                if(this.add(art)) {
                    flag++;
                }
            }
        }
        if (flag>0) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Resets this Warehouse to a Warehouse that contains 0 Articles.
     */
    public void reset() {
        this.list.clear();
    }

    /**
     * Removes certain Articles from this Warehouse. Exactly those Articles
     * are kept whose price in pence is greater than or equal to the specified
     * minimum price in pence.
     *
     * @param minArticlePriceInPence the minimum price in pence for the
     *  Articles that are kept
     */
    public void keepOnlyArticlesWith(int minArticlePriceInPence) {
        for(int i=(this.list.size()-1); i >= 0; i--){
            if(this.list.get(i).getPriceInPence() < minArticlePriceInPence){
                this.list.remove(i);   
            }
        }
    }

    /* Accessors */

    /**
     * Returns the number of non-null Articles in this Warehouse.
     *
     * @return the number of non-null Articles in this Warehouse
     */
    public int numberOfArticles() {
        return this.list.size();
    }

    /**
     * Returns the total price of the Articles in this Warehouse.
     *
     * @return the total price of the Articles in this Warehouse.
     */
    public int totalPriceInPence() {
        int total=0;
        for(Article art : this.list) {
            total += art.getPriceInPence();
        }
        return total;
    }

    /**
     * Returns the average price in pence of the (non-null) Articles
     * in this Warehouse. In case there is no Article in this Warehouse,
     * -1.0 is returned.
     *
     * For example, if this Warehouse has the contents
     *   new Article("Soda", 400)
     * and
     *   new Article("Water", 395),
     * the result is: 397.5
     *
     * @return the average price of the Articles in this Warehouse,
     *  or -1.0 if there is no such Article.
     */
    public double averagePriceInPence() {
        int size = this.list.size();
        if(!(size>0)) {
            return -1;
        }
        int total = 0;
        for (Article art : this.list) {
            total += art.getPriceInPence();
        }
        return total/size;
    }

    /**
     * Returns the most expensive Article in this Warehouse;
     * null if this Warehouse does not contain any Article objects.
     * If several Articles have the same maximum price, an arbitrary
     * of these Articles will be returned.
     *
     * @return the most expensive Article in this Warehouse;
     *  null if this Warehouse does not contain any Article objects
     */
    public Article mostExpensiveArticle() {
        int size = this.list.size();
        if(!(size>0)) {
            return null;
        }
        Article mostExpensive = this.list.get(0);
        for(Article art : this.list) {
            if(art.getPriceInPence() > mostExpensive.getPriceInPence()) {
                mostExpensive = art;
            }
        }
        return mostExpensive;
    }

    /**
     * Returns a new Warehouse with exactly those Articles of this Warehouse
     * whose price is greater than or equal to the specified method parameter.
     * Does not modify this Warehouse.
     *
     * @param minArticlePriceInPence the minimum price in pence for the
     *  Articles in the new Warehouse
     * @return a new Warehouse with exactly those Articles of this Warehouse
     *  whose price is greater than or equal to the specified method parameter
     */
    public Warehouse makeNewWarehouseWith(int minArticlePriceInPence) {
        Warehouse result = new Warehouse();
        for (Article art : this.list) {
            if(art.getPriceInPence() >= minArticlePriceInPence){
                result.add(art);
            }
        }
        return result;
    }

    /**
     * Returns a string representation of this Warehouse. The string
     * representation consists of a list of the Warehouse's contents,
     * enclosed in square brackets ("[]"). Adjacent Articles are
     * separated by the characters ", " (comma and space). Articles are
     * converted to strings as by their toString() method. The
     * representation does not mention any null references.
     *
     * So for
     *
     * Article a1 = new Article("Pen", 750);
     * Article a2 = null;
     * Article a3 = new Article("Stamp", 80);
     * Article[] articles = { a1, a2, a1, a3 };
     * Warehouse w = new Warehouse(articles);
     *
     * the call w.toString() will return one of the three following Strings:
     *
     * "[(Pen, 750), (Pen, 750), (Stamp, 80)]"
     * "[(Pen, 750), (Stamp, 80), (Pen, 750)]"
     * "[(Stamp, 80), (Pen, 750), (Pen, 750)]"
     *
     * @return a String representation of this Warehouse
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String s = "[";
        int size = this.list.size();
        for(int i=0; i<size; i++) {
            Article art = this.list.get(i);
            if(i>0){
                s=s+", ";
            }
            s = s+art;
        }
        s = s +("]");
        return s;
    }

    /* class methods */

    /**
     * Class method to return a Warehouse with the highest total price from an
     * array of Warehouses. If we have an array with a Warehouse of 3000 pence
     * and a Warehouse with 4000 pence, the Warehouse with 4000 pence is
     * returned.
     *
     * Entries of the array may be null, and your method should work also in
     * the presence of such entries. So, if in the above example we had an
     * additional third array entry null, the result would be exactly the same.
     *
     * If there are several Warehouses with the same price, it is up to the
     * method implementation to choose one of them as the result (i.e., the
     * choice is implementation-specific, and method users should not rely on
     * any particular behaviour).
     *
     * @param warehouses must not be null, but may contain null
     * @return one of the Warehouses with the highest total price among all
     *  Warehouses in the parameter array; null if there is no non-null
     *  reference in warehouses
     */
    public static Warehouse mostValuedWarehouse(Warehouse[] warehouses) {
        if (warehouses == null) {
            throw new NullPointerException("warehouses must not be null!");
        }
        Warehouse most = new Warehouse();
        boolean flag = false;
        for (Warehouse w : warehouses) {
            if (w != null) {
                most = w;
                flag=true;
                break;
            }
        }
        if (flag == false) {
            return null;
        }
        for(Warehouse w : warehouses) {
            if(w != null) {
                if(w.totalPriceInPence() > most.totalPriceInPence()) {
                    most = w;
                }
            }
            else {
            }
        }
        return most;
    }
}
