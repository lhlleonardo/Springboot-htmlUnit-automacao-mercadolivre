package com.br.segundafase.segundafase.schedule;

import com.br.segundafase.segundafase.service.DemandaService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/*
 @Author: Leonardo Henrique Lopes
 @Date: 30/12/2021
*/

//@Component
public class Schedule {

    /*
    @Autowired
    public DemandaService demandaService;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    @Scheduled(fixedDelay = 1000)
    public void iniciar(){

        boolean resultado = true;

        System.out.println("Iniciando...");

        try {

            System.out.println(demandaService.retornarItemProcurado("Kindle"));

        } catch (Exception e) {

            resultado = false;

            System.out.println("Falha...");

            e.printStackTrace();

        } finally {

            System.out.println("O processo está sendo finalizado...");

        }
    }
    */
}
