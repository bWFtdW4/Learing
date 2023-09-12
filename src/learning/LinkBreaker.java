package learning;

import java.util.ArrayList;
import java.util.List;


public class LinkBreaker {

	public static void main (String[] args) {

		String id = "";
		List<String> idList = new ArrayList<>();
		String[] links = { "https://www.wowhead.com/npc=27217/spirit-of-competition",
			"https://www.wowhead.com/item=206268/ethereal-transmogrifier",
			"https://www.wowhead.com/spell=302362/alabaster-thunderwing",
			"https://www.wowhead.com/spell=302361/alabaster-stormtalon",
			"https://www.wowhead.com/item=207821/ancestral-clefthoof",
			"https://www.wowhead.com/item=190870/city-guard-heater-shield",
			"https://www.wowhead.com/item=190871/grunts-buckler",
			"https://www.wowhead.com/item=208040/queens-conservatory-ball-gloves",
			"https://www.wowhead.com/item=208039/ember-court-soiree-gloves",
			"https://www.wowhead.com/item=190576/ensemble-vagabonds-azure-threads",
			"https://www.wowhead.com/item=190577/ensemble-wanderers-azure-trappings",
			"https://www.wowhead.com/item=190851/ensemble-vagabonds-crimson-threads",
			"https://www.wowhead.com/item=190850/ensemble-wanderers-crimson-trappings",
			"https://www.wowhead.com/item=190071/azure-scalesworn-longbow",
			"https://www.wowhead.com/item=190143/shard-of-frozen-secrets",
			"https://www.wowhead.com/item=190812/azure-nexus-crescent",
			"https://www.wowhead.com/item=190438/crimson-nexus-crescent",
			"https://www.wowhead.com/item=207957/aquamarine-felfire-bulwark",
			"https://www.wowhead.com/item=207959/aquamarine-felfire-splitblade",
			"https://www.wowhead.com/item=190910/ruby-felfire-bulwark",
			"https://www.wowhead.com/item=190909/ruby-felfire-splitblade",
			"https://www.wowhead.com/item=95475/crown-of-eternal-winter",
			"https://www.wowhead.com/item=97213/hood-of-hungering-darkness",
			"https://www.wowhead.com/item=190078/blade-of-brutal-sacrifice",
			"https://www.wowhead.com/item=189898/fury-of-the-firelord"
		};

		//loop for links
		for (int i = 0; i < links.length; i++) {
			//empty id
			id = "";
			id = links[i].replaceAll("[^0-9]+", "");
			idList.add(id);
		}
		System.out.println("checked : " + links.length + " links.");
		System.out.println("Filtered: " + idList.size() + " id's!");
		//print list
		for (String string : idList) {
			System.out.print("\n"+string);			
		}
	}
	

	public void clean1 () {
		String link = "https://www.wowhead.com/npc=27217/spirit-of-competition";
		String id1 = "";

		for (int i = 0; i <= link.length() - 1; i++) {
			System.out.print(" " + link.charAt(i));
			//if (link.charAt(i) >= 0 || link.charAt(i) <= 9) {
			//if ((int) link.charAt(i) >= 0 && (int)link.charAt(i) <= 9) {
			//if ((Integer.parseInt(link) >= 0) && (Integer.parseInt(link) <= 9)){
			char cc = link.charAt(i);
			if (Character.isDigit(cc)) {
				id1 = id1 + link.charAt(i);
				//System.out.println(">" + id);
			} /*
				 * else { System.out.print("no"); }
				 */
		}
		System.out.println("___");
		System.out.println("result: " + id1);
	}
	
	public void clean2 () {
		String id = "";
		List<String> idList = new ArrayList<>();
		String[] links = { "" };

		//loop for links
		for (int i = 0; i < links.length; i++) {
			//empty id
			id = "";
			//loop for char in links[i]
			for (int j = 0; j < links[i].length(); j++) {
				System.out.print("" + links[i].charAt(j));
				char c = links[i].charAt(j);
				if (Character.isDigit(c)) {
					id += c;
				}
			}
			idList.add(id);
			System.out.println("");
		}
		System.out.println("checked : " + links.length + " links.");
		System.out.println("Filtered: " + idList.size() + " id's!");
		//print list
		for (String string : idList) {
			System.out.print("\n"+string);			
		}
	}
	
	
	
	
}
