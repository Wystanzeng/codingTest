import java.util.TreeMap;

/**
 * the bundles for the format
 */
public class FormatBundle {

    // format of submission
    private String format;

    // code for the format
    private String code;

    // map to store the bundle
    private TreeMap<Integer, Double> bundles;

    public FormatBundle(String format, String code) {
        this.format = format;
        this.code = code;
        bundles = new TreeMap<>();
    }

    /**
     * get the format of submission
     *
     * @return string represent the format
     */
    public String getFormat() {
        return format;
    }

    /**
     * get the code for the format
     *
     * @return string represent the code
     */
    public String getCode() {
        return code;
    }

    /**
     * put the bundle input the bundle map
     *
     * @param bundle a integer for the size of bundle
     * @param price a double for the price for the bundle
     */
    public void putBundle(Integer bundle, Double price) {
        bundles.put(bundle, price);
    }

    /**
     * get the bundles
     *
     * @return treeMap store the price information of bundle
     */
    public TreeMap<Integer, Double> getBundles() {
        return bundles;
    }
}
