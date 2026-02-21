# Echo Charging Android App

Echo Charging is a simple Android application that estimates the remaining full-charge time for a phone battery.

## Tech stack
- **Java**: Activity and UI handling logic.
- **Kotlin**: Charging estimation engine.
- **Gradle**: Build and dependency management.
- **AndroidX + Material Components**: UI framework.

## Features
- Enter current battery percentage.
- Enter battery capacity (mAh).
- Enter charger power (W).
- Get estimated charging time in hours.

## Project structure
- `app/src/main/java/com/echocharging/MainActivity.java` – Java UI controller.
- `app/src/main/java/com/echocharging/ChargingCalculator.kt` – Kotlin calculation logic.
- `app/src/main/res/layout/activity_main.xml` – App UI layout.

## Run locally
1. Open this project in Android Studio (Hedgehog or newer).
2. Allow Gradle sync to complete.
3. Run the app on an emulator or Android device (API 24+).

## Test
```bash
./gradlew test
```
