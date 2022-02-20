package de.mclenburg.br.server.rest.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BrResponse <T>{
    private final T response;
    private final BrError error;
}
