package com.example;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component("SamsungTV")
public class SamsungTV implements TV{

    private boolean power;
    private int volume;

    public SamsungTV() {
        power = false;
        volume = 0;
    }

    @Override
    public String powerOn() {
        this.power = true;
        return("SAMSUNG TV : POWER-ON");
    }

    @Override
    public String powerOff() {
        this.power = false;
        return("SAMSUNG TV : POWER-OFF");
    }

    @Override
    public String volumeUp() {
        this.volume += 1;
        return("SAMSUNG TV : VOLUME-UP");
    }

    @Override
    public String volumeDown() {
        this.volume -= 1;
        return("SAMSUNG TV : VOLUME-DOWN");
    }
}
