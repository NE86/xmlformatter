package com.example.xmlformatter;

import com.example.xmlformatter.service.ScannerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class XmlformatterApplication implements CommandLineRunner {

    private static Logger LOG = LoggerFactory.getLogger(XmlformatterApplication.class);
    private ScannerService scannerService;

    @Autowired
    public XmlformatterApplication(ScannerService scannerService) {
        this.scannerService = scannerService;
    }

    public static void main(String[] args) {
        LOG.info("SATRTING THE APPLICATION");
        SpringApplication.run(XmlformatterApplication.class, args);
        LOG.info("APPLICATION FINISHED");
    }

    @Override
    public void run(String... args) {
        LOG.info("EXECUTING : command line runner");
        scannerService.run();
    }
}
