FROM openjdk:11 AS builder

COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src
RUN chmod +x ./gradlew
RUN ./gradlew clean
RUN ./gradlew bootJar --info


FROM openjdk:11

COPY --from=builder build/libs/*.jar flyway.jar
ENTRYPOINT ["java", "-jar", "/flyway.jar"]