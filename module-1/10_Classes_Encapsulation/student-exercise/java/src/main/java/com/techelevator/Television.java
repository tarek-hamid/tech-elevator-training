package com.techelevator;

public class Television {
    private boolean isOn;
    private int currentChannel;
    private int currentVolume;

    public Television(){
        isOn = false;
        currentChannel = 3;
        currentVolume = 2;
    }

    public boolean isOn() {
        return isOn;
    }

    public int getCurrentChannel() {
        return currentChannel;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void turnOff(){
        isOn = false;
    }

    public void turnOn(){
        isOn = true;
        currentChannel = 3;
        currentVolume = 2;
    }

    public void changeChannel(int newChannel){
        if (isOn && newChannel > 2 && newChannel < 19){
            currentChannel = newChannel;
        }
    }

    public void channelUp() {
        if (isOn && currentChannel == 18) {
            currentChannel = 3;
        } else if (isOn) {
            currentChannel++;
        }
    }

    public void channelDown(){
        if(isOn && currentChannel == 3){
            currentChannel = 18;
        } else if (isOn){
            currentChannel--;
        }
    }

    public void raiseVolume(){
        if (isOn && currentVolume != 10){
            currentVolume++;
        }
    }

    public void lowerVolume(){
        if (isOn && currentVolume != 0){
            currentVolume--;
        }
    }
}
