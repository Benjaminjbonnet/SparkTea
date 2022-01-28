FROM java:8-jdk-alpine

COPY /target/CaramelApple-2.6.2.jar /userrest.jar

CMD ["java","-jar","userrest.jar"]