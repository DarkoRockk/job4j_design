package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Dmitry Shadrin";
        int age = 31;
        double dub = 2.3;
        float flo = 1.3f;
        boolean boo = false;
        byte by = 1;
        short sho = 2;
        char ch = 56;

        LOG.debug("User info name : {}, age : {}, double : {}, float : {}, boolean : {}, byte : {}, short : {}, char : {}", name,
                age, dub, flo, boo, by, sho, ch);
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");
    }
}
