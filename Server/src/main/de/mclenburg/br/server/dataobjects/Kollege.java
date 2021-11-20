package de.mclenburg.br.server.dataobjects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Kollege {
    private long id;
    private String name;
    private String nachname;
}
