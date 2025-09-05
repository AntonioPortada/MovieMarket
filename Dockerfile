#Etapa 1: Build con gradle 8.14.3 y jdk 21 (compilacion)
FROM gradle:8.14.3-jdk-21-and-24-alpine AS build
COPY --chown=gradle:gradle . /app
WORKDIR /app
RUN gradle bootJar --no-daemon

#Etapa 2: Runtime con JDK 21 (ejecucion)
FROM zulu-openjdk:21-latest
WORKDIR /app
COPY --from=build /app/build/libs/*.jar movie_market.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "movie_market.jar"]