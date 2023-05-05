package com.simplicity;

public class TimeThread implements Runnable {
    private static TimeThread instance; 
    private Object lock = new Object(); 
    private boolean pause; 

    private TimeThread(){
        pause = true; 
    }

    public static TimeThread getInstance(){
        if (instance == null) {
            instance = new TimeThread(); 
        }
        return instance; 
    }

    @Override
    public void run(){
        while (true){
            synchronized(lock){
                while(pause){
                    try {
                        lock.wait();
                    } catch (InterruptedException ex){
        
                    }
                }
                
            }
            try {
                Thread.sleep(1000);
            }catch(InterruptedException ex){

            }
        }
    }

    public void resume(){
        synchronized (lock){ 
            pause = false;
            lock.notifyAll();
        }
    }

    public void pause(){
        pause = true; 
        System.out.println("Bazinga"); 
    }
}
