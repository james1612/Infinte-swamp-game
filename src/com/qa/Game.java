package com.qa;

import java.util.Scanner;

public class Game {

    private int gridSize;

    private Player player = new Player();

    private Treasure treasure = new Treasure();


    public void run() {
        createGrid();
        generateCoordinates();
        handleMove();
    }

    public void generateCoordinates() {
        player.setxCoordinate((int) Math.floor(Math.random() * gridSize));
        player.setyCoordinate((int) Math.floor(Math.random() * gridSize));

        treasure.setxCoordinate((int) Math.floor(Math.random() * gridSize));
        treasure.setyCoordinate((int) Math.floor(Math.random() * gridSize));

        if (player.getxCoordinate() == treasure.getxCoordinate() && player.getyCoordinate() == treasure.getyCoordinate()) {
            generateCoordinates();
        }
    }

    public void overEdge(String direction) {
        if (direction == "North") {
            player.setyCoordinate(0);
            if (this.hasWon()) {
                handleWin();
            }
        }
        else if (direction == "South") {
            player.setyCoordinate(gridSize);
            if (this.hasWon()) {
                handleWin();
            }
        }
        else if (direction == "East") {
            player.setxCoordinate(0);
            if (this.hasWon()) {
                handleWin();
            }
        }
        else if (direction == "West") {
            player.setxCoordinate(gridSize);
            if (this.hasWon()) {
                handleWin();
            }
        }
    }

    public void createGrid() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What size grid would you like? The grid created will be zero indexed");
        gridSize = sc.nextInt();
        System.out.println("Grid created1!");
    }

    public void handleMove() {
        System.out.println("You are " + this.findDistance() + " units away from the treasure!");
        System.out.println("Would you like to move North, South, East or West?");
        System.out.println("Enter 1 to go North, 2 to go South, 3 to go East, 4 to go West");

        Scanner sc = new Scanner(System.in);
        int playerMove = sc.nextInt();
        if (playerMove == 1) {
            player.moveNorth();
            if (player.getyCoordinate() == (gridSize+1)) {
                overEdge("North");
            }
            if (this.hasWon()) {
                handleWin();
            }
            else {
                handleMove();
            }
        }
        else if (playerMove == 2) {
            player.moveSouth();
            if (player.getyCoordinate() == (-1)) {
                overEdge("South");
            }
            if (this.hasWon()) {
                handleWin();
            }
            else {
                handleMove();
            }
        }
        else if (playerMove == 3) {
            player.moveEast();
            if (player.getxCoordinate() == (gridSize+1)) {
                overEdge("East");
            }

            if (this.hasWon()) {
                handleWin();
            }
            else {
                handleMove();
            }
        }
        else if (playerMove == 4) {
            player.moveWest();
            if (player.getxCoordinate() == (-1)) {
                overEdge("West");
            }
            if (this.hasWon()) {
                handleWin();
            }
            else {
                handleMove();
            }
        }
        else {
            System.out.println("Please enter a valid move!");
            handleMove();
        }
    }

    public void handleWin() {
        System.out.println("Congratulations. You have won!");
        System.out.println("Starting again...");
        run();
    }

    public boolean hasWon() {
        if (player.getxCoordinate() == treasure.getxCoordinate() && player.getyCoordinate() == treasure.getyCoordinate()) {
            return true;
        }
        return false;
    }

    // Dont know how to square in java
    public double findDistance() {
        return Math.sqrt((treasure.getxCoordinate() - player.getxCoordinate()) + (treasure.getyCoordinate() - player.getyCoordinate()));
    }


    // used for testing app
    public void displayInformation() {
        System.out.println("the players coordinates are: " + player.getxCoordinate() + " " + player.getyCoordinate());
        System.out.println("the treasures coordinates are: " + treasure.getxCoordinate() + " " + treasure.getyCoordinate());

    }



}
