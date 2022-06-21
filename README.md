# Spring Boot ScoreKeep Application
### spring-scorekeep

A Scorekeeper application written in Spring Boot for web access of scores from tabletop games. 
Technologies used in this Application

#### Language: Java 11

### Technologies used in this application: 

#### Application Framework Technologies: 
- Spring Boot 2.5.4
- Apache Maven 

#### Database Technologies
- Docker Desktop 
- (On the desktop) PostgresQL 14.3 (latest) running on Docker. 
- Redgate Flyway Community 7.7.3

Currently: 
This application contains a viewer at endpoint "/" that shows the list of all scores logged in the database "jonnyscorekeep". 

This application when complete will keep a table of scores earned in tabletop games. 
Supported Applications
We support the games of "Scrabble", and "Pounce". Soon we will support the game "Spades". 

## Configuration and Running 

An out of the box command that can be used to download and run a docker database environment that will run compatible with this image is provided below with a few instructions.

- Create a space to host a docker volume on your hard drive, I created a directory at this path on my machine "C:\Users\<my_username>\srv\pg3"
- run this command

```docker run --name java-postgres -e POSTGRES_PASSWORD=password -d -v "C:\Users\<username>\srv\pg3":/var/lib/postgresql/data -p 5432:5432 postgres```

- Clone this project and then run spring boot at the root where your pom.xml resides. 

```mvn spring-boot:run``` 

I'm running this command on Windows. Once you have this, all the settings in the configuration of the spring boot project should run to connect to this database, and start this application to be served on a page you can get to from your browser

- Navigate to ```http://localhost:8080``` to see a sample scores page.

Here is how it looks: 
