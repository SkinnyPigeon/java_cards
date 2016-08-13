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

  public boolean pairTwoTwo() {
    if( this.playerCards.size() > 3 ) {
      twoPair();
    }

    if( this.processedCards.size() > 3 ) {
      char firstCard = this.processedCards.get(0).charAt(0);
      char secondCard = this.processedCards.get(2).charAt(0);
      if( firstCard == '2' || secondCard == '2' ) {
        return true;
      }
    }
    return false;
  }

  public boolean pairThreeTwo() {
    if( this.playerCards.size() > 3 ) {
      twoPair();
    }

    if( this.processedCards.size() > 3 ) {
      char firstCard = this.processedCards.get(0).charAt(0);
      char secondCard = this.processedCards.get(2).charAt(0);
      if( firstCard == '3' || secondCard == '3' ) {
        return true;
      }
    }
    return false;
  }

  public boolean pairFourTwo() {
    if( this.playerCards.size() > 3 ) {
      twoPair();
    }

    if( this.processedCards.size() > 3 ) {
      char firstCard = this.processedCards.get(0).charAt(0);
      char secondCard = this.processedCards.get(2).charAt(0);
      if( firstCard == '4' || secondCard == '4' ) {
        return true;
      }
    }
    return false;
  }

  public boolean pairFiveTwo() {
    if( this.playerCards.size() > 3 ) {
      twoPair();
    }

    if( this.processedCards.size() > 3 ) {
      char firstCard = this.processedCards.get(0).charAt(0);
      char secondCard = this.processedCards.get(2).charAt(0);
      if( firstCard == '5' || secondCard == '5' ) {
        return true;
      }
    }
    return false;
  }

  public boolean pairSixTwo() {
    if( this.playerCards.size() > 3 ) {
      twoPair();
    }

    if( this.processedCards.size() > 3 ) {
      char firstCard = this.processedCards.get(0).charAt(0);
      char secondCard = this.processedCards.get(2).charAt(0);
      if( firstCard == '6' || secondCard == '6' ) {
        return true;
      }
    }
    return false;
  }

  public boolean pairSevenTwo() {
    if( this.playerCards.size() > 3 ) {
      twoPair();
    }

    if( this.processedCards.size() > 3 ) {
      char firstCard = this.processedCards.get(0).charAt(0);
      char secondCard = this.processedCards.get(2).charAt(0);
      if( firstCard == '7' || secondCard == '7' ) {
        return true;
      }
    }
    return false;
  }

  public boolean pairEightTwo() {
    if( this.playerCards.size() > 3 ) {
      twoPair();
    }

    if( this.processedCards.size() > 3 ) {
      char firstCard = this.processedCards.get(0).charAt(0);
      char secondCard = this.processedCards.get(2).charAt(0);
      if( firstCard == '8' || secondCard == '8' ) {
        return true;
      }
    }
    return false;
  }

  public boolean pairNineTwo() {
    if( this.playerCards.size() > 3 ) {
      twoPair();
    }

    if( this.processedCards.size() > 3 ) {
      char firstCard = this.processedCards.get(0).charAt(0);
      char secondCard = this.processedCards.get(2).charAt(0);
      if( firstCard == '9' || secondCard == '9' ) {
        return true;
      }
    }
    return false;
  }

  public boolean pairTenTwo() {
    if( this.playerCards.size() > 3 ) {
      twoPair();
    }

    if( this.processedCards.size() > 3 ) {
      char firstCard = this.processedCards.get(0).charAt(0);
      char secondCard = this.processedCards.get(2).charAt(0);
      if( firstCard == '1' || secondCard == '1' ) {
        return true;
      }
    }
    return false;
  }

  public boolean pairJackTwo() {
    if( this.playerCards.size() > 3 ) {
      twoPair();
    }

    if( this.processedCards.size() > 3 ) {
      char firstCard = this.processedCards.get(0).charAt(0);
      char secondCard = this.processedCards.get(2).charAt(0);
      if( firstCard == 'J' || secondCard == 'J' ) {
        return true;
      }
    }
    return false;
  }

  public boolean pairQueenTwo() {
    if( this.playerCards.size() > 3 ) {
      twoPair();
    }

    if( this.processedCards.size() > 3 ) {
      char firstCard = this.processedCards.get(0).charAt(0);
      char secondCard = this.processedCards.get(2).charAt(0);
      if( firstCard == 'Q' || secondCard == 'Q' ) {
        return true;
      }
    }
    return false;
  }

  public boolean pairKingTwo() {
      twoPair();

    if( this.processedCards.size() > 3 ) {
      char firstCard = this.processedCards.get(0).charAt(0);
      char secondCard = this.processedCards.get(2).charAt(0);
      if( firstCard == 'K' || secondCard == 'K' ) {
        return true;
      }
    }
    return false;
  }

  public boolean pairAceTwo() {
      twoPair();
    if( this.processedCards.size() > 3 ) {
      char firstCard = this.processedCards.get(0).charAt(0);
      char secondCard = this.processedCards.get(2).charAt(0);
      if( firstCard == 'A' || secondCard == 'A' ) {
        return true;
      }
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
    this.awardScore = 1000;

  } else if( straightFlush() == true ) {
    this.awardScore = 900;
  } else if ( four() == true ) {
    this.awardScore = 800;
  } else if ( fullHouse() == true ) {
    this.awardScore = 700;


  } else if( almostRoyalFlush() == true ) {
    this.awardScore = 690;
  } else if( barelyCloseToARoyalFlush() == true ) {
    this.awardScore = 680;
  } else if( isTenARoyalFlush() == true ) {
    this.awardScore = 670;
  } else if ( flush() == true ) {
    this.awardScore = 660;
  } else if( lowFlush() == true ) {
    this.awardScore = 650;

  } else if ( royalStraight() == true ) {
    this.awardScore = 590;
  } else if ( almostRoyalStraight() == true ) {
    this.awardScore = 580;
  } else if ( furtherFromARoyalStraight() == true ) {
    this.awardScore = 570;
  } else if ( isTenARoyal() == true ) {
    this.awardScore = 560;
  } else if ( straight() == true ) {
    this.awardScore = 550;
  } else if ( lowStraight() == true ) {
    this.awardScore = 540;

  } else if ( three() == true ) {
    this.awardScore = 500;

  // } else if ( pairAceTwo() == true ) {
  //   this.awardScore = 225;
  // } else if ( pairKingTwo() == true ) {
  //   this.awardScore = 224;

  } else if ( pairAceTwo() == true && pairKingTwo() == true) {
    this.awardScore = 449;
  } else if ( pairAceTwo() == true && pairQueenTwo() == true) {
    this.awardScore = 448;
  } else if ( pairAceTwo() == true && pairJackTwo() == true) {
    this.awardScore = 447;
  } else if ( pairAceTwo() == true && pairTenTwo() == true) {
    this.awardScore = 446;
  } else if ( pairAceTwo() == true && pairNineTwo() == true) {
    this.awardScore = 445;
  } else if ( pairAceTwo() == true && pairEightTwo() == true) {
    this.awardScore = 444;
  } else if ( pairAceTwo() == true && pairSevenTwo() == true) {
    this.awardScore = 443;
  } else if ( pairAceTwo() == true && pairSixTwo() == true) {
    this.awardScore = 442;
  } else if ( pairAceTwo() == true && pairFiveTwo() == true) {
    this.awardScore = 441;
  } else if ( pairAceTwo() == true && pairFourTwo() == true) {
    this.awardScore = 440;
  } else if ( pairAceTwo() == true && pairThreeTwo() == true) {
    this.awardScore = 439;
  } else if ( pairAceTwo() == true && pairTwoTwo() == true) {
    this.awardScore = 438;

  } else if ( pairKingTwo() == true && pairQueenTwo() == true ) {
    this.awardScore = 437;
  } else if ( pairKingTwo() == true && pairJackTwo() == true ) {
    this.awardScore = 436;
  } else if ( pairKingTwo() == true && pairTenTwo() == true ) {
    this.awardScore = 435;
  } else if ( pairKingTwo() == true && pairNineTwo() == true ) {
    this.awardScore = 434;
  } else if ( pairKingTwo() == true && pairEightTwo() == true ) {
    this.awardScore = 433;
  } else if ( pairKingTwo() == true && pairSevenTwo() == true ) {
    this.awardScore = 432;
  } else if ( pairKingTwo() == true && pairSixTwo() == true ) {
    this.awardScore = 431;
  } else if ( pairKingTwo() == true && pairFiveTwo() == true ) {
    this.awardScore = 430;
  } else if ( pairKingTwo() == true && pairFourTwo() == true ) {
    this.awardScore = 429;
  } else if ( pairKingTwo() == true && pairThreeTwo() == true ) {
    this.awardScore = 428;
  } else if ( pairKingTwo() == true && pairTwoTwo() == true ) {
    this.awardScore = 427;    

  } else if ( pairQueenTwo() == true && pairJackTwo() == true ) {
    this.awardScore = 426;
  } else if ( pairQueenTwo() == true && pairTenTwo() == true ) {
    this.awardScore = 425;
  } else if ( pairQueenTwo() == true && pairNineTwo() == true ) {
    this.awardScore = 424;
  } else if ( pairQueenTwo() == true && pairEightTwo() == true ) {
    this.awardScore = 423;
  } else if ( pairQueenTwo() == true && pairSevenTwo() == true ) {
    this.awardScore = 422;
  } else if ( pairQueenTwo() == true && pairSixTwo() == true ) {
    this.awardScore = 421;
  } else if ( pairQueenTwo() == true && pairFiveTwo() == true ) {
    this.awardScore = 420;
  } else if ( pairQueenTwo() == true && pairFourTwo() == true ) {
    this.awardScore = 419;
  } else if ( pairQueenTwo() == true && pairThreeTwo() == true ) {
    this.awardScore = 418;
  } else if ( pairQueenTwo() == true && pairTwoTwo() == true ) {
    this.awardScore = 417;

  } else if ( pairJackTwo() == true && pairTenTwo() == true ) {
    this.awardScore = 222;



  } else if ( pairTenTwo() == true ) {
    this.awardScore = 221;
  } else if ( pairNineTwo() == true ) {
    this.awardScore = 220;
  } else if ( pairEightTwo() == true ) {
    this.awardScore = 219;
  } else if ( pairSevenTwo() == true ) {
    this.awardScore = 218;
  } else if ( pairSixTwo() == true ) {
    this.awardScore = 217;
  } else if ( pairFiveTwo() == true ) {
    this.awardScore = 216;
  } else if ( pairFourTwo() == true ) {
    this.awardScore = 215;
  } else if ( pairThreeTwo() == true ) {
    this.awardScore = 214;
  } else if ( pairTwoTwo() == true ) {
    this.awardScore = 213;

  } else if ( pairAce() == true ) {
    this.awardScore = 212;
  } else if ( pairKing() == true ) {
    this.awardScore = 211;
  } else if ( pairQueen() == true ) {
    this.awardScore = 210;
  } else if ( pairJack() == true ) {
    this.awardScore = 209;
  } else if ( pairTen() == true ) {
    this.awardScore = 208;
  } else if ( pairNine() == true ) {
    this.awardScore = 207;
  } else if ( pairEight() == true ) {
    this.awardScore = 206;
  } else if ( pairSeven() == true ) {
    this.awardScore = 205;
  } else if ( pairSix() == true ) {
    this.awardScore = 204;
  } else if ( pairFive() == true ) {
    this.awardScore = 203;
  } else if ( pairFour() == true ) {
    this.awardScore = 202;
  } else if ( pairThree() == true ) {
    this.awardScore = 201;
  } else if ( pairTwo() == true ) {
    this.awardScore = 200;

  } else {
    this.awardScore = 100;
  }
}



}











