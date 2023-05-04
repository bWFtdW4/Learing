package monster;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyMonsterTeam {
	private List<Map<String,Object>> playerMonsterTeam = new ArrayList<>();
	private List<Map<String,Object>> monsterList = new ArrayList<>();

	
	private MonsterController controller;
	private Player thePlayer;

	
	MyMonsterTeam(){
		//this.playerMonsterTeam = controller.playerMonsterTeam;
		//this.monsterList = controller.monsterList;
		
	}
	
	
	
	public List<Map<String,Object>> getplayerMonsterTeam() {
		return this.playerMonsterTeam;
	}

	public String getPlayername () {
		String nameString = this.controller.plsgetname();
		return nameString; 
	}
	
	public void showMyTeam () {
		//System.out.println(getPlayername() + "'s Team:");
		System.out.println("The Team:");
		for (Map<String,Object> monster : controller.playerMonsterTeam) {
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
	
}
