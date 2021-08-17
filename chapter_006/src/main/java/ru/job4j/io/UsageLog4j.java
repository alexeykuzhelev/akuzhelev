package ru.job4j.io;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/*
  @author Alexey Kuzhelev (aleks2kv1977@gmail.com)
 * @version $Id$
 * @since 18.08.2021
 */

/**
 * Класс показывает работу библиотеки логгирования Log4j с выводом в консоль.
 */
public class UsageLog4j {

    private static final Logger LOG = LogManager.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");
    }
}
