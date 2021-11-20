package de.mclenburg.br.server.dataobjects;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class Kollege {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String nachname;
    @ManyToOne(targetEntity = Einzelmassnahme.class)
    private List<Einzelmassnahme> einzelmassnahmen;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Kollege kollege = (Kollege) o;
        return id != null && Objects.equals(id, kollege.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
