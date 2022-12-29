package com.ipi.jva350.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class) // Junit 4 : @RunWith(SpringRunner.class)
@DataJpaTest // ou carrément @SpringBootTest et sa configuration
public class SalarieAideADomicileRepositoryTest {
    @Autowired
    com.ipi.jva350.repository.SalarieAideADomicileRepository salarieRepository;

    @Test
    public void testFindByNom() {
        SalarieAideADomicile nom = new SalarieAideADomicile();
        nom.getNom();
        SalarieAideADomicile res = salarieRepository.findByNom("Dupont");
    Assertions.assertEquals(res);
    }
}