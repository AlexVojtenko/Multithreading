package threads;

import entity.CustomClass;

public class FirstThreadClass extends Thread {

    @Override
    public void run() {
        Thread.currentThread().setName("FirstThread");
        for (int i = 0; i < 1000; i++) {
            CustomClass.getThreadNameAndNumber();
        }
    }
}
