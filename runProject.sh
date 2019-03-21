#!/bin/bash

#run project without tests
mvn clean install -q -DskipTests
java -jar target/ox-0.1.jar
