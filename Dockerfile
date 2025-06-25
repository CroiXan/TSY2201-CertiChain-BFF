FROM openjdk:21-jdk

WORKDIR /app

COPY target/bff-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8082

CMD ["java", "-jar", "app.jar"]