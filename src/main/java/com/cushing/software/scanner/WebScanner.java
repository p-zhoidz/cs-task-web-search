package com.cushing.software.scanner;

import com.cushing.software.domain.SearchResult;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author p.zhoidz.
 */
public class WebScanner {
    private static final String USER_AGENT = "Mozilla/5.0";

    /**
     * Accomplish web search based on provided search properties.
     *
     * @param searchProperties properties to be used.
     * @return List of {@link SearchResult} objects.
     * @throws IOException standard I/O exception cases.
     */
    public List<SearchResult> search(SearchProperties searchProperties) throws IOException {

        Document doc = Jsoup.connect(searchProperties.getSearchUrl())
                .userAgent(USER_AGENT)
                .get();

        return doc.select(searchProperties.getElementXPath())
                .stream()
                .limit(searchProperties.getMaxResults())
                .map(element ->
                        new SearchResult(element.attr(searchProperties.getAttributeXPath()), element.text()))
                .collect(toList());
    }

}
