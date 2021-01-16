/***************************************
Name: Manh Sy

objective: create a matching board game
****************************************/
public class Card{
   //value representing the value of the card
   private int value;
   //boolean indicating if the card is face up or down 
   private boolean faceUp;
   public Card(int initValue){
      this.value = initValue;
      this.faceUp = false;
   }
   //return the value 
   public int getValue(){
      return value;
   }
   //return faceUp value 
   public boolean isFaceUp(){
      return faceUp;
   }
   //flip card method 
   public void flipCard(){
      //if face up = true 
      if(faceUp){
         //face up = false
         this.faceUp=false;
      }else{
         //face up = true 
         this.faceUp=true;
      }
   }
   //method to set card face up 
   public void setFaceUp(){
      this.faceUp = true;
   }
   //method to set card face down 
   public void setFaceDown(){
      this.faceUp = false;
   }
   //method to compare one card to the other 
   public boolean equals(Card otherCard){
      if(this.value==otherCard.value){
         return true;
      }else{
         return false;
      }
   }
   //method to replaces all the cards facing down to *'s
   public String toString(){
      String temp = "";
      if(faceUp){
         temp+=value;
      }else{
         temp = "*";
      }
      return temp;
   }
}
