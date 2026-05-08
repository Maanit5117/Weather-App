# Weather App 

An Android weather app built with Jetpack Compose, Retrofit, MVVM architecture, and the OpenWeatherMap API.

## Features

- Search weather by city name
- Displays temperature, humidity, wind speed, and weather condition
- Clean and minimal UI with a custom background
- Real-time data fetched from OpenWeatherMap API

## Tech Stack

- **Language**: Kotlin
- **UI**: Jetpack Compose
- **Architecture**: MVVM (Model-View-ViewModel)
- **Networking**: Retrofit
- **API**: OpenWeatherMap
- **State Management**: StateFlow + collectAsState

## Screenshots

> Coming soon

## Getting Started

### Prerequisites
- Android Studio Hedgehog or later
- Minimum SDK: 26
- An API key from [OpenWeatherMap](https://openweathermap.org/api)

### Setup

1. Clone the repository
   ```bash
   git clone https://github.com/Maanit5117/Weather-App.git
   ```

2. Open the project in Android Studio

3. Create a `local.properties` file in the root directory and add your API key:
   ```
   WEATHER_API_KEY=your_api_key_here
   ```

4. Build and run the app on an emulator or physical device

## Project Structure

```
app/
└── src/main/java/com/example/weatherapp/
    ├── MainActivity.kt
    ├── WeatherViewModel.kt
    ├── WeatherResponse.kt
    ├── APIInterface.kt
    └── ui/theme/
```

## License

This project is licensed under the MIT License.
