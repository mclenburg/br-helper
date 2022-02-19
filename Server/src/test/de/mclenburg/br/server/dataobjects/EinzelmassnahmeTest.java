package de.mclenburg.br.server.dataobjects;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class EinzelmassnahmeTest {

    @Test
    public void shouldCreateObject() {
       Einzelmassnahme einzelmassnahme = new Einzelmassnahme(-1L, LocalDate.now(), null, "Test");
       Assert.assertEquals("Id should be -1", Long.valueOf(-1L), einzelmassnahme.getId());
       Assert.assertEquals("Inhalt should be Test", "Test", einzelmassnahme.getInhalt());
    }
}