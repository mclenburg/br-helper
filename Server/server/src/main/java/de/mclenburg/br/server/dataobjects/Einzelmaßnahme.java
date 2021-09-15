package java.de.mclenburg.br.server.dataobjects;

import lombok.Data;

import java.de.mclenburg.br.server.catalogues.Maßnahmeart;
import java.time.LocalDate;
import java.util.List;

@Data
public class Einzelmaßnahme {
    private long id;
    private LocalDate datum;
    private List<Maßnahmeart> maßnahmearten;
    private String inhalt;
}
