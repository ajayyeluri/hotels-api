FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/hotel-api.war app.jar
EXPOSE 8090 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]