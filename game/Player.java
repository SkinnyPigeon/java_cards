package Game;
import java.util.*;


public class Player {

  private String name;
  private ArrayList< String > hand;
  private int chips;
  private int bet;
  private int playerNumber;
  private Integer score;
  private Integer kicker;

  public Player( String name, int playerNumber ) {
    this.name = name;
    this.hand = new ArrayList< String >();
    this.chips = 500;
    this.bet = 0;
    this.playerNumber = playerNumber;
    this.score = 0;
    this.kicker = 0;
  }

  public String name() {
    return this.name;
  }

  public Integer seeScore() {
    return this.score;
  }

  public void awardScore( Integer handScore ) {
    this.score = handScore;
  }

  public void takeCard( String card ) {
    this.hand.add( card );
  }

  public ArrayList seeHand() {
    return this.hand;
  }

  public void awardKicker( Integer kickerScore ) {
    this.kicker = kickerScore;
  }

  public Integer seeKicker() {
    return this.kicker;
  }

  public int countChips() {
    return this.chips;
  }

  public void placeBet( int chips ) {
    if( this.chips >= chips ) {
      this.chips -= chips;
      this.bet = chips; 
    } else {
      this.bet = 0;
    }
  }

  public int check() {
    return this.bet;
  }

  public int giveBet() {
    return this.bet;
  }

  public int number() {
    return this.playerNumber;
  }

  public void winChips( int chips ) {
    this.chips += chips;
  }



}