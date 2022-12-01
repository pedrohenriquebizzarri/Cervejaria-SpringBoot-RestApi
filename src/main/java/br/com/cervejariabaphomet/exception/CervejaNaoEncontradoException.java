package br.com.cervejariabaphomet.exception;

public class CervejaNaoEncontradoException extends Exception{

	public CervejaNaoEncontradoException() {
		super();
	}

	public CervejaNaoEncontradoException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public CervejaNaoEncontradoException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public CervejaNaoEncontradoException(String arg0) {
		super(arg0);
	}

	public CervejaNaoEncontradoException(Throwable arg0) {
		super(arg0);
	}
}

