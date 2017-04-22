package poketest;

import java.util.ArrayList;

public class telaMediator implements Mediator{
	
	protected ArrayList<Colleague> resolucoes;

	public telaMediator() {
		resolucoes = new ArrayList<Colleague>();
	}

	public void adicionarColleague(Colleague colleague) {
		resolucoes.add(colleague);
	}

	@Override
	public void tela(String resolucao, Colleague colleague) {
		for (Colleague res : resolucoes) {
			if (res != colleague) {
				definirProtocolo(res);
				res.definirResolucao(resolucao);
			}
		}
	}

	private void definirProtocolo(Colleague resolucao) {
		if (resolucao instanceof MobileColleague) {
			System.out.println("Protocolo Mobile Phone");
		} else if (resolucao instanceof PcColleague) {
			System.out.println("Protocolo PC");
		} else if (resolucao instanceof DsColleague) {
			System.out.println("Protocolo 3DS");
		} else if (resolucao instanceof TvColleague) {
			System.out.println("Protocolo Tv");
		}
	}

}
