package com.goit.module12;

import java.util.concurrent.TimeUnit;

public class TimeDisplay {

    public static void main(String[] args) {
        // Стартуємо перший потік, який буде відображати час
        Thread timeThread = new Thread(() -> {
            long startTime = System.currentTimeMillis();
            while (true) {
                long currentTime = System.currentTimeMillis();
                long elapsedTime = currentTime - startTime;
                System.out.println("The hour has passed: " + elapsedTime / 1000 + " seconds");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        timeThread.start();

        // Стартуємо другий потік, який буде виводити повідомлення про миналі 5 секунд
        Thread messageThread = new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("5 seconds have passed");
            }
        });
        messageThread.start();
    }
}
