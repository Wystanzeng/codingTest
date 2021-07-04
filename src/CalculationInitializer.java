import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * the calculation initializer
 */
public class CalculationInitializer {

    // file path
    private String filePath;

    // format bundle list for the company
    private FormatBundleList formatBundleList;

    // bundle calculator
    private BundleCalculator bundleCalculator;

    public CalculationInitializer(String filePath, FormatBundleList formatBundleList) {
        this.filePath = filePath;
        this.formatBundleList = formatBundleList;
        this.bundleCalculator = new BundleCalculator();
    }

    public void startCalculation() throws IOException {
        // start to read the input file
        FileReader input = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(input);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] informations = line.split(" ");
            // quantity for the order
            Integer quantity = Integer.parseInt(informations[0]);
            // format for the order
            String format = informations[1];
            // bundle detail for the given format
            FormatBundle formatBundle =
                    formatBundleList.getFormatBundleList().get(format);
            // creat the order
            Order order = new Order(format, quantity);
            // creat the orderDetail
            OrderDetail
                    orderDetail = new OrderDetail(order, formatBundle);
            bundleCalculator.priceCalculator(orderDetail);
        }
    }
}
