# TeamDProject

## Project Structure

### Backend

The backend uses Dropwizard and Java.

Dropwizard is a Java framework for developing ops-friendly, high-performance, RESTful web services

#### Database connection

Database Management System: `MySQL`

Host: `academy2020.cpc8rvmbbd9k.eu-west-2.rds.amazonaws.com`

To connect to the database you'll need to add a `config.yml` file to the project's home directory using this structure:

```
# Database settings.
database:
  # the name of your JDBC driver
  driverClass: com.mysql.cj.jdbc.Driver

  # the username
  user: *******

  # the password
  password: ********

  # the JDBC URL
  url: jdbc:mysql://HOST_NAME/DATABASE_NAME
```

You'll need to create a database name and populate the data by using the script `DatabaseSetup.sql`

### API Layer

Dropwizard is used to perform GET, POST, PUT and DELETE requests. The `Resource` includes all the API path and methods to get data.
The `DAO` interface includes all the SQL queries and this is mapped to the `Mapper` to output the result set from the database.

API Route available:
* http://localhost:8080/api/role/getRoles
* http://localhost:8080/api/role/{roleID}
* http://localhost:8080/api/responsibility/getResponsibilityByID/{roleID}
* http://localhost:8080/api/capability/getCapabilityLeads
* http://localhost:8080/api/employee/getEmployees
* http://localhost:8080/api/band/getBands
* http://localhost:8080/api/competency/getCompetencyByBand/{bandID}
* 

### Frontend

The front end is handled by Node.js and Nunjunks.

Node. js is a JavaScript runtime built on Chrome's V8 JavaScript engine. Node. js uses an event-driven, non-blocking I/O model that makes it lightweight and efficient.  Nunjucks is a full featured templating engine for javascript.

Data is provided by the API layer and passed down to the HTML templates to be rendered to the page.

### Selenium 

Selenium is a automated testing framework used to validate web applications across different browsers and platforms.
Selenium is used to test the UI elements of our frontend.

## Run Application

### Frontend

#### How to start the application
1. `cd frontend`
1. Run `npm install` to build your application
2. Start application with `npm start`
3. To check that your application is running enter url `http://localhost:3000`

##### Run test

1. Run `npm test`

### Backend

#### How to start the application
1. Change directory `cd backend`
2. Run `mvn clean install` to build your application
3. Start application with `java -jar target/TeamDProject-1.0-SNAPSHOT.jar server ../config.yml`
4. To check that your application is running enter url `http://localhost:8080`

##### Run test

1. Run `mvn test -B`

### Selenium

#### How to start the application
1. Change directory `cd selenium`
2. Run `mvn clean install` to build your application
3. Make sure you have both the front end and back end application running

##### Run test

1. Run `mvn test -B`
