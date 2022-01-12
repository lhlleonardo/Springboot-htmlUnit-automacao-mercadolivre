FROM openjdk:11
MAINTAINER Leonardo Henrique Lopes
EXPOSE 8080
ADD target/app-terceira-fase.jar app-terceira-fase.jar
# ENTRYPOINT ["java","-jar","/app-terceira-fase.jar"]