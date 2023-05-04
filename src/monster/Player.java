package monster;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Player {

	//private MyMonsterTeam myMonsterTeam;
	//private MonsterController controller;
	//private final List<Map<String,Object>> playerMonsterTeam = new ArrayList<>();
	
	private String playerName;
	private int playerLevel;
	private int playerExp;

	
	Player(){		
		this.playerName = "name";
		this.playerLevel = 1;
		this.playerExp = 0;
		
		
	}

	public String getPlayerName () {
		System.out.println("----Log getPlayername: " + this.playerName);
		return playerName;
	}

	public void setPlayerName (String parameterization) {
		System.out.println("starting name change...");
		this.playerName = "mango";
		System.out.println(this.playerName);
		String asdString = parameterization;
		System.out.println("new playername is : " + asdString);
		this.playerName = asdString;
		
		
		//this.playerName = parameterization;
		//System.out.println("----Log setPlayername: " + this.playerName);
		
	}

	public int getPlayerLevel () {
		return this.playerLevel;
	}

	public void setPlayerLevel (int playerLevel) {
		this.playerLevel = playerLevel;
	}
	
	
	
}
