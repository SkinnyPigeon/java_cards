package Game;
import java.util.*;


public class Player {

  private String name;
  private ArrayList< String > hand;

  public Player( String name ) {
    this.name = name;
    this.hand = new ArrayList< String >();
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

}