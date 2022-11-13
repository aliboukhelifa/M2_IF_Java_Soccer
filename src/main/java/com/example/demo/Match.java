package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Match {

    public static void goalsNumber(){
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<Object> response = 
    restTemplate.getForEntity("https://jsonmock.hackerrank.com/api/football_matches?year=2011&team2=Barcelona&page=1",Object.class);
    System.out.println(response);

    }
    
    public static void main(String[] args) {
        goalsNumber();
        
    }
}