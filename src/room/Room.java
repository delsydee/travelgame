package room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Room {
    private String name;
    private String description;
    private HashMap<String, Room> exits;
    private ArrayList<String> items;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.exits = new HashMap<>();
        this.items = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void addExit(String direction, Room room) {
        exits.put(direction, room);
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }

    public void addItem(String item) {
        items.add(item);
    }

    public boolean hasItem(String item) {
        return items.contains(item);
    }

    public void removeItem(String item) {
        items.remove(item);
    }

    public void showItems() {
        if (items.isEmpty()) {
            System.out.println("No items here.");
        } else {
            System.out.println("Items in this room: " + items);
        }
    }
}

class Player {
    private Room currentRoom;
    private ArrayList<String> inventory;

    public Player(Room startingRoom) {
        this.currentRoom = startingRoom;
        this.inventory = new ArrayList<>();
    }

    public void move(String direction) {
        Room nextRoom = currentRoom.getExit(direction);
        if (nextRoom != null) {
            currentRoom = nextRoom;
            System.out.println("You moved to: " + currentRoom.getName());
        } else {
            System.out.println("You can't go that way!");
        }
    }

    public void pickUp(String item) {
        if (currentRoom.hasItem(item)) {
            inventory.add(item);
            currentRoom.removeItem(item);
            System.out.println("You picked up: " + item);
        } else {
            System.out.println("No such item here!");
        }
    }

    public void showInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("Your inventory: " + inventory);
        }
    }

    public void lookAround() {
        System.out.println(currentRoom.getDescription());
        currentRoom.showItems();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
}

