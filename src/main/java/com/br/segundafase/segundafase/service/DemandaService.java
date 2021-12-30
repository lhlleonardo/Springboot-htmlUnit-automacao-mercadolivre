package com.br.segundafase.segundafase.service;

import com.br.segundafase.segundafase.model.Demanda;
import com.br.segundafase.segundafase.model.Produto;
import com.br.segundafase.segundafase.pages.MeliResultado;
import com.gargoylesoftware.htmlunit.html.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class DemandaService {

    @Autowired
    MeLiService meLiService;

    public String retornarItemProcurado(String item) throws IOException {

        HtmlPage resultadoBusca = meLiService.mercadoLivreBuscarItem(item);

        HtmlHeading1 itemBuscado = resultadoBusca.getFirstByXPath(MeliResultado.ITEM_BUSCADO_PATH);
        HtmlSpan quantidadeResultados = resultadoBusca.getFirstByXPath(MeliResultado.QTDE_RESULTADOS_PATH);
        HtmlListItem totalPaginas = resultadoBusca.getFirstByXPath(MeliResultado.QTDE_PAGINAS_PATH);
        HtmlAnchor botaoProximo = resultadoBusca.getFirstByXPath(MeliResultado.BOTAO_PROXIMO_PATH);

        String paginas = totalPaginas.getTextContent().replaceAll("\\D+","");

        Demanda demanda = new Demanda();

        demanda.setItemDemanda(itemBuscado.getTextContent());
        demanda.setQtdeResultados(quantidadeResultados.getTextContent());

        for (int i = 1; i <= Integer.parseInt(paginas); i++) {

            List<HtmlDivision> resultados = resultadoBusca.getByXPath(MeliResultado.RESULTADOS_PATH);

            for (HtmlDivision r : resultados) {

                HtmlSpan precoProduto = r.getFirstByXPath(MeliResultado.PRECO_ITEM_PATH);
                HtmlHeading2 descricaoProduto = r.getFirstByXPath(MeliResultado.DESCRICAO_ITEM_PATH);
                HtmlImage imagemProduto = r.getFirstByXPath(MeliResultado.IMAGEM_ITEM_PATH);

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
