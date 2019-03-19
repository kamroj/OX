#!/bin/bash

#run project with tests
mvn clean install -q
cd target
java -cp *.jar kamil.rojek.ox.AppMain
