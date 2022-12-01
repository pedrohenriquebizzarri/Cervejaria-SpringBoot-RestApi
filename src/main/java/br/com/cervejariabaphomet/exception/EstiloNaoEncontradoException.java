package br.com.cervejariabaphomet.exception;

@SuppressWarnings("serial")
public class EstiloNaoEncontradoException extends Exception{

	public EstiloNaoEncontradoException() {
		super();
	}

	public EstiloNaoEncontradoException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public EstiloNaoEncontradoException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public EstiloNaoEncontradoException(String arg0) {
		super(arg0);
	}

	public EstiloNaoEncontradoException(Throwable arg0) {
		super(arg0);
	}
}
