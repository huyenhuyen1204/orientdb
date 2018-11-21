package com.example.apporientdb;

import com.example.apporientdb.entry.NameBasics;
import com.orientechnologies.orient.object.db.OObjectDatabaseTx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.orient.commons.core.OrientTransactionManager;
import org.springframework.data.orient.commons.repository.config.EnableOrientRepositories;
import org.springframework.data.orient.object.OrientObjectDatabaseFactory;
import org.springframework.data.orient.object.OrientObjectTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;

@Configuration
@EnableTransactionManagement
@EnableOrientRepositories("com.example.apporientdb.interfaces.repositorys")
@SpringBootApplication
public class AppOrientdbApplication implements CommandLineRunner {


    @Autowired
    private OrientObjectDatabaseFactory factory;

    public static void main(String[] args) {
        SpringApplication.run(AppOrientdbApplication.class, args);
    }

    @Bean
    public OrientObjectDatabaseFactory factory() {
        OrientObjectDatabaseFactory factory =  new OrientObjectDatabaseFactory();

        factory.setUrl("remote:178.128.58.224/orientdb");
        factory.setUsername("admin");
        factory.setPassword("admin");

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

    //
    @PostConstruct
    public void registerEntities() {
        try {
            factory().db().getEntityManager().registerEntityClass(NameBasics.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void run(String... args) throws Exception {
        OObjectDatabaseTx db = null;

        try {
            db = factory.openDatabase();
            db.getEntityManager().registerEntityClass(NameBasics.class);
        } finally {
            if (db != null) {
                db.close();
            }
        }
    }
}
