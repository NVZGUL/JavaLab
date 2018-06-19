package com.javalab;

import com.javalab.model.Contact;
import com.javalab.model.UsualContact;
import org.springframework.context.annotation.*;

import java.util.Arrays;
import java.util.List;


@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.javalab.aop", "com.javalab.model"})
@ImportResource("aop.xml")
public class JavaConfig {

    @Bean
    public List<Contact> contacts() {
        return Arrays.asList(
                new UsualContact(1,"EMAIL","test@email.com"),
                new UsualContact(2,"TELEPHONE","+1 (111) 111-11-11")
        );
    }
}
