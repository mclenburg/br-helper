package de.mclenburg.br.server.dataobjects;

import de.mclenburg.br.server.catalogues.Maßnahmeart;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class Einzelmaßnahme {
    private long id;
    private LocalDate datum;
    private List<Maßnahmeart> maßnahmearten;
    private String inhalt;
}
