FROM openjdk:11

# Install maven
RUN apt-get update
RUN apt-get install -y maven

WORKDIR /dep

ADD bd1-todo/pom.xml /dep/pom.xml
RUN ["mvn", "dependency:resolve"]
RUN ["mvn", "verify"]

# Adding source, compile and package into a fat jar
ADD bd1-todo/src /dep/src
RUN ["mvn", "install"]



WORKDIR /code

# Prepare by downloading dependencies
ADD bd1-todo-api/pom.xml /code/pom.xml
RUN ["mvn", "dependency:resolve"]
RUN ["mvn", "verify"]

# Adding source, compile and package into a fat jar
ADD bd1-todo-api/src /code/src
RUN ["mvn", "package"]

EXPOSE 4567
CMD ["java", "-jar", "target/todo-api-jar-with-dependencies.jar"]
