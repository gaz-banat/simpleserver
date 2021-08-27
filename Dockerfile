FROM openjdk:latest

COPY ./SimpleServer.jar /tmp

EXPOSE 80

CMD ["java", "-jar", "/tmp/SimpleServer.jar"]
