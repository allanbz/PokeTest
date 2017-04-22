package poketest;

import java.util.Random;

public abstract class PokemonPrototype implements generalPoke {

	public String name;
	public String type;
	public int Hp;
	public int number;
	public String[] attacks;
	
	//padrao prototype
	public abstract PokemonPrototype clone();
	
	//getters e setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getHp() {
		return Hp;
	}
	public void setHp(int life) {
		this.Hp = life;
	}
	public String[] getAttacks() {
		return attacks;
	}
	public void setAttacks(String[] attacks) {
		this.attacks = attacks;
	}
	
	//acoes dos pokemons
	Random chance = new Random();
	
	public int attack() {
		
		Random rand = new Random();
		int n = rand.nextInt(4);
		System.out.println("Wild " + this.name + " uses " + this.attacks[n]);
		return 3*(n+1);
	}

	public int capture() {
		
		int catchchance = chance.nextInt(2);
		
		if(catchchance == 1)
		{
			return 1;
		}
		else{
			System.out.println("Sorry you pokeball is broken");
			return 0;		
		}
	}

	public int run(int n) {

		int runchance = chance.nextInt(4);
		if(runchance == 1)
		{
			//pokemon foge
		}
		
		return 0;
	}
	
}
