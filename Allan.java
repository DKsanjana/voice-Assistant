/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 package voicerec;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import com.teamdev.jxmaps.Circle;
import com.teamdev.jxmaps.CircleOptions;
import com.teamdev.jxmaps.ControlPosition;
import com.teamdev.jxmaps.LatLng;
import com.teamdev.jxmaps.Map;
import com.teamdev.jxmaps.MapOptions;
import com.teamdev.jxmaps.MapReadyHandler;
import com.teamdev.jxmaps.MapStatus;
import com.teamdev.jxmaps.MapTypeControlOptions;
import com.teamdev.jxmaps.Marker;
import com.teamdev.jxmaps.Polyline;
import com.teamdev.jxmaps.PolylineOptions;
import com.teamdev.jxmaps.swing.MapView;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import jaco.mp3.player.MP3Player;
import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import static java.lang.Thread.sleep;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import static java.util.Arrays.stream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import voicerec.Voicerec;

import voicerec.Mapa;

//import java.util.*;


/**
 *
 * @author acer
 */
 
 
public class Allan extends javax.swing.JFrame {

    
  String gotcom;
   String gotresu;
    /**
     * Creates new form Allan
     */
   
    MP3Player player;
    
    File songFile;
    
    String currentDirectory = "home.user"; // I am using home.user this will call file chooser in user documents.
   
    String currentPath;
   
    String imagePath;
   
    String appName = "JOBME TECH SOLUTIONS - (MP3 Player)";
   
    boolean repeat = false;
    
   
    boolean windowCollapsed = false;
   
   
   public Allan() {
        initComponents();
        clock();
       
        
       // Weather("");
       
      //  showing();
        
     /* ImageIcon myimage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Aln.jpg") ));
        Image img1=myimage.getImage();
        Image img2=img1.getScaledInstance(jLabel2.getWidth(),jLabel2.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon i =new ImageIcon(img2);
        jLabel1.setIcon(i);
        */
     
     
        
        
    }
   
    
    public void MusicP()
    {
       Thread th;
        th = new Thread(){
            public void run(){
                try{
        
        songFile = new File("D:\\music\\romanian\\Edward Maya ft. Vika Jigulina - This Is My Life.mp3");
        
        
        String fileName = songFile.getName();
        
        //songNameDisplay.setText(fileName);
        
        
        player = mp3Player();
      
        player.addToPlayList(songFile);
        
        
        currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
        imagePath = "\\images";
        player.play();
         
         }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                    
                }
             
            }
            
            
        };
     th.start();  
      
    
    }
    
    public void stopM()
    {
        
      player.stop();
       
          
    }
    
    public void pauseM()
    {
      player.pause();
    }
    
    
    public void repeat()
    {
      if(repeat == false){
            repeat = true;
            player.setRepeat(repeat);
            
            String image = currentPath+imagePath+"\\repeat_enabled.png";
            //repeatBtn.setIcon(new ImageIcon(image));
        }else if(repeat == true){
            repeat = false;
            player.setRepeat(repeat);
            
            String image = currentPath+imagePath+"\\repeat.png";
           // repeatBtn.setIcon(new ImageIcon(image));            
        }
    }
    
     private MP3Player mp3Player(){
        MP3Player mp3Player = new MP3Player();
        return mp3Player;
    }
     
    public void muteM()
    {
         Mixer.Info[] mixers = AudioSystem.getMixerInfo();
        // Now use a for loop to list all mixers
        for(Mixer.Info mixerInfo : mixers){
            // Get Mixer
            Mixer mixer = AudioSystem.getMixer(mixerInfo);
            // Now Get Target Line
            Line.Info[] lineInfos = mixer.getTargetLineInfo();
            // Here again use for loop to list lines
            for(Line.Info lineInfo : lineInfos){
                // Make a null line
                Line line = null;
                // Make a boolean as opened
                boolean opened = true;
                // Now use try exception for opening a line
                try{
                    line = mixer.getLine(lineInfo);
                    opened = line.isOpen() || line instanceof Clip;
                    // Now Check If Line Is not Opened
                    if(!opened){
                        // Open Line
                        line.open();
                    }
                    // Make a float control
                    FloatControl volControl = (FloatControl) line.getControl(FloatControl.Type.VOLUME);
                    // Get Current Volume Now
                    float currentVolume = volControl.getValue();
                    // Make a temp double variable and store valuePlusMinus
                    Double volumeToCut = 0.0;
                    // Make a float and calculate the addition or subtraction in volume
                    float changedCalc = (float) ((double)volumeToCut);
                    // Now Set This Changed Value Into Volume Line.
                    volControl.setValue(changedCalc);
                    
                }catch (LineUnavailableException lineException){
                }catch (IllegalArgumentException illException){
                }finally{
                    // Close Line If it opened
                    if(line != null && !opened){
                        line.close();
                    }
                }
            }
        }
    
    
    }
         
  
   
/*   protected DaemonThread myThread = null;
    int count = 0;
    VideoCapture webSource = null;
    Mat frame = new Mat();
    MatOfByte mem = new MatOfByte();
    CascadeClassifier faceDetector = new CascadeClassifier(Voicerec.class.getResource("haarcascade_frontalface_alt.xml").getPath().substring(1));
    MatOfRect faceDetections = new MatOfRect();

    private void setOnMapReadyHandler(MapReadyHandler mapReadyHandler) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
   

    class DaemonThread implements Runnable {

        protected volatile boolean runnable = false;

        @Override
        public void run() {
            synchronized (this) {
                while (runnable) {
                    if (webSource.grab()) {
                        try {
                            webSource.retrieve(frame);
                            Graphics g = jPanel2.getGraphics();
                           // Graphics g = jDesktopPane1.getGraphics();
                            faceDetector.detectMultiScale(frame, faceDetections);
                            for (Rect rect : faceDetections.toArray()) {
                                System.out.println("ttt");
                               
                                 Core.rectangle(frame, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
                                        new Scalar(0, 255,0));
                                 
                            }
                            Highgui.imencode(".bmp", frame, mem);
                            Image im = ImageIO.read(new ByteArrayInputStream(mem.toArray()));
                            BufferedImage buff = (BufferedImage) im;
                            if (g.drawImage(buff, 0, 0, getWidth(), getHeight()-150 , 0, 0, buff.getWidth(), buff.getHeight(), null)) {
                                if (runnable == false) {
                                    System.out.println("Paused ..... ");
                                    this.wait();
                                }
                            }
                        } catch (Exception ex) {
                            System.out.println("Error!!");
                            ex.printStackTrace();
                            
                            new Voicerec("Access Denied!");
                        }
                    }
                }
         
            }
            
                       //start thrad
       
            
            
        }
    }               
           
  
   
    */
    
  
     public void map(String[] args){
       
         System.out.println("inside the method"); 
        Mapa.run(args);
       
         jPanel3.getGraphics();
              Thread th;
        th = new Thread(){
            public void run2(){
                
                
             
                
            }
                };
     th.start(); 
        
    }
          //String w;
     public void Weather(String x) throws IOException{
        // jLabel4.setText("Distric :"+x);
        System.out.println("weather");
        
      
   
    
    }
    
    
    
    
    
   public void clock(){
       
        Thread th;
        th = new Thread(){
            public void run(){
                
                try{
                    for(;;){
                        Calendar cl=new GregorianCalendar();
                        int day=cl.get(Calendar.DAY_OF_MONTH);
                        int month=cl.get(Calendar.MONTH);
                        int year=cl.get(Calendar.YEAR);
                        
                        int second=cl.get(Calendar.SECOND);
                        int min=cl.get(Calendar.MINUTE);
                        int hour=cl.get(Calendar.HOUR);
                        int am_pm=cl.get(Calendar.AM_PM);
                        
                        String d_n="";
                        if(am_pm==1)
                            d_n="PM";
                        else
                            d_n="AM";
                        
                        if(hour==00){ hour=12; };
                        
                        String h= Integer.toString(hour);
                        
            
              
                        jLabel2.setText(""+h+":"+min+":"+second+" "+d_n+"");
                       // jLabel4.setText(" "+day+"/"+month+"/"+year+"");
                        sleep(1000); 
                        
                        //String distric= vc.w;
                       
                       
                      //System.out.println(gotcom);
                      
                      
                         
                   
                    }
                    
                                         

                }
                catch(InterruptedException ex)
                {
                    ex.printStackTrace();
                }
                
                
                 
            }
         
         
        };
     th.start();
   
    
    } 
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(null);

        jLabel2.setBackground(new java.awt.Color(0, 255, 255));
        jLabel2.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 255, 255));
        jPanel1.add(jLabel2);
        jLabel2.setBounds(740, 10, 200, 30);

        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(0, 710, 1680, 90);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setBorder(null);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(1620, 90, 40, 40);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(1620, 40, 40, 40);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(20, 20, 260, 240);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jLabel4.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 255, 0));
        jLabel4.setText("jLabel4");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel4)
                .addContainerGap(382, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel4)
                .addContainerGap(131, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(1200, 420, 460, 190);
        jPanel1.add(jLabel5);
        jLabel5.setBounds(400, 280, 50, 40);

        jButton3.setText("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(940, 260, 79, 25);

        jButton4.setText("jButton4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(940, 350, 79, 25);

        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1680, 800);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1679, 801));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      // TODO add your handling code here:
      // video capture from default cam
    /*    webSource = new VideoCapture(0);
        myThread = new DaemonThread(); //create object of threat class
        Thread t = new Thread(myThread);
        t.setDaemon(true);
        myThread.runnable = true;
        t.start();
        
        new Voicerec("waiting for face authorization!");
        */
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        //   myThread.runnable = false;            // stop thread
            // deactivate stop button
    
       
       // webSource.release();         // TODO add your handling code here:
       
      String drinks[] = {"water", "coffee", "tea"};

       map(drinks);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
           //player.stop();
           // TODO add your handling code here:
           stopM();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
           MusicP();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed
                
   /*   public void showing(java.awt.event.ActionEvent evt){
        webSource = new VideoCapture(0);
        myThread = new DaemonThread(); //create object of threat class
        Thread t = new Thread(myThread);
        t.setDaemon(true);
        myThread.runnable = true;
        t.start();
      
      }      */       
                 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException, AWTException, InterruptedException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Allan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Allan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Allan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Allan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
          
        // System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
         
         
          
         
        java.awt.EventQueue.invokeLater(new Runnable() {
           
            
            public void run() {
               try{
                Thread.sleep(5500);
               }
               catch(Exception e){}
             new  Allan().setVisible(true);
                
           }
            
            
           
        });
        
        //Voicerec.AllanWorks(args); 
                         
    
     //System.out.println(Runtime.getRuntime().toString());
      
       
       
               

        
        
        
       
    }
    
    
    
    
    
    
    
    
    
    
    
   
    
    
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables


}

