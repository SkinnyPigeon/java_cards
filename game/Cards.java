package Game;
import java.util.*;

public class Cards {

  private String dealtCard;
  private ArrayList< String > cards;
  private ArrayList< String > shuffledCards;

  public Cards() {
    this.cards = new ArrayList< String>();
    this.cards.add( "A♠️" );
    this.cards.add( "A♥️" );
    this.cards.add( "A♣️" );
    this.cards.add( "A♦️" );
    this.cards.add( "K♠️" );
    this.cards.add( "Q♠️" );
    this.cards.add( "K♥️" );
    this.cards.add( "2♥️" );
    this.cards.add( "3♥️" );
    this.cards.add( "4♥️" );
    this.cards.add( "5♥️" );
    this.cards.add( "6♥️" );
    this.cards.add( "J♠️" );
    this.cards.add( "10♠️" );
    this.cards.add( "9♠️" );
    this.cards.add( "8♠️" );
    this.cards.add( "7♠️" );
    this.cards.add( "6♠️" );

    this.dealtCard = dealtCard;
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
    this.dealtCard = this.cards.remove(0); 
  }

  public String deal() {
    pickCard();
    return this.dealtCard;
  }




}