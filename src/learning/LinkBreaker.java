package learning;

import java.util.ArrayList;
import java.util.List;


public class LinkBreaker {

	public static void main (String[] args) {

		String id = "";
		List<String> idList = new ArrayList<>();
		String[] links = { 
			"https://www.wowhead.com/item=208176/plate-of-the-light-avenger",
				"https://www.wowhead.com/item=208177/armaments-of-the-light-avenger",
				"https://www.wowhead.com/item=208178/secrets-of-the-unnamed-cult",
				"https://www.wowhead.com/item=208405/blood-onyx-uniform",
				"https://www.wowhead.com/item=208179/blood-onyx-blades",
				"https://www.wowhead.com/item=208045/slyvy",
				"https://www.wowhead.com/item=190698/gently-used-cleaver",
				"https://www.wowhead.com/item=190699/gorian-mining-pick",
				"https://www.wowhead.com/item=189895/watchmans-flare",
				"https://www.wowhead.com/item=206332/ensemble-wanderers-sunny-trappings",
				"https://www.wowhead.com/item=206321/ensemble-vagabonds-sunny-threads",
				"https://www.wowhead.com/item=208148/burgundy-cap",
				"https://www.wowhead.com/item=208147/yellow-tweed-cap",
				"https://www.wowhead.com/item=189882/dread-admirals-bicorne",
				"https://www.wowhead.com/item=190144/irontide-raiders-bicorne",
				"https://www.wowhead.com/item=190712/ancestral-skychaser-totem",
				"https://www.wowhead.com/item=190693/ancestral-stonehoof-totem",
				"https://www.wowhead.com/item=208423/homebrewers-sampling-crest",
				"https://www.wowhead.com/item=190799/ensemble-swashbuckling-buccaneers-slops",
				"https://www.wowhead.com/item=190155/trusty-treasure-trove",
				"https://www.wowhead.com/item=208400/silks-of-the-unnamed-cult"
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
