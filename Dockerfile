FROM openjdk:latest

COPY ./out/artifacts/SimpleServer_jar/SimpleServer.jar /tmp

EXPOSE 8088

CMD ["java", "-jar", "/tmp/SimpleServer.jar"]
