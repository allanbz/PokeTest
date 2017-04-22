package poketest;

public class MobileColleague extends Colleague {

	public MobileColleague(Mediator m) {
		super(m);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void definirResolucao(String resolucao) {
		// TODO Auto-generated method stub
		
		System.out.println("---- MobilePhone resolution (340x640) ----");
		
		System.out.println(resolucao);
	}

}
