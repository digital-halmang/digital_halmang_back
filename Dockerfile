FROM krmp-d2hub-idock.9rum.cc/goorm/gradle:7.4.1-jdk17
WORKDIR /app
COPY . .
RUN gradle clean bootJar

FROM krmp-d2hub-idock.9rum.cc/goorm/openjdk:17
WORKDIR /app
COPY --from=0 /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]