public class Game {
  
  public static void main(String[] args) {  

    Prompter prompter = new Prompter();
    Jar jar = new Jar(prompter.gameType(), prompter.gameMaxNumber()); 
    do{    
      prompter.play(jar); 
    }while(prompter.promptNewGame());              
  }
}
