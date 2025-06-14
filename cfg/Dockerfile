FROM openjdk:21-jdk-slim
WORKDIR /app
COPY target/*.jar app.jar
EXPOSE ${env.PORT}
ENTRYPOINT ["java", "-jar", "app.jar"]