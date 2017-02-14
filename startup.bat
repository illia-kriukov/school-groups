@echo on
call mvn clean install -P h2
call java -jar target/school-groups-1.0-SNAPSHOT.jar
pause