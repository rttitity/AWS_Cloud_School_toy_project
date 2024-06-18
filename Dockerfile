FROM openjdk:17
WORKDIR /app
ADD build/libs/*-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
