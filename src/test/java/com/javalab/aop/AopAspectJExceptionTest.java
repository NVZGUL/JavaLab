package com.javalab.aop;

import com.javalab.JavaConfig;
import com.javalab.model.Bar;
import com.javalab.model.Person;
import com.javalab.model.PersonBrokenException;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static lombok.AccessLevel.PRIVATE;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = JavaConfig.class)
@FieldDefaults(level = PRIVATE)
@AllArgsConstructor(onConstructor = @__(@Autowired))
class AopAspectJExceptionTest {

    Bar bar;

    Person person;

    @BeforeEach
    void setUp() {
        person = person.withBroke(true);
    }

    @Test
    void testAfterThrowingAdvice() {
        String fromSystemOut = TestUtils.fromSystemOut(() ->
                assertThrows(PersonBrokenException.class, () ->
                        bar.sellSquishee(person)));
        System.out.println(fromSystemOut);
        assertTrue(fromSystemOut.contains("Hmmm..."), "Customer is not broken ");
    }
}

