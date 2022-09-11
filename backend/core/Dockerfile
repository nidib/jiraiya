#
# Build stage
#
FROM maven:3.8.5-openjdk-17-slim AS build
WORKDIR /usr/app
COPY ./pom.xml ./pom.xml
RUN mvn dependency:go-offline -B
COPY ./src ./src
RUN mvn -f ./pom.xml clean package -Dmaven.test.skip=true

#
# Package stage
#
FROM openjdk:17.0-jdk
WORKDIR /usr/app
COPY --from=build /usr/app/target/jiraiya.jar ./jiraiya.jar
ENTRYPOINT ["java", "-jar", "./jiraiya.jar"]