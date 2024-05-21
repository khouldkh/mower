package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.services.impl.MowerReaderImpl;
import org.example.services.impl.MowerMovementsImp;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        MowerMovementsImp mowerMovementsImp = new MowerMovementsImp(new MowerReaderImpl());
        LOGGER.info("The final positions for programmed mowers are {}",mowerMovementsImp.getMowerFinalPosition());
    }
}