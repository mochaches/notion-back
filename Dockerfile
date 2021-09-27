FROM openjdk:11-jdk-slim

ENV APP_HOME="app"
ENV APP_JAR="notion-back-app.jar"
ENV JAVA_OPTS=""

COPY notion-back-app/target/notion-back-app-*.jar ${APP_HOME}/${APP_JAR}

ENTRYPOINT java $JAVA_OPTS -jar ${APP_HOME}/${APP_JAR}
