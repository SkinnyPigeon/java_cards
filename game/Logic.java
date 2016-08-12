package Game;
import java.util.*;

public class Logic {

  private ArrayList< String > playerCards;
  private ArrayList< String > tableCards;
  private ArrayList< String > processedCards;
  private Integer awardScore;

  public Logic( ArrayList playerCards, ArrayList tableCards ) {
    this.playerCards = playerCards;
    this.tableCards = tableCards;
    this.processedCards = new ArrayList< String >();
    this.awardScore = awardScore;
  }

  public Integer seeScore() {
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
    pair();
    char firstCard = this.processedCards.get(0).charAt(0);
    if( firstCard == '2' ) {
      return true;
    }
    return false;
  }

  public boolean pairThree() {
    pair();
    char firstCard = this.processedCards.get(0).charAt(0);
    if( firstCard == '3' ) {
      return true;
    }
    return false;
  }

  public boolean pairFour() {
    pair();
    char firstCard = this.processedCards.get(0).charAt(0);
    if( firstCard == '4' ) {
      return true;
    }
    return false;
  }

  public boolean pairFive() {
    pair();
    char firstCard = this.processedCards.get(0).charAt(0);
    if( firstCard == '5' ) {
      return true;
    }
    return false;
  }

  public boolean pairSix() {
    pair();
    char firstCard = this.processedCards.get(0).charAt(0);
    if( firstCard == '6' ) {
      return true;
    }
    return false;
  }

  public boolean pairSeven() {
    pair();
    char firstCard = this.processedCards.get(0).charAt(0);
    if( firstCard == '7' ) {
      return true;
    }
    return false;
  }

  public boolean pairEight() {
    pair();
    char firstCard = this.processedCards.get(0).charAt(0);
    if( firstCard == '8' ) {
      return true;
    }
    return false;
  }

  public boolean pairNine() {
    pair();
    char firstCard = this.processedCards.get(0).charAt(0);
    if( firstCard == '9' ) {
      return true;
    }
    return false;
  }

  public boolean pairTen() {
    pair();
    char firstCard = this.processedCards.get(0).charAt(0);
    if( firstCard == '1' ) {
      return true;
    }
    return false;
  }

  public boolean pairJack() {
    pair();
    char firstCard = this.processedCards.get(0).charAt(0);
    if( firstCard == 'J' ) {
      return true;
    }
    return false;
  }

  public boolean pairQueen() {
    pair();
    char firstCard = this.processedCards.get(0).charAt(0);
    if( firstCard == 'Q' ) {
      return true;
    }
    return false;
  }

  public boolean pairKing() {
    pair();
    char firstCard = this.processedCards.get(0).charAt(0);
    if( firstCard == 'K' ) {
      return true;
    }
    return false;
  }

  public boolean pairAce() {
    pair();
    char firstCard = this.processedCards.get(0).charAt(0);
    if( firstCard == 'A' ) {
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

public Integer setScore() {
  if( royalFlush() == true ) {
    return this.awardScore = 1000;

  } else if( straightFlush() == true ) {
    return this.awardScore = 900;
  } else if ( four() == true ) {
    return this.awardScore = 800;
  } else if ( fullHouse() == true ) {
    return this.awardScore = 700;


  } else if( almostRoyalFlush() == true ) {
    return this.awardScore = 690;
  } else if( barelyCloseToARoyalFlush() == true ) {
    return this.awardScore = 680;
  } else if( isTenARoyalFlush() == true ) {
    return this.awardScore = 670;
  } else if ( flush() == true ) {
    return this.awardScore = 660;
  } else if( lowFlush() == true ) {
    return this.awardScore = 650;

  } else if ( royalStraight() == true ) {
    return this.awardScore = 590;
  } else if ( almostRoyalStraight() == true ) {
    return this.awardScore = 580;
  } else if ( furtherFromARoyalStraight() == true ) {
    return this.awardScore = 570;
  } else if ( isTenARoyal() == true ) {
    return this.awardScore = 560;
  } else if ( straight() == true ) {
    return this.awardScore = 550;
  } else if ( lowStraight() == true ) {
    return this.awardScore = 540;

  } else if ( three() == true ) {
    return this.awardScore = 400;
  } else if ( twoPair() == true ) {
    return this.awardScore = 300;

  } else if ( pairAce() == true ) {
    return this.awardScore = 290;
  } else if ( pairKing() == true ) {
    return this.awardScore = 285;
  } else if ( pairQueen() == true ) {
    return this.awardScore = 280;
  } else if ( pairJack() == true ) {
    return this.awardScore = 270;
  } else if ( pairTen() == true ) {
    return this.awardScore = 260;
  } else if ( pairNine() == true ) {
    return this.awardScore = 255;
  } else if ( pairEight() == true ) {
    return this.awardScore = 250;
  } else if ( pairSeven() == true ) {
    return this.awardScore = 245;
  } else if ( pairSix() == true ) {
    return this.awardScore = 240;
  } else if ( pairFive() == true ) {
    return this.awardScore = 235;
  } else if ( pairFour() == true ) {
    return this.awardScore = 230;
  } else if ( pairThree() == true ) {
    return this.awardScore = 220;
  } else if ( pairTwo() == true ) {
    return this.awardScore = 200;

  } else {
    return this.awardScore = 100;
  }
}



}











