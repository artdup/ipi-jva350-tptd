package com.ipi.jva350.model;

import static org.junit.Assert.assertEquals;
import java.time.LocalDate;
import org.junit.Test;

import com.ipi.jva350.service.SalarieAideADomicileService;

public class CongeTest {
    @Test
    public void testProportionPondereeDuMois() {
        // Test for month of January
        LocalDate moisDuConge = LocalDate.of(2022, 1, 1);
        double expected = 8d / 12d / 10d;
        double actual = Entreprise.proportionPondereeDuMois(moisDuConge);
        assertEquals(expected, actual, 1e-9);

        // Test for month of June
        moisDuConge = LocalDate.of(2022, 6, 1);
        expected = (8 + 20 + 20 + 8 + 8 + 8) / 12d / 10d;
        actual = Entreprise.proportionPondereeDuMois(moisDuConge);
        assertEquals(expected, actual, 1e-9);

        // Test for month of December
        moisDuConge = LocalDate.of(2022, 12, 1);
        expected = (8 + 20 + 20 + 8 + 8 + 8 + 8 + 8 + 8 + 8 + 8) / 12d / 10d;
        actual = Entreprise.proportionPondereeDuMois(moisDuConge);
        assertEquals(expected, actual, 1e-9);
    }

    @Test
    public void testGetPremierJourAnneeDeConges() {
        // Test input dates in current year
        LocalDate input1 = LocalDate.of(2020, 7, 15);
        LocalDate expectedOutput1 = LocalDate.of(2020, 6, 1);
        assertEquals(expectedOutput1, Entreprise.getPremierJourAnneeDeConges(input1));

        LocalDate input2 = LocalDate.of(2020, 5, 31);
        LocalDate expectedOutput2 = LocalDate.of(2019, 6, 1);
        assertEquals(expectedOutput2, Entreprise.getPremierJourAnneeDeConges(input2));

        // Test input dates in previous year
        LocalDate input3 = LocalDate.of(2019, 4, 30);
        LocalDate expectedOutput3 = LocalDate.of(2018, 6, 1);
        assertEquals(expectedOutput3, Entreprise.getPremierJourAnneeDeConges(input3));

        // Test null input
        assertEquals(null, Entreprise.getPremierJourAnneeDeConges(null));
    }

    @Test
    public void testCalculeLimiteEntrepriseCongesPermis() {
        // Test with current month in January, acquired paid time off in previous year,
        // contract start date in January,
        // paid time off starting in July, and paid time off ending in August
        LocalDate moisEnCours = LocalDate.of(2022, 1, 1);
        double congesPayesAcquisAnneeNMoins1 = 20;
        LocalDate moisDebutContrat = LocalDate.of(2021, 1, 1);
        LocalDate premierJourDeConge = LocalDate.of(2022, 7, 1);
        LocalDate dernierJourDeConge = LocalDate.of(2022, 8, 31);
        long limiteConges = SalarieAideADomicileService.calculeLimiteEntrepriseCongesPermis(moisEnCours,
                congesPayesAcquisAnneeNMoins1, moisDebutContrat, premierJourDeConge, dernierJourDeConge);

        // Verify that the limit is what we expect it to be
        assertEquals(30, limiteConges);

        // Test with current month in June, acquired paid time off in previous year,
        // contract start date in January,
        // paid time off starting in July, and paid time off ending in August
        moisEnCours = LocalDate.of(2022, 6, 1);
        congesPayesAcquisAnneeNMoins1 = 20;
        moisDebutContrat = LocalDate.of(2021, 1, 1);
        premierJourDeConge = LocalDate.of(2022, 7, 1);
        dernierJourDeConge = LocalDate.of(2022, 8, 31);
        limiteConges = SalarieAideADomicileService.calculeLimiteEntrepriseCongesPermis(moisEnCours,
                congesPayesAcquisAnneeNMoins1, moisDebutContrat, premierJourDeConge, dernierJourDeConge);

        // Verify that the limit is what we expect it to be
        assertEquals(32, limiteConges);

        // Test with current month in July, acquired paid time off in previous year,
        // contract start date in January,
        // paid time off starting in July, and paid time off ending in August
        moisEnCours = LocalDate.of(2022, 7, 1);
        congesPayesAcquisAnneeNMoins1 = 20;
        moisDebutContrat = LocalDate.of(2021, 1, 1);
        premierJourDeConge = LocalDate.of(2022, 7, 1);
        dernierJourDeConge = LocalDate.of(2022, 8, 31);
        limiteConges = SalarieAideADomicileService.calculeLimiteEntrepriseCongesPermis(moisEnCours,
                congesPayesAcquisAnneeNMoins1, moisDebutContrat, premierJourDeConge, dernierJourDeConge);
    }
}