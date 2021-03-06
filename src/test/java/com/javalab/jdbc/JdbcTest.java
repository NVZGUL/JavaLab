package com.javalab.jdbc;

import com.javalab.JavaConfig;
import com.javalab.dao.CountryDao;
import com.javalab.model.Country;
import com.javalab.model.UsualCountry;
import io.vavr.Tuple;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.javalab.dao.CountryDao.COUNTRY_INIT_DATA;
import static lombok.AccessLevel.PRIVATE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@FieldDefaults(level = PRIVATE, makeFinal = true)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = JavaConfig.class)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
class JdbcTest {

    CountryDao countryDao;

    @NonFinal
    List<Country> expectedCountryList;

    @NonFinal
    List<Country> expectedCountryListStartsWithA;

    @NonFinal
    Country countryWithChangedName;

    @BeforeEach
    void setUp() {

        expectedCountryList = IntStream.range(0, COUNTRY_INIT_DATA.length)
                .mapToObj(i -> Tuple.of(i + 1, COUNTRY_INIT_DATA[i][0], COUNTRY_INIT_DATA[i][1]))
                .map(issTuple -> new UsualCountry(issTuple._1, issTuple._2, issTuple._3))
                .collect(Collectors.toList());

        expectedCountryListStartsWithA = expectedCountryList.stream()
                .filter(country -> country.getName().startsWith("A"))
                .collect(Collectors.toList());

        countryWithChangedName = new UsualCountry(8, "Russia", "RU");

        countryDao.loadCountries();
    }

    @Test
    @DirtiesContext
    void testCountryList() {
        List<Country> countryList = countryDao.getCountryList();
        assertNotNull(countryList);
        assertEquals(expectedCountryList.size(), countryList.size());
        for (int i = 0; i < expectedCountryList.size(); i++)
            assertEquals(expectedCountryList.get(i), countryList.get(i));
    }

    @Test
    @DirtiesContext
    void testCountryListStartsWithA() {
        List<Country> countryList = countryDao.getCountryListStartWith("A");
        assertNotNull(countryList);
        assertEquals(expectedCountryListStartsWithA.size(), countryList.size());
        for (int i = 0; i < expectedCountryListStartsWithA.size(); i++)
            assertEquals(expectedCountryListStartsWithA.get(i), countryList.get(i));
    }

    @Test
    @DirtiesContext
    void testCountryChange() {
        countryDao.updateCountryName("RU", "Russia");
        assertThat(countryDao.getCountryByCodeName("RU"), is(countryWithChangedName));
    }

}

