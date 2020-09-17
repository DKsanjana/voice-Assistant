/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voicerec;

import java.awt.Desktop;
import java.io.File;
import static java.lang.Thread.sleep;
import java.util.Calendar;
import java.util.GregorianCalendar;

 import org.opencv.core.*;
 import org.opencv.highgui.Highgui;        
//import org.opencv.videoio.VideoCapture;  
import org.opencv.highgui.VideoCapture;
/**
 *
 * @author acer
 */
public class clock extends type {
    
    String toAllan;
   String hAllan;
   
             Calendar cl=new GregorianCalendar();
                        int day=cl.get(Calendar.DAY_OF_MONTH);
                        int month=cl.get(Calendar.MONTH);
                        int year=cl.get(Calendar.YEAR);
                        
                        int second=cl.get(Calendar.SECOND);
                        int min=cl.get(Calendar.MINUTE);
                        int hour=cl.get(Calendar.HOUR);
                        int am_pm=cl.get(Calendar.AM_PM);
         public void time(){
        Thread th;
        th = new Thread(){
            public void run(){
                try{
                  // for(;;){
                       /* Calendar cl=new GregorianCalendar();
                        int day=cl.get(Calendar.DAY_OF_MONTH);
                        int month=cl.get(Calendar.MONTH);
                        int year=cl.get(Calendar.YEAR);
                        
                        int second=cl.get(Calendar.SECOND);
                        int min=cl.get(Calendar.MINUTE);
                        int hour=cl.get(Calendar.HOUR);
                        int am_pm=cl.get(Calendar.AM_PM); */
                        
                        
                        String m= Integer.toString(min);
                        String sec= Integer.toString(second);
                        
                        String d_n="";
                        if(am_pm==1){
                            d_n="P.M.";
                        }
                        else
                        {   
                          
                            d_n="A.M.";
                            
                        }
                        if(hour==00){ hour=12; };
                        
                        String h= Integer.toString(hour);
                        new Voicerec(h+":"+m+":"+d_n+"");
                        sleep(1000); 
                       System.out.print(h);
                        
                    //}

                }
                catch(InterruptedException ex)
                {
                    ex.printStackTrace();
                    
                }
             
            }
            
            
        };
     th.start();
   
   
    
    }
         
         
  public void great(){
               Thread th;
        th = new Thread(){
            public void run(){
                try{
                  // for(;;){
                        
                        
                        
                        String m= Integer.toString(min);
                        String sec= Integer.toString(second);
                        
                        String d_n="";
                        if(am_pm==1){
                            d_n="P.M.";
                        }
                        else
                        {   
                          
                            d_n="A.M.";
                            
                        }
                        if(hour==00){ hour=12; };
                        
                        String h= Integer.toString(hour);
                        sleep(1000); 
                     
                        if(hour>3&&hour<7&&d_n=="P.M."){
                     
                        new Voicerec("hellooo'''good evening");
                      
                      
                       } 
                     else if(hour>12&&d_n=="P.M."&&hour<2){
                     
                       new Voicerec("hellooo'''good afternoon");
                      
                      
                     } 
                      else if(hour>4&&d_n=="A.M."&&hour<12){
                     
                       new Voicerec("hellooo'''good morning");
                      
                      
                     } 
                         new Voicerec("so..''by the way i'm allan'");
                         new Voicerec("what is your name?");
                    //}

                }
                catch(InterruptedException ex)
                {
                    ex.printStackTrace();
                    
                }
             
            }
            
            
        };
     th.start();
   
  
  
   }

  public void Sgreet(){
      
       Desktop d=Desktop.getDesktop();
               Thread th;
        th = new Thread(){
            public void run(){
                try{
                  // for(;;){
                      /*  Calendar cl=new GregorianCalendar();
                        int day=cl.get(Calendar.DAY_OF_MONTH);
                        int month=cl.get(Calendar.MONTH);
                        int year=cl.get(Calendar.YEAR);
                        
                        int second=cl.get(Calendar.SECOND);
                        int min=cl.get(Calendar.MINUTE);
                        int hour=cl.get(Calendar.HOUR);
                        int am_pm=cl.get(Calendar.AM_PM); */
                        
                        
                        String m= Integer.toString(min);
                        String sec= Integer.toString(second);
                        
                        String d_n="";
                        if(am_pm==1){
                            d_n="P.M.";
                        }
                        else
                        {   
                          
                            d_n="A.M.";
                            
                        }
                        if(hour==00){ hour=12; }
                        
                        String h= Integer.toString(hour);
                        sleep(1000); 
                     
                        if(hour>3&&hour<7&&d_n=="P.M."){
                     
                        new Voicerec("good evening.");
                      
                      
                       } 
                     else if(hour>12&&d_n=="P.M."&&hour<2){
                     
                       new Voicerec("hellow'' good afternoon.");
                      
                      
                     } 
                      else if(hour>4&&d_n=="A.M."&&hour<12){
                     
                       new Voicerec("Hellow''good morning.");
                       new Voicerec("I am Allan!");
                       new Voicerec("it's" + h+":"+m+":"+d_n+".in the morning");
                      new Voicerec("so.how do i serve you");
                      
                      //new Voicerec("Today is your birthday");
              // new Voicerec("so,,,wish you a very happy birthday sir!");
              // new Voicerec("sir! May your all dreams are come true");
               
               
                
                
               // new Voicerec("this song is for you");
                      
                     } 
                      else{
                            new Voicerec("Hellow'' I am Allan!'' it's" + h+":"+m+":"+d_n+"");
                      // new Voicerec("I am Allan!");
                       new Voicerec(".so.how do i serve you");
                     // new Voicerec("so.how do i serve you");
                      
                      }
                         
                       //  new Voicerec("what is your name?");
                    //}

                }
                catch(InterruptedException ex)
                {
                    ex.printStackTrace();
                    
                }
             
            }
            
            
        };
     th.start();
   
  
  
   }


 public void PhotoCapture (){
    	System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    	VideoCapture camera = new VideoCapture(0);
    	
    	if(!camera.isOpened()){
    		System.out.println("Error");
    	}
    	else {
    		Mat frame = new Mat();
    	    while(true){
    	    	if (camera.read(frame)){
    	    		System.out.println("Frame Obtained");
    	    		System.out.println("Captured Frame Width " + 
    	    		frame.width() + " Height " + frame.height());
    	    		Highgui.imwrite("camera.jpg", frame);
    	    		System.out.println("OK");
    	    		break;
    	    	}
    	    }	
    	}
    	camera.release();
        new Voicerec("took it!");
        
        
    } 


public void commanText(String a,String b){
      toAllan=a;
      hAllan=b;
    
 } 







}
