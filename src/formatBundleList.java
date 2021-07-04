import java.util.HashMap;
import java.util.Map;

/**
 * the format list
 */
public class FormatBundleList {

    // map to store the bundles list
    Map<String, FormatBundle> formatBundleList;

    public FormatBundleList() {
        formatBundleList = new HashMap<>();
    }

    /**
     * get the bundle list
     *
     * @return map store the bundle information of all the format
     */
    public Map<String, FormatBundle> getFormatBundleList() {
        return formatBundleList;
    }

    /**
     * put the bundle into the map
     *
     * @param formatBundle the bundle information for the format
     */
    public void putFormatBundle(FormatBundle formatBundle) {
        formatBundleList.put(formatBundle.getCode(), formatBundle);
    }
}
