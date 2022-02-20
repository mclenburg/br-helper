package de.mclenburg.br.server.rest.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BrError {
    private long code;
    private String message;
}
