FROM openjdk:8
EXPOSE 3975
ADD target/docker-stock-exchange.jar docker-stock-exchange.jar
ENTRYPOINT ["java","-jar","/docker-stock-exchange.jar"]
