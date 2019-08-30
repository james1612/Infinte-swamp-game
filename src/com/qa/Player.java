package com.qa;

public class Player {


    private int xCoordinate;
    private int yCoordinate;

//    public Player(int xCoordinate, int yCoordinate) {
//        this.xCoordinate = xCoordinate;
//        this.yCoordinate = yCoordinate;
//    }

    public int getxCoordinate() {
        return xCoordinate;

    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;

    }

    public int getyCoordinate() {
        return yCoordinate;

    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;

    }


    public void moveNorth() {
        this.yCoordinate += 1;

    }

    public void moveSouth() {
        this.yCoordinate -= 1;

    }

    public void moveWest() {
        this.xCoordinate -= 1;

    }

    public void moveEast() {
        this.xCoordinate += 1;

    }

}
