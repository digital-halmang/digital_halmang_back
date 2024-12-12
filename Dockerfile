FROM krmp-d2hub-idock.9rum.cc/goorm/gradle:7.3.1-jdk17 AS builder
WORKDIR /app
COPY . .
RUN gradle build 

FROM krmp-d2hub-idock.9rum.cc/goorm/openjdk:17
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]