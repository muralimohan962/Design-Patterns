package com.design.patterns;

abstract class Beverage {
    protected String description = "Unknown Beverage";

    String getDescription() {
        return description;
    }

    abstract int cost();
}

abstract class CondimentDecorator extends Beverage {

    abstract String getDescription();
}

class Espresso extends Beverage {

    Espresso() {
        description = "Espresso";
    }

    @Override
    int cost() {
        return 3;
    }
}

class HouseBlend extends Beverage {

    HouseBlend() {
        description = "House Blend";
    }

    @Override
    int cost() {
        return 4;
    }
}

class Mocha extends CondimentDecorator {
    private Beverage beverage;

    Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    int cost() {
        return beverage.cost() + 7;
    }

    @Override
    String getDescription() {
        return beverage.getDescription() + " and Mocha.";
    }
}

class DarkRoast extends Beverage {

    @Override
    String getDescription() {
        return "Dark Roast.";
    }

    @Override
    int cost() {
        return 8;
    }
}

public class DecoratorPattern {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();

        System.out.println(beverage.getDescription());

        beverage = new DarkRoast();
        beverage = new Mocha(beverage);


        System.out.println(beverage.cost());
        System.out.println(beverage.getDescription());
    }
}
