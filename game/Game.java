package Game;
import java.util.*;

public class Game {

  private int pot;
  private int playerTurn;
  private int noOfPlayers;
  
  public Game( int noOfPlayers ){
    this.pot = 0;
    this.playerTurn = 1;
    this.noOfPlayers = noOfPlayers;
  }

  public void takeTurn(){
  } 

  public int showPot() {
    return this.pot;
  }

  public boolean playerCheck( Player player ) {
    if( player.number() == this.playerTurn ) {
      return true;
    } else {
      return false;
    }
  }

  public void addBet( Player player ) {
    if( playerCheck( player ) == true ) {
      this.pot += player.giveBet();
    }
  }

  public int turn() {
    return this.playerTurn;
  }

  public int numberOfPlayers() {
    return this.noOfPlayers;
  }

  public void nextTurn() {
    if( this.playerTurn == this.noOfPlayers ) {
      this.playerTurn = 1;
    } else {
      this.playerTurn += 1;
    }
  }



}













