package org.example;

public class WatchTester {

    private Watch watch;

    public WatchTester(Watch watch){
        this.watch = watch;
    }

    public void setWatch(Watch watch){
        this.watch = watch;
    }

    public Watch getWatch(){
        return this.watch;
    }

    public void run() {
        System.out.println("getDate() : " + watch.getDate());
        System.out.println("getTime() : " + watch.getTime());
        System.out.println("getDateTime() : " + watch.getDateTime());
    }

    public String toString(){
        return "WatchTester{" + "watch=" + watch + '}';
    }
}
