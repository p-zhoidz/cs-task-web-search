package com.cushing.software.domain;

/**
 * Web search result holder. Can be extended if needed.
 * The main goal is to prevent existing "search result consumers" if any additional data
 * will be needed in future.
 *
 * @author p.zhoidz.
 */
public class SearchResult {
    private final String attributeValue;
    private final String elementText;

    /**
     * Parametrized constructor.
     *
     * @param attributeValue search result attribute value.
     * @param elementText    search result text.
     */
    public SearchResult(String attributeValue, String elementText) {
        this.attributeValue = attributeValue;
        this.elementText = elementText;
    }

    /**
     * @return Returns the value of attributeValue.
     */
    public String getAttributeValue() {
        return attributeValue;
    }

    /**
     * @return Returns the value of elementText.
     */
    public String getElementText() {
        return elementText;
    }
}
