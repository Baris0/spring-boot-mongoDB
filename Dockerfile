FROM adoptopenjdk/openjdk15
EXPOSE 8080
ARG JAR_FILE=target/demo-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} spring-boot-mongoDB.jar
ENTRYPOINT ["java", "-jar", "/spring-boot-mongoDB.jar"]