package zag.sm.user.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.sql.DataSource;

@Configuration
@EnableJpaAuditing
@ConfigurationProperties(prefix = "spring.datasource.hikari")
public class DatabaseSource extends HikariConfig {

    @Bean
    @Primary
    public DataSource dataSource() {
        return new HikariDataSource(this);
    }
}
