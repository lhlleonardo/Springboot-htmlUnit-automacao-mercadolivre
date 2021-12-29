package com.br.segundafase.segundafase.pages;

public class MeliResultado {

    public final String itemBuscadoPath = "//h1[@class='ui-search-breadcrumb__title']";
    public final String quantidadeResultadosPath = "//span[@class='ui-search-search-result__quantity-results']";
    public final String resultadosPath = "//div[@class='ui-search-result__wrapper']";
    public final String quantidadePaginasPath = "//li[@class='andes-pagination__page-count']";
    public final String precoItemPath = ".//div[@class='ui-search-price ui-search-price--size-medium ui-search-item__group__element']//div[@class='ui-search-price__second-line']//span[@class='price-tag-amount']";
    public final String descricaoItemPath = ".//div[@class='ui-search-result__content-wrapper']//h2[@class='ui-search-item__title ui-search-item__group__element']";
    public final String imagemItemPath = ".//img[@class='ui-search-result-image__element']";
    public final String botaoProximaPath = "//a[@class='andes-pagination__link ui-search-link'][@title='Seguinte']";

}
