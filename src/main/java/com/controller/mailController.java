package com.controller;

import com.mailFuntions.emailFuntions;
import com.request.requestBodyMessage;
import com.response.responseSendMessage;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

@Controller("/mailController")
public class mailController {

    @Get(uri="/", produces="text/plain")
    public String index() {
        emailFuntions email = new emailFuntions();
       // email.SendMailSmtpAuthentication();
        return "Hola mundo";
    }
    @Post(value = "/sendMessageHtml", produces = MediaType.APPLICATION_JSON)
    public responseSendMessage send(requestBodyMessage RequestBodyMessage) {
        emailFuntions message = new emailFuntions();
        message.SendMailSmtpAuthentication(RequestBodyMessage.getMessageHtml());
        System.out.println(RequestBodyMessage.getMessageHtml());
        responseSendMessage response = new responseSendMessage();
        response.setResponse("envio correcto");
        return response;
    }
}