package poketest;

public class MobileStrategy extends Display {

	public Display configurarDisplay(Display display) {
		
		display.altura = 1280;
		display.comprimento = 720;
		
		return display;
	}
}