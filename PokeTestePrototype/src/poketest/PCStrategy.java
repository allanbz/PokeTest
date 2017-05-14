package poketest;

public class PCStrategy extends Display {

	public Display configurarDisplay(Display display) {
		
		display.altura = 1920;
		display.comprimento = 1080;
		
		return display;
	}
}
