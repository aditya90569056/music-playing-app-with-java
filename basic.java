package basicOfJava;
import java.util.Arrays;
import java.util.*;
import java.io.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.*;

public class basic {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        String filePath = "music.wav";
        File file = new File(filePath);
        try (Scanner scanner = new Scanner(System.in);AudioInputStream audioStream = AudioSystem.getAudioInputStream(file)) {
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            String respond = "";
            while(!respond.equals("q")){
                System.out.println("P=play");
                System.out.println("S=stop");
                System.out.println("R=rset");
                System.out.println("Q=quit");
                System.out.println("Enter you'r choice");
                respond = sc.nextLine();
                switch(respond){
                    case "p" ->clip.start();
                    case "s" ->clip.stop();
                    case "r" ->clip.setMicrosecondPosition(0);
                    case "q" ->clip.close();
                }
           }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

}