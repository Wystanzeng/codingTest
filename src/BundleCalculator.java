import java.util.*;

/**
 * for the bundle calculation
 */
public class BundleCalculator {

    /**
     * calculate the bundle number and price, then printout the total price
     * and detail
     *
     * @param orderDetail order for the given format
     */
    public static void priceCalculator(OrderDetail orderDetail) {
        // creat the bundles price with given format code
        FormatBundle formatBundle = orderDetail.getFormatBundle();
        // creat array for bundles
        ArrayList<Integer> bundles = new ArrayList(formatBundle.getBundles().keySet());
        //
        Integer quantity = orderDetail.getQuantity();
        // go through the bundles in reverse order
        for (int i = bundles.size() - 1; i >= 0; i--) {
            Integer presentBundle = bundles.get(i);
            // get hte bundle number
            Integer bundleNum = quantity / presentBundle;
            // calculate the remaining quantity
            quantity = quantity % presentBundle;
            if (i == 0 && quantity != 0) {
                bundleNum++;
            } else if (i != 0 && quantity != 0) {
                /* round up the quantity if present quantity divides present
                 bundle is over 0.5 and less than 1 */
                if ((double) quantity / presentBundle > 0.5 && (double)
                        quantity / presentBundle < 1) {
                    bundleNum++;
                    quantity = 0;
                }
            }
            if (bundleNum != 0) {
                orderDetail.putOrder(presentBundle, bundleNum);
            }
        }
        // print out the output
        System.out.println(orderDetail.toString());
    }
}
