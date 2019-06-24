package com.example.xmlformatter.config;

import com.example.xmlformatter.factory.PathFactory;
import com.example.xmlformatter.factory.ScannerFactory;
import com.example.xmlformatter.model.PathHolder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Path;
import java.util.Scanner;

@Configuration
@ComponentScan
public class AppConfig {

    @Bean
    public Scanner getScanner() {
        return ScannerFactory.getInstance();
    }

    @Bean
    public Path getPath() {
        return PathFactory.getInstance();
    }

    @Bean
    public PathHolder getPathHolder(Path path) {
        return new PathHolder(path);
    }

}
