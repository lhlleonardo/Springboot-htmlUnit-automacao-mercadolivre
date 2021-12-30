package com.br.segundafase.segundafase.schedule;

import com.br.segundafase.segundafase.service.DemandaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/*
 @Author: Leonardo Henrique Lopes
 @Date: 30/12/2021
*/

@Component
public class Schedule {

    @Autowired
    public DemandaService demandaService;

    @Scheduled(fixedDelay = 10000)
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

            if ( resultado ) System.out.println("Finalizado com sucesso...");

        }
    }
}
