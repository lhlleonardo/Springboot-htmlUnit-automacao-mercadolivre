package com.br.segundafase.segundafase.service;

import com.br.segundafase.segundafase.configs.DriverConfig;
import com.br.segundafase.segundafase.pages.MeliHome;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

import java.io.IOException;

public class MeLiService {

    WebClient webClient = new DriverConfig().chromeDriver();

    public HtmlPage mercadoLivreBuscarItem(String item) throws IOException {

        HtmlPage page = webClient.getPage(MeliHome.URL);

        HtmlInput campoBusca = page.getFirstByXPath(MeliHome.CAMPO_BUSCA_PATH);

        campoBusca.setValueAttribute(item);

        HtmlButton botaoBusca = page.getFirstByXPath(MeliHome.BOTAO_BUSCA_PATH);

        HtmlPage resultadoBusca = botaoBusca.click();

        return resultadoBusca;
    }
}
