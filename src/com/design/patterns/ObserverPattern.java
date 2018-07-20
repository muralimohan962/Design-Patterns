package com.design.patterns;

import java.util.ArrayList;

/**
 * This interface must be implemented by any class that wants to be an Observer for some Observable object.
 */
interface Observer {
    void update(double temperature, double pressure, double humidity);
}

/**
 * This interface must be implemented by any class that wants to be an Observable for some data.
 */
interface Observable {
    /**
     * Lets you register an observer to get notified of data changes.
     *
     * @param observer the observer to be notified when data changes.
     */
    void addObserver(Observer observer);

    /**
     * Lets you remove an observer from this Observable.
     *
     * @param observer the observer to be removed.
     */
    void removeObserver(Observer observer);

    /**
     * Lets you notify observers.
     */
    void notifyObservers();
}

/**
 * One such class which is acting as an Observable.
 */
class WeatherStation implements Observable {
    private double temperature = 0.0;
    private double pressure = 0.0;
    private double humidity = 0.0;

    // Here the Weather Station stores its observers.
    private ArrayList<Observer> myObservers = new ArrayList<>();

    @Override // This is just an annotation used for assisting tools for program development. Use can remove it if you wish so.
    public void addObserver(Observer observer) {
        myObservers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        myObservers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : myObservers)
            observer.update(temperature, pressure, humidity);
    }

    void updateWeatherData(double temperature, double pressure, double humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;

        // After updating the data we notify the observers.
        notifyObservers();
    }
}

/**
 * This class displays live weather info by registering itself with the weather station.
 */
class LiveWeatherDisplay implements Observer {
    private double temperature = 0.0;
    private double pressure = 0.0;
    private double humidity = 0.0;

    @Override
    public void update(double temperature, double pressure, double humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;

        displayLiveWeatherData();
    }

    private void displayLiveWeatherData() {
        System.out.println("========== Live Weather Parameters ============");
        System.out.println("Temperature: " + temperature + "\nPressure: " + pressure + "\nHumidity: " + humidity);
    }
}


public class ObserverPattern {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        LiveWeatherDisplay weatherDisplay = new LiveWeatherDisplay();

        // Register the weather display object with weather station object
        weatherStation.addObserver(weatherDisplay);

        // Update the data of weather station so weather display gets notified.
        weatherStation.updateWeatherData(43.0, 45.0, 48.0);
    }
}
