# TeamDProject [![Build Status](https://travis-ci.com/shibuzgeorge/TeamDProject.svg?token=JPwaVvxXZez87HNoYyEe&branch=main)](https://travis-ci.com/shibuzgeorge/TeamDProject)

## Project Structure

### Backend

The backend uses Dropwizard and Java.

Dropwizard is a Java framework for developing ops-friendly, high-performance, RESTful web services. Basic Authentication is used for this application and you must login to access API routes.
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

All API routes are protected except for `/api/login`. You must log in using user credentials to access the API routes. 

There are 2 users in the `User` database with different roles => `Admin` or `Employee`. Example user credentials you can use is available in the `DatabaseSetup.sql` file. You can insert your own user with a `username`, `password` and `role`. The passwords are hashed and salted using BCrypt, read more [here](https://www.mindrot.org/projects/jBCrypt/). 

If you want to protect an API for a certain role e.g. Admin you can use this annotation => `@RolesAllowed({ "Admin" })` to the method.

#### API Documentation

API documentation is provided for every single API route listed below.
The documentation contains the URL, HTTP verb, parameters, responses and the expected payload

Finding the API documentation:

1. Run the WebApplication
2. Go to localhost:8080/swagger

All the APIs are then displayed, click on each one to display each individual route

At the bottom of the page, there is a models section - this contains the expected format of every API route (the data expected)

API Routes available:
* User:
  * http://localhost:8080/api/login (POST)
  * http://localhost:8080/api/user/getUsers (GET)
* Role:
  * http://localhost:8080/api/role/getRoles (GET)
  * http://localhost:8080/api/role/{roleID} (GET)
  * http://localhost:8080/api/roleFromCapability/{capability} (GET)
* Responsibility:
  * http://localhost:8080/api/responsibility/getResponsibilityByID/{roleID} (GET)
* Capability:
  * http://localhost:8080/api/capability/getCapabilityLeads (GET)
  * http://localhost:8080/api/capability/{capability} (GET)
  * http://localhost:8080/api/capability/getCapability (GET)
* Employee:    
  * http://localhost:8080/api/employee/getEmployees (GET)
* Band:    
  * http://localhost:8080/api/band/getBands (GET)
* Competency
  * http://localhost:8080/api/competency/getCompetencyByBand/{bandID} (GET)
  * http://localhost:8080/api/competency/{competencyID} (GET)
  * http://localhost:8080/api/competency/getCompetencies (GET)

* Training
  * http://localhost:8080/api/training/getTrainings (GET)
  * http://localhost:8080/api/training/getTrainingByBand/{bandID} (GET)
* Job Family
  * http://localhost:8080/api/jobFamily/getJobFamily (GET)
  * http://localhost:8080/api/jobFamilyFromCapability/{capability} (GET)
  * http://localhost:8080/api/newJobFamily (GET)
  * http://localhost:8080/api/editJobFamily/1 (PUT)
  * http://localhost:8080/api/newJobFamily (POST)

### Frontend

The front end is handled by Node.js and Nunjunks.

Node. js is a JavaScript runtime built on Chrome's V8 JavaScript engine. Node. js uses an event-driven, non-blocking I/O model that makes it lightweight and efficient.  Nunjucks is a full featured templating engine for javascript.

Data is provided by the API layer and passed down to the HTML templates to be rendered to the page.

Login credentials are required once you started the project which should be in your `User` database. Middleware is used to prevent a user from accessing a page they do not have access to. E.g. if you want to protect a route for only Admins you can add this to your route parameters => `permit('Admin')`. For multiple roles you can comma separate => `permit('Admin', 'Employee')` 

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
