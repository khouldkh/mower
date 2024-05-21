package org.example.services.impl;

import org.example.enums.Direction;
import org.example.models.Mower;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MowerMovementsImpTest {
    private MowerMovementsImp mowerMovementsImp;
    private MowerReaderImpl mowerReaderImpl;

    @BeforeEach
    public void setUp() {
        mowerReaderImpl = mock(MowerReaderImpl.class);
        mowerMovementsImp = new MowerMovementsImp(mowerReaderImpl);
    }

    @Test
    void testExecuteInstructions() {
        Mower mower1 = new Mower(1, 2, Direction.N, "GAGAGAGAA", 5, 5);

        mowerMovementsImp.executeInstructions(mower1);

        assertEquals(1, mower1.getXAxisPosition());
        assertEquals(3, mower1.getYAxisPosition());
        assertEquals(Direction.N, mower1.getOrientation());
    }

    @Test
    public void testGetMowerFinalPosition_NoMowers() {
        when(mowerReaderImpl.setAllMowers()).thenReturn(Collections.emptyList());

        String result = mowerMovementsImp.getMowerFinalPosition();

        assertEquals("You have not configure any mower! please check the input file!", result);
    }

    @Test
    public void testGetMowerFinalPosition_WithMowers() {
        Mower mower1 = new Mower(1, 2, Direction.N, "GAGAGAGAA", 5, 5);
        Mower mower2 = new Mower(3, 3, Direction.E, "AADAADADDA", 5, 5);
        List<Mower> mowers = Arrays.asList(mower1, mower2);
        when(mowerReaderImpl.setAllMowers()).thenReturn(mowers);

        String result = mowerMovementsImp.getMowerFinalPosition();

        assertEquals("1 3 N 5 1 E", result);
    }

}