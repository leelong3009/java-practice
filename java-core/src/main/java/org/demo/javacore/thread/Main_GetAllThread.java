package org.demo.javacore.thread;

import java.util.Set;

/**
 * Hello world!
 *
 */
public class Main_GetAllThread 
{
    public static void main( String[] args )
    {
        Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
        for(Thread t : threadSet){
        	System.out.println("Thread id " + t.getId() + " name " + t.getName()+ t.getPriority()+t.getThreadGroup());
        }

    }
}
