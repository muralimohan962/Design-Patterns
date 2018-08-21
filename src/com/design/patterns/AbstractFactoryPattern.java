package com.design.patterns;

interface Widget {
    String getWidgetName();
}

interface WidgetFactory {
    Button createButton();

    ScrollBar createScrollBar();
}

abstract class Button implements Widget {

    public abstract String getWidgetName();
}

class PMButton extends Button {

    @Override
    public String getWidgetName() {
        return "PM Button";
    }
}

class MotifButton extends Button {

    @Override
    public String getWidgetName() {
        return "Motif Button";
    }
}

abstract class ScrollBar implements Widget {

    public abstract String getWidgetName();
}

class PMScrollBar extends ScrollBar {

    @Override
    public String getWidgetName() {
        return "PM ScrollBar";
    }
}

class MotifScrollBar extends ScrollBar {

    @Override
    public String getWidgetName() {
        return "Motif ScrollBar";
    }
}

class PMWidgetFactory implements WidgetFactory {

    @Override
    public Button createButton() {
        return new PMButton();
    }

    @Override
    public ScrollBar createScrollBar() {
        return new PMScrollBar();
    }
}

class MotifFactory implements WidgetFactory {

    @Override
    public Button createButton() {
        return new MotifButton();
    }

    @Override
    public ScrollBar createScrollBar() {
        return new MotifScrollBar();
    }
}

public class AbstractFactoryPattern {
    public static void main(String[] args) {
        System.setProperty(LOOK_AND_FEEL_KEY, PM);

        WidgetFactory widgetFactory;
        Button button;
        ScrollBar scrollBar;

        String lookAndFeel = System.getProperty(LOOK_AND_FEEL_KEY);

        widgetFactory = getAppropriateFactory(lookAndFeel);

        button = widgetFactory.createButton();
        scrollBar = widgetFactory.createScrollBar();

        System.out.println(button.getWidgetName());
        System.out.println(scrollBar.getWidgetName());
    }

    private static WidgetFactory getAppropriateFactory(String lookAndFeel) {
        if (lookAndFeel.equals(PM))
            return new PMWidgetFactory();
        else return new MotifFactory();
    }

    private static final String LOOK_AND_FEEL_KEY = "look.and.feel";
    private static final String MOTIF = "motif";
    private static final String PM = "pm";
}