package com.br.segundafase.segundafase.configs;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 @Author: Leonardo Henrique Lopes
 @Date: 30/12/2021
*/

@Configuration
public class DriverConfig {

    @Bean
    public WebClient chrome() { return chromeDriver(); }

    @Bean
    public WebClient firefox() { return firefoxDrive(); }

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
