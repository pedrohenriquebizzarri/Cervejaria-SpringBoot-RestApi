package br.com.cervejariabaphomet.exception;

public class LivroNotFoundException extends RuntimeException {

    public LivroNotFoundException(Long id) {
        super("Book id not found : " + id);
    }

}
