package de.mclenburg.br.server.dataobjects;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class EinzelmaßnahmeTest {

    @Test
    public void shouldCreateObject() {
       Einzelmaßnahme einzelmaßnahme = new Einzelmaßnahme(-1L, LocalDate.now(), null, "Test");
       Assert.assertEquals("Id should be -1", -1L, einzelmaßnahme.getId());
       Assert.assertEquals("Inhalt should ne Test", "Test", einzelmaßnahme.getInhalt());
    }
}