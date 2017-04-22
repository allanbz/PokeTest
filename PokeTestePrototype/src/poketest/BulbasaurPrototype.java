package poketest;

public class BulbasaurPrototype extends PokemonPrototype {

	//construtor para clonagem
	protected BulbasaurPrototype(BulbasaurPrototype bulbasaurPrototype) {
		this.name = bulbasaurPrototype.getName();
		this.type = bulbasaurPrototype.getType();
		this.Hp = bulbasaurPrototype.getHp();
		this.number = bulbasaurPrototype.getNumber();
		this.attacks = bulbasaurPrototype.getAttacks();
	}
	
	//construtor base
	protected BulbasaurPrototype() {
		this.name = "Bulbasaur";
		this.type = "Grass";
		this.Hp = 45;
		this.number = 1;
		String[] atk = new String[4];
		atk[0] = "Vine Whip";
		atk[1] = "Poison Powder";
		atk[2] = "Razor Leaf";
		atk[3] = "SeedBomb";
		this.setAttacks(atk);
	}
	
	@Override
	public PokemonPrototype clone() {
		return new BulbasaurPrototype(this);
	}
}
