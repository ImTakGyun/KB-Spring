package com.example;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component("LgTV")
public class LgTV implements TV{

    private boolean power;
    private int volume;

    public LgTV() {
        power = false;
        volume = 0;
    }

    @Override
    public String powerOn() {
        this.power = true;
        return("LG TV : POWER-ON");
    }

    @Override
    public String powerOff() {
        this.power = false;
        return("LG TV : POWER-OFF");
    }

    @Override
    public String volumeUp() {
        this.volume += 1;
        return("LG TV : VOLUME-UP");
    }

    @Override
    public String volumeDown() {
        this.volume -= 1;
        return("LG TV : VOLUME-DOWN");
    }
}
