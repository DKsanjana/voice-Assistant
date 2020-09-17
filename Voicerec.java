/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voicerec;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import java.io.IOException;
import java.awt.Desktop;
import java.io.File;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import jaco.mp3.player.MP3Player;
import java.awt.AWTException;
import java.awt.Robot; 
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

//import voicerec.Allan;

public class Voicerec extends clock{
    
    String command;
   
    VoiceManager vm;
    Voice v;
    clock ob=new clock();
    
    Allan lb=new Allan();
    
     
     
   // Gsearch sb=new Gsearch();
    public Voicerec(boolean x){
      ob.time();
      
    
    }
    public Voicerec(int y){
      ob.great();
      
    
    }
    String w;
    
    public Voicerec(String x,String y) throws IOException{
       // ActionEvent evt = null;
         if(x=="play")
        {
             new Voicerec("enjoy your music");
            
            lb.MusicP();
            
             
        }
        
          //lb.Weather(x);
         
        if(y=="stop")
        {
          
            new Voicerec("asfasfasf"); 
        
            lb.stopM();
        
        }
        
      //  if(z=="mute")
        {
         // lb.muteM();
        
        }
    
    }
       private MP3Player mp3Player(){
        MP3Player mp3Player = new MP3Player();
        return mp3Player;
    }
    
    public Voicerec(String x,String y,String z)
    {
        
      
        
    }
    
    public Voicerec(double y){
      
      ob.Sgreet();
    
    }
    
     public Voicerec(int p,int o){
      ob.PhotoCapture();
      
    
    }
    // public Voicerec(int x) throws IOException{
      
      //sb.Gsearch(command);
    
   // }
    
  
    public Voicerec(String words) {
        
        System.setProperty("mbrola.base", "mbrola");
        vm = VoiceManager.getInstance();
 
        
        v = vm.getVoice("mbrola_us2");

       
        v.allocate();
        sayWords(words);
        
        
    } 

    Voicerec() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }
    
    public void sayWords(String words) {
        
        v.speak(words);
    }
    
    
    public static void main(String[] args) throws IOException, AWTException, InterruptedException {
        boolean access=false;
        boolean name=false;
        boolean shutd=false;
        int username=0;
        Desktop d=Desktop.getDesktop();
        //FileInputStream blah = null;
      
       
        int mpAccess=0;
        Configuration configuration = new Configuration();
 
        
        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        
         configuration.setDictionaryPath("7198.dic");
       
         configuration.setLanguageModelPath("7198.lm");
       
 
         
        LiveSpeechRecognizer recognize = new LiveSpeechRecognizer(configuration);
        
       
       recognize.startRecognition(true);
 
        
        SpeechResult result=null;
        
                new Voicerec(1.0);
                 name = true; 
        
    try{
       while ((result = recognize.getResult()) != null) {
            
               if(mpAccess!=1)
               {
                   mpAccess=1;
                // Allan.main(args);
               }
           
            if((result= recognize.getResult())!=null) {
              String  com  = result.getHypothesis();
                System.out.println(com);
                
            
                 
                
             if(result.getHypothesis().equalsIgnoreCase("allan")&&(access==false)||result.getHypothesis().equalsIgnoreCase("wake up allan")&&(access==false)){ 
               new Voicerec(1.0);
               name=true;
               
               //File f=new File("C:\\Users\\acer\\Desktop\\New folder\\athmaye ma.mp4");
               //d.open(f);
               
              
            } 
             
             if(com.equalsIgnoreCase("allan")&&(access==true)){ 
               new Voicerec("yes.");
               name = true;
               
            } 
            
             if(result.getHypothesis().equalsIgnoreCase("allan you up")){ 
               new Voicerec("for you' always.!");
               
               name = true;
            } 
            
            if(result.getHypothesis().equalsIgnoreCase("hello allan")){ 
               new Voicerec("yes..' tell me");
               
               name = true;
            } 
            
             if(result.getHypothesis().equalsIgnoreCase("social mode")){ 
                
                new Voicerec(10);
                
                
                
                  while ((result = recognize.getResult()) != null) { 
                      
                               String com1 = result.getHypothesis();
                               System.out.println(com1);
                                    
                                      String name2=com1;
                     try{                 
         		if(name2.substring(0,10).equalsIgnoreCase("my name is")){
                                                       String usern=name2.substring(11,name2.length());
                                                 new Voicerec("what a beautiful name'");
                                                 new Voicerec(",hellooo" + usern);
                                                 new Voicerec("now tell me your age please?");
                                    }  
                                      
                                     if(com1.substring(com1.length()-9,com1.length()).equalsIgnoreCase("years old")){
                                                        String age=com1.substring(0,name2.length()-10);
                                                     if(age.equalsIgnoreCase("twenty one")){
                                                                           new Voicerec("i can call you master then");
                                                                     
                                                        }
                                                    }  
                             }
                  catch(IndexOutOfBoundsException e){}
                    
                     if(com1.equalsIgnoreCase("sing a song for me"))
                        {
                               new Voicerec("twinkle twinkle little star");
                                new Voicerec("how i wonder what you are'");
                            
                            // new Voicerec("weeee will' weeee will'  rock you");
                        }
                    
                     if(com1.equalsIgnoreCase("shutdown")) {
                          new Voicerec("social mode deactivated");
                          new Voicerec("activating working mode");
                          name=true;
                          break;
                   }
                                       
              }                      
              
             
             }        
                
            
            }
         
     if(name==true){
             access=true;
        while ((result = recognize.getResult()) != null) {
 
            //Get the recognized speech
            String command = result.getHypothesis();
            String work = null;
            Process p = null;
            System.out.println(command);
            Robot robot = new Robot(); 
            
     
          if(command.equalsIgnoreCase("hey allan"))
               {
                   new Voicerec("hey!");
               }
           if(command.equalsIgnoreCase("hello allan")){
                new Voicerec("hellow!");
            }
            
           if(command.equalsIgnoreCase("allan")) {
               new Voicerec("yes..");
                
           }  
           
          /* if(command.equalsIgnoreCase("photo")) {
               new Voicerec("done it..");
                new Voicerec("","");
           }  */
             
           if (command.equalsIgnoreCase("project allan")) {
                new Voicerec("Hello! My name is allan");
               // new Voicerec("what is your name?");
                
               // new Voicerec("hello"+command);
                new Voicerec("i'm developed by kaveen sanjana");
               // new Voicerec("He is a MAHINDIAN' According to him' i'm a MAHINDIAN too");
               // new Voicerec("He named me as jarvis because he thinks he is the iron man' ha ha");
                new Voicerec("He is going to develop me as a home voice Assistant");
                new Voicerec("I can cntrol most of functions in your personal computer");
                new Voicerec("you can activate me by saying allan' and you can hibernate me by saying sleep sleep or sleep allan");
                new Voicerec("and also you can deactivate me by saying shutdown.");
                new Voicerec("All my commands are included in the project document");
                new Voicerec("GoodBye! Have a nice day");
              
               
            }
           
            
           if(command.equalsIgnoreCase("you up")){
                new Voicerec("for you' Always");
             }
          
           if(command.equalsIgnoreCase("wish me luck")){
                 new Voicerec("Best of luck");
                
              }
            
            
            
            if (command.equalsIgnoreCase("sleep allan")||command.equalsIgnoreCase("sleep sleep")) {
                new Voicerec("Good bye!");
                
                break;
              } 
            
            if (command.equalsIgnoreCase("good night allan")||command.equalsIgnoreCase("night allan")) {
                new Voicerec("good night");
                
              }
             
            if (command.equalsIgnoreCase("file allan")) {
                new Voicerec("Sorry master allan is my previous name,call me jarvis");
                
              }
            
            if(command.equalsIgnoreCase("good morning")||command.equalsIgnoreCase("morning allan")||command.equalsIgnoreCase("good morning allan")) {
               new Voicerec("good mornnig");
               } 
            
            if(command.equalsIgnoreCase("good afternoon")||command.equalsIgnoreCase("afternoon allan")||command.equalsIgnoreCase("good afternoon allan")) {
               new Voicerec("good afternoon");
               } 
            
            if(command.equalsIgnoreCase("good evening")||command.equalsIgnoreCase("evening allan")||command.equalsIgnoreCase("good evening allan")) {
               new Voicerec("good evening");
              } 
            
            if (command.equalsIgnoreCase("open browser")||command.equalsIgnoreCase("allan open browser")) {
                work = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
                p = Runtime.getRuntime().exec(work);
                new Voicerec("browser openned");
               }
            if (command.equalsIgnoreCase("open photoshop")||command.equalsIgnoreCase("allan open photoshop")) {
                work = "D:\\photoshop\\ph\\Adobe\\Adobe Photoshop CC 2015.5\\Photoshop.exe";
                p = Runtime.getRuntime().exec(work);
                new Voicerec("photoshop openned");
             }
            
            if (command.equalsIgnoreCase("open flash")||command.equalsIgnoreCase("allan open flash")) {
                work = "C:\\Program Files (x86)\\Adobe\\Adobe Flash CS6\\Flash.exe";
                p = Runtime.getRuntime().exec(work);
                new Voicerec("adobe flash openned");
             }
            
            if (command.equalsIgnoreCase("open player")||command.equalsIgnoreCase("allan open player")) {
                work = "C:\\Program Files (x86)\\VideoLAN\\VLC\\vlc.exe";
                p = Runtime.getRuntime().exec(work);
                new Voicerec("vlc player openned");
            }
           
            if (command.equalsIgnoreCase("media player")||command.equalsIgnoreCase("open media player")||command.equalsIgnoreCase("allan open media player")) {
                work = " C:\\KMPlayer\\KMPlayer.exe";
                p = Runtime.getRuntime().exec(work);
                new Voicerec("K.M.P. player openned");
            }
                String search=command;
                int sugest = 0;
              
              try{ 
                if(search.substring(0,6).equalsIgnoreCase("search")){
                    
                    String docu=search.substring(7,search.length());
                    
                    String GOOGLE_SEARCH_URL = "https://simple.m.wikipedia.org/w/index.php?search";
                    //void Gsearch(String a)throws IOException {
                    
                    //Scanner scanner = new Scanner(System.in);
                    //System.out.println("Please enter the search term.");
                    String searchTerm =docu;
                    
                    //scanner.close();
                    
                    String searchURL = GOOGLE_SEARCH_URL + "="+searchTerm;
                    
                    Document doc = Jsoup.connect(searchURL).userAgent("google chrome").get();
                    
                      try{ 
                       d.browse(new URI(searchURL)); }catch(IOException | URISyntaxException e2){
                          sugest =1;
                       }
                      if(sugest==1){new Voicerec("Sorry! i can't found any search results");}
                   
                    String results = doc.select("p").text();
                    //System.out.print(results);
                      if(results.length()!=0&&results.length()>500){
                        new Voicerec("do you want me to read it?");
                           while ((result = recognize.getResult()) != null) {
                                String readit = result.getHypothesis();
                                System.out.println(readit);
                                     if(readit.equalsIgnoreCase("yes"))
                                          {
                                             new Voicerec(results);
                                             break;
                                          }
                                     if(readit.equalsIgnoreCase("no"))
                                          {
                                              new Voicerec("ok then!");
                                              break;
                                          }
                                
                             }
                        
                        }
                        int b=results.length();
                    if(b==0){
                        new Voicerec("i found the document' but i can't access to the data base");
                     }
                   
                                   
                }
                if(search.equalsIgnoreCase("weather report")){
                          
                          // new Voicerec(search,"");
                     String URL = "http://www.meteo.gov.lk/index.php?search";
                    //void Gsearch(String a)throws IOException {
                    
                    //Scanner scanner = new Scanner(System.in);
                    //System.out.println("Please enter the search term.");
                    String searchT =search;
                    
                    //scanner.close();
                    
                    String searchURl = URL + "="+searchT;
                    
                    Document doc2 = Jsoup.connect(searchURl).userAgent("google chrome").get();
                    
                    
                    String result2 = doc2.select("div.last24details").text();
                    String tem=result2.substring(17,21);
                    String sen=result2.substring(24,result2.length());


                    int index=sen.indexOf('M');
                    String dis=sen.substring(0,index);


                    String mtem=sen.substring(index+16,index+22);


                    String Ssen=sen.substring(index+23,sen.length());

                     int index2=Ssen.indexOf('M');
                     String dis2=Ssen.substring(0,index+1);
                     
   
                    String rain=Ssen.substring(index+15,Ssen.length());
                    
                    String rainf=rain.substring(0,6);
                    String dis3=rain.substring(8,rain.length());
                    
                    String pointvalue1=tem.substring(3,4);
                    String decimalValue1=tem.substring(0,3);
                    
                    String pointvalue2=mtem.substring(4,5);
                    String decimalValue2=mtem.substring(0,3);
                    
                   // System.out.println(pointvalue2);
                   // System.out.println(decimalValue2);
                   // System.out.print(result2);
                    
                    //new Voicerec(dis,"");
                    
                    
                    new Voicerec("max tempreture from"+dis+"");
                    new Voicerec("it's"+decimalValue1+"point"+pointvalue1+"celsius!");       
                    new Voicerec("and the minimum tempreture from!."+dis2+"");
                    new Voicerec("it's"+decimalValue2+"point"+pointvalue2+"celsius!");
                    new Voicerec("max rainfall reported in"+dis3+"as!"+rainf+"milimeeters!");
                              
                             
                      
                           
                             
                    
        
                           }
                
               }
                 catch(IndexOutOfBoundsException e){
               
               }catch(Exception e){
                   new Voicerec("sorry! I am not connected to internet");
                   new Voicerec("please turn on your network connection");
               }
                
               
            
            
            if (command.equalsIgnoreCase("close Photoshop")||command.equalsIgnoreCase("allan close Photoshop")) {
                work = "taskkill /IM photoshop.exe";
               p=Runtime.getRuntime().exec(work);
               new Voicerec("done it sir");
               
                
            }
           
            if (command.equalsIgnoreCase("close flash")||command.equalsIgnoreCase("allan close flash")) {
                work = "taskkill /IM Flash.exe";
               p=Runtime.getRuntime().exec(work);
               new Voicerec("done it!");
                  
               }
           
           if (command.equalsIgnoreCase("close browser")||command.equalsIgnoreCase("allan close browser")||command.equalsIgnoreCase("allan close the browser")) {
                work = "taskkill /IM chrome.exe";
               p=Runtime.getRuntime().exec(work);
               
              // work = "taskkill /IM iexplore.exe";
               //p=Runtime.getRuntime().exec(work);
               new Voicerec("done it!");   
            }
          if (command.equalsIgnoreCase("close music")||command.equalsIgnoreCase("close player")||command.equalsIgnoreCase("close media allan")||command.equalsIgnoreCase("close music allan")||command.equalsIgnoreCase("allan close player")||command.equalsIgnoreCase("close media")||command.equalsIgnoreCase("close movie"))
            {
             
                work = "taskkill /IM vlc.exe";
               p=Runtime.getRuntime().exec(work);
               
               work = "taskkill /IM KMPlayer.exe";
               p=Runtime.getRuntime().exec(work);
               
               new Voicerec("done it!");
               
                
            }
          if (command.equalsIgnoreCase("film folder")||command.equalsIgnoreCase("open the film folder")||command.equalsIgnoreCase("allan open the film folder")) {
                File f=new File("F:\\Films");
                d.open(f);
                new Voicerec("film folder opend");
                
            }
             
          try{
                 int a = 0;
                 String browse=command.substring(0,7);
          if (browse.equalsIgnoreCase("browser")) {
                browse=command.substring(8,command.length()); 
                 String c=browse;
                
                 work = " explorer.exe";
                p = Runtime.getRuntime().exec(work); 

            
                try { 
            Thread.sleep(500); 
            } 
              catch (InterruptedException e) 
           { 

            } 
             
             for(int x=0;x<4;x++){  
              robot.keyPress(KeyEvent.VK_TAB); 
              Thread.sleep(250);  
              a=x;
             }
               
           if(a==3){
            for(char i:c.toCharArray()){
             int keycode= KeyEvent.getExtendedKeyCodeForChar(i);
            
              robot.keyPress(keycode); 
            }
              
              
            }
            new Voicerec("working on it");
            
          }
          }catch(IndexOutOfBoundsException e){}
          
          
          
          
          if (command.equalsIgnoreCase("open youtube")||command.equalsIgnoreCase("open the youtube")||command.equalsIgnoreCase("allan open the youtube")) {
                
               try{ 
                d.browse(new URI("https://www.youtube.com/watch?v=JuygPoTr4X8")); }catch(IOException | URISyntaxException e2){e2.printStackTrace();}
                new Voicerec("will do"); 
           }  
         
           if (command.equalsIgnoreCase("my music")) 
           {
                
               new Voicerec("as you wish");
               File f=new File("C:\\Users\\acer\\Desktop\\athmaye ma.mp4");
                d.open(f);
               
               
            }
           
          if (command.equalsIgnoreCase("allan walker")||command.equalsIgnoreCase("open allan walker music")) 
           {
                
               new Voicerec("allan walker Different world playlist opend");
               File f=new File("D:\\music\\english\\EDM\\17k eng\\Alan Walker - Different World【FULL ALBUM】 - YouTube.mkv");
                d.open(f);
               
               
            }
          
          if (command.equalsIgnoreCase("iron man")||command.equalsIgnoreCase("allan iron man")) 
           {
                
               new Voicerec("inspiration protocol activated");
               File f=new File("C:\\Users\\acer\\Desktop\\New folder\\iron man.mp4");
                d.open(f);
               
               
            }
           
          if (command.equalsIgnoreCase("activate the party mode")||command.equalsIgnoreCase("allan activate the party mode")) 
            {
               new Voicerec("party mode Activated");
               
               File f=new File("D:\\music\\english\\EDM\\17k eng\\FESTIVAL MIX - The Best Electro House Dance Club Mix 2018 - Drop G - YouTube.mkv");
                d.open(f);
               
               
            } 
           
          if(command.equalsIgnoreCase("tell me time")||command.equalsIgnoreCase("time please")||command.equalsIgnoreCase("time please allan")){
                
               new Voicerec(true);
               
            }
            
          if(command.equalsIgnoreCase("good good")||command.equalsIgnoreCase("good boy")) {
               new Voicerec("thank you!");
            } 
          
          if(command.equalsIgnoreCase("open notepad")||command.equalsIgnoreCase("open the notepad")||command.equalsIgnoreCase("allan open the notepad")){
                
               work = "notepad.exe";
               p=Runtime.getRuntime().exec(work);
               new Voicerec("done it");
             
              
               
            }
          if(command.equalsIgnoreCase("open sublime text")||command.equalsIgnoreCase("allan open sublime text")){
                
               work = "C:\\Program Files\\Sublime Text 3\\sublime_text.exe";
               p=Runtime.getRuntime().exec(work);
               new Voicerec("done it");
             
              
               
            }
          if(command.equalsIgnoreCase("close sublime text")||command.equalsIgnoreCase("allan close sublime text")){
                
               work = "taskkill /IM sublime_text.exe";
               p=Runtime.getRuntime().exec(work);
               new Voicerec("done it");
             
              
               
            }
          if(command.equalsIgnoreCase("open intellij")||command.equalsIgnoreCase("allan open intelij")){
                
               work = "C:\\Program Files\\JetBrains\\IntelliJ IDEA Educational Edition 2018.2\\bin\\idea64.exe";
               p=Runtime.getRuntime().exec(work);
               new Voicerec("done it");
             
              
               
            }
          if(command.equalsIgnoreCase("close intellij")||command.equalsIgnoreCase("allan close intelij")){
                
               work = "taskkill /IM idea64.exe";
               p=Runtime.getRuntime().exec(work);
               new Voicerec("done it");
             
              
               
            }
          
          
         /*  if(command.substring(0,22).equalsIgnoreCase("take down a schedule at")){
               String time= command.substring(24,command.length());
              
               
             
              
               
            } */
           
           
          
          if(command.equalsIgnoreCase("close notepad")||command.equalsIgnoreCase("allan close notepad")){
                
               work = "taskkill /IM notepad.exe";
               p=Runtime.getRuntime().exec(work);
               new Voicerec("done it");
            }
         
          
          if(command.equalsIgnoreCase("open file")||command.equalsIgnoreCase("open folder")||command.equalsIgnoreCase("go in")||command.equalsIgnoreCase("put on fullscreen")||command.equalsIgnoreCase("exit fullscreen")||command.equalsIgnoreCase("allan go in")){
           try { 
            Thread.sleep(10); 
            } 
              catch (InterruptedException e) 
           { 

            } 
        
              robot.keyPress(KeyEvent.VK_ENTER); 
              Thread.sleep(5); 
               new Voicerec("ok!");
           } 
          if(result.getHypothesis().equalsIgnoreCase("fast forward"))
             {
              
                try { 
                 Thread.sleep(10); 
                } 
              catch (InterruptedException e) 
               { 

              } 
              for(int x=0;x<10;x++){  
              robot.keyPress(KeyEvent.VK_RIGHT); 
              Thread.sleep(5); 
              }
               new Voicerec("done it");
             }
       
          if(command.equalsIgnoreCase("go down allan")||command.equalsIgnoreCase("volume dowm")||command.equalsIgnoreCase("go down")){
           try { 
               Thread.sleep(10); 
            } 
              catch (InterruptedException e) 
           { 

            } 
              robot.keyPress(KeyEvent.VK_DOWN); 
              Thread.sleep(5); 
              new Voicerec("ok");
         } 
          
            if(command.equalsIgnoreCase("volume down")||command.equalsIgnoreCase("allan go down")){
           try { 
               Thread.sleep(10); 
            } 
              catch (InterruptedException e) 
           { 

            } 
             for(int x=0;x<10;x++){
              robot.keyPress(KeyEvent.VK_DOWN); 
              Thread.sleep(5); 
              
             }
             new Voicerec("Do you need more?");
             
             while ((result = recognize.getResult()) != null) { 
                String com = result.getHypothesis();
                System.out.println(com);
                
              if(result.getHypothesis().equalsIgnoreCase("yes")||result.getHypothesis().equalsIgnoreCase("please yes"))
             {
              
                try { 
                 Thread.sleep(10); 
                } 
              catch (InterruptedException e) 
               { 

              } 
              for(int x=0;x<10;x++){  
              robot.keyPress(KeyEvent.VK_DOWN); 
              Thread.sleep(5); 
              }
               
              new Voicerec("Do you need more?");
             }
                if(result.getHypothesis().equalsIgnoreCase("no")||result.getHypothesis().equalsIgnoreCase("enough")){
                    new Voicerec("as you wish");
                    break;
                  }
            }
               
         } 
        
         
     if(command.equalsIgnoreCase("pause music")||command.equalsIgnoreCase("play music")||command.equalsIgnoreCase("play media")||command.equalsIgnoreCase("pause media")||command.equalsIgnoreCase("stop media")||command.equalsIgnoreCase("stop music")){
           try { 
            Thread.sleep(10); 
            } 
              catch (InterruptedException e) 
           { 

            } 
              
              robot.keyPress(KeyEvent.VK_SPACE); 
              Thread.sleep(5); 
              new Voicerec("ok!");
         }  
          
          if(command.equalsIgnoreCase("Volume up")){
          
             try { 
            Thread.sleep(10); 
            } 
              catch (InterruptedException e) 
           { 

            } 
              for(int x=0;x<10;x++){  
              robot.keyPress(KeyEvent.VK_UP); 
              Thread.sleep(5);
              }
               
              new Voicerec("Do you need more?");
          
              while ((result = recognize.getResult()) != null) { 
                String com = result.getHypothesis();
                System.out.println(com);
                
              if(result.getHypothesis().equalsIgnoreCase("yes")||result.getHypothesis().equalsIgnoreCase("yes please"))
             {
              
                try { 
                 Thread.sleep(10); 
                } 
              catch (InterruptedException e) 
               { 

              } 
              for(int x=0;x<10;x++){  
              robot.keyPress(KeyEvent.VK_UP); 
              Thread.sleep(5); 
              }
               
              new Voicerec("Do you need more?");
             }
                if(result.getHypothesis().equalsIgnoreCase("no")||result.getHypothesis().equalsIgnoreCase("enough")){
                    new Voicerec("as you wish");
                    break;
                  }
            }
         } 
         
       
        if(command.equalsIgnoreCase("allan go up")){
           try { 
            Thread.sleep(10); 
            } 
              catch (InterruptedException e) 
           { 

            } 
               
            
              robot.keyPress(KeyEvent.VK_UP); 
              Thread.sleep(5); 
              new Voicerec("ok");
         }
     
        
        if(command.equalsIgnoreCase("go left")||command.equalsIgnoreCase("go backward")){
           try { 
            Thread.sleep(10); 
            } 
              catch (InterruptedException e) 
           { 

            } 
               
            
               robot.keyPress(KeyEvent.VK_LEFT);
             
              Thread.sleep(5); 
              new Voicerec("ok");
         }
        
        if(command.equalsIgnoreCase("allan go right")||command.equalsIgnoreCase("go forward")){
           try { 
            Thread.sleep(10); 
            } 
              catch (InterruptedException e) 
           { 

            } 
               
           
               robot.keyPress(KeyEvent.VK_RIGHT);
             
              Thread.sleep(5); 
              new Voicerec("okey");
         }
         
        if(command.equalsIgnoreCase("next track")||command.equalsIgnoreCase("next music")||command.equalsIgnoreCase("next one")||command.equalsIgnoreCase("allan next one")||command.equalsIgnoreCase("next music allan")){
           try { 
            Thread.sleep(10); 
            } 
              catch (InterruptedException e) 
           { 

            } 
               
           
               robot.keyPress(KeyEvent.VK_PAGE_DOWN);
             
              Thread.sleep(5); 
              new Voicerec("okey sir");
         }
       if(command.equalsIgnoreCase("back track")||command.equalsIgnoreCase("previous track")||command.equalsIgnoreCase("back music")||command.equalsIgnoreCase("back track allan")||command.equalsIgnoreCase("previous track allan")){
           try { 
            Thread.sleep(10); 
            } 
              catch (InterruptedException e) 
           { 

            } 
               
           
               robot.keyPress(KeyEvent.VK_PAGE_UP);
             
              Thread.sleep(5); 
              new Voicerec("ok");
         }
       if(command.equalsIgnoreCase("allan go back")||command.equalsIgnoreCase("go back allan")){
           try { 
            Thread.sleep(10); 
            } 
              catch (InterruptedException e) 
           { 

            } 
               
             
               robot.keyPress(KeyEvent.VK_BACK_SPACE);
             
              Thread.sleep(5); 
              new Voicerec("ok");
         }
       
       if(command.equalsIgnoreCase("open my computer")){
                                             work = "explorer.exe";
                                             p=Runtime.getRuntime().exec(work);
                                             new Voicerec("done it");   
                                            
                                         }
       if(command.equalsIgnoreCase("close my computer")){
                                             work = "taskkill /IM explorer.exe";
                                             p=Runtime.getRuntime().exec(work);
                                             new Voicerec("done it");   
                                            
                                         }
 
                 int elenght = 0;
       if(command.equalsIgnoreCase("start typing")||command.equalsIgnoreCase("write down this")||command.equalsIgnoreCase("note down this")||command.equalsIgnoreCase("allan write down this")||command.equalsIgnoreCase("allan note down this")){
               work = "notepad.exe";
               p=Runtime.getRuntime().exec(work);
               new Voicerec("i'm ready" );
                        while((result = recognize.getResult()) != null){
                            String com4 = result.getHypothesis();
                             
                            if(com4.equalsIgnoreCase("exit")){
                                             work = "taskkill /IM notepad.exe";
                                             p=Runtime.getRuntime().exec(work);
                                             new Voicerec("done it");   
                                             break;
                                         }
                            if(com4.equalsIgnoreCase("next line")){
                                      robot.keyPress(KeyEvent.VK_ENTER);
                                      com4=null;
                                      
                                  }
                            try{
                            if(com4.equalsIgnoreCase("erase")||com4.equalsIgnoreCase("no no erase")||com4.equalsIgnoreCase("erase erase")){
                                      
                                     for(int i=0;i<=elenght;i++){
                                       robot.keyPress(KeyEvent.VK_BACK_SPACE);
                                     }
                                      com4=null;
                                      
                                  } 
                            }catch(NullPointerException s){}
                            
                            System.out.println(com4);
           
                            try { 
                                     Thread.sleep(10); 
                                 } 
                                   catch (InterruptedException e) 
                                 { 

                              } 
                                     try{
                                         if(com4!=null&&com4!="erase"){
                                                elenght=com4.length();
                                           }
                                         
                                        for(char i:com4.toCharArray()){
                                                 
                                                 int keycodet= KeyEvent.getExtendedKeyCodeForChar(i);
                                                  
                                                    robot.keyPress(keycodet);
                                                    
                                                    Thread.sleep(5);  
           
                                                 }
                                     }catch(NullPointerException ex){}
                                     if(com4!=null){
                                      robot.keyPress(KeyEvent.VK_SPACE);
                                     }
                                      
                             }  

                        }
       
                  if(command.equalsIgnoreCase("i am booring")||command.equalsIgnoreCase("allan i am booring")||command.equalsIgnoreCase("i'm booring")||command.equalsIgnoreCase(" allan i'm booring")){
               new Voicerec("if you like.'i can open you tube.' or play a song.' or a film" );
               while((result = recognize.getResult()) != null){
                   String bor = result.getHypothesis();
                   System.out.println(bor);
                        if(bor.equalsIgnoreCase("open youtube")){
                                             try{ 
                                                         d.browse(new URI("https://www.youtube.com/watch?v=JuygPoTr4X8")); }catch(IOException | URISyntaxException e2){e2.printStackTrace();}
                                                        new Voicerec("will do");
                                                        break;
                               }

             if (bor.equalsIgnoreCase("song is better")||bor.equalsIgnoreCase("play a song for me")||bor.equalsIgnoreCase("song for me")) 
           {
                
                      new Voicerec("best song for you");
                      File f=new File("D:\\music\\english\\KSHMR\\mandala.mp4");
                      d.open(f);
                      
                      f=new File("D:\\music");
                      d.open(f);
                      new Voicerec("your music derectory is also opened.");
                      break;
                       
               
              }

              if (bor.equalsIgnoreCase("movies")||bor.equalsIgnoreCase("play a movie")||bor.equalsIgnoreCase("movie is better")||bor.equalsIgnoreCase("film is better")||bor.equalsIgnoreCase("film")) {
               
               new Voicerec("your favourite movie sir");
               File f=new File("F:\\Films\\MARVEL MOVIES\\Iron Man (2008)\\Iron Man 2008.720p.BrRip.x264.YIFY.mp4");
                      d.open(f);
               
               
                f=new File("F:\\Films");
                d.open(f);
                new Voicerec("As a help i opened your film derectory too");
                break;
                
            }


        }  

}
         if (command.equalsIgnoreCase("allan take a photo")) {
               new Voicerec(1,2);
              File f=new File("D:\\my document\\My projects\\voicerec\\camera.jpg");
                d.open(f);
               
                
            }
         
          if (command.equalsIgnoreCase("music")) {
             
              //new Voicerec("play","");
               
               
             //  File f=new File("C:\\Users\\acer\\Desktop\\Projects\\java\\voicerec\\camera.jpg");
               // d.open(f);
               
                
            }
          
          if (command.equalsIgnoreCase("new")) {
             
             new Voicerec("","stop");
               
               
             //  File f=new File("C:\\Users\\acer\\Desktop\\Projects\\java\\voicerec\\camera.jpg");
               // d.open(f);
               
                
            }
          
          if (command.equalsIgnoreCase("track")) {
             
              new Voicerec("","","mute");
               
               
             //  File f=new File("C:\\Users\\acer\\Desktop\\Projects\\java\\voicerec\\camera.jpg");
               // d.open(f);
               
                
            }

      
        if (command.equalsIgnoreCase("System hibernate")) {
                work = "shutdown -h";
               p=Runtime.getRuntime().exec(work);
               
                
            }
        if (command.equalsIgnoreCase("System sign out")) {
                work = "shutdown -L";
               p=Runtime.getRuntime().exec(work);
               
                
            }
          
        if (command.equalsIgnoreCase("allan shutdown")||command.equalsIgnoreCase("shutdown allan")) {
                new Voicerec("shutting down");
                shutd=true;
                break;
                
            }
          
          }
         name=false; 
        }  
     if(shutd==true){
        break;
     }
     
     
   }
    }catch(NullPointerException es){}
 }


   

}
    

