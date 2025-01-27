package ru.job4j.gc.ref;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class SoftDemo {

    public static void main(String[] args) {
        /* example1(); */
       /* example2();*/
        safeSoftRef();
    }

    private static void example1() {
        Object strong = new Object();
        SoftReference<Object> soft = new SoftReference<>(strong);
        strong = null;
        System.out.println(soft.get());
    }

    private static void example2() {
        List<SoftReference<Object>> objects = new ArrayList<>();
        for (int i = 0; i < 100_000_000; i++) {
            objects.add(new SoftReference<Object>(new Object() {
                String value = String.valueOf(System.currentTimeMillis());

                @Override
                protected void finalize() throws Throwable {
                    System.out.println("Object removed!");
                }
            }));
        }
        System.gc();
        int liveObject = 0;
        for (SoftReference<Object> ref : objects) {
            Object object = ref.get();
            if (object != null) {
                liveObject++;
            }
        }
        System.out.println(liveObject);
    }

    /**
     * Пример, как безопасно работать с SoftReference, чтобы GC не затер данные при работе с ней
     */
    private static void safeSoftRef() {
        SoftReference<String> softReference = new SoftReference<>("data1Test");
        String dataRef = softReference.get();
        if (dataRef != null) {
            System.out.println(dataRef.contains("data1"));
        }
    }
}
