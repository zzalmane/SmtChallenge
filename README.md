# Description
We neeed to developp a service with hight load, a possible solution will be to use reactive programming aproach using Webflux for Spring boot.
Then we will have a non-blocking API that can be faster with an important amount of concurrent users, the cost will also be cheaper.

With this approach we have to have in mind that all our code must be non-blocking, including logging.

# Extension 1

A call for the POST request was implemennted, you can comment/uncomment one of the lines in CountController.java

```
processGetRequest(webClient,endpoint.get(),idCounter.size());

//processPostRequest(webClient,endpoint.get(),idCounter.size());
```

# Extension 2

This point is complicated without a centralized logging solution like EFK or ELK, with a load balancer we will not be able to process the request inside the service and make that the deduplication works, instead of that we can use Fluentd or Logstash and then export the result to ElasticSerch, it's a possible solution that I can't implement for the challenge, it's complicated and may need more time and dedication. 

# Extension 1
