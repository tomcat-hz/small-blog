FROM  openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/blog-0.0.1-SNAPSHOT.jar blog.jar
ENTRYPOINT ["java","-jar","blog.jar"]
