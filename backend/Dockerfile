FROM eclipse-temurin:21-jre-alpine
EXPOSE 8080
WORKDIR /app
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
COPY build/libs/backend-0.0.1-SNAPSHOT.jar /app/app.jar
