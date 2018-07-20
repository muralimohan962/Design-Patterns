package com.design.patterns;

/**
 * The remote depends on this interface to control different devices.
 */
interface Command {
    void switchOn();
    void switchOff();
}

/**
 * A class representing a Fan.
 */
class Fan {

    void switchOnFan() {
        System.out.println("The fan is switched on!");
    }

    void switchOffFan() {
        System.out.println("The fan is switched off!");
    }
}

/**
 * A class representing a Light.
 */
class Light  {

    void switchOnLight() {
        System.out.println("The light is switched on!");
    }

    void switchOffLight() {
        System.out.println("The light is switched off!");
    }
}

/**
 * A class that implements Command interface and delegates requests to Fan object.
 */
class FanCommand implements  Command {
    // The object to which request are delegated.
    private Fan fan;

    FanCommand(Fan f) {
        fan = f;
    }

    @Override
    public void switchOn() {
        fan.switchOnFan();
    }

    @Override
    public void switchOff() {
        fan.switchOffFan();
    }
}

/**
 * A class that implements Command interface and delegates requests to Light object.
 */
class LightCommand implements Command {
    // The object to which request are delegated.
    private Light light;

    LightCommand(Light l) {
        light = l;
    }

    @Override
    public void switchOn() {
        light.switchOnLight();
    }

    @Override
    public void switchOff() {
        light.switchOffLight();
    }
}

/**
 * A class representing the remote.
 */
class Remote {
    // Remote depending on the command interface to control different devices.
    private Command command;

    /**
     * Lets you configure different device so that remove can control them.
     * @param c the object representing a device like fan or light.
     */
    void setCommand(Command c) {
        command = c;
    }

    void switchOnDevice() {
        command.switchOn();
    }

    void switchOffDevice() {
        command.switchOff();
    }
}

public class CommandPattern {
    public static void main(String[] args) {
        Remote remote = new Remote();

        // Configure remote to control fan
        remote.setCommand(new FanCommand(new Fan()));
        remote.switchOnDevice();
        remote.switchOffDevice();

        // Configure remote to control light
        remote.setCommand(new LightCommand(new Light()));
        remote.switchOnDevice();
        remote.switchOffDevice();

        /*

        Task: Now try to control another device like washing machine by the above remote.
         Read the code and do it.
        */
    }
}
