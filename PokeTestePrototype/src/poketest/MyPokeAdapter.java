package poketest;

public class MyPokeAdapter extends PokemonPrototype implements generalPoke {
	
	My_Pokemon MyPoke = new My_Pokemon();
	
	public MyPokeAdapter(My_Pokemon poke) {
		MyPoke = poke;
		this.name = poke.name;
		this.type = poke.type;
		this.Hp = poke.Hp;
		this.attacks = poke.attacks;
		this.number = poke.number;
	}

	@Override
	public int attack() {
		
		int x = MyPoke.atacar();
		return x;
	}

	@Override
	public int capture() {
		MyPoke.alimentar();
		return 0;
	}

	@Override
	public int run(int n) {
		int x = MyPoke.recuperar(n);
		return x;
		
	}

	@Override
	public PokemonPrototype clone() {
		return this;
	}
	
}
