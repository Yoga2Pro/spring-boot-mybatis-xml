# this is to build image for the java app
# no need of Dockerfile for redis/mysql as docker-compose use std image for them
FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/*.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
