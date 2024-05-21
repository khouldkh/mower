package org.example.services.impl;

import org.example.models.Mower;
import org.example.services.MowerReader;
import org.example.services.MowerMovements;

import java.util.List;

public class MowerMovementsImp implements MowerMovements {

    private final MowerReader mowerReader;

    public MowerMovementsImp(MowerReader mowerReaderImp) {
        this.mowerReader = mowerReaderImp;
    }

    @Override
    public String getMowerFinalPosition() {
        List<Mower> mowers = mowerReader.setAllMowers();
        if (mowers.isEmpty()) return "You have not configure any mower! please check the input file!";
        StringBuilder finalPositions = new StringBuilder();
        for (Mower mower : mowers) {
            executeInstructions(mower);
            finalPositions.append(mower).append(" ");
        }
        return finalPositions.toString();
    }

    @Override
    public void executeInstructions(Mower mower) {
        for (char instruction : mower.getInstructions().toCharArray()) {
            switch (instruction) {
                case 'G':
                    turnLeft(mower);
                    break;
                case 'D':
                    turnRight(mower);
                    break;
                case 'A':
                    moveForward(mower);
                    break;
            }
        }
    }

    private void turnLeft(Mower mower) {
        mower.setOrientation(mower.getOrientation().turnLeft());
    }

    private void turnRight(Mower mower) {
        mower.setOrientation(mower.getOrientation().turnRight());
    }

    private void moveForward(Mower mower) {
        int newX = mower.getXAxisPosition(), newY = mower.getYAxisPosition();
        switch (mower.getOrientation()) {
            case N -> newY++;
            case E -> newX++;
            case S -> newY--;
            case W -> newX--;
        }

        if (newX >= 0 && newX <= mower.getSurfaceHeight() && newY >= 0 && newY <= mower.getSurfaceHeight()) {
            mower.setXAxisPosition(newX);
            mower.setYAxisPosition(newY);
        }
    }
}
