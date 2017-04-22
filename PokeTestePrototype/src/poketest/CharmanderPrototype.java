package poketest;

public class CharmanderPrototype extends PokemonPrototype {
	
	//construtor para clonagem
	protected CharmanderPrototype(CharmanderPrototype charmanderPrototype) {
		this.name = charmanderPrototype.getName();
		this.type = charmanderPrototype.getType();
		this.Hp = charmanderPrototype.getHp();
		this.number = charmanderPrototype.getNumber();
		this.attacks = charmanderPrototype.getAttacks();
	}
	
	//construtor base
	protected CharmanderPrototype() {
		this.name = "Charmander";
		this.type = "Fire";
		this.Hp = 45;
		this.number = 4;
		String[] atk = new String[4];
		atk[0] = "Ember";
		atk[1] = "Fire Fang";
		atk[2] = "Flame Burst";
		atk[3] = "Slash";
		this.setAttacks(atk);
	}
	
	@Override
	public PokemonPrototype clone() {
		return new CharmanderPrototype(this);
	}
}
