package com.br.segundafase.segundafase.service;

import com.br.segundafase.segundafase.pages.MeliHome;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MeLiService {

    @Autowired
    public WebClient chrome;

    public HtmlPage mercadoLivreBuscarItem(String item) throws IOException {

        HtmlPage page = chrome.getPage(MeliHome.URL);

        HtmlInput campoBusca = page.getFirstByXPath(MeliHome.CAMPO_BUSCA_PATH);

        campoBusca.setValueAttribute(item);

        HtmlButton botaoBusca = page.getFirstByXPath(MeliHome.BOTAO_BUSCA_PATH);

        HtmlPage resultadoBusca = botaoBusca.click();

        return resultadoBusca;
    }
}
