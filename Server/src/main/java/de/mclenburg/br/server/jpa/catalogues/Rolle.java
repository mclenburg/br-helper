package de.mclenburg.br.server.jpa.catalogues;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Rolle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(unique = true)
    String bezeichnung;
}
