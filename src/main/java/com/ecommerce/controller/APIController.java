package com.ecommerce.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by oa on 6/19/2019.
 */

@RestController
public class APIController
{
    @RequestMapping(method = RequestMethod.GET,value = "/meet/{name}")
    public String meetings(@PathVariable String name) {
        return "Hello"
                + name;
    }

    @RequestMapping(method = RequestMethod.POST,value = "/meet/{name}")
    public String meeting(@PathVariable String name) {
        return "Hello"
                + name;
    }




    @RequestMapping(method = RequestMethod.GET,value="/greets/{name}" )
public String greetings(@PathVariable String name)
{
 return "Hello "+name;
}





    @RequestMapping(method = RequestMethod.GET,value="/hello")
    public String sayHello()
    {

        return "hello";
    }



}
