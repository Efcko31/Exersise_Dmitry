package ru.lectures.Patterns.StructuralPatterns.Adapter.USBAdapter;

public class LightningToUSBAdapter implements USB {
    private LightningPort lightningPort;

    public LightningToUSBAdapter(LightningPort lightningPort) {
        this.lightningPort = lightningPort;
    }

    @Override
    public void connect() {
        lightningPort.plugIn();
    }
}
