package poketest;

public class TVStrategy extends Display {
	
	public Display configurarDisplay(Display display) {
		
		display.altura = 2160;
		display.comprimento = 4096;
		
		return display;
	}
}
