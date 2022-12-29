package com.ipi.jva350.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.util.LinkedHashSet;

import static org.junit.jupiter.api.Assertions.*;

class SalarieAideADomicileTest {

    @Test
    public void aLegalementDroitADesCongesPayesTest() {
        //Given
        SalarieAideADomicile aide = new SalarieAideADomicile();
        // When
        boolean res = aide.aLegalementDroitADesCongesPayes();
        // Then
        Assertions.assertTrue(res);
    }

    @Test
    public void aLegalementDroitADesCongesPayesGreatNumber() {
        //Given
        SalarieAideADomicile aide = new SalarieAideADomicile();
        aide.setJoursTravaillesAnneeNMoins1(100);
        //When
        boolean res = aide.aLegalementDroitADesCongesPayes();
        //Then
        Assertions.assertTrue(res);
    }
@ParameterizedTest
@CsvSource({
        "'',false",
        "'',true",
})
    @Test
    public void calculeJoursDeCongeDecomptesPourPlageTest() {
        //Given
        SalarieAideADomicile aide = new SalarieAideADomicile();
        //When
        LinkedHashSet<LocalDate> joursDeCongesDecomptes = aide.calculeJoursDeCongeDecomptesPourPlage((dateDebut, dateFin))

        //Then
        Assertions.assertEquals(joursDeCongesDecomptes.size(),expected);

    }
}