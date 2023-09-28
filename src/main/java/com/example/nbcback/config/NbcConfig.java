package com.example.nbcback.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;
import javax.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "nbcEntityManager",
        transactionManagerRef = "nbcTransactionManager",
        basePackages = {
                "com.example.nbcback.repositories"
        }
)
public class NbcConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.nbc.datasource")
    public DataSource nbcDataSource() {
        return DataSourceBuilder
                .create()
                .build();
    }

    @Bean(name = "nbcEntityManager")
    public LocalContainerEntityManagerFactoryBean nbcEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(nbcDataSource())
                .properties(hibernateProperties())
                .packages(
                        "com.example.nbcback.model"
                )
                .persistenceUnit("nbcPU")
                .build();
    }

    @Bean(name = "nbcTransactionManager")
    public PlatformTransactionManager nbcTransactionManager(@Qualifier("nbcEntityManager") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager((jakarta.persistence.EntityManagerFactory) entityManagerFactory);
    }

    private Map<String, Object> hibernateProperties() {

        Resource resource = new ClassPathResource("hibernate.properties");
        try {
            Properties properties = PropertiesLoaderUtils.loadProperties(resource);
            return properties.entrySet().stream()
                    .collect(Collectors.toMap(
                            e -> e.getKey().toString(),
                            e -> e.getValue())
                    );
        } catch (IOException e) {
            return new HashMap<String, Object>();
        }
    }

}
