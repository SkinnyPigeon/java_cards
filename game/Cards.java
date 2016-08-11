package Game;
import java.util.*;

public class Cards {

  private String dealtCards;
  private ArrayList< String > cards;
  private ArrayList< String > shuffledCards;

  public Cards() {
    this.cards = new ArrayList< String>();
    this.cards.add( "A♠️" );
    this.cards.add( "A♥️" );
    this.cards.add( "A♣️" );
    this.cards.add( "A♦️" );

    this.dealtCards = dealtCards;
  }

  public int cardLength() {
    return this.cards.size();
  }

  public String shuffle() {
    Collections.shuffle( this.cards );
    for( String card : this.cards ) {
      if( card != null ) {
        System.out.println( card );
      }
    }
    return "Shuffled 😀";
  }

  public void pickCard() {
    this.dealtCards = this.cards.remove(0); 
  }

  public String deal() {
    pickCard();
    return this.dealtCards;
  }




}