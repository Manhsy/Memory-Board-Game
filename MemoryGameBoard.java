/***************************************
Name: Manh Sy
Assignment: Project #4
objective: create a matching board game
****************************************/
//import to use random 
import java.util.*;
//declare class
public class MemoryGameBoard{
   //declare all the needed fields 
   public int BOARD_SIZE = 4;
   private int NUM_SWAPS = 1000;
   private Card[][] gameBoard;
   //constructor to create two dimensional cards and initialize them 
   public MemoryGameBoard(){
      gameBoard = new Card[BOARD_SIZE+1][BOARD_SIZE+1];
      initializeCards();
   }
   //method to shuffle cards
   public void shuffleCard(){
      //turn cards face down 
      turnCardsFaceDown();
      Random rand = new Random();
      //for loop to shuffle card
      for(int i = 0; i < NUM_SWAPS; i++){
         int a = rand.nextInt(BOARD_SIZE)+1; 
         int b = rand.nextInt(BOARD_SIZE)+1;
         int c = rand.nextInt(BOARD_SIZE)+1;
         int d = rand.nextInt(BOARD_SIZE)+1;
         Card hold = gameBoard[a][b];
         Card hold2 = gameBoard[c][d];
         gameBoard[c][d]=hold;
         gameBoard[a][b]=hold2;
      }
   }
   //show board 
   public void showBoard(){
      //hide board 
      hideBoard();
      //print out board 
      System.out.println(this);
      
   }
   //return whether or not the cards picked matches 
   public boolean cardsMatch(int row1, int col1, int row2, int col2){
      
      if(gameBoard[row1][col1].getValue()==gameBoard[row2][col2].getValue()) {
         return true;
      }else {
         return false;
      }
   }
   //return if the cards picked already faces up 
   public boolean isFaceUp(int row, int col){
      
      if(gameBoard[row][col].isFaceUp()){
         return true;
      }else{
         return false;
      }
      
   }
   //flip the card at the chosen place 
   public void flipCard(int row1, int col1){
      gameBoard[row1][col1].flipCard();
   }
   //initialize the cards 
   public void initializeCards(){
   
      int count = 1;
      int temp = 1;
      int o=1; 
      while(o<=4){
         for(int i = 1; i <= BOARD_SIZE; i++){
            gameBoard[count][i]= new Card(temp);
            temp++;
         }
         count++;
         o++;
         if(temp>8){
            temp=1;
         }
      }
   }
   //method to hide board by printing 10 empty lines 
   private void hideBoard(){
      for(int i = 1; i<=10; i++) {
         System.out.println();
      }
   }
   //method to turn card face down 
   private void turnCardsFaceDown(){
      //loop for board size 
      for(int i = 1; i <= BOARD_SIZE; i++) {
         for(int j = 1; j <= BOARD_SIZE; j++) {
         //turn [i][j] face down 
            gameBoard[i][j].setFaceDown();
         }
      }
   }
   //method to print the string of the board 
   public String toString(){
      String temp = String.format("   1 2 3 4\n   =======\n1 |%s %s %s %s|\n2 |%s %s %s %s|\n3 |%s %s %s %s|\n4 |%s %s %s %s|\n   =======",
      gameBoard[1][1],gameBoard[1][2],
      gameBoard[1][3],gameBoard[1][4],
      gameBoard[2][1],gameBoard[2][2],
      gameBoard[2][3],gameBoard[2][4],
      gameBoard[3][1],gameBoard[3][2],
      gameBoard[3][3],gameBoard[3][4],
      gameBoard[4][1],gameBoard[4][2],
      gameBoard[4][3],gameBoard[4][4]);
      return temp;
   }
  
}

