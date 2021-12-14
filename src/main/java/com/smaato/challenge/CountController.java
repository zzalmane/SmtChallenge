package com.smaato.challenge;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.util.Logger;
import reactor.util.Loggers;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


/**
 * @author Salmane Mhamedi
 */
@SuppressWarnings( "deprecation" )
@RestController
@RequestMapping("/api/smaato")
public class CountController extends RuntimeException {


    Set<Integer> idCounter = new HashSet<>();
    final private String okResponse ="ok";
    final private String failedResponse="failed";
    private static final Logger log = Loggers.getLogger(CountController.class); // Non blocking logging



    @GetMapping(value = {"/accept/{id}","/accept/{id}/{endpoint}"})
    public Mono<String> acceptRequest(@PathVariable("id")  int id, @RequestParam(value = "endpoint") Optional<String> endpoint){


        idCounter.add(id);
        if(endpoint.isPresent()){
            try{
                WebClient webClient = WebClient.create();
                processGetRequest(webClient,endpoint.get(),idCounter.size());
                //processPostRequest(webClient,endpoint.get(),idCounter.size());
            }catch(RuntimeException ex){
                return Mono.just(failedResponse);
            }
        }
        return Mono.just(okResponse).onErrorReturn(failedResponse);

    }


    @Scheduled(fixedRate = 60000)
    public void processLogs(){
        log.info("Number of Unique Ids per minute: "+idCounter.size());
        idCounter = new HashSet<>();
    }

    public void processGetRequest(WebClient webClient, String endpoint, int counter){
        Mono<ClientResponse> response= webClient.get().uri(endpoint+"/"+counter)
                .exchange();
        response.subscribe(res -> log.info("HTTP status code of the response to: "+endpoint+" :"+ res.statusCode()));

    }
    public void processPostRequest(WebClient webClient, String endpoint, int counter){
        Mono<ClientResponse> response= webClient.post().uri(endpoint).body(Mono.just(counter), Integer.class)
                .exchange();
        response.subscribe(res -> log.info("HTTP status code of the response to: "+endpoint+" :"+ res.statusCode()));

    }


}
