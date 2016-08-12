package Game;
import java.util.*;

public class Logic {

  private ArrayList< String > playerCards;
  private ArrayList< String > tableCards;

  public Logic( ArrayList playerCards, ArrayList tableCards ) {
    this.playerCards = playerCards;
    this.tableCards = tableCards;
  }

  public void combineCards() {
    this.playerCards.addAll( this.tableCards );
    System.out.println( this.playerCards );
  }

  public ArrayList seeHand() {
    return this.playerCards;
  }

  public boolean pair() {
    for( int i = 0; i < this.playerCards.size() - 1; i++ ) {
      if( this.playerCards.get(i).charAt( 0 ) == this.playerCards.get(i + 1).charAt( 0 ) ) {
        return true;
      }
    }
    return false;
  }

}
