FROM openjdk:latest
VOLUME /tmp
ADD target/ApiPocMedHead.jar ApiPocMedHead.jar
EXPOSE 9000
ENTRYPOINT ["java", "-jar", "ApiPocMedHead.jar"]
