package com.academy.atilla;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class SpringAssignmentTwo {

    @RequestMapping(value = "/fb/{number}")
    public String FizzBussEndpoint(@PathVariable("number") int inputNumber)
    {
        String toReturnString = "";

        if(inputNumber % 3 == 0)
        {
            toReturnString += "Fizz";
        }

        if(inputNumber % 5 == 0)
        {
            toReturnString += "Buzz";
        }

        if(toReturnString.isEmpty())
        {
            return String.valueOf(inputNumber);
        }
        else
        {
            return toReturnString;
        }
    }
}
