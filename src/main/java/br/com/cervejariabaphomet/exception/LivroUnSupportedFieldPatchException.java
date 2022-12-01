package br.com.cervejariabaphomet.exception;

import java.util.Set;

public class LivroUnSupportedFieldPatchException extends RuntimeException {

    public LivroUnSupportedFieldPatchException(Set<String> keys) {
        super("Field " + keys.toString() + " update is not allow.");
    }

}
