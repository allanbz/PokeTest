package poketest;

public abstract class Colleague {

	protected Mediator mediator;
	
	public Colleague(Mediator m) {
		mediator = m;
	}

	public void mudarTela(String resolucao) {
		mediator.tela(resolucao, this);
	}

	public abstract void definirResolucao(String resolucao);
	
}
