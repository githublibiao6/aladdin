package com.aladdin.mis.ms;

import java.time.LocalDateTime;

public class ThreadDemo {

    public static void main(String[] args) throws InterruptedException {

    }

    private class ThreadJoinTest extends Thread {
        public ThreadJoinTest(String name) {
            super(name);
        }
        @Override
        public void run() {
            System.err.println(this.getName() + "--------" + LocalDateTime.now());
        }
    }


    /**
    - 现在有 T1、T2、T3 三个线程，你怎样保证 T2 在 T1 执行完后执行，T3 在 T2 执行完后执行？
    - */
    static void test1(){
        Thread t1 = new Thread(() -> {
            // 线程T1的任务
            System.out.println("T1 is executing.");
        });

        Thread t2 = new Thread(() -> {
            try {
                t1.join(); // 等待T1执行完毕
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            // 线程T2的任务
            System.out.println("T2 is executing.");
        });
        Thread t3 = new Thread(() -> {
            try {
                t2.join(); // 等待T1执行完毕
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            // 线程T2的任务
            System.out.println("T3 is executing.");
        });

        t3.start();
        t2.start();
        t1.start();
    }
}

