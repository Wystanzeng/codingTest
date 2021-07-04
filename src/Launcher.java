import java.io.IOException;

/**
 * main program
 */
public class Launcher {

    public static void main(String[] args) throws IOException {
        // create price for image
        FormatBundle imageBundle = new FormatBundle("Image", "IMG");
        imageBundle.putBundle(5, 450.00);
        imageBundle.putBundle(10, 800.00);
        // create price for audio
        FormatBundle audioBundle = new FormatBundle("Audio", "FLAC");
        audioBundle.putBundle(3, 427.50);
        audioBundle.putBundle(6, 810.00);
        audioBundle.putBundle(9, 1147.50);
        // create price for video
        FormatBundle videoBundle = new FormatBundle("Video", "VID");
        videoBundle.putBundle(3, 570.00);
        videoBundle.putBundle(5, 900.00);
        videoBundle.putBundle(9, 1530.00);
        // create format list
        FormatBundleList formatBundleList = new FormatBundleList();
        formatBundleList.putFormatBundle(imageBundle);
        formatBundleList.putFormatBundle(audioBundle);
        formatBundleList.putFormatBundle(videoBundle);
        // file path
        String filePath = "inputFile/testInput";
        start(filePath, formatBundleList);
    }

    private static void start(String filePath,
                              FormatBundleList formatBundleList)
            throws IOException {
        CalculationInitializer calculationInitializer =
                new CalculationInitializer(filePath, formatBundleList);
        calculationInitializer.startCalculation();
    }
}
