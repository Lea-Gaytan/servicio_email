/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.request;

import javax.validation.constraints.NotBlank;

public class requestBodyMessage {
    @NotBlank
    String messageHtml;

    public String getMessageHtml() {
        return messageHtml;
    }

    public void setMessageHtml(String messageHtml) {
        this.messageHtml = messageHtml;
    }
    
    
    
}
