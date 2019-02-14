import java.util.Scanner;

public class Burrow{

	public static void main(String[] args) {
		System.out.println("Hello, and welcome to My Game!\nLets start by making a character.");
		
		//Get Player race
		int race = 0, type =0;
		Scanner kb = new Scanner(System.in);
		boolean rbad = true, tbad = true;
		while(rbad){
			System.out.print("Are you a halfling, elf, or gnome? ");
			String playerRace = kb.next();
			if (playerRace.contains("halfling")){
				race = 1;
				rbad = false;
			}
			else if (playerRace.contains("elf")){
				race = 2;
				rbad = false;
			}
			else if (playerRace.contains("gnome")){
				race = 3;
				rbad = false;
			}
			else{
				System.out.print("ERROR, halfling, elf, or gnome. ");
				rbad = true;
			}
		}
		
		//Get Player Type
		while(tbad){
			System.out.print("Are you a knight, scout, or spellsword? ");
			String playerType = kb.next();
			if (playerType.contains("knight")){
				type = 1;
				tbad = false;
			}
			else if (playerType.contains("scout")){
				type = 2;
				tbad = false;
			}
			else if (playerType.contains("spellsword")){
				type = 3;
				tbad = false;
			}
			else{
				System.out.print("ERROR, please type knight, scout, or spellsword. ");
				tbad = true;
			}
		}
		Character player = new Character(race, type);
		
		//Begin!
		System.out.println("\nAlright! Let's begin:\nYour current health is: "+player.currentHealth()+". You have "+ player.potions()+" potions left.\n"
				+ "You are talking a walk when you notice a dark cave opening with old bones\n"
				+ "littered about the opening. Who knows what treasures could lay within!\n"
				+ "You enter.\n");
		
		Stage dungeon = new Stage(player);

	}

}
