package com.desafio.banco.contaservice.messages;

import com.desafio.banco.contaservice.dto.UserDTO;
import com.desafio.banco.contaservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class MessageListener {

    @Autowired
    private AccountService accountService;

    @StreamListener(Sink.INPUT)
    public void readMessage(UserDTO user) {
        accountService.createAccountToUser(user);
    }

}
