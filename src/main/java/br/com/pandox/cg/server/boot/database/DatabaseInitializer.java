package br.com.pandox.cg.server.boot.database;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Profile("staging")
public class DatabaseInitializer {

    @PostConstruct
    public void init() {

    }

}
