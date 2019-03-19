#!/bin/bash

#run project without tests
mvn clean install -q -DskipTests
cd target
java -cp *.jar kamil.rojek.ox.AppMain
