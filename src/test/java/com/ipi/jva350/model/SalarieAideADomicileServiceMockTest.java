package com.ipi.jva350.model;

import com.ipi.jva350.repository.SalarieAideADomicileRepository;
import com.ipi.jva350.service.SalarieAideADomicileService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

public class SalarieAideADomicileServiceMockTest {
    @Mock
    private SalarieAideADomicileService service;
    private SalarieAideADomicileService mockSalarie;

    @BeforeEach
    public void setUp() {
        // Création d'un mock pour SalarieAideADomicile
        mockSalarie = mock(SalarieAideADomicile.class);

        // Création d'un SalarieAideADomicileService avec le mock en tant que dépendance
        service = new SalarieAideADomicileService(mockSalarie);
    }


    @Test
    public void testClotureMois() {
        // Définition des comportements du mock
        when(mockSalarie.getMoisEnCours()).thenReturn(11);
        when(mockSalarie.getYear()).thenReturn(2022);
        when(mockSalarie.getSalaire()).thenReturn(1000);

        // Appel de la méthode SalarieAideADomicileService.clotureMois()
        service.clotureMois(mockSalarie);

        // Nous vérifions que les méthodes attendues ont été appelées sur le mock avec les valeurs attendues
        verify(mockSalarie).setMois(12);
        verify(mockSalarie).setAnnee(2022);
        verify(mockSalarie).setSalaire(1500);

        boolean result = mockSalarieAideADomicileService.clotureMois();

        assertTrue(result);
    }
}
