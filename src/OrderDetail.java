import java.util.HashMap;
import java.util.TreeSet;

/**
 * the order for the given format
 */
public class OrderDetail {
    // the order
    Order order;
    // format for the order
    Double totalPrice;
    // the bundle price for the given format
    FormatBundle formatBundle;
    // the order detail
    HashMap<Integer, Integer> orderDetail;

    public OrderDetail(Order order, FormatBundle formatBundle) {
        this.order = order;
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
     * order quantity
     *
     * @return Integer the given quantity for the order
     */
    public Integer getQuantity() {
        return order.getQuantity();
    }

    /**
     * string represent the order
     *
     * format:
     * Quantity formatCode totalPrice
     * bundleNum x bundle BundlePrice
     * ...
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s %s %.2f", order.getQuantity(),
                order.getQuantity(),
                totalPrice));
        for (Integer bundle: new TreeSet<>(orderDetail.keySet()).descendingSet()) {
            sb.append(System.lineSeparator() + orderDetail.get(bundle) + " x " + bundle + " "
                    + formatBundle.getBundles().get(bundle) * orderDetail.get(bundle));
        }
        return sb.toString();
    }
}
