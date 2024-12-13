# Use OpenJDK as base image
FROM openjdk:17-jdk-slim

# Set working directory inside the container
WORKDIR /app

# Copy the built JAR file into the container
COPY build/libs/javami-1.jar javami-service.jar

# Command to run the JAR file
ENTRYPOINT ["java", "-jar", "javami-service.jar"]

# Expose the port on which your Spring Boot app runs
EXPOSE 8080
