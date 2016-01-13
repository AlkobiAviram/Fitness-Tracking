package com.games.aviramalkobi.fitness_tracking;

/**
 * Created by AviramAlkobi on 13/01/2016.
 */
public class Exercise {

    private String name;
    private int repeat;
    private int amount;
    private int BreakTime;


    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public int getRepeat() {
        return repeat;
    }
    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }


    public int getAmount() {
        return this.amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }


    public int getBreakTime() {
        return this.BreakTime;
    }
    public void setBreakTime(int breakTime) {
        this.BreakTime = breakTime;
    }

}
