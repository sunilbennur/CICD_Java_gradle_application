package com.echocharging

import kotlin.math.max

object ChargingCalculator {
    private const val BATTERY_VOLTAGE = 3.85
    private const val EFFICIENCY_FACTOR = 0.88

    fun estimateTimeHours(currentBatteryPercent: Int, batterySizeMah: Double, chargerPowerWatt: Double): Double {
        val remainingCapacityMah = batterySizeMah * ((100 - currentBatteryPercent) / 100.0)
        val remainingEnergyWh = (remainingCapacityMah / 1000.0) * BATTERY_VOLTAGE
        val effectivePower = max(chargerPowerWatt * EFFICIENCY_FACTOR, 0.1)

        return remainingEnergyWh / effectivePower
    }
}
