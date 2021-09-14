FROM openjdk:11

COPY ./target/scss-application.jar scss-application.jar

ENTRYPOINT ["java","-jar","/scss-application.jar"]