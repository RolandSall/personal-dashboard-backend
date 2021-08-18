FROM openjdk:11

LABEL author="Roland Salloum"

ENV PORT=8080

VOLUME /tmp

ADD  target/todo-service.jar todo-service.jar

EXPOSE $PORT

ENTRYPOINT ["java","-jar","/todo-service.jar"]