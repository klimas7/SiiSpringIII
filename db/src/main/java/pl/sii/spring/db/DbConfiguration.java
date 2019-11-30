package pl.sii.spring.db;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class DbConfiguration {

    @Bean
    @Profile("dev")
    @Lazy
    public DataSource devDS() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:scripts/schema.sql")
                .addScript("classpath:scripts/test-data.sql")
                .build();
    }

    @Bean
    @Profile("test")
    @Lazy
    public DataSource dataSourceTest() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("org.h2.Driver");
        ds.setUrl("jdbc:h2:tcp://192.168.0.145:1521/test");
        ds.setUsername("sa");
        ds.setPassword("");
        ds.setInitialSize(2);
        ds.setMaxTotal(10);
        return ds;
    }

    @Bean
    @Lazy
    public LocalSessionFactoryBean sessionFactory(DataSource ds) {
        LocalSessionFactoryBean lsf = new LocalSessionFactoryBean();
        lsf.setDataSource(ds);
        lsf.setPackagesToScan("pl.sii.spring.db.model");
        Properties properties = new Properties();
        properties.setProperty("dialect", "org.hibernate.dialect.H2Dialect");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        lsf.setHibernateProperties(properties);
        return lsf;
    }

    @Bean
    @Profile("prod")
    @Lazy
    public DataSource dataSource() {
        JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
        jndiObjectFactoryBean.setJndiName("jdbc/SiiSpringDS");
        jndiObjectFactoryBean.setResourceRef(true);
        jndiObjectFactoryBean.setProxyInterface(DataSource.class);
        return (DataSource) jndiObjectFactoryBean.getObject();
    }
}
