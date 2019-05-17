package org.example.csv2bean;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

public class ParserTest {

    @Test
    public void testUtf8() throws IOException {
        Parser parser = new Parser();
        File utf8 = new File(getClass().getResource("/csv/sample_UTF8.csv").getFile());
        List<Bean> result = parser.parse(utf8);
        assertEquals(1, result.size());
        assertEquals("first", result.get(0).getA());
    }

    @Test
    public void testUtf8Bom() throws IOException {
        Parser parser = new Parser();
        File utf8Bom = new File(getClass().getResource("/csv/sample_UTF8-BOM.csv").getFile());
        List<Bean> result = parser.parse(utf8Bom);
        assertEquals(1, result.size());
        assertEquals("first", result.get(0).getA());
    }

}
