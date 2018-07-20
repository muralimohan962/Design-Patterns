package com.design.patterns;

class Sun {

    // In singleton make sure to private the constructor so that no one create the objects.
    private Sun() {
    }

    // Here create a single object of type Sun
    private static Sun INSTANCE = new Sun();

    // Give access to Sun object it by a public method
    static Sun getInstance() {
        return INSTANCE;
    }

    void shine() {
        System.out.println("Shining......");
    }
}


public class SingletonPattern {
    public static void main(String[] args) {
        Sun sun = Sun.getInstance();

        sun.shine();

        // Only one instance or object of Sun can be created and that is created in Sun class itself.
        // This is singleton pattern.

        /*
        Sun sun = new Sun(); gives you error because the constructor is private.

         */
    }
}
