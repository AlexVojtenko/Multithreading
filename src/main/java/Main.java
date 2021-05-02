import threads.FirstThreadClass;
import threads.SecondThreadClass;
import threads.ThirdThreadClass;

import java.util.concurrent.FutureTask;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        FirstThreadClass firstThread = new FirstThreadClass();

        SecondThreadClass secondThreadClass = new SecondThreadClass();
        Thread secondThread = new Thread(secondThreadClass);

        ThirdThreadClass thirdThreadClass = new ThirdThreadClass();
        FutureTask<Integer> task = new FutureTask<>(thirdThreadClass);
        Thread thirdThread = new Thread(task);

        firstThread.start();
        secondThread.start();
        thirdThread.start();

        /* 5. Запустить программу несколько раз - возможно, вернувшееся значение переменной, которую получит поток будет разным.
         Результатом программы прикрепить либо к решению, либо в коде комментарием следующие варианты:
           5.1. Какой диапазон результатов переменной возвращает поток после выполнения если программу запустить несколько раз? (пример 3000-3000);
           5.2. Какой диапазон результатов переменной возвращает поток после выполнения если предварительно методу дополнительного класса(п.2),
            который вызывают все потоки добавить синхронизацию и запустить программу несколько раз? (пример 2980-3000);
           5.3. Какой диапазон результатов переменной возвращает поток после выполнения если после КАЖДОГО запуска потока (start()) указывать остальным,
            чтобы ждали его выполнения (join()) и программу запустить несколько раз? (пример 2500-2900); */

        // Во всех случаях вызова потоков диапазон значений переменной будет 3000-3000

        // Deadlock
        final Integer number1 = 1;
        final Integer number2 = 2;

        Thread t1 = new Thread() {
            public void run() {
                synchronized (number1) {
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                    }
                    synchronized (number2) {
                    }
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                synchronized (number2) {
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                    }
                    synchronized (number1) {
                    }
                }
            }
        };

        t1.start();
        t2.start();
    }
}
