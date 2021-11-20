package de.mclenburg.br.server.dataobjects;

import de.mclenburg.br.server.catalogues.Massnahmeart;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class Einzelmassnahme {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate datum;
    @ManyToOne(targetEntity = Massnahmeart.class)
    private List<Massnahmeart> massnahmearten;
    private String inhalt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Einzelmassnahme that = (Einzelmassnahme) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
