package io.github.pranavgade20.autohotbar;

public class Criticals {
    public static boolean enabled = false;

    public static void toggle() {
        System.out.println("Toggled Criticals");
        enabled = !enabled;
    }
}
