package com.br.segundafase.segundafase.service;

import com.br.segundafase.segundafase.configs.DriverConfig;
import com.br.segundafase.segundafase.pages.MeliHome;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

import java.io.IOException;

public class MeLiService {

    WebClient webClient = new DriverConfig().chromeDriver();

    MeliHome meliHome = new MeliHome();

    public HtmlPage mercadoLivreBuscarItem(String item) throws IOException {

        HtmlPage page = webClient.getPage(meliHome.url);

        HtmlInput campoBusca = page.getFirstByXPath(meliHome.campoBuscaPath);

        campoBusca.setValueAttribute(item);

        HtmlButton botaoBusca = page.getFirstByXPath(meliHome.botaoBuscarPath);

        HtmlPage resultadoBusca = botaoBusca.click();

        return resultadoBusca;
    }
}
