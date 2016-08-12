package Game;
import java.util.*;

public class Game {

  private int pot;
  private int lastBet;
  private int playerTurn;
  private int noOfPlayers;
  private ArrayList< String > sharedCards;

  
  public Game( int noOfPlayers ){
    this.pot = 0;
    this.playerTurn = 1;
    this.noOfPlayers = noOfPlayers;
    this.lastBet = lastBet;
    this.sharedCards = new ArrayList< String >();
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

  public void takeCard( String card ) {
    this.sharedCards.add( card );
  }

  public ArrayList seeCards() {
    return this.sharedCards;
  }

  public void addBet( Player player ) {
    if( ( playerCheck( player ) == true ) && ( this.lastBet <= player.giveBet() )) {
      this.pot += player.giveBet();
      this.lastBet = player.giveBet();
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

  public void handWon( Player player ) {
    player.winChips( this.pot );
  }

}













