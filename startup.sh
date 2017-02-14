#!/usr/bin/env bash
mvn clean install -P h2
java -jar target/school-groups-1.0-SNAPSHOT.jar