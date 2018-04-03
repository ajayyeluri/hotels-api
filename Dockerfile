FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/integration-api.war app.war
EXPOSE 8090 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.war"]