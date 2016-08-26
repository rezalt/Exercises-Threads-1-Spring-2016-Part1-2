/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.threadtest1;

/**
 *
 * @author Henrik
 */
public class Ex1
{

    public static class Thread1 extends Thread
    {

        long sum = 0;
        long n = 1000000000L;

        public void run()
        {

            for (long i = 1; i <= n; i++)
            {
                sum += i;

            }

            System.out.println("sum: " + sum);

        }

    }

    public static class Thread2 extends Thread
    {

        public void run()
        {
            for (int i = 1; i <= 5; i++)
            {
                System.out.println("Thread 2 value: " + i);

                try
                {
                    // thread to sleep for 2000 milliseconds
                    System.out.println("Thread 2 sleeping for 2 seconds.");
                    Thread2.sleep(2000);
                }
                catch (Exception e)
                {
                }

            }
        }
    }

    public static class Thread3 extends Thread
    {

        public volatile boolean finished = false;
        private int i = 10;

        public void run()
        {

            while (!finished)
            {

                System.out.println("Thread 3 value: " + i);
                i++;

                try
                {

                    System.out.println("Thread 3 sleeping for 3 seconds.");
                    Thread3.sleep(3000);
                }
                catch (Exception e)
                {
                }

            }
        }

    }

    public static class Thread4 extends Thread
    {

        int seconds = 1;

        public void run()
        {

            while (seconds <= 20)
            {

                seconds += 1;
                System.out.println("Seconds; " + seconds);

                try
                {

                    Thread4.sleep(1000);
                }
                catch (Exception e)
                {
                }

            }
        }

    }

    public static void main(String[] args)
    {

        Thread1 T1 = new Thread1();
        Thread2 T2 = new Thread2();
        Thread3 T3 = new Thread3();
        Thread4 T4 = new Thread4();

        // Second counter
        T4.start();

        T1.start();
        T2.start();
        T3.start();

        try
        {
            // thread to sleep for 10000 milliseconds
            System.out.println("Thread sleeping.");
            Thread.sleep(10000);
        }
        catch (Exception e)
        {
        }

        T3.finished = true;

    }

}
