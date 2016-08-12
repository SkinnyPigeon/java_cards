package Game;
import java.util.*;

public class Logic {

  private ArrayList< String > playerCards;
  private ArrayList< String > tableCards;
  private ArrayList< String > processedCards;
  private double awardScore;

  public Logic( ArrayList playerCards, ArrayList tableCards ) {
    this.playerCards = playerCards;
    this.tableCards = tableCards;
    this.processedCards = new ArrayList< String >();
    this.awardScore = 0;
  }

  public double awardScore() {
    return this.awardScore;
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

  public boolean pairTwo() {
    char firstCard = this.processedCards.get(0).charAt(0);
    if( pair() == true && firstCard == '2' ) {
      return true;
    }
    return false;
  }

  public boolean pairThree() {
    char firstCard = this.processedCards.get(0).charAt(0);
    if( pair() == true && firstCard == '3' ) {
      return true;
    }
    return false;
  }

  public boolean pairFour() {
    char firstCard = this.processedCards.get(0).charAt(0);
    if( pair() == true && firstCard == '4' ) {
      return true;
    }
    return false;
  }

  public boolean pairFive() {
    char firstCard = this.processedCards.get(0).charAt(0);
    if( pair() == true && firstCard == '5' ) {
      return true;
    }
    return false;
  }

  public boolean pairSix() {
    char firstCard = this.processedCards.get(0).charAt(0);
    if( pair() == true && firstCard == '6' ) {
      return true;
    }
    return false;
  }

  public boolean pairSeven() {
    char firstCard = this.processedCards.get(0).charAt(0);
    if( pair() == true && firstCard == '7' ) {
      return true;
    }
    return false;
  }

  public boolean pairEight() {
    char firstCard = this.processedCards.get(0).charAt(0);
    if( pair() == true && firstCard == '8' ) {
      return true;
    }
    return false;
  }

  public boolean pairNine() {
    char firstCard = this.processedCards.get(0).charAt(0);
    if( pair() == true && firstCard == '9' ) {
      return true;
    }
    return false;
  }

  public boolean pairTen() {
    char firstCard = this.processedCards.get(0).charAt(0);
    if( pair() == true && firstCard == '1' ) {
      return true;
    }
    return false;
  }

  public boolean pairJack() {
    char firstCard = this.processedCards.get(0).charAt(0);
    if( pair() == true && firstCard == 'J' ) {
      return true;
    }
    return false;
  }

  public boolean pairQueen() {
    char firstCard = this.processedCards.get(0).charAt(0);
    if( pair() == true && firstCard == 'Q' ) {
      return true;
    }
    return false;
  }

  public boolean pairKing() {
    char firstCard = this.processedCards.get(0).charAt(0);
    if( pair() == true && firstCard == 'K' ) {
      return true;
    }
    return false;
  }

  public boolean pairAce() {
    char firstCard = this.processedCards.get(0).charAt(0);
    if( pair() == true && firstCard == 'A' ) {
      return true;
    }
    return false;
  }

  public boolean twoPair() {
    char firstCard;
    char secondCard;
    char thirdCard;
    char fourthCard;
    for( int i = 0; i < this.playerCards.size() - 3; i++ ) {
      firstCard = this.playerCards.get( i ).charAt( 0 );
      secondCard = this.playerCards.get( i + 1 ).charAt( 0 );
      thirdCard = this.playerCards.get( i + 2 ).charAt( 0 );
      fourthCard = this.playerCards.get( i + 3 ).charAt( 0 );
      if( firstCard == secondCard && thirdCard == fourthCard ) {
        this.processedCards.add( this.playerCards.remove( i + 3 ) );
        this.processedCards.add( this.playerCards.remove( i + 2 ) );
        this.processedCards.add( this.playerCards.remove( i + 1 ) );
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
    if( firstCard == '0' ) {
      firstCard = this.playerCards.get( 0 ).charAt( 2 );
    }

    secondCard = this.playerCards.get( 1 ).charAt( 1 );
    if( secondCard == '0' ) {
      secondCard = this.playerCards.get( 1 ).charAt( 2 );
    }

    thirdCard = this.playerCards.get( 2 ).charAt( 1 );
    if( thirdCard == '0' ) {
      thirdCard = this.playerCards.get( 2 ).charAt( 2 );
    }

    fourthCard = this.playerCards.get( 3 ).charAt( 1 );
    if( fourthCard == '0' ) {
      fourthCard = this.playerCards.get( 3 ).charAt( 2 );
    }

    fifthCard = this.playerCards.get( 4 ).charAt( 1 );
    if( fifthCard == '0' ) {
      fifthCard = this.playerCards.get( 4 ).charAt( 2 );
    }

    if( firstCard == secondCard && firstCard == thirdCard 
      && firstCard == fourthCard && firstCard == fifthCard ) {
      return true;
    }
    return false;
  }

  public boolean royalStraight() {
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

    if( firstCard == '1' && secondCard == 'A' && thirdCard == 'J' 
      && fourthCard == 'K' && fifthCard == 'Q' ) {
      return true;
    }
    return false;
  }

  public boolean almostRoyalStraight() {
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

    if( firstCard == '1' && secondCard == '9' && thirdCard == 'J' 
      && fourthCard == 'K' && fifthCard == 'Q' ) {
      return true;
    }
    return false;
  }

  public boolean furtherFromARoyalStraight() {
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

    if( firstCard == '1' && secondCard == '8' && thirdCard == '9' 
      && fourthCard == 'J' && fifthCard == 'Q' ) {
      return true;
    }
    return false;
  }

  public boolean barelyCloseToARoyalStraight() {
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

    if( firstCard == '1' && secondCard == '7' && thirdCard == '8' 
      && fourthCard == '9' && fifthCard == 'J' ) {
      return true;
    }
    return false;
  }

  public boolean isTenARoyal() {
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

    if( firstCard == '1' && secondCard == '6' && thirdCard == '7' 
      && fourthCard == '8' && fifthCard == '9' ) {
      return true;
    }
    return false;
  }

  public boolean almostRoyalFlush() {
    if( almostRoyalStraight() == true && flush() == true ) {
      return true;
    }
    return false;
  }

  public boolean lowStraight() {
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

    if( firstCard == '2' && secondCard == '3' && thirdCard == '4' 
      && fourthCard == '5' && fifthCard == 'A' ) {
      return true;
    }
    return false;
  }

  public boolean royalFlush() {
    if( flush() == true && royalStraight() == true ) {
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

  public boolean furtherFromARoyalFlush() {
    if( furtherFromARoyalStraight() == true && flush() == true ) {
      return true;
    }
    return false;
  }

  public boolean barelyCloseToARoyalFlush() {
    if( barelyCloseToARoyalStraight() == true && flush() == true ) {
      return true;
    }
    return false;
  }

  public boolean isTenARoyalFlush() {
    if( isTenARoyal() == true && flush() == true ) {
      return true;
    }
    return false;
  }

  public boolean lowFlush() {
    if( lowStraight() == true && flush() == true ) {
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

  public void setScore() {
    if( royalFlush() == true ) {
      this.awardScore = 10;

    } else if( straightFlush() == true ) {
      this.awardScore = 9;
    } else if ( four() == true ) {
      this.awardScore = 8;
    } else if ( fullHouse() == true ) {
      this.awardScore = 7;


    } else if( almostRoyalFlush() == true ) {
      this.awardScore = 6.9;
    } else if( barelyCloseToARoyalFlush() == true ) {
      this.awardScore = 6.8;
    } else if( isTenARoyalFlush() == true ) {
      this.awardScore = 6.7;
    } else if ( flush() == true ) {
      this.awardScore = 6.6;
    } else if( lowFlush() == true ) {
      this.awardScore = 6.5;

    } else if ( royalStraight() == true ) {
      this.awardScore = 5.9;
    } else if ( almostRoyalStraight() == true ) {
      this.awardScore = 5.8;
    } else if ( furtherFromARoyalStraight() == true ) {
      this.awardScore = 5.7;
    } else if ( isTenARoyal() == true ) {
      this.awardScore = 5.6;
    } else if ( straight() == true ) {
      this.awardScore = 5.5;
    } else if ( lowStraight() == true ) {
      this.awardScore = 5.4;

    } else if ( three() == true ) {
      this.awardScore = 4;
    } else if ( twoPair() == true ) {
      this.awardScore = 3;

    } else if ( pairAce() == true ) {
      this.awardScore = 2.9;
    } else if ( pairKing() == true ) {
      this.awardScore = 2.85;
    } else if ( pairQueen() == true ) {
      this.awardScore = 2.8;
    } else if ( pairJack() == true ) {
      this.awardScore = 2.7;
    } else if ( pairTen() == true ) {
      this.awardScore = 2.6;
    } else if ( pairNine() == true ) {
      this.awardScore = 2.55;
    } else if ( pairEight() == true ) {
      this.awardScore = 2.5;
    } else if ( pairSeven() == true ) {
      this.awardScore = 2.45;
    } else if ( pairSix() == true ) {
      this.awardScore = 2.4;
    } else if ( pairFive() == true ) {
      this.awardScore = 2.35;
    } else if ( pairFour() == true ) {
      this.awardScore = 2.3;
    } else if ( pairThree() == true ) {
      this.awardScore = 2.2;
    } else if ( pairTwo() == true ) {
      this.awardScore = 2;

    } else {
      this.awardScore = 1;
    }
  }



}











