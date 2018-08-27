package com.design.patterns;

interface Window {
    void drawText();

    void drawRect();
}

abstract class IconWindow implements Window {

    public abstract void drawText();

    public abstract void drawRect();
}

abstract class TransientWindow implements Window {

    public abstract void drawText();

    public abstract void drawRect();
}

interface WindowImp {
    void drawText();

    void drawLine();
}

class MacWindowImpl implements WindowImp {

    @Override
    public void drawText() {
        System.out.println("Drawing the text on Mac Aqua User Interface.");
    }

    @Override
    public void drawLine() {
        System.out.println("Drawing line on Mac Aqua User Interface.");
    }
}

class PMWindowImpl implements WindowImp {

    @Override
    public void drawText() {
        System.out.println("Drawing the text on PM Window!");
    }

    @Override
    public void drawLine() {
        System.out.println("Drawing the line on the PM Window!");
    }
}

public class BridgePattern {
    public static void main(String[] args) {
        // This pattern is incomplete as of now.
    }
}
