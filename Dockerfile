FROM adoptopenjdk/openjdk8:alpine-jre
#ADD target/university-0.0.1-SNAPSHOT.jar app.jar
ADD university-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]