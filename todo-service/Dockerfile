FROM openjdk:11
VOLUME /tmp
ADD  target/todo-service.jar todo-service.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/todo-service.jar"]