package monsterTest;

import java.io.IOException;

public class App {
	
	
	public static void main (String[] args) throws IOException {
		final Controller controller = new Controller();
		controller.eventSource().execute();
	}
}
