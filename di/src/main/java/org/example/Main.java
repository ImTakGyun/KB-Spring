package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        GalaxyWatch galaxyWatch = new GalaxyWatch();
        AppleWatch appleWatch = new AppleWatch();

        WatchTester watchTester = new WatchTester(galaxyWatch);
        watchTester.run();
        watchTester.setWatch(appleWatch);
        watchTester.run();
        watchTester.setWatch(galaxyWatch);
        watchTester.run();
        System.out.println(watchTester);
    }
}