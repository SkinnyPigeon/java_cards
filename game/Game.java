package Game;
import java.util.*;

public class Game  {

  private int pot;
  private int lastBet;
  private int playerTurn;
  private int noOfPlayers;
  private ArrayList< String > sharedCards;
  private ArrayList< Player > winnerArray;
  private PlayerComparator playerComparator;
  private KickerComparator kickerComparator;
  private Player handWinner;
  
  public Game( int noOfPlayers ){
    this.pot = 0;
    this.playerTurn = 1;
    this.noOfPlayers = noOfPlayers;
    this.lastBet = lastBet;
    this.sharedCards = new ArrayList< String >();
    this.winnerArray = new ArrayList< Player >();
    this.handWinner = handWinner;
    this.playerComparator = new PlayerComparator();
    this.kickerComparator = new KickerComparator();
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

  public void pickWinner() {
    Collections.sort( this.winnerArray, this.playerComparator );
    for( int i = 0; i < this.winnerArray.size() - 1; i++ ) {
      if( ( this.winnerArray.get( i ).seeScore() ).intValue() == ( this.winnerArray.get( i + 1 ).seeScore() ).intValue() ) {
        pickKicker();
      } else {
        this.handWinner = this.winnerArray.get( this.winnerArray.size() - 1 );
      }
    }
  }

  public void pickKicker() {
    Collections.sort( this.winnerArray, this.kickerComparator );
    this.handWinner = this.winnerArray.get( this.winnerArray.size() - 1 );
  }

  public Player seeWinner() {
    return this.handWinner;
  }

  public void takeCard( String card ) {
    this.sharedCards.add( card );
  }

  public void addPlayer( Player player ) {
    this.winnerArray.add( player );
  }

  public ArrayList showPlayers() {
    return this.winnerArray;
  }

  public ArrayList seeHand() {
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













