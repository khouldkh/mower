package org.example.services.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.enums.Direction;
import org.example.models.Mower;
import org.example.services.MowerReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MowerReaderImpl implements MowerReader {

    private static final Logger LOGGER = LogManager.getLogger(MowerReaderImpl.class);

    private static final String INPUT_FILE_PATH = "src/main/resources/mowers_program.txt";

    @Override
    public List<Mower> setAllMowers() {

        List<Mower> mowers = new ArrayList<>();
        try {
            File file = new File(INPUT_FILE_PATH);
            Scanner scanner = new Scanner(file);
            int surfaceWidth = scanner.nextInt();
            int surfaceHeight = scanner.nextInt();

            while (scanner.hasNext()) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                Direction orientation = Direction.valueOf(scanner.next());
                String instructions = scanner.next();
                Mower mower = new Mower(x, y, orientation, instructions, surfaceWidth, surfaceHeight);
                mowers.add(mower);
            }
            scanner.close();
        } catch (Exception e) {
            LOGGER.error("The input file not well formatted !");
            e.printStackTrace();
        }
        return mowers;
    }

}
