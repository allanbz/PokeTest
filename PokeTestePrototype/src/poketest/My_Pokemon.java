package poketest;

import java.util.ArrayList;
import java.util.Scanner;

public class My_Pokemon extends PokemonPrototype {
	
	Scanner input = new Scanner(System.in);

	public int recuperar(int n){
		
		if(n == 0)
		{
			return 25;
		}
		else return 45;
		
	
	}
	
	public void alimentar(){
		
		
		
	}
	
	public int atacar(){
		
		for(int i = 0; i < 4; i++)System.out.println(i + " " + this.attacks[i]);
		
		System.out.println("Choose a move:");
		int move = input.nextInt();
		
		System.out.println("You use " + this.attacks[move]);
		
		return 3*(move+1);
		
	}
	
	public void addpokes(ArrayList <PokemonPrototype> poke, int i){

		this.setName(poke.get(i).name);
		this.setHp(poke.get(i).Hp);
		this.setType(poke.get(i).type);
		this.setAttacks(poke.get(i).attacks);
		this.setNumber(poke.get(i).number);
		
	}
	
	@Override
	public PokemonPrototype clone() {
		return this;
	}

}
