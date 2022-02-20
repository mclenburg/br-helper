package de.mclenburg.br.server.jpa.catalogues;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Rolle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String bezeichnung;
}
