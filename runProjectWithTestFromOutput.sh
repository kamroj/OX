#!/bin/bash

if [ "$#" == 1 ]; then
mvn clean install -q -DskipTests

java -jar target/ox-0.1.jar $1


else
echo Please pass one argument!
fi
