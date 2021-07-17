FROM openjdk:11
VOLUME /tmp
ADD  target/personal-dashboard.jar personal-dashboard.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/personal-dashboard.jar"]