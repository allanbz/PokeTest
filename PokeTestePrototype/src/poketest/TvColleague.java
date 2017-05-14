package poketest;

public class TvColleague extends Colleague {

	public TvColleague(Mediator m) {
		super(m);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void definirResolucao(String resolucao) {
		// TODO Auto-generated method stub
		System.out.println("---- Tv resolution (4096x2160) ----");
		
		System.out.println(resolucao);
	}

}
