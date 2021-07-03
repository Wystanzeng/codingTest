import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * the calculation initializer
 */
public class calculationInitializer {

    // file path
    String filePath;

    // format bundle list for the company
    formatBundleList formatBundleList;

    // bundle calculator
    bundleCalculator bundleCalculator;

    public calculationInitializer(String filePath, formatBundleList formatBundleList) {
        this.filePath = filePath;
        this.formatBundleList = formatBundleList;
        this.bundleCalculator = new bundleCalculator();
    }

    public void startCalculation() throws IOException {
        // start to read the input file
        FileReader input = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(input);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] informations = line.split(" ");
            Integer quantity = Integer.parseInt(informations[0]);
            bundleCalculator.priceCalculator(quantity, informations[1],
                    formatBundleList.getFormatBundleList());
        }
    }
}
