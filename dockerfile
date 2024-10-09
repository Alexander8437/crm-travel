 # Use the official OpenJDK image as the base
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy all the required JAR files into the container
COPY dao-module/target/dao-module.jar /app/dao-module.jar
COPY service-module/target/service-module.jar /app/service-module.jar
COPY repo-module/target/repo-module.jar /app/repo-module.jar
COPY util-module/target/util-module.jar /app/util-module.jar
COPY controller-module/target/controller-module.jar /app/controller-module.jar
COPY jwt-config/target/jwt-config.jar /app/jwt-config.jar

# Expose the port the application will run on (change if necessary)
EXPOSE 8080

# Run the application with the correct classpath including all the JARs
# Replace com.example.MainClass with your actual main class from controller-module
ENTRYPOINT ["java", "-cp", "dao-module.jar:service-module.jar:repo-module.jar:util-module.jar:controller-module.jar:jwt-config.jar", "com.ms.jwt.CrmApplication"]
