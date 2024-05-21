package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.enums.Direction;

@Data
@AllArgsConstructor
public class Mower {

    private int xAxisPosition;
    private int yAxisPosition;
    private Direction orientation;
    private String instructions;
    private int surfaceWidth;
    private int surfaceHeight;

    @Override
    public String toString() {
        return xAxisPosition + " " + yAxisPosition + " " + orientation;
    }
}
