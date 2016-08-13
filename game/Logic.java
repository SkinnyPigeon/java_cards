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
        System.out.println( this.processedCards );
        return true;
      }
    }
    return false;
  }

  public boolean threeAce() {
    three();
    char firstCard;
    if( this.processedCards.size() > 2 ) {
      firstCard = this.processedCards.get( 0 ).charAt( 0 );
      if( firstCard == 'A' ) {
        return true;
      }
    }
    return false;
  }

  public boolean threeKing() {
    three();
    char firstCard;
    if( this.processedCards.size() > 2 ) {
      firstCard = this.processedCards.get( 0 ).charAt( 0 );
      if( firstCard == 'K' ) {
        return true;
      }
    }
    return false;
  }

  public boolean threeQueen() {
    three();
    char firstCard;
    if( this.processedCards.size() > 2 ) {
      firstCard = this.processedCards.get( 0 ).charAt( 0 );
      if( firstCard == 'Q' ) {
        return true;
      }
    }
    return false;
  }

  public boolean threeJack() {
    three();
    char firstCard;
    if( this.processedCards.size() > 2 ) {
      firstCard = this.processedCards.get( 0 ).charAt( 0 );
      if( firstCard == 'J' ) {
        return true;
      }
    }
    return false;
  }

  public boolean threeTen() {
    three();
    char firstCard;
    if( this.processedCards.size() > 2 ) {
      firstCard = this.processedCards.get( 0 ).charAt( 0 );
      if( firstCard == '1' ) {
        return true;
      }
    }
    return false;
  }

  public boolean threeNine() {
    three();
    char firstCard;
    if( this.processedCards.size() > 2 ) {
      firstCard = this.processedCards.get( 0 ).charAt( 0 );
      if( firstCard == '9' ) {
        return true;
      }
    }
    return false;
  }

  public boolean threeEight() {
    three();
    char firstCard;
    if( this.processedCards.size() > 2 ) {
      firstCard = this.processedCards.get( 0 ).charAt( 0 );
      if( firstCard == '8' ) {
        return true;
      }
    }
    return false;
  }

  public boolean threeSeven() {
    three();
    char firstCard;
    if( this.processedCards.size() > 2 ) {
      firstCard = this.processedCards.get( 0 ).charAt( 0 );
      if( firstCard == '7' ) {
        return true;
      }
    }
    return false;
  }

  public boolean threeSix() {
    three();
    char firstCard;
    if( this.processedCards.size() > 2 ) {
      firstCard = this.processedCards.get( 0 ).charAt( 0 );
      if( firstCard == '6' ) {
        return true;
      }
    }
    return false;
  }

  public boolean threeFive() {
    three();
    char firstCard;
    if( this.processedCards.size() > 2 ) {
      firstCard = this.processedCards.get( 0 ).charAt( 0 );
      if( firstCard == '5' ) {
        return true;
      }
    }
    return false;
  }

  public boolean threeFour() {
    three();
    char firstCard;
    if( this.processedCards.size() > 2 ) {
      firstCard = this.processedCards.get( 0 ).charAt( 0 );
      if( firstCard == '4' ) {
        return true;
      }
    }
    return false;
  }

  public boolean threeThree() {
    three();
    char firstCard;
    if( this.processedCards.size() > 2 ) {
      firstCard = this.processedCards.get( 0 ).charAt( 0 );
      if( firstCard == '3' ) {
        return true;
      }
    }
    return false;
  }

  public boolean threeTwo() {
    three();
    char firstCard;
    if( this.processedCards.size() > 2 ) {
      firstCard = this.processedCards.get( 0 ).charAt( 0 );
      if( firstCard == '2' ) {
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
        this.processedCards.add( this.playerCards.remove( i + 3 ) );
        this.processedCards.add( this.playerCards.remove( i + 2 ) );
        this.processedCards.add( this.playerCards.remove( i + 1 ) );
        this.processedCards.add( this.playerCards.remove( i ) );
        return true;
      } 
    }
    return false;
  }

  public boolean fullHouseTwoFirst() {
    char firstCard;
    char secondCard;
    char thirdCard;
    char fourthCard;
    char fifthCard;
    if( this.playerCards.size() > 4 ) {
      firstCard = this.playerCards.get( 0 ).charAt( 0 );
      secondCard = this.playerCards.get( 1 ).charAt( 0 );
      thirdCard = this.playerCards.get( 2 ).charAt( 0 );
      fourthCard = this.playerCards.get( 3 ).charAt( 0 );
      fifthCard = this.playerCards.get( 4 ).charAt( 0 );
      if( firstCard == secondCard && 
        thirdCard == fourthCard && thirdCard == fifthCard ) {
        this.processedCards.add( this.playerCards.remove( 4 ) );
        this.processedCards.add( this.playerCards.remove( 3 ) );
        this.processedCards.add( this.playerCards.remove( 2 ) );
        this.processedCards.add( this.playerCards.remove( 1 ) );
        this.processedCards.add( this.playerCards.remove( 0 ) );
        return true;
      } 
    }
    return false;
  }

  public boolean fullHouseThreeFirst() {
    char firstCard;
    char secondCard;
    char thirdCard;
    char fourthCard;
    char fifthCard;
    if( this.playerCards.size() > 4 ) {
      firstCard = this.playerCards.get( 0 ).charAt( 0 );
      secondCard = this.playerCards.get( 1 ).charAt( 0 );
      thirdCard = this.playerCards.get( 2 ).charAt( 0 );
      fourthCard = this.playerCards.get( 3 ).charAt( 0 );
      fifthCard = this.playerCards.get( 4 ).charAt( 0 );
      if( firstCard == secondCard && firstCard == thirdCard 
        && fourthCard == fifthCard ) {
        this.processedCards.add( this.playerCards.remove( 4 ) );
        this.processedCards.add( this.playerCards.remove( 3 ) );
        this.processedCards.add( this.playerCards.remove( 2 ) );
        this.processedCards.add( this.playerCards.remove( 1 ) );
        this.processedCards.add( this.playerCards.remove( 0 ) );
        return true;
      } 
    }
    return false;
  }

  // public boolean fullHouse() {
  //   if( three() && pair() ) {
  //     return true;
  //   }
  //   return false;
  // }




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
    if( almostRoyalStraight() && flush() ) {
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
    if( flush() && royalStraight() ) {
      return true;
    }
    return false;
  }

  public boolean straightFlush() {
    if( flush() && straight() ) {
      return true;
    }
    return false;
  }

  public boolean furtherFromARoyalFlush() {
    if( furtherFromARoyalStraight() && flush() ) {
      return true;
    }
    return false;
  }

  public boolean barelyCloseToARoyalFlush() {
    if( barelyCloseToARoyalStraight() && flush() ) {
      return true;
    }
    return false;
  }

  public boolean isTenARoyalFlush() {
    if( isTenARoyal() && flush() ) {
      return true;
    }
    return false;
  }

  public boolean lowFlush() {
    if( lowStraight() && flush() ) {
      return true;
    }
    return false;
  }



  public void setScore() {

    if( royalFlush() ) {
      this.awardScore = 1000;

    } else if( straightFlush() ) {
      this.awardScore = 900;
    } else if ( four() ) {
      this.awardScore = 800;
    } else if ( fullHouseTwoFirst() || fullHouseThreeFirst() ) {
      this.awardScore = 700;


    } else if( almostRoyalFlush() ) {
      this.awardScore = 690;
    } else if( barelyCloseToARoyalFlush() ) {
      this.awardScore = 680;
    } else if( isTenARoyalFlush() ) {
      this.awardScore = 670;
    } else if ( flush() ) {
      this.awardScore = 660;
    } else if( lowFlush() ) {
      this.awardScore = 650;

    } else if ( royalStraight() ) {
      this.awardScore = 590;
    } else if ( almostRoyalStraight() ) {
      this.awardScore = 580;
    } else if ( furtherFromARoyalStraight() ) {
      this.awardScore = 570;
    } else if ( isTenARoyal() ) {
      this.awardScore = 560;
    } else if ( straight() ) {
      this.awardScore = 550;
    } else if ( lowStraight() ) {
      this.awardScore = 540;

    } else if ( threeAce() ) {
      this.awardScore = 512;
    } else if ( threeKing() ) {
      this.awardScore = 511;
    } else if ( threeQueen() ) {
      this.awardScore = 510;
    } else if ( threeJack() ) {
      this.awardScore = 509;
    } else if ( threeTen() ) {
      this.awardScore = 508;
    } else if ( threeNine() ) {
      this.awardScore = 507;
    } else if ( threeEight() ) {
      this.awardScore = 506;
    } else if ( threeSeven() ) {
      this.awardScore = 505;
    } else if ( threeSix() ) {
      this.awardScore = 504;
    } else if ( threeFive() ) {
      this.awardScore = 503;
    } else if ( threeFour() ) {
      this.awardScore = 502;
    } else if ( threeThree() ) {
      this.awardScore = 501;
    } else if ( threeTwo() ) {
      this.awardScore = 500;

    } else if ( pairAceTwo() && pairKingTwo() ) {
      this.awardScore = 449;
    } else if ( pairAceTwo() && pairQueenTwo() ) {
      this.awardScore = 448;
    } else if ( pairAceTwo() && pairJackTwo() ) {
      this.awardScore = 447;
    } else if ( pairAceTwo() && pairTenTwo() ) {
      this.awardScore = 446;
    } else if ( pairAceTwo() && pairNineTwo() ) {
      this.awardScore = 445;
    } else if ( pairAceTwo() && pairEightTwo() ) {
      this.awardScore = 444;
    } else if ( pairAceTwo() && pairSevenTwo() ) {
      this.awardScore = 443;
    } else if ( pairAceTwo() && pairSixTwo() ) {
      this.awardScore = 442;
    } else if ( pairAceTwo() && pairFiveTwo() ) {
      this.awardScore = 441;
    } else if ( pairAceTwo() && pairFourTwo() ) {
      this.awardScore = 440;
    } else if ( pairAceTwo() && pairThreeTwo() ) {
      this.awardScore = 439;
    } else if ( pairAceTwo() && pairTwoTwo() ) {
      this.awardScore = 438;

    } else if ( pairKingTwo() && pairQueenTwo() ) {
      this.awardScore = 437;
    } else if ( pairKingTwo() && pairJackTwo() ) {
      this.awardScore = 436;
    } else if ( pairKingTwo() && pairTenTwo() ) {
      this.awardScore = 435;
    } else if ( pairKingTwo() && pairNineTwo() ) {
      this.awardScore = 434;
    } else if ( pairKingTwo() && pairEightTwo() ) {
      this.awardScore = 433;
    } else if ( pairKingTwo() && pairSevenTwo() ) {
      this.awardScore = 432;
    } else if ( pairKingTwo() && pairSixTwo() ) {
      this.awardScore = 431;
    } else if ( pairKingTwo() && pairFiveTwo() ) {
      this.awardScore = 430;
    } else if ( pairKingTwo() && pairFourTwo() ) {
      this.awardScore = 429;
    } else if ( pairKingTwo() && pairThreeTwo() ) {
      this.awardScore = 428;
    } else if ( pairKingTwo() && pairTwoTwo() ) {
      this.awardScore = 427;    

    } else if ( pairQueenTwo() && pairJackTwo() ) {
      this.awardScore = 426;
    } else if ( pairQueenTwo() && pairTenTwo() ) {
      this.awardScore = 425;
    } else if ( pairQueenTwo() && pairNineTwo() ) {
      this.awardScore = 424;
    } else if ( pairQueenTwo() && pairEightTwo() ) {
      this.awardScore = 423;
    } else if ( pairQueenTwo() && pairSevenTwo() ) {
      this.awardScore = 422;
    } else if ( pairQueenTwo() && pairSixTwo() ) {
      this.awardScore = 421;
    } else if ( pairQueenTwo() && pairFiveTwo() ) {
      this.awardScore = 420;
    } else if ( pairQueenTwo() && pairFourTwo() ) {
      this.awardScore = 419;
    } else if ( pairQueenTwo() && pairThreeTwo() ) {
      this.awardScore = 418;
    } else if ( pairQueenTwo() && pairTwoTwo() ) {
      this.awardScore = 417;

    } else if ( pairJackTwo() && pairTenTwo() ) {
      this.awardScore = 416;
    } else if ( pairJackTwo() && pairNineTwo() ) {
      this.awardScore = 415;
    } else if ( pairJackTwo() && pairEightTwo() ) {
      this.awardScore = 414;
    } else if ( pairJackTwo() && pairSevenTwo() ) {
      this.awardScore = 413;
    } else if ( pairJackTwo() && pairSixTwo() ) {
      this.awardScore = 412;
    } else if ( pairJackTwo() && pairFiveTwo() ) {
      this.awardScore = 411;
    } else if ( pairJackTwo() && pairFourTwo() ) {
      this.awardScore = 410;
    } else if ( pairJackTwo() && pairThreeTwo() ) {
      this.awardScore = 409;
    } else if ( pairJackTwo() && pairTwoTwo() ) {
      this.awardScore = 408;

    } else if ( pairTenTwo() && pairNineTwo() ) {
      this.awardScore = 407;
    } else if ( pairTenTwo() && pairEightTwo() ) {
      this.awardScore = 406;
    } else if ( pairTenTwo() && pairSevenTwo() ) {
      this.awardScore = 405;
    } else if ( pairTenTwo() && pairSixTwo() ) {
      this.awardScore = 404;
    } else if ( pairTenTwo() && pairFiveTwo() ) {
      this.awardScore = 403;
    } else if ( pairTenTwo() && pairFourTwo() ) {
      this.awardScore = 402;
    } else if ( pairTenTwo() && pairThreeTwo() ) {
      this.awardScore = 401;
    } else if ( pairTenTwo() && pairTwoTwo() ) {
      this.awardScore = 400;

    } else if ( pairNineTwo() && pairEightTwo() ) {
      this.awardScore = 399;
    } else if ( pairNineTwo() && pairSevenTwo() ) {
      this.awardScore = 398;
    } else if ( pairNineTwo() && pairSixTwo() ) {
      this.awardScore = 397;
    } else if ( pairNineTwo() && pairFiveTwo() ) {
      this.awardScore = 396;
    } else if ( pairNineTwo() && pairFourTwo() ) {
      this.awardScore = 395;
    } else if ( pairNineTwo() && pairThreeTwo() ) {
      this.awardScore = 394;
    } else if ( pairNineTwo() && pairTwoTwo() ) {
      this.awardScore = 393;

    } else if ( pairEightTwo() && pairSevenTwo() ) {
      this.awardScore = 392;
    } else if ( pairEightTwo() && pairSixTwo() ) {
      this.awardScore = 391;
    } else if ( pairEightTwo() && pairFiveTwo() ) {
      this.awardScore = 390;
    } else if ( pairEightTwo() && pairFourTwo() ) {
      this.awardScore = 389;
    } else if ( pairEightTwo() && pairThreeTwo() ) {
      this.awardScore = 388;
    } else if ( pairEightTwo() && pairTwoTwo() ) {
      this.awardScore = 387;

    } else if ( pairSevenTwo() && pairSixTwo() ) {
      this.awardScore = 386;
    } else if ( pairSevenTwo() && pairFiveTwo() ) {
      this.awardScore = 385;
    } else if ( pairSevenTwo() && pairFourTwo() ) {
      this.awardScore = 384;
    } else if ( pairSevenTwo() && pairThreeTwo() ) {
      this.awardScore = 383;
    } else if ( pairSevenTwo() && pairTwoTwo() ) {
      this.awardScore = 382;

    } else if ( pairSixTwo() && pairFiveTwo() ) {
      this.awardScore = 381;
    } else if ( pairSixTwo() && pairFourTwo() ) {
      this.awardScore = 380;
    } else if ( pairSixTwo() && pairThreeTwo() ) {
      this.awardScore = 379;
    } else if ( pairSixTwo() && pairTwoTwo() ) {
      this.awardScore = 378;

    } else if ( pairFiveTwo() && pairFourTwo() ) {
      this.awardScore = 377;
    } else if ( pairFiveTwo() && pairThreeTwo() ) {
      this.awardScore = 376;
    } else if ( pairFiveTwo() && pairTwoTwo() ) {
      this.awardScore = 375;

    } else if ( pairFourTwo() && pairThreeTwo() ) {
      this.awardScore = 374;
    } else if ( pairFourTwo() && pairTwoTwo() ) {
      this.awardScore = 373;

    } else if ( pairThreeTwo() && pairTwoTwo() ) {
      this.awardScore = 372;


    } else if ( pairAce() ) {
      this.awardScore = 212;
    } else if ( pairKing() ) {
      this.awardScore = 211;
    } else if ( pairQueen() ) {
      this.awardScore = 210;
    } else if ( pairJack() ) {
      this.awardScore = 209;
    } else if ( pairTen() ) {
      this.awardScore = 208;
    } else if ( pairNine() ) {
      this.awardScore = 207;
    } else if ( pairEight() ) {
      this.awardScore = 206;
    } else if ( pairSeven() ) {
      this.awardScore = 205;
    } else if ( pairSix() ) {
      this.awardScore = 204;
    } else if ( pairFive()) {
      this.awardScore = 203;
    } else if ( pairFour() ) {
      this.awardScore = 202;
    } else if ( pairThree() ) {
      this.awardScore = 201;
    } else if ( pairTwo() ) {
      this.awardScore = 200;

    } else {
      this.awardScore = 100;
    }
  }



}











