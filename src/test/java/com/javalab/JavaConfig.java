package com.javalab;

import com.javalab.model.Contact;
import com.javalab.model.UsualContact;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;

import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2;


@Configuration
@EnableAspectJAutoProxy
@ImportResource("jdbc.xml")
@ComponentScan({"com.javalab.aop", "com.javalab.model", "com.javalab.dao"})
public class JavaConfig {

    @Bean
    public List<Contact> contacts() {
        return Arrays.asList(
                new UsualContact(1,"EMAIL","test@email.com"),
                new UsualContact(2,"TELEPHONE","+1 (111) 111-11-11")
        );
    }

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .generateUniqueName(true)
                .setType(H2)
                .setScriptEncoding("UTF-8")
                .ignoreFailedDrops(true)
                .addScript("db-shema.sql")
                .build();
    }
}
