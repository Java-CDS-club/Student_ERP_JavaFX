/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studenter;

/**
 *
 * @author Asus
 */
public class Multithread {
    public static void main(String[] args)
    {
        int n = 8; // Number of threads 
        for (int i=0; i<8; i++) 
        { 
            MultiThreadingDemo object = new MultiThreadingDemo(); 
            object.start(); 
        } 
    }
}
class MultiThreadingDemo extends Thread
{
    public void run() 
    { 
        try
        { 
            // Displaying the thread that is running 
            System.out.println ("Thread " + 
                  Thread.currentThread().getId() + 
                  " is running"); 
  
        } 
        catch (Exception e) 
        { 
            // Throwing an exception 
            System.out.println ("Exception is caught"); 
        } 
    } 
}
