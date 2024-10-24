package com.shrey.calculatorgdsc;

import static android.provider.Settings.System.getString;

import android.content.Context;
import android.view.View;

import com.synerset.unitility.unitsystem.thermodynamic.Temperature;

public class Test {
    public static void main(String[] args) {
        double value = 298;
        Temperature temperature = Temperature.ofKelvins(value);
        double valueInCelsius = temperature.getInCelsius();
        double valueInKelvin = temperature.getInKelvins();
        double valueInFahrenheit = temperature.getInFahrenheits();
    }
}