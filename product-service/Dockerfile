# Builder stage
FROM gradle:8.4-jdk21-alpine AS builder
WORKDIR /app
COPY . .
RUN gradle build --no-daemon -x test

# Final stage
FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=builder /app/build/libs/*0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8082
VOLUME /home/ite/media
VOLUME /keys
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "app.jar"]
