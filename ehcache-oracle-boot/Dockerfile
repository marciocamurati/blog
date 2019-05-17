# Alpine Linux Image with JDK8
FROM openjdk:8-alpine

LABEL MAINTAINER="saikris12@gmail.com"

RUN apk update && apk add bash

COPY wait-for-it.sh wait-for-it.sh

ADD target/ehcache-boot-0.0.1-SNAPSHOT.jar /app.jar

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS  -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
