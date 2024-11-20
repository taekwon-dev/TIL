FROM openjdk:17-alpine
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} hanghae-api.jar
ENTRYPOINT ["java","-jar","/hanghae-api.jar"]