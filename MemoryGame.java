/***************************************
Name: Manh Sy
Assignment: Project #4
objective: create a matching board game
****************************************/
//import to use scanner
import java.util.*;
//declare class
public class MemoryGame{
   
   //constant board size = 4 
   public static final int BOARD_SIZE = 4;
   //main method 
   public static void main(String[] args){
      run();
   }
   public static void run(){
      //print introduction 
      Introduction();
      //create memoryg game board 
      MemoryGameBoard game = new MemoryGameBoard();
      //declare scanner 
      Scanner console = new Scanner(System.in);
      //initialize all the needed variables 
      int bestScore=500;
      int turnCount = 0;
      int pairsLeft = 0;
      boolean playGame=false;
      //prompt for user to start the game 
      System.out.println("Press any key to start the game");
      //if user input number or word 
      if(console.hasNext()||console.hasNextInt()){
         //clear out the console
         console.next();
         //set playGame = true so the game can start 
         playGame = true;
      }
      //while play game is true 
      while(playGame){
         //shuffle cards
         game.shuffleCard();
         //get the value of pairs left 
         pairsLeft = (int)Math.pow(BOARD_SIZE,2)/2;
         //display the board 
         game.showBoard();
         //while pairs left is not 0 
         while(pairsLeft!=0){
            
            //initialize all the needed variable 
            int row=0;
            int column=0;
            int row2=0;
            int column2=0;
            //while pairsleft is not 0
            while(pairsLeft!=0){
                //prompt for the user 
               System.out.println("Where is the first card you wish to see?");
                //get the values from getValidInt method 
               row = getValidInt("Row: ");
               column = getValidInt("Column: ");
               System.out.println("Where is the second card you wish to see?");
               row2 = getValidInt("Row: ");
               column2 = getValidInt("Column: ");
                //while card chosen is flipped 
               while(game.isFaceUp(row, column)||game.isFaceUp(row2, column2)) {
                  int roow = 0;
                  int cool = 0;
                     //if card 1 is flipped
                  if(game.isFaceUp(row, column)){
                        //get the value of the numbers entered 
                     roow = row;
                     cool = column;
                     //else get the values of the second card entered
                  }else{
                     roow = row2;
                     cool = column2;
                  }
                     //let the uer know that card was already flipped and prompt them to get another card 
                  System.out.printf("Card at row: %d & column: %d was already successfully flipped, please pick another card\n", roow, cool);
                  System.out.println("Where is the first card you wish to see?");
                  row = getValidInt("Row: ");
                  column = getValidInt("Column: ");
                  System.out.println("Where is the second cared you wish to see?");
                  row2 = getValidInt("Row: ");
                  column2 = getValidInt("Column: ");
                     //while loop will exit when the user enters cards that hasn't alreayd been flipped 
               }
            //flip card at the entered dimension 
               game.flipCard(row, column);
            //flip card at the entered dimension
               game.flipCard(row2, column2);
            //check if the two cards entered mathces 
               boolean match = game.cardsMatch(row, column, row2, column2);
            //if card entered are at the same places then...
               if(row==row2 && column == column2){
               //match = false 
                  match = false;
               //prompt for the user to not input same cards 
                  System.out.println("Please do not input two of the same cards!");
               }
            
            //display the board 
               game.showBoard();
            //if match is true and paird left is not 0 
               if(match&&pairsLeft!=0) {
                  //prompt for the user 
                  System.out.println("You found a match!");
                  //incriment count 
                  turnCount++;
                  //decriment pairs left 
                  pairsLeft--;
                  //prompt the user to press any key to continue playing 
                  System.out.print("Press any key to continue");
                  //if user input String or int 
                  if(console.hasNext() || console.hasNextInt()){
                     //show the card
                     game.showBoard();
                     //clear the console 
                     console.next();                  
                  }
               //else      
               }else {
               //tell user cards selected does not match 
                  System.out.println("Not a match, better luck next time!");
               //incriment count 
                  turnCount++;
               //flips the card back to normal 
                  game.flipCard(row, column);
                  game.flipCard(row2, column2);
               //prompt to the user to press whatever to continue 
                  System.out.print("Press any key to continue");
                  if(console.hasNext() || console.hasNextInt()){
                     game.showBoard();
                     console.next();
                  }
               
               }            
            }
         
         }
         //if there is no pairs left 
         if(pairsLeft==0){
            //print
            System.out.println("CONGRATULATION, YOU FOUND ALL THE MATCHING PAIRS");
            //print wit turn count 
            System.out.printf("You did it in %d turn\n", turnCount);
            //if turn count is smalll thean best cored
            if(turnCount<bestScore){
               //display the method 
               System.out.println("That is your best score so far");
               //get best score to turn count 
               bestScore = turnCount;
            //else 
            }else{
               //print
               System.out.println("That is not your best score so far");
            }
            //ask the user if they'd like to play again 
            System.out.println("would you like to play again");
            String ans = console.next();
            //if yes, set playGame to true to the loop can repeast 
            if(ans.equalsIgnoreCase("yes")){
               playGame = true;
            //if not set game Game to false
            }else{
               System.out.println("Thanks for playing, play again soon :)");
               playGame = false;
            }
            
         }
      }
   }

   public static int getValidInt(String prompt) {
      Scanner console = new Scanner(System.in);
      int rowcolumn=0;
      System.out.print(prompt);
      while(true) {
         while(!console.hasNextInt()) {
            console.next();
            System.out.print(prompt);
         }
         rowcolumn = console.nextInt();
         if(rowcolumn<=4 && rowcolumn>=1) {
            return rowcolumn;
         }
         else{
            System.out.println("Please only input numbers on the range of 1-4 ");
            System.out.print(prompt);
         }
      }
      
   }
   public static void Introduction(){
      System.out.println("Welcome to the Memory Game.");
      System.out.println("The goal is to find all the matching pairs in as few turns as possible.\nAt each turn select two different positions on the board to see if they match.");
   }
}