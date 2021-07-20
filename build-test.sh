#!/bin/bash

cd backend
mvn clean install
java -jar target/TeamDProject-1.0-SNAPSHOT.jar server ../testDBconfig.yml &
cd ../frontend
npm install
npm start &
cd ../selenium
mvn clean install
