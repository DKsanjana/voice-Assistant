/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voicerec;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

/**
 *
 * @author acer
 */
public class type extends Allan{
    
 public void Type() throws IOException, 
                           AWTException, InterruptedException 
    { 
        String command = "notepad.exe"; 
        Runtime run = Runtime.getRuntime(); 
        run.exec(command); 
        try { 
            Thread.sleep(2000); 
        } 
        catch (InterruptedException e) 
        { 

        } 
        Voicerec ob=new Voicerec();
        Robot robot = new Robot(); 
        String N=ob.command;
        String ar[] = null;
     while(command==null){
        int i=0;
        ar[i]=N.substring(i);
        robot.keyPress(KeyEvent.VK_N); 
        Thread.sleep(500); 
        robot.notifyAll();
        
        
     }
    } 
 
 
 
 
 
 
} 


