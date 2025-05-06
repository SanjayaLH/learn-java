package com.learn.threads.q5;

import java.util.Random;

public class WeatherData {
    private volatile float temperature;
    private volatile float humidity;

    public float getTemp() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public synchronized void update(float temp, float hum) {
        this.temperature = temp;
        this.humidity = hum;

        System.out.println(Thread.currentThread().getName() + " updated data: " +
                "Temp=" + temp + ", Humidity=" + hum);
    }

    public synchronized void print() {
        System.out.println("Current Weather => Temp: " + temperature +
                ", Humidity: " + humidity);
    }

    public static void main(String[] args) throws InterruptedException {
        WeatherData data = new WeatherData();
        Random random = new Random();

        Thread t1 = new Thread(() -> {
            float temp = 20 + random.nextFloat() * 15;
            float hum = 40 + random.nextFloat() * 40;

            data.update(temp, hum);
            data.print();

        });
        Thread t2 = new Thread(() -> {
            float temp = 20 + random.nextFloat() * 15;
            float hum = 40 + random.nextFloat() * 40;

            data.update(temp, hum);
            data.print();

        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Current Temp: " + data.getTemp() + " Current Hum: " + data.getHumidity());
    }
}
