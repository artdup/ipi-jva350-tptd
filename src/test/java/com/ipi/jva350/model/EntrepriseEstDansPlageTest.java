package com.ipi.jva350.model;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

public class EntrepriseEstDansPlageTest {
    @Test
    public void testEstDansPlage() {
        LocalDate d = LocalDate.of(2020, 1, 1);
        LocalDate debut = LocalDate.of(2019, 12, 31);
        LocalDate fin = LocalDate.of(2020, 1, 3);
        assertTrue(Entreprise.estDansPlage(d, debut, fin));
    }

}
