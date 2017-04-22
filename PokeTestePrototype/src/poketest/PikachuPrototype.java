package poketest;

public class PikachuPrototype extends PokemonPrototype {
	
	//construtor para clonagem
	protected PikachuPrototype(PikachuPrototype pikachuPrototype) {
		this.name = pikachuPrototype.getName();
		this.type = pikachuPrototype.getType();
		this.Hp = pikachuPrototype.getHp();
		this.number = pikachuPrototype.getNumber();
		this.attacks = pikachuPrototype.getAttacks();
	}
	
	//construtor base
	protected PikachuPrototype() {
		this.name = "Pikachu";
		this.type = "Electric";
		this.Hp = 45;
		this.number = 42;
		String[] atk = new String[4];
		atk[0] = "Thunder Shock";
		atk[1] = "Spark";
		atk[2] = "Thunderbolt";
		atk[3] = "Discharge";
		this.setAttacks(atk);
	}
	
	@Override
	public PokemonPrototype clone() {
		return new PikachuPrototype(this);
	}
}
