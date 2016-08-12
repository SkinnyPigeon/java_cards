package Game;
import java.util.*;

public class Logic {

  private ArrayList< String > playerCards;
  private ArrayList< String > tableCards;
  private ArrayList< String > processedCards;

  public Logic( ArrayList playerCards, ArrayList tableCards ) {
    this.playerCards = playerCards;
    this.tableCards = tableCards;
    this.processedCards = new ArrayList< String >();
  }

  public int royalConverter( String card ) {
    if( card == "K" ) {
      return 13;
    } else if( card == "Q" ) {
      return 12;
    } else if( card == "J" ) {
      return 11;
    } 
    return 0;
  }

  public int aceConverterHigh( String card ) {
    if( card == "A" ) {
      return 14;
    }
    return 0;
  }

  public int aceConverterLow( String card ) {
    if( card == "A" ) {
      return 1;
    }
    return 0;
  }

  public int cardChecker( String card ) {
    if( royalConverter( card ) != 0 ) {
      return royalConverter( card );
    } else if ( aceConverterHigh( card ) != 0 ) {
      return aceConverterHigh( card );
    }
    return Integer.parseInt( card );
  }



  public void combineCards() {
    this.playerCards.addAll( this.tableCards );
    Collections.sort( this.playerCards );
  }

  public ArrayList seeHand() {
    return this.playerCards;
  }

  public boolean pair() {
    char firstCard;
    char secondCard;
    for( int i = 0; i < this.playerCards.size() - 1; i++ ) {
      firstCard = this.playerCards.get( i ).charAt( 0 );
      secondCard = this.playerCards.get( i + 1).charAt( 0 );
      if( firstCard == secondCard ) {
        this.processedCards.add( this.playerCards.remove( i + 1) );
        this.processedCards.add( this.playerCards.remove( i ) );
        return true;
      } 
    }
    return false;
  }

  public boolean three() {
    char firstCard;
    char secondCard;
    char thirdCard;
    for( int i = 0; i < this.playerCards.size() - 2; i++ ) {
      firstCard = this.playerCards.get( i ).charAt( 0 );
      secondCard = this.playerCards.get( i + 1 ).charAt( 0 );
      thirdCard = this.playerCards.get( i + 2 ).charAt( 0 );
      if( firstCard == secondCard && firstCard == thirdCard ) {
        this.processedCards.add( this.playerCards.remove( i + 2 ) );
        this.processedCards.add( this.playerCards.remove( i + 1 ) );
        this.processedCards.add( this.playerCards.remove( i ) );
        return true;
      } 
    }
    return false;
  }

  public boolean four() {
    char firstCard;
    char secondCard;
    char thirdCard;
    char fourthCard;
    for( int i = 0; i < this.playerCards.size() - 3; i++ ) {
      firstCard = this.playerCards.get( i ).charAt( 0 );
      secondCard = this.playerCards.get( i + 1 ).charAt( 0 );
      thirdCard = this.playerCards.get( i + 2 ).charAt( 0 );
      fourthCard = this.playerCards.get( i + 3 ).charAt( 0 );
      if( firstCard == secondCard && firstCard == thirdCard && firstCard == fourthCard ) {
        return true;
      } 
    }
    return false;
  }

  public boolean straight() {
    char firstCard;
    char secondCard;
    char thirdCard;
    char fourthCard;
    char fifthCard;

    firstCard = this.playerCards.get( 0 ).charAt( 0 );
    secondCard = this.playerCards.get( 1 ).charAt( 0 );
    thirdCard = this.playerCards.get( 2 ).charAt( 0 );
    fourthCard = this.playerCards.get( 3 ).charAt( 0 );
    fifthCard = this.playerCards.get( 4 ).charAt( 0 );

    if( firstCard + 1 == secondCard && firstCard + 2 == thirdCard 
      && firstCard + 3 == fourthCard && firstCard + 4 == fifthCard ) {
      return true;
    }
    return false;
  }

  public boolean flush() {
    char firstCard;
    char secondCard;
    char thirdCard;
    char fourthCard;
    char fifthCard;

    firstCard = this.playerCards.get( 0 ).charAt( 1 );
    secondCard = this.playerCards.get( 1 ).charAt( 1 );
    thirdCard = this.playerCards.get( 2 ).charAt( 1 );
    fourthCard = this.playerCards.get( 3 ).charAt( 1 );
    fifthCard = this.playerCards.get( 4 ).charAt( 1 );

    if( firstCard == secondCard && firstCard == thirdCard 
      && firstCard == fourthCard && firstCard == fifthCard ) {
      return true;
    }
    return false;
  }

  public boolean straightFlush() {
    if( flush() == true && straight() == true ) {
      return true;
    }
    return false;
  }

  public boolean fullHouse() {
    if( three() == true && pair() == true ) {
      return true;
    }
    return false;
  }



}











