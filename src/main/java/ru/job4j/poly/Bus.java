package ru.job4j.poly;

public class Bus implements Transport{
    private boolean drive;
    private int countPassengers;
    @Override
    public void drive() {
        this.drive = true;
    }

    @Override
    public void passangers(int cnt) {
        this.countPassengers = cnt;
    }

    @Override
    public float fill(float litre) {
        return litre*42;
    }
}
