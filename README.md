# Web Search App

## Prerequisites:
To build the application locally you will need:
- JDK 8
- maven version 3.1 or higher

## Configuration
Search engine can be configured through the configuration.properties file.
By default, it has the following configuration:
- base.url=https://www.google.com/search  - Base URL of the engine.
- result.xpath=h3.r > a                   - Since we are getting plain HTML in the response, this specifies xPath to the required element
- results=1                               - Number of results to output. Pagination is not supported, so you can see less results then you've specified.
- query.param.name=q                      - Search query param name.
- element.url.xpath=href                  - Element to output for the element specified by "result.xpath".

When changing configuration, please make sure that all setting are consistent for the specific search engine.


## Building
Clone this repo and run the following command:
```
mvn clean install
```

## Running
1. Find executable jar file. (By default should be in the local maven repository.
    For instance: ~/.m2/repository/com/cushing/software/tasks/web-search/0.0.1-SNAPSHOT)

2. Run the following: java -jar web-search-{VERSION}.jar
