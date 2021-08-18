FROM openjdk:11

LABEL author="Roland Salloum"

ENV PORT=8080

VOLUME /tmp

ADD  target/rating-service.jar rating-service.jar

EXPOSE $PORT

ENTRYPOINT ["java","-jar","/rating-service.jar"]