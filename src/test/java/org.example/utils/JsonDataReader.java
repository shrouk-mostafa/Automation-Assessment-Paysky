package org.example.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JsonDataReader {

    private static final String FILE_PATH = "src/test/resources/testData/checkoutData.json";

    public static List<Map<String, String>> getCheckoutData() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Map<String, List<Map<String, String>>> data = mapper.readValue(new File(FILE_PATH), Map.class);
            return data.get("checkoutData");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read test data from JSON file.");
        }
    }
}

