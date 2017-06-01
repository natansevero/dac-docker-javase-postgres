FROM openjdk:8-jdk-alpine
COPY target/dac-aula-1.0-jar-with-dependencies.jar dac-aula-1.0-jar-with-dependencies.jar 
ENTRYPOINT java -jar dac-aula-1.0-jar-with-dependencies.jar  
