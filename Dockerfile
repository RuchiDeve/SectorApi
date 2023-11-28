FROM maven:3.8.2-eclipse-temurin-17 AS build
COPY . .
RUN mvn clean install -DskipTests

FROM openjdk:17-jdk-slim
COPY --from=build /target/*.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]

