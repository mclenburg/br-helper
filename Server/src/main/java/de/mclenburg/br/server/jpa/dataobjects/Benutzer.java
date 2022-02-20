package de.mclenburg.br.server.jpa.dataobjects;

import de.mclenburg.br.server.jpa.catalogues.Rolle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "Benutzer")
@AllArgsConstructor
@NoArgsConstructor
public class Benutzer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(unique = true)
    String username;
    String nachname;
    String vorname;
    String passwort;
    @ManyToMany(fetch = FetchType.EAGER)
    List<Rolle> rollen;

    public static String encryptString(String value) {
        return DigestUtils.sha256Hex(value);
    }
}
