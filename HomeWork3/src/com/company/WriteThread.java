package com.company;

import java.util.ArrayList;

/**
 * Created by Donsleep on 02.12.2016.
 */
public class WriteThread implements Runnable {
    private static ArrayList<Integer> list = new ArrayList<>();
    public static int getList(int a) {
        return list.get(a);
    }
    Thread t1;
    WriteThread() {
        t1 = new Thread(this);
        System.out.println("Поток записи создан: " + t1);
        t1.start();
    }
    @Override
    public void run() {
        try {
            for (int i = 0; i < 5 ; i++) {
                System.out.println("Работа потока записи...");
                list.add(i);
                Thread.sleep((int)(Math.random() * 1500));
            }
        } catch (InterruptedException e) {
            System.out.println("Поток записи прерван");
        }
        System.out.println("Поток записи завершен");
    }
}
