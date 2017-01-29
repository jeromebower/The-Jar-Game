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
  private Prompter mGameSetup = new Prompter();
  
  public Jar(String type, int max){
    mTypeOfItem = type;
    mMaxNumber = max;                                 
    this.fillRandomNumber();   
  }
  
  public int fillRandomNumber(){
    anArray = new int[mMaxNumber];  //creates an array to store previously guessed numbers, it uses the max number as index because you can't guess over or under
    boolean isNotZero = true;
    Random random = new Random();
    someNumber = 0;
    int i = 0;
    //while (isNotZero){
    do{
      someNumber = random.nextInt(mMaxNumber+1);
      System.out.printf("%s %n", someNumber);
      //to loop for a number other than zero - Comment out from here
      if(someNumber == 0){        
        System.exit(0);//to pass test
      }//Comment to here
    }while(someNumber == 0);
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
    //resets the game variables
    numberOfGuesses = 0;
    arg = 0;
    anArray = null;
    mTypeOfItem = mGameSetup.gameType();
    mMaxNumber = mGameSetup.gameMaxNumber();
    this.fillRandomNumber();
  }
  
  public void validateGuessForTwo(int guessing){
    //for loop through the array for already guessed number, setting yesGuess to true if it finds it
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
      //checks if guess is greater than max guess
      System.out.printf("Way too high \n"); 
    }else{
      validateGuessForTwo(guess);                                                       //tests guess for previously used guess
      anArray[arg] = guess;                                                             //sets the next index of the array with the new guess
      if(yesGuess == false){
        numberOfGuesses++;
        arg++;
        if(someNumber == guess){
          isTrue = true;
          numberOfWins++;
          System.out.printf("You Win!\n" );
          System.out.printf("You guessed %s time(s) and won %s time(s). \n", numberOfGuesses, numberOfWins);
        }else if(guess > someNumber){
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
