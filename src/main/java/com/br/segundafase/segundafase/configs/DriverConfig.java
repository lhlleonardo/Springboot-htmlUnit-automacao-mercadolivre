package com.br.segundafase.segundafase.configs;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;

public class DriverConfig {

    public WebClient chromeDriver() {

        WebClient webClient = new WebClient(BrowserVersion.CHROME);

        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);

        return webClient;
    }

    public WebClient firefoxDrive() {

        WebClient webClient = new WebClient(BrowserVersion.FIREFOX);

        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);

        return webClient;
    }
}
