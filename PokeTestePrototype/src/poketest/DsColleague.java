package poketest;

public class DsColleague extends Colleague {

	public DsColleague(Mediator m) {
		super(m);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void definirResolucao(String resolucao) {
		// TODO Auto-generated method stub
		
		System.out.println("---- 3DS resolution (800×240) ----");
		
		System.out.println(resolucao);
	}

}
