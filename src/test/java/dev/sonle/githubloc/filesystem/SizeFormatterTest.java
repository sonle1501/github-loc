package dev.sonle.githubloc.filesystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SizeFormatterTest {

    private SizeFormatter formatter;

    @BeforeEach
    void setUp() {
        formatter = new SizeFormatter();
    }

    @Test
    void testConvertSizeNegative() {
        assertEquals("undefined", formatter.convertSize(-5));
        assertEquals("undefined", formatter.convertSize(-1));
    }

    @Test
    void testConvertSizeLessThan100KB() {
        // Less than 100 * 1024 = 102400 bytes
        assertEquals("0.00 KB", formatter.convertSize(0));
        assertEquals("1.00 KB", formatter.convertSize(1024));
        assertEquals("99.99 KB", formatter.convertSize(102390));
    }

    @Test
    void testConvertSizeMB() {
        // Between 100KB and 1GB
        assertEquals("0.10 MB", formatter.convertSize(102400));
        assertEquals("1.00 MB", formatter.convertSize(1048576));
        assertEquals("500.00 MB", formatter.convertSize(524288000));
        assertEquals("1023.99 MB", formatter.convertSize(1073731800)); // slightly less than 1GB
    }

    @Test
    void testConvertSizeGB() {
        // >= 1GB (1073741824 bytes)
        assertEquals("1.00 GB", formatter.convertSize(1073741824L));
        assertEquals("2.50 GB", formatter.convertSize(2684354560L));
    }
}
