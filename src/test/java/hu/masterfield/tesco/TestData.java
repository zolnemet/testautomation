package hu.masterfield.tesco;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestData {
    public static final Properties testData = new Properties();

    static {
        try {
            testData.load(new FileReader("src/test/resources/test_data.properties"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
