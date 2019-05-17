package org.example.csv2bean;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

public class Parser {

    private static final char separator = ';';

    public List<Bean> parse(File file) throws IOException {
        Reader reader = null;
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        try {
            fileInputStream = new FileInputStream(file);
            inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            reader = new BufferedReader(inputStreamReader);
            HeaderColumnNameMappingStrategy<Bean> ms = new HeaderColumnNameMappingStrategy<Bean>();
            ms.setType(Bean.class);
            CsvToBean<Bean> csvToBean = new CsvToBeanBuilder<Bean>(reader).withType(Bean.class).withMappingStrategy(ms)
                    .withSeparator(separator).build();

            return csvToBean.parse();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                }
            }
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                }
            }
        }
    }

}
