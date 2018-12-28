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
- Scrapes data from a specific date on 03/10/2018 (random date)
### /authors
- Type - Get request
- Search available authors
### //authors/{author}/articles
- Type - Get request
- Search articles based on authors
### /articles?title=""&description=""
- Type - Get request
- Search articles by title and description

## Architecture
 - Spring boot application 
 - Searches a given url for article links(based on .ece suffix)
 - Accesses these articles, fetches Title, description and Author from these articles
 - Stores this information in H2(in-memory) database with article URL as primary key
 - The REST API calls the services accessing the database through Spring JPA
