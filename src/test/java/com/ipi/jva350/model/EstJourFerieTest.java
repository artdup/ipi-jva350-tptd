package com.ipi.jva350.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

public class EstJourFerieTest {
    @Test
    public void testEstJourFerie() {
        // Test a non-leap year
        LocalDate nonLeapYear = LocalDate.of(2021, 1, 1); // New Year's Day
        assertTrue(Entreprise.estJourFerie(nonLeapYear));

        nonLeapYear = LocalDate.of(2021, 4, 5); // Not a public holiday
        assertFalse(Entreprise.estJourFerie(nonLeapYear));

        // Test a leap year
        LocalDate leapYear = LocalDate.of(2020, 2, 29); // Leap Day
        assertTrue(Entreprise.estJourFerie(leapYear));

        leapYear = LocalDate.of(2020, 4, 5); // Not a public holiday
        assertFalse(Entreprise.estJourFerie(leapYear));
    }

}
