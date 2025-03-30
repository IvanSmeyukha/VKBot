FROM maven:3.8.6-eclipse-temurin-17 as builder
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY . .
RUN mvn package -DskipTests

FROM maven:3.8.6-eclipse-temurin-17
WORKDIR /app
COPY --from=builder /app/target/*.jar vk-bot-app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "vk-bot-app.jar"]