import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class bundleCalculator {

    public static void main(String[] args) throws IOException {
        // create price for image
        TreeMap<Integer, Double> imageBundles = new TreeMap<>();
        imageBundles.put(5, 450.00);
        imageBundles.put(10, 800.00);
        // create price for audio
        TreeMap<Integer, Double> audioBundles = new TreeMap<>();
        audioBundles.put(3, 427.50);
        audioBundles.put(6, 810.00);
        audioBundles.put(9, 1147.50);
        // create price for video
        TreeMap<Integer, Double> videoBundles = new TreeMap<>();
        videoBundles.put(3, 570.00);
        videoBundles.put(5, 900.00);
        videoBundles.put(9, 1530.00);
        // create format list
        Map<String, TreeMap> formatBundleList = new HashMap<>();
        formatBundleList.put("IMG", imageBundles);
        formatBundleList.put("FLAC", audioBundles);
        formatBundleList.put("VID", videoBundles);

        // start to read the input file
        FileReader input = new FileReader("inputFile/testInput");
        BufferedReader bufferedReader = new BufferedReader(input);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] informations = line.split(" ");
            Integer quantity = Integer.parseInt(informations[0]);
            priceCalculator(quantity, informations[1], formatBundleList);
        }
    }

    public static void priceCalculator(Integer quantity, String format,
                                       Map<String, TreeMap> formatBundleList) {
        // creat the bundles price with given formate code
        TreeMap bundlesPrice = formatBundleList.get(format);
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
