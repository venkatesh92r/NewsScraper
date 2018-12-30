# NewsScraper

## Environment Set up

### Software
  - JDK-1.8
  - Tomcat 8 web server
  - Apache Maven 

### Database configuration
  Execute the below database in the in memory db by accessing http://localhost:8080/h2/
  
        create schema NEWS_SCRAPER_DEV
  
## Deployment instructions

### Eclipse Tomcat
  - Import the project to eclipse
  - Run as Java application -> NewsScraperApplication.java
  - Application will be hosted in localhost:8080

### Tomcat
  - Run "mvn clean install" command on project folder
  - Copy the war from target folder and deploy it in tomcat.

## API Endpoints

### /scrapeArticles
- Type - Get request
- Scrapes data from a specific date on 03/10/2010 (arbitrary date)
- Mandatory call to be made after the application start-up as this call loads the data into the db
### /authors
- Type - Get request
- Search available authors
### /authors/{authorName}/articles
- Type - Get request
- Search articles based on authors
### /articles (Request parameters -> title,description)
- Type - Get request
- Search articles by title and description
- Yet to implement

## Architecture
 - Spring boot application 
 - Searches a given url for article links(based on .ece suffix)
 - Accesses these articles, fetches Title, description and Author from these articles
 - Stores this information in H2(in-memory) database with article URL as primary key
 - The REST API calls the services accessing the database through Spring JPA

## Open points
 - Calling /scrapeArticles method during start-up. Can be done by writing a StartupListener by implementing ApplicationListener.
  - Exception handling in controllers. A user defined exception should be created and the same JSON object format should be returned for all kinds of checked and unchecked exceptions.
 - Current implementation scrapes through articles only from a specific arbitrary date. As per requirements, this logic has to be changed to work with all the available dates from the archive site.
 - Compliance to robots.txt. Logic has to be updated to change to access the archive xml from robots.txt as XMLs are light weight and these article should be accessed.
 - Checking the possibility to load only the meta tags info from articles instead of the complete article.
