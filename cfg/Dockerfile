FROM openjdk:21-jdk-slim

ARG APP_PORT=8085
ENV APP_PORT=$APP_PORT

WORKDIR /app
COPY target/*.jar app.jar
EXPOSE $APP_PORT
ENTRYPOINT ["java", "-jar", "app.jar"]