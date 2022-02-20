package de.mclenburg.br.server.rest.api;

import lombok.Data;

import java.util.List;

@Data
public class Kollege {
    Long id;
    String nachname;
    String vorname;
    List<String> einzelmassnahmen;

    public static final String ENDPOINT = "kollege";
}
