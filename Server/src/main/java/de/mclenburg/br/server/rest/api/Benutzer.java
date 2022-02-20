package de.mclenburg.br.server.rest.api;

import lombok.Data;

import java.util.List;

@Data
public class Benutzer {
    private Long id;
    private String nachname;
    private String vorname;
    private String benutzername;
    private String passwort;
    private List<String> rollen;

    public static final String ENDPOINT = "/benutzer";
}
