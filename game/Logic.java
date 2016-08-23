package Game;
import java.util.*;

public class Logic {

  private ArrayList< String > playerCards;
  private ArrayList< String > tableCards;
  private ArrayList< String > processedCards;
  private Integer awardScore;
  private Integer kickerScore;

  public Logic( ArrayList playerCards, ArrayList tableCards ) {
    this.playerCards = playerCards;
    this.tableCards = tableCards;
    this.processedCards = new ArrayList< String >();
    this.awardScore = awardScore;
    this.kickerScore = 0;
  }

  public Integer seeScore() {
    return this.awardScore;
  }

  public Integer seeKicker() {
    return this.kickerScore;
  }

  public void setKicker( Integer points ) {
    this.kickerScore += points;
  }

  public void combineCards() {
    this.playerCards.addAll( this.tableCards );
    Collections.sort( this.playerCards );
  }

  public ArrayList seeHand() {
    return this.playerCards;
  }

  public void countPoints() {
    char firstCard;
    if( this.playerCards.size() > 0 ) {
      for( int i = 0; i < this.playerCards.size(); i++ ) {
        firstCard = this.playerCards.get( i ).charAt( 0 );

        if( firstCard == 'A' ) {
          setKicker( 4196 );
        } else if ( firstCard == 'K' ) {
          setKicker( 2048 );
        } else if ( firstCard == 'Q' ) {
          setKicker( 1024 );
        } else if ( firstCard == 'J' ) {
          setKicker( 512 );
        } else if ( firstCard == '1' ) {
          setKicker( 256 );
        } else if ( firstCard == '9' ) {
          setKicker( 128 );
        } else if ( firstCard == '8' ) {
          setKicker( 64 );
        } else if ( firstCard == '7' ) {
          setKicker( 32 );
        } else if ( firstCard == '6' ) {
          setKicker( 16 );
        } else if ( firstCard == '5' ) {
          setKicker( 8 );
        } else if ( firstCard == '4' ) {
          setKicker( 4 );
        } else if ( firstCard == '3' ) {
          setKicker( 2 );
        } else if ( firstCard == '2' ) {
          setKicker( 1 );
        }
      }
    }
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
        countPoints();
        return true;
      } 
    }
    return false;
  }

  public boolean pairCheck( char firstNumber ) {
    pair();
    if( this.processedCards.size() > 1 ) {
      char firstCard = this.processedCards.get(0).charAt(0);
      if( firstCard == firstNumber ) {
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
        countPoints();
        return true;
      } 
    }
    return false;
  }

  public boolean twoPairCheck( char firstNumber ) {
    if( this.playerCards.size() > 3 ) {
      twoPair();
    }
    if( this.processedCards.size() > 3) {
      char firstCard = this.processedCards.get(0).charAt(0);
      char secondCard = this.processedCards.get(2).charAt(0);
      if( firstCard == firstNumber || secondCard == firstNumber ) {
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
        countPoints();
        return true;
      }
    }
    return false;
  }

  public boolean threeCheck( char firstNumber ) {
    three();
    char firstCard;
    if( this.processedCards.size() > 2 ) {
      firstCard = this.processedCards.get(0).charAt(0);
      if( firstCard == firstNumber ) {
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
    if( this.playerCards.size() > 3 ) {
      for( int i = 0; i < this.playerCards.size() - 3; i++ ) {
        firstCard = this.playerCards.get( i ).charAt( 0 );
        secondCard = this.playerCards.get( i + 1 ).charAt( 0 );
        thirdCard = this.playerCards.get( i + 2 ).charAt( 0 );
        fourthCard = this.playerCards.get( i + 3 ).charAt( 0 );
        if( firstCard == secondCard && firstCard == thirdCard 
          && firstCard == fourthCard ) {
          this.processedCards.add( this.playerCards.remove( i + 3 ) );
          this.processedCards.add( this.playerCards.remove( i + 2 ) );
          this.processedCards.add( this.playerCards.remove( i + 1 ) );
          this.processedCards.add( this.playerCards.remove( i ) );
          countPoints();
          return true;
        } 
      }
    }
    return false;
  }

  public boolean fourCheck( char firstNumber ) {
    four();
    if( this.processedCards.size() > 3 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      if( firstCard == firstNumber ) {
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

  public boolean fullHouseCheck( char firstNumber, char secondNumber ) {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == firstNumber && secondCard == secondNumber ) || 
            firstCard == secondNumber && secondCard == firstNumber ) {
        return true;
      }
    }
    return false;
  }

  public boolean flush() {
    char firstCard;
    char secondCard;
    char thirdCard;
    char fourthCard;
    char fifthCard;
    if( this.playerCards.size() > 4) {
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
        countPoints();
        return true;
      }
    }
  return false;
  }

  public boolean straightCheck( char firstNumber, char secondNumber, char thirdNumber, char fourthNumber, char fifthNumber ) {
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

          if( firstCard == firstNumber && secondCard == secondNumber && thirdCard == thirdNumber && fourthCard == fourthNumber && fifthCard == fifthNumber ) {
            return true;
        }
      }
    return false;
  }

  public boolean straightFlushCheck( char firstNumber, char secondNumber, char thirdNumber, char fourthNumber, char fifthNumber ) {
    if( straightCheck( firstNumber, secondNumber, thirdNumber, fourthNumber, fifthNumber) && flush() ) {
      return true;
    }
    return false;
  }

  public void setScore() {

    if( straightFlushCheck( '1', 'A', 'J', 'K', 'Q' ) ) {
      this.awardScore = 1000;
    } else if( straightFlushCheck( '1', '9', 'J', 'K', 'Q' ) ) {
      this.awardScore = 990;
    } else if( straightFlushCheck( '1', '8', '9', 'J', 'Q' ) ) {
      this.awardScore = 980;
    } else if( straightFlushCheck( '1', '7', '8', '9', 'J' ) ) {
      this.awardScore = 970;
    } else if( straightFlushCheck( '1', '6', '7', '8', '9' ) ) {
      this.awardScore = 960;
    } else if( straightFlushCheck( '5', '6', '7', '8', '9' ) ) {
      this.awardScore = 950;
    } else if( straightFlushCheck( '4', '5', '6', '7', '8' ) ) {
      this.awardScore = 940;
    } else if( straightFlushCheck( '3', '4', '5', '6', '7' ) ) {
      this.awardScore = 930;
    } else if( straightFlushCheck( '2', '3', '4', '5', '6' ) ) {
      this.awardScore = 920;
    } else if( straightFlushCheck( '2', '3', '4', '5', 'A' ) ) {
      this.awardScore = 910;

    } else if ( fourCheck( 'A' ) ) {
      this.awardScore = 813;
    } else if ( fourCheck( 'K' ) ) {
      this.awardScore = 812;
    } else if ( fourCheck( 'Q' ) ) {
      this.awardScore = 811;
    } else if ( fourCheck( 'J' ) ) {
      this.awardScore = 810;
    } else if ( fourCheck( '1' ) ) {
      this.awardScore = 809;
    } else if ( fourCheck( '9' ) ) {
      this.awardScore = 808;
    } else if ( fourCheck( '8' ) ) {
      this.awardScore = 807;
    } else if ( fourCheck( '7' ) ) {
      this.awardScore = 806;
    } else if ( fourCheck( '6' ) ) {
      this.awardScore = 805;
    } else if ( fourCheck( '5' ) ) {
      this.awardScore = 804;
    } else if ( fourCheck( '4' ) ) {
      this.awardScore = 803;
    } else if ( fourCheck( '3' ) ) {
      this.awardScore = 802;
    } else if ( fourCheck( '2' ) ) {
      this.awardScore = 801;

    } else if ( fullHouseCheck( 'A', 'K' ) ) {
      this.awardScore = 799;
    } else if ( fullHouseCheck( 'A', 'Q' ) ) {
      this.awardScore = 798;
    } else if ( fullHouseCheck( 'A', 'J' ) ) {
      this.awardScore = 797;
    } else if ( fullHouseCheck( 'A', '1' ) ) {
      this.awardScore = 796;
    } else if ( fullHouseCheck( 'A', '9' ) ) {
      this.awardScore = 795;
    } else if ( fullHouseCheck( 'A', '8' ) ) {
      this.awardScore = 794;
    } else if ( fullHouseCheck( 'A', '7' ) ) {
      this.awardScore = 793;
    } else if ( fullHouseCheck( 'A', '6' ) ) {
      this.awardScore = 792;
    } else if ( fullHouseCheck( 'A', '5' ) ) {
      this.awardScore = 791;
    } else if ( fullHouseCheck( 'A', '4' ) ) {
      this.awardScore = 790;
    } else if ( fullHouseCheck( 'A', '3' ) ) {
      this.awardScore = 789;
    } else if ( fullHouseCheck( 'A', '2' ) ) {
      this.awardScore = 788;

    } else if ( fullHouseCheck( 'K', 'Q' ) ) {
      this.awardScore = 787;
    } else if ( fullHouseCheck( 'K', 'J' ) ) {
      this.awardScore = 786;
    } else if ( fullHouseCheck( 'K', '1' ) ) {
      this.awardScore = 785;
    } else if ( fullHouseCheck( 'K', '9' ) ) {
      this.awardScore = 784;
    } else if ( fullHouseCheck( 'K', '8' ) ) {
      this.awardScore = 783;
    } else if ( fullHouseCheck( 'K', '7' ) ) {
      this.awardScore = 782;
    } else if ( fullHouseCheck( 'K', '6' ) ) {
      this.awardScore = 781;
    } else if ( fullHouseCheck( 'K', '5' ) ) {
      this.awardScore = 780;
    } else if ( fullHouseCheck( 'K', '4' ) ) {
      this.awardScore = 779;
    } else if ( fullHouseCheck( 'K', '3' ) ) {
      this.awardScore = 778;
    } else if ( fullHouseCheck( 'K', '2' ) ) {
      this.awardScore = 777;



    } else if ( fullHouseCheck( 'Q', 'J' ) ) {
      this.awardScore = 776;
    } else if ( fullHouseCheck( 'Q', '1' ) ) {
      this.awardScore = 775;
    } else if ( fullHouseCheck( 'Q', '9' ) ) {
      this.awardScore = 774;
    } else if ( fullHouseCheck( 'Q', '8' ) ) {
      this.awardScore = 773;
    } else if ( fullHouseCheck( 'Q', '7' ) ) {
      this.awardScore = 772;
    } else if ( fullHouseCheck( 'Q', '6' ) ) {
      this.awardScore = 771;
    } else if ( fullHouseCheck( 'Q', '5' ) ) {
      this.awardScore = 770;
    } else if ( fullHouseCheck( 'Q', '4' ) ) {
      this.awardScore = 769;
    } else if ( fullHouseCheck( 'Q', '3' ) ) {
      this.awardScore = 768;
    } else if ( fullHouseCheck( 'Q', '2' ) ) {
      this.awardScore = 767;

    } else if ( fullHouseCheck( 'J', '1' ) ) {
      this.awardScore = 766;
    } else if ( fullHouseCheck( 'J', '9' ) ) {
      this.awardScore = 765;
    } else if ( fullHouseCheck( 'J', '8' ) ) {
      this.awardScore = 764;
    } else if ( fullHouseCheck( 'J', '7' ) ) {
      this.awardScore = 763;
    } else if ( fullHouseCheck( 'J', '6' ) ) {
      this.awardScore = 762;
    } else if ( fullHouseCheck( 'J', '5' ) ) {
      this.awardScore = 761;
    } else if ( fullHouseCheck( 'J', '4' ) ) {
      this.awardScore = 760;
    } else if ( fullHouseCheck( 'J', '3' ) ) {
      this.awardScore = 759;
    } else if ( fullHouseCheck( 'J', '2' ) ) {
      this.awardScore = 758;


    } else if ( fullHouseCheck( '1', '9' ) ) {
      this.awardScore = 757;
    } else if ( fullHouseCheck( '1', '8' ) ) {
      this.awardScore = 756;
    } else if ( fullHouseCheck( '1', '7' ) ) {
      this.awardScore = 755;
    } else if ( fullHouseCheck( '1', '6' ) ) {
      this.awardScore = 754;
    } else if ( fullHouseCheck( '1', '5' ) ) {
      this.awardScore = 753;
    } else if ( fullHouseCheck( '1', '4' ) ) {
      this.awardScore = 752;
    } else if ( fullHouseCheck( '1', '3' ) ) {
      this.awardScore = 751;
    } else if ( fullHouseCheck( '1', '2' ) ) {
      this.awardScore = 750;

    } else if ( fullHouseCheck( '9', '8' ) ) {
      this.awardScore = 748;
    } else if ( fullHouseCheck( '9', '7' ) ) {
      this.awardScore = 747;
    } else if ( fullHouseCheck( '9', '6' ) ) {
      this.awardScore = 746;
    } else if ( fullHouseCheck( '9', '5' ) ) {
      this.awardScore = 745;
    } else if ( fullHouseCheck( '9', '4' ) ) {
      this.awardScore = 744;
    } else if ( fullHouseCheck( '9', '3' ) ) {
      this.awardScore = 743;
    } else if ( fullHouseCheck( '9', '2' ) ) {
      this.awardScore = 742;

    } else if ( fullHouseCheck( '8', '7' ) ) {
      this.awardScore = 741;
    } else if ( fullHouseCheck( '8', '6' ) ) {
      this.awardScore = 739;
    } else if ( fullHouseCheck( '8', '5' ) ) {
      this.awardScore = 738;
    } else if ( fullHouseCheck( '8', '4' ) ) {
      this.awardScore = 737;
    } else if ( fullHouseCheck( '8', '3' ) ) {
      this.awardScore = 736;
    } else if ( fullHouseCheck( '8', '2' ) ) {
      this.awardScore = 735;

    } else if ( fullHouseCheck( '7', '6' ) ) {
      this.awardScore = 734;
    } else if ( fullHouseCheck( '7', '5' ) ) {
      this.awardScore = 733;
    } else if ( fullHouseCheck( '7', '4' ) ) {
      this.awardScore = 732;
    } else if ( fullHouseCheck( '7', '3' ) ) {
      this.awardScore = 731;
    } else if ( fullHouseCheck( '7', '2' ) ) {
      this.awardScore = 730;

    } else if ( fullHouseCheck( '6', '5' ) ) {
      this.awardScore = 729;
    } else if ( fullHouseCheck( '6', '4' ) ) {
      this.awardScore = 728;
    } else if ( fullHouseCheck( '6', '3' ) ) {
      this.awardScore = 727;
    } else if ( fullHouseCheck( '6', '2' ) ) {
      this.awardScore = 726;

    } else if ( fullHouseCheck( '5', '4' ) ) {
      this.awardScore = 725;
    } else if ( fullHouseCheck( '5', '3' ) ) {
      this.awardScore = 724;
    } else if ( fullHouseCheck( '5', '2' ) ) {
      this.awardScore = 723;

    } else if ( fullHouseCheck( '4', '3' ) ) {
      this.awardScore = 722;
    } else if ( fullHouseCheck( '4', '2' ) ) {
      this.awardScore = 721;

    } else if ( fullHouseCheck( '3', '2' ) ) {
      this.awardScore = 720;

    } else if ( flush() ) {
      this.awardScore = 600;

    } else if ( straightCheck( '1', 'A', 'J', 'K', 'Q' ) ) {
      this.awardScore = 590;
    } else if ( straightCheck( '1', '9', 'J', 'K', 'Q' ) ) {
      this.awardScore = 580;
    } else if ( straightCheck( '1', '8', '9', 'J', 'Q' ) ) {
      this.awardScore = 570;
    } else if ( straightCheck( '1', '7', '8', '9', 'J' ) ) {
      this.awardScore = 560;
    } else if ( straightCheck( '1', '6', '7', '8', '9' ) ) {
      this.awardScore = 550;
    } else if ( straightCheck( '5', '6', '7', '8', '9' ) ) {
      this.awardScore = 540;
    } else if ( straightCheck( '4', '5', '6', '7', '8' ) ) {
      this.awardScore = 530;
    } else if ( straightCheck( '3', '4', '5', '6', '7' ) ) {
      this.awardScore = 520;
    } else if ( straightCheck( '2', '3', '4', '5', '6' ) ) {
      this.awardScore = 510;
    } else if ( straightCheck( '2', '3', '4', '5', 'A' ) ) {
      this.awardScore = 500;

    } else if ( threeCheck( 'A' ) ) {
        this.awardScore = 512;
    } else if ( threeCheck( 'K' ) ) {
        this.awardScore = 511;
    } else if ( threeCheck( 'Q' ) ) {
        this.awardScore = 510;
    } else if ( threeCheck( 'J' ) ) {
        this.awardScore = 509;
    } else if ( threeCheck( '1' ) ) {
        this.awardScore = 508;
    } else if ( threeCheck( '9' ) ) {
        this.awardScore = 507;
    } else if ( threeCheck( '8' ) ) {
        this.awardScore = 506;
    } else if ( threeCheck( '7' ) ) {
        this.awardScore = 505;
    } else if ( threeCheck( '6' ) ) {
        this.awardScore = 504;
    } else if ( threeCheck( '5' ) ) {
        this.awardScore = 503;
    } else if ( threeCheck( '4' ) ) {
        this.awardScore = 502;
    } else if ( threeCheck( '3' ) ) {
        this.awardScore = 501;
    } else if ( threeCheck( '2' ) ) {
        this.awardScore = 500;

    } else if ( twoPairCheck( 'A') && twoPairCheck( 'K') ) {
      this.awardScore = 449;
    } else if ( twoPairCheck( 'A') && twoPairCheck( 'Q') ) {
      this.awardScore = 448;
    } else if ( twoPairCheck( 'A') && twoPairCheck( 'J') ) {
      this.awardScore = 447;
    } else if ( twoPairCheck( 'A') && twoPairCheck( '1') ) {
      this.awardScore = 446;
    } else if ( twoPairCheck( 'A') && twoPairCheck( '9') ) {
      this.awardScore = 445;
    } else if ( twoPairCheck( 'A') && twoPairCheck( '8') ) {
      this.awardScore = 444;
    } else if ( twoPairCheck( 'A') && twoPairCheck( '7') ) {
      this.awardScore = 443;
    } else if ( twoPairCheck( 'A') && twoPairCheck( '6') ) {
      this.awardScore = 442;
    } else if ( twoPairCheck( 'A') && twoPairCheck( '5') ) {
      this.awardScore = 441;
    } else if ( twoPairCheck( 'A') && twoPairCheck( '4') ) {
      this.awardScore = 440;
    } else if ( twoPairCheck( 'A') && twoPairCheck( '3') ) {
      this.awardScore = 439;
    } else if ( twoPairCheck( 'A') && twoPairCheck( '2') ) {
      this.awardScore = 438;

    } else if ( twoPairCheck( 'K') && twoPairCheck( 'Q') ) {
      this.awardScore = 437;
    } else if ( twoPairCheck( 'K') && twoPairCheck( 'J') ) {
      this.awardScore = 436;
    } else if ( twoPairCheck( 'K') && twoPairCheck( '1') ) {
      this.awardScore = 435;
    } else if ( twoPairCheck( 'K') && twoPairCheck( '9') ) {
      this.awardScore = 434;
    } else if ( twoPairCheck( 'K') && twoPairCheck( '8') ) {
      this.awardScore = 433;
    } else if ( twoPairCheck( 'K') && twoPairCheck( '7') ) {
      this.awardScore = 432;
    } else if ( twoPairCheck( 'K') && twoPairCheck( '6') ) {
      this.awardScore = 431;
    } else if ( twoPairCheck( 'K') && twoPairCheck( '5') ) {
      this.awardScore = 430;
    } else if ( twoPairCheck( 'K') && twoPairCheck( '4') ) {
      this.awardScore = 429;
    } else if ( twoPairCheck( 'K') && twoPairCheck( '3') ) {
      this.awardScore = 428;
    } else if ( twoPairCheck( 'K') && twoPairCheck( '2') ) {
      this.awardScore = 427; 

    } else if ( twoPairCheck( 'Q') && twoPairCheck( 'J') ) {
      this.awardScore = 426; 
    } else if ( twoPairCheck( 'Q') && twoPairCheck( '1') ) {
      this.awardScore = 425; 
    } else if ( twoPairCheck( 'Q') && twoPairCheck( '9') ) {
      this.awardScore = 424; 
    } else if ( twoPairCheck( 'Q') && twoPairCheck( '8') ) {
      this.awardScore = 423; 
    } else if ( twoPairCheck( 'Q') && twoPairCheck( '7') ) {
      this.awardScore = 422; 
    } else if ( twoPairCheck( 'Q') && twoPairCheck( '6') ) {
      this.awardScore = 421; 
    } else if ( twoPairCheck( 'Q') && twoPairCheck( '5') ) {
      this.awardScore = 420; 
    } else if ( twoPairCheck( 'Q') && twoPairCheck( '4') ) {
      this.awardScore = 419; 
    } else if ( twoPairCheck( 'Q') && twoPairCheck( '3') ) {
      this.awardScore = 418; 
    } else if ( twoPairCheck( 'Q') && twoPairCheck( '2') ) {
      this.awardScore = 417; 

    } else if ( twoPairCheck( 'J') && twoPairCheck( '1') ) {
      this.awardScore = 416;
    } else if ( twoPairCheck( 'J') && twoPairCheck( '9') ) {
      this.awardScore = 415; 
    } else if ( twoPairCheck( 'J') && twoPairCheck( '8') ) {
      this.awardScore = 414; 
    } else if ( twoPairCheck( 'J') && twoPairCheck( '7') ) {
      this.awardScore = 413; 
    } else if ( twoPairCheck( 'J') && twoPairCheck( '6') ) {
      this.awardScore = 412; 
    } else if ( twoPairCheck( 'J') && twoPairCheck( '5') ) {
      this.awardScore = 411; 
    } else if ( twoPairCheck( 'J') && twoPairCheck( '4') ) {
      this.awardScore = 410; 
    } else if ( twoPairCheck( 'J') && twoPairCheck( '3') ) {
      this.awardScore = 409; 
    } else if ( twoPairCheck( 'J') && twoPairCheck( '2') ) {
      this.awardScore = 408;  

    } else if ( twoPairCheck( '1') && twoPairCheck( '9') ) {
      this.awardScore = 407;
    } else if ( twoPairCheck( '1') && twoPairCheck( '8') ) {
      this.awardScore = 406;
    } else if ( twoPairCheck( '1') && twoPairCheck( '7') ) {
      this.awardScore = 405;
    } else if ( twoPairCheck( '1') && twoPairCheck( '6') ) {
      this.awardScore = 404;
    } else if ( twoPairCheck( '1') && twoPairCheck( '5') ) {
      this.awardScore = 403;
    } else if ( twoPairCheck( '1') && twoPairCheck( '4') ) {
      this.awardScore = 402;
    } else if ( twoPairCheck( '1') && twoPairCheck( '3') ) {
      this.awardScore = 401;
    } else if ( twoPairCheck( '1') && twoPairCheck( '2') ) {
      this.awardScore = 400;

    } else if ( twoPairCheck( '9') && twoPairCheck( '8') ) {
      this.awardScore = 399;
    } else if ( twoPairCheck( '9') && twoPairCheck( '7') ) {
      this.awardScore = 398;
    } else if ( twoPairCheck( '9') && twoPairCheck( '6') ) {
      this.awardScore = 397;
    } else if ( twoPairCheck( '9') && twoPairCheck( '5') ) {
      this.awardScore = 396;
    } else if ( twoPairCheck( '9') && twoPairCheck( '4') ) {
      this.awardScore = 395;
    } else if ( twoPairCheck( '9') && twoPairCheck( '3') ) {
      this.awardScore = 394;
    } else if ( twoPairCheck( '9') && twoPairCheck( '2') ) {
      this.awardScore = 393;

    } else if ( twoPairCheck( '8') && twoPairCheck( '7') ) {
      this.awardScore = 392;
    } else if ( twoPairCheck( '8') && twoPairCheck( '6') ) {
      this.awardScore = 391;
    } else if ( twoPairCheck( '8') && twoPairCheck( '5') ) {
      this.awardScore = 390;
    } else if ( twoPairCheck( '8') && twoPairCheck( '4') ) {
      this.awardScore = 389;
    } else if ( twoPairCheck( '8') && twoPairCheck( '3') ) {
      this.awardScore = 388;
    } else if ( twoPairCheck( '8') && twoPairCheck( '2') ) {
      this.awardScore = 387;

    } else if ( twoPairCheck( '7') && twoPairCheck( '6') ) {
      this.awardScore = 386;
    } else if ( twoPairCheck( '7') && twoPairCheck( '5') ) {
      this.awardScore = 385;
    } else if ( twoPairCheck( '7') && twoPairCheck( '4') ) {
      this.awardScore = 384;
    } else if ( twoPairCheck( '7') && twoPairCheck( '3') ) {
      this.awardScore = 383;
    } else if ( twoPairCheck( '7') && twoPairCheck( '2') ) {
      this.awardScore = 382;

    } else if ( twoPairCheck( '6') && twoPairCheck( '5') ) {
      this.awardScore = 381;
    } else if ( twoPairCheck( '6') && twoPairCheck( '4') ) {
      this.awardScore = 380;
    } else if ( twoPairCheck( '6') && twoPairCheck( '3') ) {
      this.awardScore = 379;
    } else if ( twoPairCheck( '6') && twoPairCheck( '2') ) {
      this.awardScore = 378;

    } else if ( twoPairCheck( '5') && twoPairCheck( '4') ) {
      this.awardScore = 377;
    } else if ( twoPairCheck( '5') && twoPairCheck( '3') ) {
      this.awardScore = 376;
    } else if ( twoPairCheck( '5') && twoPairCheck( '2') ) {
      this.awardScore = 375;

    } else if ( twoPairCheck( '4') && twoPairCheck( '3') ) {
      this.awardScore = 374;
    } else if ( twoPairCheck( '4') && twoPairCheck( '2') ) {
      this.awardScore = 373;

    } else if ( twoPairCheck( '3') && twoPairCheck( '2') ) {
      this.awardScore = 372;

    } else if ( pairCheck( 'A' ) ) {
      this.awardScore = 212;
    } else if ( pairCheck( 'K' ) ) {
      this.awardScore = 211;
    } else if ( pairCheck( 'Q' ) ) {
      this.awardScore = 210;
    } else if ( pairCheck( 'J' ) ) {
      this.awardScore = 209;
    } else if ( pairCheck( '1' ) ) {
      this.awardScore = 208;
    } else if ( pairCheck( '9' ) ) {
      this.awardScore = 207;
    } else if ( pairCheck( '8' ) ) {
      this.awardScore = 206;
    } else if ( pairCheck( '7' ) ) {
      this.awardScore = 205;
    } else if ( pairCheck( '6' ) ) {
      this.awardScore = 204;
    } else if ( pairCheck( '5' ) ) {
      this.awardScore = 203;
    } else if ( pairCheck( '4' ) ) {
      this.awardScore = 202;
    } else if ( pairCheck( '3' ) ) {
      this.awardScore = 201;
    } else if ( pairCheck( '2' ) ) {
      this.awardScore = 200;

    } else {
      this.awardScore = 0;
      countPoints();
    }
  }



}











