package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
  @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 12.09.2021
 */

/**
 * Класс использует slf4j как шаблон для подстановки переменных.
 */
public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Alexey";
        int age = 44;
        short child = 1;
        boolean genderMan = true;
        long userId = 100000L;
        byte minusByteValue = (byte) 0b1111_1111;
        float piValue = (float) Math.PI;
        double piValueExt = Math.PI;
        LOG.debug("User info name : {}, age : {}", name, age);
        LOG.debug("User info child : {}, gender man : {}", child, genderMan);
        LOG.debug("User info userId : {}", userId);
        LOG.debug("minByteValue + maxByteValue : {}", minusByteValue);
        LOG.debug("Float value : {}, Double value : {}", piValue, piValueExt);
    }
}
