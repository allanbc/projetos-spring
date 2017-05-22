package com.algaworks.brewer.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.algaworks.brewer.service.CadastroCervejaService;
//Aula 9.8
import com.algaworks.brewer.service.CadastroEstiloService;
@Configuration
@ComponentScan(basePackageClasses = {CadastroCervejaService.class, CadastroEstiloService.class})
public class ServiceConfig {

}
