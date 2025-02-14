# Use the official Tomcat image from Docker Hub
FROM tomcat:9.0

# Remove the default web apps to avoid conflict
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy the WAR file to Tomcat's webapps directory
COPY target/employee-api-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/api.war

# Expose Tomcat port
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
