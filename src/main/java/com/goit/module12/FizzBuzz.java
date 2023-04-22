package com.goit.module12;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FizzBuzz {

    private int n;
    private BlockingQueue<String> queue;

    public FizzBuzz(int n) {
        this.n = n;
        this.queue = new LinkedBlockingQueue<>();
    }

    public void fizz() {
        for (int i = 3; i <= n; i += 3) {
            if (i % 5 != 0) {
                queue.add("fizz");
            }
        }
    }

    public void buzz() {
        for (int i = 5; i <= n; i += 5) {
            if (i % 3 != 0) {
                queue.add("buzz");
            }
        }
    }

    public void fizzbuzz() {
        for (int i = 15; i <= n; i += 15) {
            queue.add("fizzbuzz");
        }
    }

    public void number() {
        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 != 0) {
                queue.add(Integer.toString(i));
            } else {
                try {
                    System.out.println(queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(15);

        Thread threadA = new Thread(fizzBuzz::fizz);
        Thread threadB = new Thread(fizzBuzz::buzz);
        Thread threadC = new Thread(fizzBuzz::fizzbuzz);
        Thread threadD = new Thread(fizzBuzz::number);

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
    }
}