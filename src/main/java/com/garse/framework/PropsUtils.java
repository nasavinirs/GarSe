package com.garse.framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/***
 * 
 * @author srinivasans
 *
 */
public class PropsUtils {
    private static String CONFIG_FILE = "src/main/resources/config.properties";
    private static InputStream in = null;
    private static Properties properties = null;

    /***
     * This method reads single property from the properfies file.
     * @param key
     * @return returns the read property
     */
    public static String getProperty(String key) {
        try {
            in = new FileInputStream(CONFIG_FILE);
            properties = new Properties();
            properties.load(in);

            return properties.getProperty(key);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return key;
    }
}

