package com.echocharging

import org.junit.Assert.assertEquals
import org.junit.Test

class ChargingCalculatorTest {

    @Test
    fun estimateTimeHours_returnsExpectedValue() {
        val result = ChargingCalculator.estimateTimeHours(
            currentBatteryPercent = 20,
            batterySizeMah = 5000.0,
            chargerPowerWatt = 25.0
        )

        assertEquals(0.70, result, 0.05)
    }
}
