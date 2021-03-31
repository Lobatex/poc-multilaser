FROM openjdk:8-jdk-alpine
EXPOSE 8080
ENV JAR_FILE=target/mult-server-config.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT java -jar app.jar
