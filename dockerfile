 # Start with a Maven base image
FROM maven:3.8.5-openjdk-11 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the parent pom.xml
COPY pom.xml .

# Copy module poms
COPY dao-module/pom.xml ./dao-module/
COPY service-module/pom.xml ./service-module/
COPY repo-module/pom.xml ./repo-module/
COPY util-module/pom.xml ./util-module/
COPY controller-module/pom.xml ./controller-module/
COPY jwt-config/pom.xml ./jwt-config/

# Copy the entire multi-module project into the container
COPY . .

# Download dependencies
RUN mvn dependency:go-offline

# Build the project
RUN mvn clean package

# Create a new stage for the runtime environment
FROM openjdk:11

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/my-app-1.0-SNAPSHOT.jar .

# Expose the port
EXPOSE 8080

# Run the command
CMD ["java", "-jar", "my-app-1.0-
