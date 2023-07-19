# SPRING BOOT TEMPLATE 2

## Description
This project is the second version of my 
personal template for spring boot projects.

This template covers the most common and significant
topics for backend projects develop in spring boot.
The current covered topics are:

- Project structure and modularization
- Clean code
- Inputs validation
- Error handling
- Custom validation
- Database connection
- Unit testing
- Environment variables and profiles

## Steps to execute

1. Clone or download the repository [springboottemplate2](https://github.com/BrandonnC9898/springboottemplate2)
2. Install gradle dependencies
3. Mount the database
4. Configure environment variables
5. Run the project

## Commands for developing

- Run sonarqube validation
```
./gradlew sonar \
  -Dsonar.projectKey=springboottemplate2 \
  -Dsonar.projectName='springboottemplate2' \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.toke☺n=<token>
```

- Run project
```
./gradlew run
./gradlew bootRun
```

- Build
```
./gradlew build
./gradlew clean build
```