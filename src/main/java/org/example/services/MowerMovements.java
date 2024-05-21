package org.example.services;

import org.example.models.Mower;

public interface MowerMovements {

    String getMowerFinalPosition();

    void executeInstructions(Mower mower);

}
