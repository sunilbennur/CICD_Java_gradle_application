package com.echocharging;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.echocharging.databinding.ActivityMainBinding;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.calculateButton.setOnClickListener(view -> calculateChargingTime());
    }

    private void calculateChargingTime() {
        String batteryPercentInput = binding.currentBatteryInput.getText().toString().trim();
        String batterySizeInput = binding.batterySizeInput.getText().toString().trim();
        String chargerPowerInput = binding.chargerPowerInput.getText().toString().trim();

        if (batteryPercentInput.isEmpty() || batterySizeInput.isEmpty() || chargerPowerInput.isEmpty()) {
            Toast.makeText(this, R.string.input_error, Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            int currentBatteryPercent = Integer.parseInt(batteryPercentInput);
            double batterySizeMah = Double.parseDouble(batterySizeInput);
            double chargerPowerWatt = Double.parseDouble(chargerPowerInput);

            if (currentBatteryPercent < 0 || currentBatteryPercent > 100 || batterySizeMah <= 0 || chargerPowerWatt <= 0) {
                Toast.makeText(this, R.string.validation_error, Toast.LENGTH_SHORT).show();
                return;
            }

            double estimatedHours = ChargingCalculator.INSTANCE.estimateTimeHours(currentBatteryPercent, batterySizeMah, chargerPowerWatt);
            String result = String.format(Locale.getDefault(), getString(R.string.result_template), estimatedHours);
            binding.resultText.setText(result);
        } catch (NumberFormatException numberFormatException) {
            Toast.makeText(this, R.string.validation_error, Toast.LENGTH_SHORT).show();
        }
    }
}
