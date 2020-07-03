package com.techelevator;

import javax.management.remote.rmi._RMIConnection_Stub;

public class FruitTree {

    private String typeOfFruit;
    private int piecesOfFruitLeft;

    public FruitTree(String typeOfFruit, int startingPiecesOfFruit){
        this.piecesOfFruitLeft = startingPiecesOfFruit;
        this.typeOfFruit = typeOfFruit;
    }

    public int getPiecesOfFruitLeft() {
        return piecesOfFruitLeft;
    }

    public String getTypeOfFruit() {
        return typeOfFruit;
    }

    public boolean pickFruit(int numberOfPiecesToRemove){
        if (piecesOfFruitLeft > 0) {
            piecesOfFruitLeft -= numberOfPiecesToRemove;
            return true;
        } else {
            return false;
        }

    }
}
