FROM openjdk:17.0-slim AS BUILDER

RUN mkdir /app_source
COPY . /app_source

WORKDIR /app_source

RUN chmod +x ./gradlew
RUN ./gradlew :bootstrap:bootJar

FROM openjdk:17.0-slim AS RUNNER

RUN mkdir /app
COPY --from=BUILDER /app_source/bootstrap/build/libs /app

WORKDIR /app

ENV TZ=Asia/Seoul

EXPOSE 8080

ENTRYPOINT java -jar /app/*.jar
