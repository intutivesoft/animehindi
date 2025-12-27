# Use Java 17 (required for Spring Boot 3.x)
FROM eclipse-temurin:17-jdk-alpine

# App directory
WORKDIR /app

# Copy pom & download deps (layer caching)
COPY pom.xml .
RUN apk add --no-cache maven && mvn dependency:go-offline

# Copy source
COPY src ./src

# Build the app
RUN mvn clean package -DskipTests

# Expose Render port
EXPOSE 8080

# Run the app
CMD ["java", "-jar", "target/Anime-0.0.1-SNAPSHOT.jar"]
