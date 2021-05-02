package threads;

import entity.CustomClass;

import java.util.concurrent.Callable;

public class ThirdThreadClass implements Callable {

    public Object call() throws Exception {
        Thread.currentThread().setName("ThirdThread");
        for (int i = 0; i < 1000; i++) {
            CustomClass.getThreadNameAndNumber();
        }
        return null;
    }
}
