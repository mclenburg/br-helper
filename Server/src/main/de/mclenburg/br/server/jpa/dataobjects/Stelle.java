package de.mclenburg.br.server.jpa.dataobjects;

import de.mclenburg.br.server.jpa.catalogues.Anforderungsklasse;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class Stelle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String bezeichnung;
    @OneToOne
    private Anforderungsklasse anforderungsklasse;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Stelle stelle = (Stelle) o;
        return id != null && Objects.equals(id, stelle.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
