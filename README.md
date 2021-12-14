# Description
We neeed to developp a service with hight load, a possible solution will be to use reactive programming aproach using Webflux for Spring boot.
Then we will have a non-blocking API that can be faster with an important amount of concurrent users, the cost will also be cheaper.

With this approach we have to have in mind that all our code must be non-blocking, including logging.

## Running the App

#### Running from an IDE
You can run a Spring Boot application from your IDE as a simple Java application, however, first you will need to import your project. Import steps will vary depending on your IDE and build system.

After importing the project you can go to the "src/main/java/com/smaato/challenge/SmaatoDemoApplication" java class and run it.
##### Running as a packaged application
Create an executable jar with Maven (mvn clean install) and run the application :

$ java -jar jar/SmaatoDemo-1.0.jar (the jar is inside the jar folder)
##### Using Maven plugin
The Spring Boot Maven plugin includes a run goal which can be used to quickly compile and run your application.

$ mvn spring-boot:run

# Extension 1

A call for the POST request was implemennted, you can comment/uncomment one of the lines in CountController.java

```
processGetRequest(webClient,endpoint.get(),idCounter.size());

//processPostRequest(webClient,endpoint.get(),idCounter.size());
```

# Extension 2

This point is complicated without a centralized logging solution like EFK or ELK, with a load balancer we will not be able to process the request inside the service and make that the deduplication works, instead of that we can use Fluentd or Logstash and then export the result to ElasticSerch, it's a possible solution that I can't implement for the challenge, it's complicated and may need more time and dedication. 

# Extension 1

The point is not clear, if the idea is to publish the count to a streaming service or messaging system? we can use Spring Cloud Stream and then and then send the message to a topic in Kafck or RabbitMQ.

There are different approaches that can be specified depending on the real needs.

