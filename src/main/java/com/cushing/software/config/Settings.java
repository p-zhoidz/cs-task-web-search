package com.cushing.software.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Application configuration settings.
 *
 * @author p.zhoidz.
 */
public final class Settings {
    private static final String CONFIGURATION_FILE = "configuration.properties";
    private static final String BASE_URL_PROP = "base.url";
    private static final String XPATH_PROP = "result.xpath";
    private static final String RESULTS_PROP = "results";
    private static final String QUERY_PARAM_PROP = "query.param.name";
    private static final String ELEMENT_URL_PROP = "element.url.xpath";

    private static final String BASE_URL_DEFAULT = "https://www.google.com/search";
    private static final String XPATH_DEFAULT = "h3.r > a";
    private static final String RESULTS_DEFAULT = "1";
    private static final String QUERY_PARAM_DEFAULT = "q";
    private static final String ELEMENT_URL_DEFAULT = "href";

    private final String baseUrl;
    private final String xPath;
    private final int results;
    private final String queryParam;
    private final String elementUrlXPath;

    /**
     * Private constructor.
     * When object is created, all the properties are being initialized.
     */
    private Settings() {
        InputStream input = getClass().getClassLoader().getResourceAsStream(CONFIGURATION_FILE);

        Properties prop = new Properties();
        try {
            prop.load(input);
        } catch (IOException e) {
            throw new IllegalStateException(String.format(
                    "Properties file can not be initialized. "
                            + "Please make sure %s exists.", CONFIGURATION_FILE));
        }

        this.baseUrl = prop.getProperty(BASE_URL_PROP, BASE_URL_DEFAULT);
        this.xPath = prop.getProperty(XPATH_PROP, XPATH_DEFAULT);
        this.results = Integer.valueOf(prop.getProperty(RESULTS_PROP, RESULTS_DEFAULT));
        this.queryParam = prop.getProperty(QUERY_PARAM_PROP, QUERY_PARAM_DEFAULT);
        this.elementUrlXPath = prop.getProperty(ELEMENT_URL_PROP, ELEMENT_URL_DEFAULT);
    }

    /**
     * @return Returns the value of baseUrl.
     */
    public String getBaseUrl() {
        return baseUrl;
    }

    /**
     * @return Returns the value of xPath.
     */
    public String getxPath() {
        return xPath;
    }

    /**
     * @return Returns the value of results.
     */
    public int getResults() {
        return results;
    }

    /**
     * @return Returns the value of queryParam.
     */
    public String getQueryParam() {
        return queryParam;
    }

    /**
     * @return Returns the value of elementUrlXPath.
     */
    public String getElementUrlXPath() {
        return elementUrlXPath;
    }

    /**
     * {@link Settings} singleton instance holder.
     */
    public static class SettingsHolder {
        public static final Settings HOLDER_INSTANCE = new Settings();
    }
}
