package com.br.segundafase.segundafase.mensagem;

import com.br.segundafase.segundafase.configs.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@RestController
public class MensagemPublisher {

    @Autowired
    private RabbitTemplate template;

    @PostMapping("/publicar")
    public String publicarMensagem(@RequestBody Mensagem mensagem) throws IOException {

        mensagem.setIdMensagem(UUID.randomUUID().toString());
        mensagem.setMessageDate(new Date());
        template.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, mensagem);

        return "Mensagem " + mensagem.getMensagem() + " enviada!";
    }
}