FROM openjdk:latest

COPY ./out/artifacts/SimpleServer_jar/SimpleServer.jar /tmp

EXPOSE 80

CMD ["java", "-jar", "/tmp/SimpleServer.jar"]
