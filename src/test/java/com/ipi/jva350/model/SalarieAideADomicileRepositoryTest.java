package com.ipi.jva350.model;

import static org.junit.Assert.assertEquals;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ipi.jva350.repository.SalarieAideADomicileRepository;

@ExtendWith(SpringExtension.class) // Junit 4 : @RunWith(SpringRunner.class)
@DataJpaTest // ou carrément @SpringBootTest et sa configuration
@SpringBootTest
@Transactional
@AutoConfigureTestDatabase
public class SalarieAideADomicileRepositoryTest {
    @Autowired
    com.ipi.jva350.repository.SalarieAideADomicileRepository salarieRepository;

    @Test
    public void testFindByNom() {
        SalarieAideADomicile nom = new SalarieAideADomicile();
        nom.getNom();
        SalarieAideADomicile res = salarieRepository.findByNom("Dupont");
        Assertions.assertEquals(res, res);
    }

    @Autowired
    private SalarieAideADomicileRepository repository;

    @Test
    void testPartCongesPrisTotauxAnneeNMoins1() {
        // Set up test data in the database
        SalarieAideADomicile s1 = new SalarieAideADomicile();
        s1.setCongesPayesPrisAnneeNMoins1(10);
        s1.setCongesPayesAcquisAnneeNMoins1(20);
        repository.save(s1);

        SalarieAideADomicile s2 = new SalarieAideADomicile();
        s2.setCongesPayesPrisAnneeNMoins1(15);
        s2.setCongesPayesAcquisAnneeNMoins1(30);
        repository.save(s2);

        // Execute the method under test
        Double result = SalarieAideADomicileRepository.partCongesPrisTotauxAnneeNMoins1();

        // Verify the results
        assertEquals(0.5, result, 0.01);
    }
}
