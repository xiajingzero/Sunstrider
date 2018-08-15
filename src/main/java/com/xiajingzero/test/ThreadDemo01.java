package com.xiajingzero.test;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * Created by xiajing on 2018-8-15.
 */
public class ThreadDemo01 {
    public static void main(String[] args) {
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = bean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println(threadInfo.getThreadId() + ", " + threadInfo.getThreadName());
        }
    }
}
