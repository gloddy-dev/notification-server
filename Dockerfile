FROM openjdk:17.0-slim

WORKDIR build
COPY /bootstrap/build/libs/bootstrap-0.0.1-SNAPSHOT.jar app.jar

ENV TZ=Asia/Seoul

EXPOSE 8080

ENTRYPOINT java -jar app.jar
