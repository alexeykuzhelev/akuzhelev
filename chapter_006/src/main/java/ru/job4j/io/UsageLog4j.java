package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
  @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 12.09.2021
 */

/**
 * Класс показывает работу библиотеки логгирования slf4j с выводом в консоль.
 */
public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");
    }
}
