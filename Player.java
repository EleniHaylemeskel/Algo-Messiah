/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package player;

/**
 *
 * @author LENOVO
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;


public class Player {
    /**
     * @param args the command line arguments
     */
   private static ArrayList<Play_List> play_lists = new ArrayList<Play_List>();
  
   
   private static void printMenu(){
       System.out.println("Enter your choice:\n" + "1.Next Song\n" + "2.Print Playlist."+"3. Play Again");
   }
   
   
   private static void displayPlaylist(LinkedList playlist){
	   
       ListIterator<Song> displayList=playlist.listIterator();
       if(displayList.hasNext()){
           System.out.println("****************************");
           System.out.println("Songs in the playlist: ");
       }
       else{
           System.out.println("Empty playlist.");
           return;
       }
       while(displayList.hasNext()){
           System.out.println(displayList.next().toString());
       }
       System.out.println("****************************");
   }
   
   
   public static void play(LinkedList playlist){
	   Test_Play_List pl=new Test_Play_List();
       ListIterator<Song> songPlayer=playlist.listIterator();
       if(playlist.isEmpty()){
           System.out.println("Empty playlist!");
           return;
       }
       else{
           System.out.println("Now playing " + songPlayer.next().toString());
           printMenu();
       }
       
       Scanner scanner=new Scanner(System.in);
       boolean goingForward=true;
       while(true){
           int action=scanner.nextInt();
           
           switch(action){
               case 0:
               System.out.println("Playlist completed");
               return;
               case 1:
                   if(!goingForward){
                       if(songPlayer.hasNext()){
                           songPlayer.next();
                       }
                       goingForward=true;
                   }
                   if(songPlayer.hasNext()){
                       System.out.println("Now playing " + songPlayer.next().toString());
                   }
                   else{
                       System.out.println("This is the last song.");
					   
                   }
                   break;
               case 2:
                   displayPlaylist(playlist);
                   break;
				case 3:
				pl.main();
				break;
				
           }
       }
   }
    
   
}
