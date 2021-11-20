package de.mclenburg.br.server.dataobjects;

import de.mclenburg.br.server.catalogues.Anforderungsklasse;
import lombok.Data;

@Data
public class Stelle {
    private long id;
    private String bezeichnung;
    private Anforderungsklasse anforderungsklasse;
}
