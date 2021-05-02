package entity;

public class CustomClass {

    static int number = 0;

    public static int getThreadNameAndNumber() {
        System.out.println("Thread name : " + Thread.currentThread().getName() + ". Number value is " + number);
        number = ++number;
        return number;
    }
}


