package greerj.ma6;

//Player class
public class Player {
    String name;
    int attempts;
    int noGuesses;
    
    //sets name into player 
    void setName(String name){
        this.name = name;
    }
    
    //tracks attempts
    public void timesGuessed(int noGuesses){
        attempts += noGuesses;
    }

    //congratulates. prints out attempts and then sets to 0
    void result(){
        System.out.println("Congratulations! Phrase found!");
        System.out.println("Attempts: " + attempts);
        noGuesses = 0;
        attempts = 0;
    }

    
}
