package java.de.mclenburg.br.server.dataobjects;

import lombok.Data;

import java.de.mclenburg.br.server.catalogues.Anforderungsklasse;

@Data
public class Stelle {
    private long id;
    private String bezeichnung;
    private Anforderungsklasse anforderungsklasse;
}
