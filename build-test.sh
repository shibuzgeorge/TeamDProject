#!/bin/bash

cd backend
mvn clean install
mvn test -B
java -jar target/TeamDProject-1.0-SNAPSHOT.jar server config.yml &
cd ../frontend
npm install
npm start &
cd ../selenium
mvn clean install
mvn test -B
