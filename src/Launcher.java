import java.io.IOException;

/**
 * main program
 */
public class Launcher {

    public static void main(String[] args) throws IOException {
        // create price for image
        formatBundle imageBundle = new formatBundle("Image", "IMG");
        imageBundle.putBundle(5, 450.00);
        imageBundle.putBundle(10, 800.00);
        // create price for audio
        formatBundle audioBundle = new formatBundle("Audio", "FLAC");
        audioBundle.putBundle(3, 427.50);
        audioBundle.putBundle(6, 810.00);
        audioBundle.putBundle(9, 1147.50);
        // create price for video
        formatBundle videoBundle = new formatBundle("Video", "VID");
        videoBundle.putBundle(3, 570.00);
        videoBundle.putBundle(5, 900.00);
        videoBundle.putBundle(9, 1530.00);
        // create format list
        formatBundleList formatBundleList = new formatBundleList();
        formatBundleList.putFormatBundle(imageBundle);
        formatBundleList.putFormatBundle(audioBundle);
        formatBundleList.putFormatBundle(videoBundle);
        // file path
        String filePath = "inputFile/testInput";
        start(filePath, formatBundleList);
    }

    private static void start(String filePath,
                              formatBundleList formatBundleList)
            throws IOException {
        calculationInitializer calculationInitializer =
                new calculationInitializer(filePath, formatBundleList);
        calculationInitializer.startCalculation();
    }
}
