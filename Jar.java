import java.util.Scanner;
import java.util.Random;

public class Jar{
  private String mTypeOfItem;
  private int mMaxNumber;
  private int someNumber;
  public int numberOfGuesses = 0;
  public int numberOfWins = 0;
  public boolean yesGuess = false;
  int[] anArray;
  public int arg = 0;
  Scanner scanner = new Scanner(System.in);
  
  public Jar(String type, int max){
      mTypeOfItem = type;
      mMaxNumber = max;
      anArray = new int[mMaxNumber];
      this.fillRandomNumber();
    
  /*  
    System.out.print("What type of item? ");
    System.out.printf("%n");
    this.fillJarItem();
    System.out.print("How many will fit in the jar? ");
    System.out.printf("%n");
    this.fillJarInt();
    this.fillRandomNumber();
    
  */  
    
  }
  

  

  
  public int fillRandomNumber(){
    boolean isNotZero = true;
    Random random = new Random();
    someNumber = 0;
    int i = 0;
    while (isNotZero){
      someNumber = random.nextInt(mMaxNumber+1);  //if number is 20, the random number can be 0-19. Adds 1 to allow 20 to be a choice
      System.out.printf("New Guess: %s %n",someNumber); //Delete This
      if(someNumber != 0 || i == 5){
        isNotZero = false;
      }
      i++;
    }
    return someNumber;   
  }
  
  public String getTypeOfItem(){ 
  return mTypeOfItem;
  } 
  
  public int getNumberOfItems(){
  return mMaxNumber;
  }
  
  public int getRandomNumber(){
  return someNumber;
  }  
  
  public void resetGame(){
    numberOfGuesses = 0;
    arg = 0;
  }
  
public void validateGuessForTwo(int guessing){
  for(int i=0; i<anArray.length; i++){
    if(guessing == anArray[i]){
      yesGuess = true;
    }else{   
    }
  }
}
  
  
  public boolean isWinner(int guess){
    boolean isTrue = false;
    if(guess > mMaxNumber){
      System.out.printf("Way too high \n"); 
    }else{
      validateGuessForTwo(guess);
      anArray[arg] = guess;
      if(yesGuess == false){
        numberOfGuesses++;
        if(someNumber == guess){
          isTrue = true;
          numberOfWins++;
          arg++;
          System.out.printf("You Win!\n" );
          System.out.printf("You guessed %s time(s) and won %s time(s). \n", numberOfGuesses, numberOfWins);
        } else if(guess > someNumber){
          System.out.printf("Guess is too high. Try again.\n");
        }else{
          System.out.printf("Guess is too low. Try again. \n");
        }
      }else{
        System.out.printf("You already guesed that. %n");
      }
    }
    yesGuess = false;
    return isTrue;
  }
}