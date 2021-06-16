package com.intuit;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableAdminServer
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableZuulProxy
@SpringBootApplication
public class Application {
    private static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        Application.launchApp(args);
    }

    private static void launchApp(String[] args) {
        try {
            logger.info("Starting Application");
            new SpringApplicationBuilder(Application.class)
                    .run(args)
                    .registerShutdownHook();
        }
        catch (Exception ex) {
            logger.error("Exception while starting the Zuul Server {}" , ex);
            System.exit(0);
        }
    }
}
