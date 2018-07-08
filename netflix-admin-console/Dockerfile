FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/netflix-admin-console-1.0-SNAPSHOT.jar service.jar
RUN sh -c 'touch /service.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /service.jar" ]
