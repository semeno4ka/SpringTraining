package com.cydeo.tightly_coupled;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PC {

    private DellCase theCase; //tight dependency on DellCase, required loose dependency on Case theCase;
    private AcerMonitor monitor;
    private AsusMotherboard motherboard;

    public void powerUp() {
        theCase.pressPowerButton();
        drawLogo();
    }

    private void drawLogo() {
        monitor.drawPixelAt(1200, 50, "yellow");
    }
}
