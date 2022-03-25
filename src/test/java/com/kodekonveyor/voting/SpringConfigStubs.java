package com.kodekonveyor.voting;

import com.kodekonveyor.SpringConfig;
import org.mockito.Mockito;

public class SpringConfigStubs {

    public static int TEST_MAX_MEASUREMENT_LOOP = 2;

    public static void behaviour(final SpringConfig springConfig) {
        Mockito.doReturn(TEST_MAX_MEASUREMENT_LOOP).when(springConfig).getMaxMeasurementLoops();
    }
}
