package Game;
import java.util.*;

public class Logic {

  private ArrayList< String > playerCards;
  private ArrayList< String > tableCards;

  public Logic( ArrayList playerCards, ArrayList tableCards ) {
    this.playerCards = playerCards;
    this.tableCards = tableCards;
  }

  // public void combineCards() {
  //   this.playerCards.addAll( this.tableCards );
  //   for( ArrayList item : this.playerCards ) {
  //     if( item != null ) {
  //     System.out.println( item.deal() );
  //     }
  //   }
  // }

}
