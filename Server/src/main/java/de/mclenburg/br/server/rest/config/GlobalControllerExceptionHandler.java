package de.mclenburg.br.server.rest.config;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.expression.AccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.SQLException;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

        @ResponseStatus(HttpStatus.CONFLICT)  // 409
        @ExceptionHandler(DataIntegrityViolationException.class)
        public void handleConflict() {
            // Nothing to do
        }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(SQLException.class)
    public void handleSQLException() {
        // Nothing to do
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AccessException.class)
    public void handleAccessException() {
        // Nothing to do
    }
}
