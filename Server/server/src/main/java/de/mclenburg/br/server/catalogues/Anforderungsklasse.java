package java.de.mclenburg.br.server.catalogues;

import lombok.Data;

@Data
public class Anforderungsklasse {
    private long id;
    private String bezeichnung;
    private long einstufung;
}
