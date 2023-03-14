FROM openjdk
COPY ./target/MINI_PROJECT-1.0-SNAPSHOT-jar-with-dependencies.jar ./
WORKDIR ./
CMD ["java", "-jar", "MINI_PROJECT-1.0-SNAPSHOT-jar-with-dependencies.jar"]