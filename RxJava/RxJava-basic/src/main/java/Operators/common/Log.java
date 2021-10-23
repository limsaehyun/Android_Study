package Operators.common;

public class Log {
    public static void it(Object object) {
        long time = System.currentTimeMillis() - CommonUtils.startTime;
        System.out.println("Thread - 1" + time  + " | value = " + object);
    }
}
