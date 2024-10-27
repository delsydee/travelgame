package room;

import java.util.Scanner;

public class TextAdventureGame {
	
	    public static void main(String[] args) {
	        // Initialize rooms
	        Room entrance = new Room("Entrance", "You are at the entrance of a dark cave.");
	        Room hallway = new Room("Hallway", "A narrow hallway with torch-lit walls.");
	        Room treasureRoom = new Room("Treasure Room", "A room glittering with gold and jewels!");

	        // Set up exits
	        entrance.addExit("north", hallway);
	        hallway.addExit("south", entrance);
	        hallway.addExit("east", treasureRoom);
	        treasureRoom.addExit("west", hallway);

	        // Place items in rooms
	        entrance.addItem("Flashlight");
	        treasureRoom.addItem("Gold Coin");

	        // Create player and starting point
	        Player player = new Player(entrance);

	        // Game loop
	        Scanner scanner = new Scanner(System.in);
	        String command;
	        System.out.println("Welcome to the Text Adventure Game!");
	        player.lookAround();

	        while (true) {
	            System.out.print("\nEnter a command (move, look, pick up, inventory, quit): ");
	            command = scanner.nextLine().trim().toLowerCase();
	            String[] commandParts = command.split(" ");

	            if (command.equals("quit")) {
	                System.out.println("Thanks for playing!");
	                break;
	            } else if (commandParts[0].equals("move")) {
	                if (commandParts.length < 2) {
	                    System.out.println("Please specify a direction to move (e.g., 'move north').");
	                } else {
	                    String direction = commandParts[1];
	                    player.move(direction);
	                    player.lookAround();
	                }
	            } else if (command.equals("look")) {
	                player.lookAround();
	            } else if (commandParts[0].equals("pick") && commandParts.length > 1 && commandParts[1].equals("up")) {
	                if (commandParts.length < 3) {
	                    System.out.println("Please specify an item to pick up (e.g., 'pick up flashlight').");
	                } else {
	                    String item = command.substring(8); // Get item after "pick up "
	                    player.pickUp(item);
	                }
	            } else if (command.equals("inventory")) {
	                player.showInventory();
	            } else {
	                System.out.println("Unknown command.");
	            }
	        }
	        scanner.close();
	    }
	}



		
		
