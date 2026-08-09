package com.automation.utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.openqa.selenium.By;
import java.io.FileReader;

public class JsonLocatorReader {
    private JsonObject jsonObject;

    // Constructor loads the specific JSON file for a page
    public JsonLocatorReader(String filePath) {
        try {
            FileReader reader = new FileReader(filePath);
            this.jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
        } catch (Exception e) {
            throw new RuntimeException("Failed to read JSON locator file at: " + filePath, e);
        }
    }

    // Converts JSON properties into Selenium 'By' locators dynamically
    public By getLocator(String locatorKey) {
        if (!jsonObject.has(locatorKey)) {
            throw new RuntimeException("Locator key '" + locatorKey + "' not found in JSON file.");
        }

        JsonObject locatorDetails = jsonObject.getAsJsonObject(locatorKey);
        String type = locatorDetails.get("type").getAsString().toLowerCase();
        String value = locatorDetails.get("value").getAsString();

        switch (type) {
            case "id": return By.id(value);
            case "name": return By.name(value);
            case "xpath": return By.xpath(value);
            case "css": return By.cssSelector(value);
            case "classname": return By.className(value);
            case "linktext": return By.linkText(value);
            default: throw new IllegalArgumentException("Invalid locator type specified: " + type);
        }
    }
}
