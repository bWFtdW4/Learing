package monsterTest;

public class Controller {

	private final ConsoleEventSource eventSource;
	private Player player;
	private Team team;
	


	Controller () {
		this.eventSource = new ConsoleEventSource();
		this.player = new Player();
		gameMenu();

		this.eventSource.addEventListener("0", parameterization -> QuitGame());
		this.eventSource.addEventListener("1", parameterization -> gameMenu());

		/**
		 * this.eventSource.addEventListener("getname", parameterization -> getname());
		 * this.eventSource.addEventListener("setname", parameterization -> setname(parameterization));
		 * this.eventSource.addEventListener("getname2", parameterization -> player.getPlayerName());
		 * this.eventSource.addEventListener("setname2", parameterization -> player.setPlayerName(parameterization));
		 * this.eventSource.addEventListener("getname3", parameterization -> team.getPlayerName());
		 * this.eventSource.addEventListener("setname3", parameterization -> team.setPlayerName(parameterization));
		 **/
	}


	/**
	 * Returns the root view.
	 * @return the view component
	 */
	public ConsoleEventSource eventSource () {
		return this.eventSource;
	}


	public void QuitGame () {
		System.out.println("Bye Bye!");
		System.exit(0);
	}


	public void gameMenu () {

		System.out.println("Welcome Player! \t Level: " + player.getPlayerLevel() + " exp: " + player.getPlayerExp());
		System.out.println("1. Menu\n0. Exit\n");
		System.out.println("Choose an option");
	}
	
	
	public void monsterInTeam() {
		System.out.println("Nr. \t ");
	}

}
