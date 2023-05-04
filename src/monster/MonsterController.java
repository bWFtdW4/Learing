package monster;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import edu.damago.jdb.tool.ConsoleEventSource;
import edu.damago.jdb.tool.JSON;


public class MonsterController {

	public final List<Map<String,Object>> monsterList = new ArrayList<>();
	public final List<Map<String,Object>> playerMonsterTeam = new ArrayList<>();
		
	//private String playerName;
	private double currentBattleMonsterId;

	private final ConsoleEventSource eventSource;

	private Player thePlayer;
	private MyMonsterTeam myMonsterTeam;
	private Battle battle;


	public double getCurrentBattleMonsterId () {
		return currentBattleMonsterId;
	}

	public void setCurrentBattleMonsterId (double currentBattleMonsterId) {
		this.currentBattleMonsterId = currentBattleMonsterId;
	}

	public Player getThePlayer () {
		return thePlayer;
	}

	public void setThePlayer (Player thePlayer) {
		this.thePlayer = thePlayer;
	}

	public MyMonsterTeam getMyMonsterTeam () {
		return myMonsterTeam;
	}

	public void setMyMonsterTeam (MyMonsterTeam myMonsterTeam) {
		this.myMonsterTeam = myMonsterTeam;
	}

	public Battle getBattle () {
		return battle;
	}

	public void setBattle (Battle battle) {
		this.battle = battle;
	}

	public List<Map<String,Object>> getMonsterList () {
		return monsterList;
	}

	public List<Map<String,Object>> getPlayerMonsterTeam () {
		return playerMonsterTeam;
	}

	public ConsoleEventSource getEventSource () {
		return eventSource;
	}

	MonsterController () {
		this.thePlayer = new Player();
		this.myMonsterTeam = new MyMonsterTeam();
		this.eventSource = new ConsoleEventSource();

		try {
			performAutoLoadMonsterListCommand();
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gameMenuTitle();

		this.eventSource.addEventListener("loadgame", parameterization -> this.loadGame());
		this.eventSource.addEventListener("savegame", parameterization -> this.performSaveGameCommand());
		this.eventSource.addEventListener("newgame", parameterization -> this.performNewGame());

		//this.eventSource.addEventListener("name", parameterization -> this.choosePlayerName(parameterization));
		this.eventSource.addEventListener("name", parameterization -> createPlayer(parameterization));
		this.eventSource.addEventListener("namethis", parameterization -> thePlayer.setPlayerName(parameterization));

		this.eventSource.addEventListener("selectmonster", parameterization -> this.chooseFirstMonster());

		this.eventSource.addEventListener("choose", parameterization -> this.selectMonsterChooseMonster(parameterization));
		this.eventSource.addEventListener("myteam", parameterization -> myMonsterTeam.showMyTeam());
		this.eventSource.addEventListener("battle", parameterization -> battle.performBattlePrep());
		this.eventSource.addEventListener("bb", parameterization -> battle.generateBattleMonster());

		
		
		this.eventSource.addEventListener("auto", parameterization -> this.performAutoLoadMonsterListCommand());

		this.eventSource.addEventListener("loadlist", parameterization -> this.loadMonsterList(parameterization));

		this.eventSource.addEventListener("show", parameterization -> this.displayMonster(parameterization));
		this.eventSource.addEventListener("showid", parameterization -> this.displayMonsterById(parameterization));

		//this.eventSource.addEventListener("load", parameterization -> this.performLoadMultiCommand(parameterization));
		//this.eventSource.addEventListener("load1", parameterization -> this.performLoadSingelCommand(parameterization));
		//this.eventSource.addEventListener("loadm", parameterization -> this.performLoadMonster(parameterization));
		//this.eventSource.addEventListener("save", parameterization -> this.performSaveSingelCommand(parameterization));
		//this.eventSource.addEventListener("saveall", parameterization -> this.performSaveMultiCommand(parameterization));
		//this.eventSource.addEventListener("update", parameterization -> this.performUpdateCommand(parameterization));
		//this.eventSource.addEventListener("del", parameterization -> this.performRemoveThisCommand(parameterization));
		//this.eventSource.addEventListener("remove", parameterization -> this.performRemoveSelectedCommand(parameterization));
		//this.eventSource.addEventListener("delete", parameterization -> this.performRemoveSingelCommand(parameterization));
		//this.eventSource.addEventListener("help", parameterization -> this.performHelpCommand(parameterization));
		//this.eventSource.addEventListener("add", parameterization -> this.performAddTestData(parameterization));
		//this.eventSource.addEventListener("display", parameterization -> this.performDisplayMonsterListCommand(parameterization));
		this.eventSource.addEventListener("plsgetname", parameterization -> this.plsgetname());
		this.eventSource.addEventListener("plsgetname2", parameterization -> myMonsterTeam.getplayerMonsterTeam());
		this.eventSource.addEventListener("showteam", parameterization -> showMyLocalTeam());
		
	}

	public String plsgetname () {
	//System.out.println("playername" + thePlayer.getPlayerName());
	System.out.println("this.playername" + this.thePlayer.getPlayerName());
	return this.thePlayer.getPlayerName();
	}
	

	public void loadMonsterList (final String parameterization) throws IOException {

		final Path filePath = Paths.get(parameterization);

		//single-line alternative:
		final String json = Files.readString(filePath, StandardCharsets.UTF_8);
		final List<Map<String,Object>> people = JSON.parse(json);
		this.monsterList.clear();
		this.monsterList.addAll(people);
		System.out.println("complete..");
	}


	public void performLoadMonster (final String parameterization) throws NullPointerException, IOException {
		final Path filePath = Paths.get(parameterization);

		// multi-line alternative:
		final List<String> lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);
		this.monsterList.clear();

		for (final String json : lines) {
			final Map<String,Object> monster = JSON.parse(json);
			if (monster.containsKey("id")) this.monsterList.add(monster);
			else System.err.println("warning: skipped JSON line for lack of id attribute!");
		}
		System.out.println("loading completetd");
	}


	public void displayMonster (final String parameterization) {
		for (Map<String,Object> monster : this.monsterList) {
			System.out.println(JSON.stringify(monster));
		}
	}


	public void displayMonsterById (final String parameterization) {

		System.out.println("loading :" + parameterization);
		for (Map<String,Object> monster : this.monsterList) {
			double id = Double.parseDouble(parameterization);
			if ((double) monster.get("id") == id) {
				System.out.println("monster: " + JSON.stringify(monster));
			} else {
				System.out.println("monster: " + JSON.stringify(monster));

			}

		}
	}
	
	
	public void showMyLocalTeam () {
		//System.out.println(getPlayername() + "'s Team:");
		System.out.println("The Team:");
		for (Map<String,Object> monster : this.playerMonsterTeam) {
			System.out.println("Nr. " + monster.get("id")
							+ "| Name: " + monster.get("name")	
							+ "| HP: " + monster.get("hp")
							+ "| Attack: " + monster.get("attack") 
							+ "| Speed: " + monster.get("speed") 
							+ "| Height: " + monster.get("height")
							+ "| Weight: " + monster.get("weight")
							+ "| Type1: " + monster.get("type1")
							+ "| Type2: " + monster.get("type2")

				);
		}
		}


	/**
	 * Returns the root view.
	 * @return the view component
	 */
	public ConsoleEventSource eventSource () {
		return this.eventSource;
	}


	/**
	 * Performs the display command.
	 * @param parameterization the command parameterization, empty for none
	 * @throws NullPointerException if the given parameterization is null
	 */
	public void performDisplayCommand (final String parameterization) throws NullPointerException {
		for (final Map<String,Object> monster : this.monsterList)
			System.out.println(JSON.stringify(monster));

		System.out.println("display complete...");
	}


	/**
	 * [savegame]
	 * monsterSaveGamePlayer: player info monsterSaveGameDex: player team.
	 * @throws NullPointerException
	 */
	public void performSaveGameCommand () throws NullPointerException {

		final Path filePathDex = Paths.get("C:\\Java\\M\\data\\monsterSaveGameDex");
		final Path filePathPlayer = Paths.get("C:\\Java\\M\\data\\monsterSaveGamePlayer");

		//player
		StringBuilder contenBuilder = new StringBuilder();
		contenBuilder.append(thePlayer.getPlayerName()).append("\n");
		String playerContent = contenBuilder.toString();
		try {
			Files.writeString(filePathPlayer, playerContent, StandardCharsets.UTF_8);
			System.out.println("saving..");
		} catch (IOException e) {
			System.out.println("error not saved!");
			e.printStackTrace();
		}

		//dex
		try {
			final List<String> fileLines = new ArrayList<>();
			for (final Map<String,Object> myMonster : this.playerMonsterTeam)
				fileLines.add(JSON.stringify(myMonster));
			Files.write(filePathDex, fileLines, StandardCharsets.UTF_8);
			System.out.println("complete..");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("error not saved!");
		}

	}

	
	//[loadgame]
	public void loadGame () throws NullPointerException, IOException {
		//Player thePlayer = new Player();
		
		final Path filePathDex = Paths.get("C:\\Java\\M\\data\\monsterSaveGameDex");
		final Path filePathPlayer = Paths.get("C:\\Java\\M\\data\\monsterSaveGamePlayer");

		//player
		String content = Files.readString(filePathPlayer);
		String[] playerContent = content.split("\n");
		//this.playerName = playerContent[0];
		String playerNameString = playerContent[0];
		this.thePlayer.setPlayerName(playerNameString);
		System.out.println("----Log loadGame() thePlayer.getPlayerName(): " + thePlayer.getPlayerName());

		final List<String> fileLines = Files.readAllLines(filePathDex, StandardCharsets.UTF_8);
		//this.myTeam.clear();
		this.playerMonsterTeam.clear();

		for (final String lines : fileLines) {
			final Map<String,Object> myMonster = JSON.parse(lines);
			if (myMonster.containsKey("id")) this.playerMonsterTeam.add(myMonster);
			else System.err.println("loading error!");
		}

		welcomeBackPlayer();
	}


	/**
	 * Performs the auto load command from fixed path
	 * @param parameterization the command parameterization, empty for none
	 * @throws NullPointerException if the given parameterization is null
	 * @throws IOException if there is an I/O related problem
	 */
	public void performAutoLoadMonsterListCommand () throws NullPointerException, IOException {

		String parameterization2 = "C:\\\\Java\\\\M\\\\data\\\\monsteList2Full";
		//System.out.println("loading... C:\\Java\\M\\data\\monsteList2Full");
		//final Path filePath = Paths.get(parameterization2);

		final Path filePath = Paths.get(parameterization2);

		final List<String> lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);
		this.monsterList.clear();
		System.out.println("log: loading..." + filePath);
		for (final String line : lines) {
			final Map<String,Object> monster = JSON.parse(line);
			if (monster.containsKey("id")) this.monsterList.add(monster);
			else System.err.println("log: warning: error while loading!");
		}

	}


	public void gameMenuTitle () {
		System.out.println("The Monster Game!");
		System.out.println("[newgame] [savegame] [loadgame] ");
	}


	public void gameMenuShowOptions () {
		System.out.println("[myteam] [battle]");
	}
	
	public void gameMenuBattle () {
		System.out.println("[attack] [run]");

	}



	public void welcomeBackPlayer () {
		System.out.println("Hello " + thePlayer.getPlayerName() + "!");
		gameMenuShowOptions();
	}

	//[newgame]
	public void performNewGame () {
		System.out.println("new game starting..");
		System.out.println("What's your name?");
		System.out.println("use [name] [your name]");
	}
	
	//[name]
	public void createPlayer (String playerName) {
		this.thePlayer.setPlayerName(playerName);
		this.thePlayer.setPlayerLevel(1);
		chooseFirstMonster();
		
	}

	public void choosePlayerName (final String parameterization) {
		chooseFirstMonster();
		this.thePlayer.setPlayerName(parameterization);
		//setPlayerName(parameterization);
		System.out.println("set player done choooooooos???");
		chooseFirstMonster();
		System.out.println("asdasd");
	}


	public void chooseFirstMonster () {
		System.out.println("Choose a monster from the list:");
		for (Map<String,Object> monster : monsterList) {
			System.out.println("Nr. " + monster.get("id") + " " + monster.get("name"));
		}
		System.out.println("use [choose] + [Nr.]");
	}


	//[choose]
	public void selectMonsterChooseMonster (final String parameterization) {
		System.out.println("You choose: " + parameterization);
		final double id = Double.parseDouble(parameterization);

		//add the check nr
		for (Map<String,Object> monster : this.monsterList) {
			if (monster.get("id").equals(id)) {
				System.out.println(monster.get("name") + " " + monster.get("id"));
				this.playerMonsterTeam.add(monster);
			}
		}
		System.out.println("You have " + playerMonsterTeam.size() + " monster in your team!");
		gameMenuTitle();
		gameMenuShowOptions();

	}


	
}
