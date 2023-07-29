package org.example;

public class Spot {

    public Spot(int category, boolean taken) {
        this.category = category;
        this.taken = taken;
    }

    public Spot() {

    }

    protected int category;

    protected boolean taken;

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }



}
