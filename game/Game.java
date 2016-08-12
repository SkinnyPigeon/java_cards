package Game;
import java.util.*;

public class Game {

  private int pot;
  private int lastBet;
  private int playerTurn;
  private int noOfPlayers;
  private ArrayList< String > sharedCards;
  private ArrayList< Player > winnerArray;
  private Player handWinner;
  
  public Game( int noOfPlayers ){
    this.pot = 0;
    this.playerTurn = 1;
    this.noOfPlayers = noOfPlayers;
    this.lastBet = lastBet;
    this.sharedCards = new ArrayList< String >();
    this.winnerArray = new ArrayList< Player >();
    this.handWinner = handWinner;
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

  public void addPlayer( Player player ) {
    this.winnerArray.add( player );
  }

  public ArrayList seeHand() {
    return this.sharedCards;
  }

  // @Override
  // public double compareTo( Player comparestu ) {
  //   double compareScore( ( Player ) comparestu ).seeScore();
  //   return comparestu.seeScore() - compareScore;
  // }

  // public void pickWinner() {
  //   Collections.sort( this.winnerArray );
  //   this.handWinner = this.winnerArray.get(0);
  // }

  // public Player seeWinner() {
  //   return this.handWinner;
  // }


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













