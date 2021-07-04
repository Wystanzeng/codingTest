import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class FormatBundleTest {
    private FormatBundle videoBundle;
    TreeMap<Integer, Double> bundles;

    @BeforeEach
    void setUp() {
        videoBundle = new FormatBundle("Video", "VID");
        videoBundle.putBundle(3, 570.00);
        videoBundle.putBundle(5, 900.00);
        bundles = new TreeMap<>();
    }

    @Test
    void getFormat() {
        assertEquals("Video", videoBundle.getFormat());
    }

    @Test
    void getCode() {
        assertEquals("VID", videoBundle.getCode());
    }

    @Test
    void putBundle() {
        assertEquals(570.00, videoBundle.getBundles().get(3));
        assertEquals(900.00, videoBundle.getBundles().get(5));
        videoBundle.putBundle(9, 1530.00);
        assertEquals(1530.00, videoBundle.getBundles().get(9));
    }

    @Test
    void getBundles() {
        bundles.put(3, 570.00);
        bundles.put(5, 900.00);
        assertEquals(bundles, videoBundle.getBundles());
    }
}