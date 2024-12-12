# Build stage
FROM krmp-d2hub-idock.9rum.cc/goorm/gradle:7.4.1-jdk17 as build
WORKDIR /app
COPY . .
RUN gradle clean bootJar

# Run stage
FROM krmp-d2hub-idock.9rum.cc/goorm/openjdk:17
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]