package com.br.segundafase.segundafase.service;

import com.br.segundafase.segundafase.model.Demanda;
import com.br.segundafase.segundafase.model.Produto;
import com.br.segundafase.segundafase.pages.MeliResultado;
import com.gargoylesoftware.htmlunit.html.*;

import java.io.IOException;
import java.util.List;

public class DemandaService {

    MeLiService meLiService = new MeLiService();

    MeliResultado meliResultado = new MeliResultado();

    public String retornarItemProcurado(String item) throws IOException {

        HtmlPage resultadoBusca = meLiService.mercadoLivreBuscarItem(item);

        HtmlHeading1 itemBuscado = resultadoBusca.getFirstByXPath(meliResultado.itemBuscadoPath);
        HtmlSpan quantidadeResultados = resultadoBusca.getFirstByXPath(meliResultado.quantidadeResultadosPath);
        HtmlListItem totalPaginas = resultadoBusca.getFirstByXPath(meliResultado.quantidadePaginasPath);
        HtmlAnchor botaoProximo = resultadoBusca.getFirstByXPath(meliResultado.botaoProximaPath);

        String paginas = totalPaginas.getTextContent().replaceAll("\\D+","");

        Demanda demanda = new Demanda();

        demanda.setItemDemanda(itemBuscado.getTextContent());
        demanda.setQtdeResultados(quantidadeResultados.getTextContent());

        for (int i = 1; i <= Integer.parseInt(paginas); i++) {

            List<HtmlDivision> resultados = resultadoBusca.getByXPath(meliResultado.resultadosPath);

            for (HtmlDivision r : resultados) {

                HtmlSpan precoProduto = r.getFirstByXPath(meliResultado.precoItemPath);
                HtmlHeading2 descricaoProduto = r.getFirstByXPath(meliResultado.descricaoItemPath);
                HtmlImage imagemProduto = r.getFirstByXPath(meliResultado.imagemItemPath);

                demanda.adicionarProduto(new Produto(descricaoProduto.getTextContent(), precoProduto.getTextContent(), imagemProduto.getSrc()));
            }

            if (botaoProximo != null) {
                resultadoBusca = botaoProximo.click();
            } else {
                continue;
            }

        }

        return demanda.retornarBusca();
    }
    
}
