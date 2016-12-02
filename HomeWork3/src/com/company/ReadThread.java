package com.company;

/**
 * Created by Donsleep on 02.12.2016.
 */
public class ReadThread implements Runnable {
    Thread t2;
    ReadThread() {
        t2 = new Thread(this);
        System.out.println("Поток чтения создан: " + t2);
        t2.start();
    }
    @Override
    public void run() {
        try {
            for (int i = 0; i < 5 ; i++) {
                System.out.println("Работа потока чтения...");
                System.out.println("Чтение из листа: " + WriteThread.getList(i));
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Поток чтения прерван");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Скорость записи ниже скорости чтения");
            System.exit(1);
        }
        System.out.println("Поток чтения завершен");
    }
}
