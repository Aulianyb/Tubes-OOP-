package com.simplicity;

public class TimeThread implements Runnable {
    private static TimeThread instance; 
    private Object lock = new Object(); 
    private boolean pause; 
    private int millis; 

    private TimeThread(){
        pause = true;
        millis = 0;  
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
                millis+=1; 
                // System.out.println(millis); //testing doang
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
    }

    public int getMillis(){
        return millis; 
    }
}
