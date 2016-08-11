package Game;
import java.util.*;

public class Cards {

  private ArrayList< String > cards;

  public Cards() {
    this.cards = new ArrayList< String>();
    this.cards.add( "A♠️" );
    this.cards.add( "A♥️" );
  }

  public int cardLength() {
    return this.cards.size();
  }




}