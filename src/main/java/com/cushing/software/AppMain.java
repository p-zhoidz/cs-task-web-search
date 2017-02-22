package com.cushing.software;

import com.cushing.software.config.Settings;
import com.cushing.software.domain.SearchResult;
import com.cushing.software.scanner.SearchProperties;
import com.cushing.software.scanner.WebScanner;

import java.util.List;
import java.util.Scanner;

/**
 * @author p.zhoidz.
 */
public class AppMain {

    /**
     * Application main entry point.
     *
     * @param args entry point arguments.
     *             Skipped in terms of current implementations
     */
    public static void main(String... args) {

        try (Scanner scanner = new Scanner(System.in)) {
            Settings settings = Settings.SettingsHolder.HOLDER_INSTANCE;

            System.out.println("Please, enter the search string:");
            String searchTerm = scanner.nextLine();

            String searchURL = new StringBuilder(settings.getBaseUrl())
                    .append("?")
                    .append(settings.getQueryParam())
                    .append("=")
                    .append(searchTerm)
                    .toString();

            SearchProperties properties = SearchProperties.builder()
                    .setAttributeXPath(settings.getElementUrlXPath())
                    .setElementXPath(settings.getxPath())
                    .setMaxResults(settings.getResults())
                    .setSearchUrl(searchURL)
                    .build();

            WebScanner webScanner = new WebScanner();
            List<SearchResult> results = webScanner.search(properties);

            results.stream()
                    .map(sr -> String.format("URL: %s TEXT: %s", sr.getAttributeValue(), (sr.getElementText())))
                    .forEach(System.out::println);


        } catch (Throwable exception) {
            System.out.println("An exception has occurred. Message:");
            System.out.println(exception.getMessage());
        }
    }
}