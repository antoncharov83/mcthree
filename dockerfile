FROM gradle:7.3.3-jdk11-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon
FROM amazoncorretto:11-alpine-jdk
MAINTAINER charov
COPY --from=build /home/gradle/src/build/libs/mcthree-0.0.1-SNAPSHOT.jar /mcthree-1.0.0.jar
ENTRYPOINT ["java","-jar","/mcthree-1.0.0.jar"]