package poketest;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class PokeTest {
	
	//restricao de acesso
	private static String user = "admin";
	private static String password = "pokemao";
	
	static Scanner input = new Scanner(System.in);
	static Random rand = new Random();
	
	public static void createPokes(ArrayList<PokemonPrototype> PokeList) {
		
		//adicionando pokemons
		
		BulbasaurPrototype bulbasaurPrototype = new BulbasaurPrototype();
		PokemonPrototype bulbasaur = bulbasaurPrototype.clone();
		PokeList.add(bulbasaur);
		
		CharmanderPrototype charmanderPrototype = new CharmanderPrototype();
		PokemonPrototype charmander = charmanderPrototype.clone();
		PokeList.add(charmander);
		
		PikachuPrototype pikachuPrototype = new PikachuPrototype();
		PokemonPrototype pikachu = pikachuPrototype.clone();
		PokeList.add(pikachu);
	}
	
	public static void ListarPokes(ArrayList <PokemonPrototype> PokeList){
		for(int i = 0; i < PokeList.size(); i++)
		{
			System.out.println(i + " " + PokeList.get(i).name);
		}
	}
	
	public static void Listar_Meus_Pokes(ArrayList <MyPokeAdapter> meus){
		for(int i = 0; i < meus.size(); i++)
		{
			System.out.println(i + " " + meus.get(i).name);
		}
	}
	
	public static int battle(ArrayList <PokemonPrototype> PokeList, ArrayList <MyPokeAdapter> MyPokes, Backpack bp){
		
		System.out.println("Battle system:");
		
		System.out.println("Choose your pokemon:");
		
		Listar_Meus_Pokes(MyPokes);  
		
		int n = input.nextInt();
		
		int enemy_choice = rand.nextInt(PokeList.size());
		
		System.out.println(MyPokes.get(n).name + " Versus " + PokeList.get(enemy_choice).name);
		
		MyPokeAdapter MyPoke = MyPokes.get(n);
		
		PokemonPrototype EnemyPoke = PokeList.get(enemy_choice);
		
		int x, y;
		
		
		while(MyPoke.Hp > 0 && EnemyPoke.Hp > 0)
		{
			
			x = MyPoke.attack();
			
			EnemyPoke.Hp -= x;
			
			if(EnemyPoke.Hp <= 0)
				{
					EnemyPoke.Hp = 45;
					break;
				}
			
			y = EnemyPoke.attack();
			
			MyPoke.Hp -= y;
			if(MyPoke.Hp <= 0)
				{
					MyPoke.Hp = 0;
					break;
				}
			
			System.out.println("Your " + MyPoke.name + " have " + MyPoke.Hp + " points of life");
			System.out.println("A wild " + EnemyPoke.name + " have " + EnemyPoke.Hp + " points of life");
			
		}
		
		if(MyPoke.Hp > 0)
			{
				System.out.println("You Won!");
				
				System.out.println("Try pokeball? 1 - Y/ 0 - N");
				int ball = input.nextInt();
				if(ball == 1)
				{
					if(bp.pokeball > 0)
					{
						int pokecatch = EnemyPoke.capture();
						if(pokecatch == 1)
						{
							System.out.println("Congratulations you have catch a pokemon");
							
							My_Pokemon poke = new My_Pokemon();
							
							poke.addpokes(PokeList, enemy_choice);
							
							MyPokeAdapter NPoke = new MyPokeAdapter(poke);
							
							MyPokes.add(NPoke);
							
						}
						bp.pokeball--;
						System.out.println("Now you have "+ bp.pokeball + " pokeballs");
					}
					else System.out.println("You have no pokeballs");
				}
			}
		else System.out.println("You lose!");
		
		System.out.println("Battle again? 1 - Y/ 0 - N");
		
		int battle_again = input.nextInt();
		
		return battle_again;
			
	}
	
	public static void healing(Backpack bp, ArrayList<MyPokeAdapter> MyPokes){
		
		for(int i = 0; i < MyPokes.size(); i++)
		{
			System.out.println(i + " " + MyPokes.get(i).name + " Hp: " + MyPokes.get(i).Hp + "/45");
		}
		
		int finish;
		
		while(true){
			System.out.println("Choose a pokemon to cure: ");
			int ncure = input.nextInt();
			
			if(MyPokes.get(ncure).Hp < 45)
			{
				System.out.println("Small potion + 25\nLarge potion + 45\nChoose a potion:\n");
				System.out.println("You have " + bp.potions[0] + " small" + "and " + bp.potions[1] + " large\n");
				System.out.println("0 - small\n1 - large\n");
				int chosepotion = input.nextInt();
				if(bp.potions[chosepotion] > 0)
				{
					int qt_cura = MyPokes.get(ncure).run(chosepotion);
					MyPokes.get(ncure).Hp += qt_cura;
					if(MyPokes.get(ncure).Hp > 45)MyPokes.get(ncure).Hp = 45;
					System.out.println("Now your " + MyPokes.get(ncure).name + " have " + MyPokes.get(ncure).Hp + " points of life");
					
				}
				else System.out.println("Escolha um potion");
			}
			else System.out.println("This pokemon cannot be cured");
			
			System.out.println("Finish? 1 - Y");
			finish = input.nextInt();
			if(finish == 1)break;
		}
	}
	
	public static void screenPlay(){
		
		telaMediator mediador = new telaMediator();
		
		DsColleague ds = new DsColleague(mediador);
		MobileColleague mobile = new MobileColleague(mediador);
		PcColleague pc = new PcColleague(mediador);
		TvColleague tv = new TvColleague(mediador);
		
		mediador.adicionarColleague(ds);
		mediador.adicionarColleague(mobile);
		mediador.adicionarColleague(pc);
		mediador.adicionarColleague(tv);
		
		Display resolucao;
		
		ds.definirResolucao("1 - Oi, podemos jogar no 3DS!");
		System.out.println("=========");
		mobile.definirResolucao("2 - Oi, podemos jogar no Mobile!");
		System.out.println("=========");
		pc.definirResolucao("3 - Oi, podemos jogar no PC!");
		System.out.println("=========");
		tv.definirResolucao("4 - Oi, podemos jogar na Tv!");
		System.out.println();
	
		System.out.println("Selecione sua plataforma!");
		int n = input.nextInt();
		
		if(n == 1) {
			System.out.println("Você escolheu 3Ds!");
			
			resolucao = new DSStrategy();
			resolucao.configurarDisplay(resolucao);
		} else if(n == 2) {
			System.out.println("Você escolheu Celular!");
			
			resolucao = new MobileStrategy();
			resolucao.configurarDisplay(resolucao);
		} else if(n == 3) {
			System.out.println("Você escolheu Computador!");
			
			resolucao = new PCStrategy();
			resolucao.configurarDisplay(resolucao);
		} else if(n == 4) {
			System.out.println("Você escolheu Tv!");
			
			resolucao = new TVStrategy();
			resolucao.configurarDisplay(resolucao);
		} else {
			System.out.println("Por favor, escolha uma opção válida");
			screenPlay();
		}
		
		System.out.println();
		
	}
	
	public static boolean verificarCredencial(String usuario, String senha) {
		
		if(usuario.equals(user) && senha.equals(password)) {
			return true;
		} else return false;
	}

	public static void main(String[] args) {
		
		Boolean verificador = true;
		
		while(verificador) {
			
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("Usuário: ");
			String usuario = scanner.nextLine();
			System.out.print("Senha: ");
			String senha = scanner.nextLine();
			System.out.println("");
			
			if(verificarCredencial(usuario, senha)) {
				verificador = false;
			} else System.out.println("Dados incorretos!\n");
		}
		
		screenPlay();
		
		ArrayList <PokemonPrototype> PokeList = new ArrayList<PokemonPrototype>();
		
		ArrayList <MyPokeAdapter> MyPokes = new ArrayList<MyPokeAdapter>();
		
		Backpack bp = new Backpack();
		
		createPokes(PokeList);
		
		System.out.println("Choose a Pokemon:");
		
		ListarPokes(PokeList);
		
		int n = input.nextInt();
		
		My_Pokemon poke = new My_Pokemon();
		
		poke.addpokes(PokeList, n);
		
		MyPokeAdapter NPoke = new MyPokeAdapter(poke);
		
		MyPokes.add(NPoke);
		
		System.out.println(MyPokes.get(0).name + " is now your pokemon.");
		
		System.out.println("Pokeball - " + bp.pokeball + "\nSmall Potions - " + bp.potions[0] + "\nFood - " + bp.PokeFood);
		
		boolean loop = true;

		while(loop){
			System.out.println("1 - Battle\n2 - Pokedex\n3 - Pokémon\n4 - Bag\n0 - Exit\n");
			int choice = input.nextInt();
			switch(choice){
			case 0:
				
				loop = false;
				break;
				
			case 1:
				int batalhar = 1;
				while(batalhar == 1)
				{
					batalhar = battle(PokeList, MyPokes, bp);
				}
				break;
				
			case 2:
				
				int i, j, k;
				for(i = 1, k = 0; i <= 150; i++){
					for(j = 0; j < MyPokes.size() && k < MyPokes.size(); j++){
						if(MyPokes.get(j).getNumber() == i){
							System.out.println(i + " - " + MyPokes.get(j).getName());
							k++;
						}
					}
					System.out.println(i + " - ?");
				}
				
				break;

			case 3:

				healing(bp, MyPokes);
				break;

				
				default:
					break;
			}
			
		}
		
	}
}
