package com.example.MysqlAndLanbdaAndError;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/agency")
public class AgencyController {

    @Autowired
    public AgencyDao ad;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Agency> getAll(){
        return ad.findAll().stream().map(a->{
           return new Agency(a.id,a.name,a.city);
        }).collect(Collectors.toList());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Agency getId(@PathVariable long id) throws CustException{
        //return ad.findById(id).get();
        return ad.findAll().stream().filter(a->a.id==id).findFirst()
                .map(a->{return new Agency(a.id,a.name,a.city);})
                .orElseThrow(() -> new CustException(id));


        //return ad.findById(id).orElseThrow(() -> new CustException(id));
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public void add(@Valid @RequestBody Agency agency){
        ad.findAll().stream().filter(a->a.id==agency.id).findFirst()
                .ifPresent(a->{
                    ad.save(agency);
                });
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public Agency update(@PathVariable long id,@RequestBody Agency agency){
        //return ad.findAll().stream().filter(a->a.id==agency.id).findFirst()
        return ad.findById(id)
          .map(a->{
            a.setName(agency.name);
            a.setCity(agency.city);
            return ad.save(a);
        }).orElseGet(()->{
            agency.setId(id);
            return ad.save(agency);
         });

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id){
        ad.deleteById(id);
    }

    /*@ControllerAdvice
    public static class MyAdv{

        @ExceptionHandler(CustException.class)
        public String myerror(){
            return "myerror";
        }

    }*/

}
