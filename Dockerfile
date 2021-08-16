FROM anapsix/alpine-java:latest 
COPY target/customer-0.0.1-SNAPSHOT.jar app.jar 
EXPOSE 9742 
ENTRYPOINT java -jar ./app.jar