package com.teaching.teaching.configs;
import com.teaching.teaching.dal.DataAccessLayer;
import com.teaching.teaching.models.User;
import com.teaching.teaching.security.TokenFilter;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class DataConfiguration {
    private final SessionFactory sessionFactory;
    @Autowired
    public DataConfiguration(EntityManager entityManager) {
        Session session = entityManager.unwrap(org.hibernate.Session.class);
        this.sessionFactory = session.getSessionFactory();
    }
    @Bean
    public DataAccessLayer dataAccessLayer(){
        return new DataAccessLayer(sessionFactory);
    }
    @Bean
    public User user() {
        return new User();
    }
    @Bean
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }

}


