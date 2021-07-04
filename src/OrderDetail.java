import java.util.HashMap;
import java.util.TreeSet;

/**
 * the order for the given format
 */
public class OrderDetail extends Order{
    // format for the order
    private Double totalPrice;
    // the bundle price for the given format
    private FormatBundle formatBundle;
    // the order detail
    private HashMap<Integer, Integer> orderDetail;

    public OrderDetail(String format, Integer quantity,
                       FormatBundle formatBundle) {
        super(format, quantity);
        this.formatBundle = formatBundle;
        totalPrice = 0.0;
        orderDetail = new HashMap<>();
    }

    /**
     * the put the order detail
     *
     * @param bundle the bundle
     * @param bundleNum the number of bundle
     */
    public void putOrder(Integer bundle, Integer bundleNum) {
        orderDetail.put(bundle, bundleNum);
        // calculate the total price
        totalPrice += bundleNum * (Double) formatBundle.getBundles().get(bundle);
    }

    /**
     * get the bundles
     *
     * @return FormatBundle the bundles of given format
     */
    public FormatBundle getFormatBundle() {
        return formatBundle;
    }

    /**
     * string represent the order
     *
     * format:
     * Quantity formatCode totalPrice
     * bundleNum x bundle BundlePrice
     * ...
     *
     * @return  string represents the order
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s %s %.2f", super.getQuantity(),
                super.getFormat(),
                totalPrice));
        for (Integer bundle: new TreeSet<>(orderDetail.keySet()).descendingSet()) {
            sb.append(System.lineSeparator() + orderDetail.get(bundle) + " x " + bundle + " "
                    + formatBundle.getBundles().get(bundle) * orderDetail.get(bundle));
        }
        return sb.toString();
    }
}
