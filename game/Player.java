package Game;
import java.util.*;


public class Player {

  private String name;
  private ArrayList< String > hand;
  private int chips;
  private int bet;

  public Player( String name ) {
    this.name = name;
    this.hand = new ArrayList< String >();
    this.chips = 500;
    this.bet = 0;
  }

  public String name() {
    return this.name;
  }

  public void takeCard( String card ) {
    this.hand.add( card );
  }

  public ArrayList seeHand() {
    return this.hand;
  }

  public int countChips() {
    return this.chips;
  }

  public void placeBet( int chips ) {
    this.chips -= chips;
    this.bet = chips;
  }

  public int giveBet() {
    return this.bet;
  }



}