import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * for the bundle calculation
 */
public class bundleCalculator {

    /**
     * calculate the bundle number and price, then printout the total price
     * and detail
     *
     * example:
     * 14 IMG 1250.00
     * 1 x 10 800.0
     * 1 x 5 450.0
     *
     * @param quantity interger presents
     * @param format string presents the code of the format
     * @param formatBundleList map stores the bundle information of all format
     */
    public static void priceCalculator(Integer quantity, String format,
                                       Map<String, formatBundle> formatBundleList) {
        // creat the bundles price with given formate code
        TreeMap bundlesPrice = formatBundleList.get(format).getBundles();
        // creat array for bundles
        ArrayList<Integer> bundles = new ArrayList(bundlesPrice.keySet());
        // set the total price
        Double totalPrice = 0.0;
        HashMap<Integer, Integer> priceList = new HashMap<>();
        Integer presentQuantity = quantity;
        // go through the bundles in reverse order
        for (int i = bundles.size() - 1; i >=0; i--) {
            Integer presentBundle = bundles.get(i);
            // get hte bundle number
            Integer bundleNum = presentQuantity / presentBundle;
            // calculate the remaining quantity
            presentQuantity = presentQuantity % presentBundle;
            if (i == 0 && presentQuantity != 0) {
                bundleNum++;
            } else if (i != 0 && presentQuantity != 0) {
                /* round up the quantity if present quantity divides present
                 bundle is over 0.5 and less than 1 */
                if ((double) presentQuantity / presentBundle > 0.5 && (double)
                        presentQuantity / presentBundle < 1) {
                    bundleNum++;
                    presentQuantity = 0;
                }
            }
            // calculate the total price
            totalPrice += bundleNum * (Double) bundlesPrice.get(presentBundle);
            if (bundleNum != 0) {
                priceList.put(presentBundle, bundleNum);
            }
        }
        // print out the output
        System.out.println(String.format("%s %s %.2f", quantity, format,
                totalPrice));
        for (Integer bundle: new TreeSet<>(priceList.keySet()).descendingSet()) {
            System.out.println(priceList.get(bundle) + " x " + bundle + " "
                    + bundlesPrice.get(bundle));
        }
    }
}
