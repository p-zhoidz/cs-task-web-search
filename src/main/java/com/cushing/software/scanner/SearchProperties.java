package com.cushing.software.scanner;

import java.util.stream.Stream;

/**
 * @author p.zhoidz.
 */
public class SearchProperties {
    private String searchUrl;
    private String elementXPath;
    private Integer maxResults;
    private String attributeXPath;

    public static Builder builder() {
        return new SearchProperties().new Builder();
    }

    /**
     * @return Returns the value of searchUrl.
     */
    public String getSearchUrl() {
        return searchUrl;
    }

    /**
     * @return Returns the value of elementXPath.
     */
    public String getElementXPath() {
        return elementXPath;
    }

    /**
     * @return Returns the value of maxResults.
     */
    public int getMaxResults() {
        return maxResults;
    }

    /**
     * @return Returns the value of attributeXPath.
     */
    public String getAttributeXPath() {
        return attributeXPath;
    }

    /**
     * {@link SearchProperties} class builder.
     */
    public class Builder {

        /**
         * Private constructor.
         */
        private Builder() {
        }

        /**
         * Sets the searchUrl.
         *
         * @param searchUrl the value to be set
         */
        public Builder setSearchUrl(String searchUrl) {
            SearchProperties.this.searchUrl = searchUrl;

            return this;
        }

        /**
         * Sets the elementXPath.
         *
         * @param elementXPath the value to be set
         */
        public Builder setElementXPath(String elementXPath) {
            SearchProperties.this.elementXPath = elementXPath;

            return this;
        }


        /**
         * Sets the maxResults.
         *
         * @param maxResults the value to be set
         */
        public Builder setMaxResults(Integer maxResults) {
            SearchProperties.this.maxResults = maxResults;

            return this;
        }

        /**
         * Sets the attributeXPath.
         *
         * @param attributeXPath the value to be set
         */
        public Builder setAttributeXPath(String attributeXPath) {
            SearchProperties.this.attributeXPath = attributeXPath;

            return this;
        }

        /**
         * Build an underlying {@link SearchProperties} instance.
         * Can throw {@link IllegalStateException} if pre-initialization validation fails.
         *
         * @return SearchProperties instance.
         */
        public SearchProperties build() {
            validate();
            return SearchProperties.this;
        }

        /**
         * Accomplish validation upon abject construction.
         */
        private void validate() {
            Stream.of(searchUrl, elementXPath, maxResults, attributeXPath)
                    .filter(obj -> obj == null)
                    .findAny()
                    .ifPresent((s) -> {
                        throw new IllegalStateException("Search properties are not initialized correctly");
                    });
        }
    }
}
