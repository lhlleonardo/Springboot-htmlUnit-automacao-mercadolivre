package com.br.segundafase.segundafase.mensagem;

import com.br.segundafase.segundafase.service.DemandaService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MensagemListener {

    @Autowired
    private DemandaService demandaService;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void ouvir(Mensagem mensagem) throws IOException {

        System.out.println(mensagem);

        System.out.println(demandaService.retornarItemProcurado(mensagem.getMensagem()));
    }
}