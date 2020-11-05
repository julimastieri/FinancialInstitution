package com.solvd.OnlineShop;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;

import com.solvd.OnlineShop.daos.UserDAO;

public class Main 
{
    public static void main( String[] args )
    {
    	PropertyConfigurator.configure("log4j.properties");
        System.out.println( "Hello World!" );
        
        //ExecutorService executor =Executors.newFixedThreadPool(10);
        
        UserDAO ud = new UserDAO();
        
        ud.getUserById(1);
        
        
        
		/*
		 * executor.execute(thread1); executor.execute(thread2);
		 * executor.execute(thread3); executor.execute(runnable1);
		 * executor.execute(runnable2); executor.execute(runnable3);
		 * 
		 * executor.shutdown();
		 * try {
			executor.awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			logger.error(e);
		}
		 */
    }
    
    
}
