FROM openjdk:11
ADD target/mlme-0.0.1.jar mlme-0.0.1.jar
EXPOSE 9090
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","mlme-0.0.1.jar"]