package com.nitya.jmx;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class counterManagement {
    private static final String FILE_NAME = "test.txt";
    public static void main(String[] args) throws MalformedObjectNameException, InterruptedException, InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException {
        //Get the MBean server
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        //register the MBean
        counter mBean = new counter(FILE_NAME);
        ObjectName name = new ObjectName("com.nitya.jmx:type=counter");
        mbs.registerMBean(mBean, name);
        do{
            Thread.sleep(3000);
            System.out.println("*!!* Word Count="+mBean.getWordCount());
        }while(mBean.getWordCount() !=-1);

    }

}
