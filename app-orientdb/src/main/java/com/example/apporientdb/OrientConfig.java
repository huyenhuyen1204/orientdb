package com.example.apporientdb;

import com.example.apporientdb.entry.NameBasics;
import com.example.apporientdb.entry.TitleAkas;
import com.example.apporientdb.entry.TitlePrincipals;
import com.example.apporientdb.entry.TitleRating;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.orient.commons.core.OrientTransactionManager;
import org.springframework.data.orient.commons.repository.config.EnableOrientRepositories;
import org.springframework.data.orient.object.OrientObjectDatabaseFactory;
import org.springframework.data.orient.object.OrientObjectTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;

@Configuration
@EnableTransactionManagement
@EnableOrientRepositories(basePackages = "com.example.apporientdb.entry")
public class OrientConfig {
    @Bean
    public OrientObjectDatabaseFactory factory() {
        OrientObjectDatabaseFactory factory =  new OrientObjectDatabaseFactory();

        factory.setUrl("remote:127.0.0.1/GratefulDeadConcerts");
        factory.setUsername("huyen");
        factory.setPassword("huyen");

        return factory;
    }

    @Bean
    public OrientTransactionManager transactionManager() {
        return new OrientTransactionManager(factory());
    }

    @Bean
    public OrientObjectTemplate objectTemplate() {
        return new OrientObjectTemplate(factory());
    }


    @PostConstruct
    public void registerEntities() {
        factory().db().getEntityManager().registerEntityClasses("com.example.apporientdb.entry");

    }
}
