package com.example.RestTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping("/dummy")
public class AppController {

    @Autowired
    public RestTemplate rt;

    public String url="http://localhost:8080/students/";

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String getAll(){
        HttpHeaders headers =new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity entity =new HttpEntity(headers);
        return rt.exchange(url, HttpMethod.GET,entity,String.class).getBody();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String getId(@PathVariable long id){
        HttpHeaders headers =new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity entity =new HttpEntity(headers);
        return rt.exchange(url+id, HttpMethod.GET,entity,String.class).getBody();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String add(@RequestBody Dummy dummy){
        HttpHeaders headers =new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Dummy> entity =new HttpEntity<Dummy>(dummy,headers);
        return rt.exchange(url, HttpMethod.POST,entity,String.class).getBody();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String update(@PathVariable long id,@RequestBody Dummy dummy){
        HttpHeaders headers =new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Dummy> entity =new HttpEntity<Dummy>(dummy,headers);
        return rt.exchange(url+id, HttpMethod.PUT,entity,String.class).getBody();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String Delete(@PathVariable long id){
        HttpHeaders headers =new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity entity =new HttpEntity(headers);
        return rt.exchange(url+id, HttpMethod.DELETE,entity,String.class).getBody();
    }

    @Bean
    public RestTemplate demo(){
        return new RestTemplate();
    }

}
