package com.example.soni.springbootrestapi.config;

import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManagerFactory;

//@Configuration
public class HibernateConfiguration {

   /* @Autowired
    private EntityManagerFactory entityManagerFactory;*/

    @Bean
    @ConfigurationProperties("spring.datasource")
    public HikariDataSource dataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean(name = "entityManagerFactory")
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource());
        //emf.setJpaVendorAdapter(jpaVendorAdapter);
        //emf.setPackagesToScan("com.mysource.model");
        //emf.setPersistenceUnitName("default");
        //emf.afterPropertiesSet();
        return emf.getObject();
    }

    @Bean
    public SessionFactory getSessionFactory(@Autowired @Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
        if (entityManagerFactory().unwrap(SessionFactory.class) == null) {
            throw new NullPointerException("factory is not a hibernate factory");
        }
        return entityManagerFactory.unwrap(SessionFactory.class);
    }
}
