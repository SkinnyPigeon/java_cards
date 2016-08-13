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

  public boolean pairTwo() {
    pair();
    if( this.processedCards.size() > 1) {
      char firstCard = this.processedCards.get(0).charAt(0);
      if( firstCard == '2' ) {
        return true;
      }
    }
    return false;
  }

  public boolean pairThree() {
    pair();
    if( this.processedCards.size() > 1) {
      char firstCard = this.processedCards.get(0).charAt(0);
      if( firstCard == '3' ) {
        return true;
      }
    }
    return false;
  }

  public boolean pairFour() {
    pair();
    if( this.processedCards.size() > 1) {
      char firstCard = this.processedCards.get(0).charAt(0);
      if( firstCard == '4' ) {
        return true;
      }
    }
    return false;
  }

  public boolean pairFive() {
    pair();
    if( this.processedCards.size() > 1) {
      char firstCard = this.processedCards.get(0).charAt(0);
      if( firstCard == '5' ) {
        return true;
      }
    }
    return false;
  }

  public boolean pairSix() {
    pair();
    if( this.processedCards.size() > 1) {
      char firstCard = this.processedCards.get(0).charAt(0);
      if( firstCard == '6' ) {
        return true;
      }
    }
    return false;
  }

  public boolean pairSeven() {
    pair();
    if( this.processedCards.size() > 1) {
      char firstCard = this.processedCards.get(0).charAt(0);
      if( firstCard == '7' ) {
        return true;
      }
    }
    return false;
  }

  public boolean pairEight() {
    pair();
    if( this.processedCards.size() > 1) {
      char firstCard = this.processedCards.get(0).charAt(0);
      if( firstCard == '8' ) {
        return true;
      }
    }
    return false;
  }

  public boolean pairNine() {
    pair();
    if( this.processedCards.size() > 1) {
      char firstCard = this.processedCards.get(0).charAt(0);
      if( firstCard == '9' ) {
        return true;
      }
    }
    return false;
  }

  public boolean pairTen() {
    pair();
    if( this.processedCards.size() > 1) {
      char firstCard = this.processedCards.get(0).charAt(0);
      if( firstCard == '1' ) {
        return true;
      }
    }
    return false;
  }

  public boolean pairJack() {
    pair();
    if( this.processedCards.size() > 1) {
      char firstCard = this.processedCards.get(0).charAt(0);
      if( firstCard == 'J' ) {
        return true;
      }
    }
    return false;
  }

  public boolean pairQueen() {
    pair();
    if( this.processedCards.size() > 1) {
      char firstCard = this.processedCards.get(0).charAt(0);
      if( firstCard == 'Q' ) {
        return true;
      }
    }
    return false;
  }

  public boolean pairKing() {
    pair();
    if( this.processedCards.size() > 1) {
      char firstCard = this.processedCards.get(0).charAt(0);
      if( firstCard == 'K' ) {
        return true;
      }
    }
    return false;
  }

  public boolean pairAce() {
    pair();
    if( this.processedCards.size() > 1) {
      char firstCard = this.processedCards.get(0).charAt(0);
      if( firstCard == 'A' ) {
        return true;
      }
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
        countPoints();
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

  public boolean fourAce() {
    four();
    if( this.processedCards.size() > 3 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      if( firstCard == 'A' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fourKing() {
    four();
    if( this.processedCards.size() > 3 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      if( firstCard == 'K' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fourQueen() {
    four();
    if( this.processedCards.size() > 3 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      if( firstCard == 'Q' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fourJack() {
    four();
    if( this.processedCards.size() > 3 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      if( firstCard == 'J' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fourTen() {
    four();
    if( this.processedCards.size() > 3 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      if( firstCard == '1' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fourNine() {
    four();
    if( this.processedCards.size() > 3 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      if( firstCard == '9' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fourEight() {
    four();
    if( this.processedCards.size() > 3 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      if( firstCard == '8' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fourSeven() {
    four();
    if( this.processedCards.size() > 3 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      if( firstCard == '7' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fourSix() {
    four();
    if( this.processedCards.size() > 3 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      if( firstCard == '6' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fourFive() {
    four();
    if( this.processedCards.size() > 3 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      if( firstCard == '5' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fourFour() {
    four();
    if( this.processedCards.size() > 3 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      if( firstCard == '4' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fourThree() {
    four();
    if( this.processedCards.size() > 3 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      if( firstCard == '3' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fourTwo() {
    four();
    if( this.processedCards.size() > 3 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      if( firstCard == '2' ) {
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

  public boolean fullHouseAceKing() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == 'A' && secondCard == 'K' ) || 
            firstCard == 'K' && secondCard == 'A' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseAceQueen() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == 'A' && secondCard == 'Q' ) || 
            firstCard == 'Q' && secondCard == 'A' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseAceJack() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == 'A' && secondCard == 'J' ) || 
            firstCard == 'J' && secondCard == 'A' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseAceTen() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == 'A' && secondCard == '1' ) || 
            firstCard == '1' && secondCard == 'A' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseAceNine() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == 'A' && secondCard == '9' ) || 
            firstCard == '9' && secondCard == 'A' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseAceEight() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == 'A' && secondCard == '8' ) || 
            firstCard == '8' && secondCard == 'A' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseAceSeven() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == 'A' && secondCard == '7' ) || 
            firstCard == '7' && secondCard == 'A' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseAceSix() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == 'A' && secondCard == '6' ) || 
            firstCard == '6' && secondCard == 'A' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseAceFive() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == 'A' && secondCard == '5' ) || 
            firstCard == '5' && secondCard == 'A' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseAceFour() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == 'A' && secondCard == '4' ) || 
            firstCard == '4' && secondCard == 'A' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseAceThree() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == 'A' && secondCard == '3' ) || 
            firstCard == '3' && secondCard == 'A' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseAceTwo() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == 'A' && secondCard == '2' ) || 
            firstCard == '2' && secondCard == 'A' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseKingQueen() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == 'K' && secondCard == 'Q' ) || 
            firstCard == 'Q' && secondCard == 'K' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseKingJack() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == 'K' && secondCard == 'J' ) || 
            firstCard == 'J' && secondCard == 'K' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseKingTen() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == 'K' && secondCard == '1' ) || 
            firstCard == '1' && secondCard == 'K' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseKingNine() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == 'K' && secondCard == '9' ) || 
            firstCard == '9' && secondCard == 'K' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseKingEight() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == 'K' && secondCard == '8' ) || 
            firstCard == '8' && secondCard == 'K' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseKingSeven() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == 'K' && secondCard == '7' ) || 
            firstCard == '7' && secondCard == 'K' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseKingSix() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == 'K' && secondCard == '6' ) || 
            firstCard == '6' && secondCard == 'K' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseKingFive() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == 'K' && secondCard == '5' ) || 
            firstCard == '5' && secondCard == 'K' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseKingFour() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == 'K' && secondCard == '4' ) || 
            firstCard == '4' && secondCard == 'K' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseKingThree() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == 'K' && secondCard == '3' ) || 
            firstCard == '3' && secondCard == 'K' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseKingTwo() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == 'K' && secondCard == '2' ) || 
            firstCard == '2' && secondCard == 'K' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseQueenJack() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == 'Q' && secondCard == 'J' ) || 
            firstCard == 'J' && secondCard == 'Q' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseQueenTen() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == 'Q' && secondCard == '1' ) || 
            firstCard == '1' && secondCard == 'Q' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseQueenNine() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == 'Q' && secondCard == '9' ) || 
            firstCard == '9' && secondCard == 'Q' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseQueenEight() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == 'Q' && secondCard == '8' ) || 
            firstCard == '8' && secondCard == 'Q' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseQueenSeven() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == 'Q' && secondCard == '7' ) || 
            firstCard == '7' && secondCard == 'Q' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseQueenSix() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == 'Q' && secondCard == '6' ) || 
            firstCard == '6' && secondCard == 'Q' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseQueenFive() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == 'Q' && secondCard == '5' ) || 
            firstCard == '5' && secondCard == 'Q' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseQueenFour() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == 'Q' && secondCard == '4' ) || 
            firstCard == '4' && secondCard == 'Q' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseQueenThree() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == 'Q' && secondCard == '3' ) || 
            firstCard == '3' && secondCard == 'Q' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseQueenTwo() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == 'Q' && secondCard == '2' ) || 
            firstCard == '2' && secondCard == 'Q' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseJackTen() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == 'J' && secondCard == '1' ) || 
            firstCard == '1' && secondCard == 'J' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseJackNine() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == 'J' && secondCard == '9' ) || 
            firstCard == '9' && secondCard == 'J' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseJackEight() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == 'J' && secondCard == '8' ) || 
            firstCard == '8' && secondCard == 'J' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseJackSeven() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == 'J' && secondCard == '7' ) || 
            firstCard == '7' && secondCard == 'J' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseJackSix() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == 'J' && secondCard == '6' ) || 
            firstCard == '6' && secondCard == 'J' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseJackFive() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == 'J' && secondCard == '5' ) || 
            firstCard == '5' && secondCard == 'J' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseJackFour() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == 'J' && secondCard == '4' ) || 
            firstCard == '4' && secondCard == 'J' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseJackThree() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == 'J' && secondCard == '3' ) || 
            firstCard == '3' && secondCard == 'J' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseJackTwo() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == 'J' && secondCard == '2' ) || 
            firstCard == '2' && secondCard == 'J' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseTenNine() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == '1' && secondCard == '9' ) || 
            firstCard == '9' && secondCard == '1' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseTenEight() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == '1' && secondCard == '8' ) || 
            firstCard == '8' && secondCard == '1' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseTenSeven() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == '1' && secondCard == '7' ) || 
            firstCard == '7' && secondCard == '1' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseTenSix() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == '1' && secondCard == '6' ) || 
            firstCard == '6' && secondCard == '1' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseTenFive() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == '1' && secondCard == '5' ) || 
            firstCard == '5' && secondCard == '1' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseTenFour() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == '1' && secondCard == '4' ) || 
            firstCard == '4' && secondCard == '1' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseTenThree() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == '1' && secondCard == '3' ) || 
            firstCard == '3' && secondCard == '1' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseTenTwo() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == '1' && secondCard == '2' ) || 
            firstCard == '2' && secondCard == '1' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseNineEight() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == '9' && secondCard == '8' ) || 
            firstCard == '8' && secondCard == '9' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseNineSeven() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == '9' && secondCard == '7' ) || 
            firstCard == '7' && secondCard == '9' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseNineSix() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == '9' && secondCard == '6' ) || 
            firstCard == '6' && secondCard == '9' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseNineFive() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == '9' && secondCard == '5' ) || 
            firstCard == '5' && secondCard == '9' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseNineFour() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == '9' && secondCard == '4' ) || 
            firstCard == '4' && secondCard == '9' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseNineThree() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == '9' && secondCard == '3' ) || 
            firstCard == '3' && secondCard == '9' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseNineTwo() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == '9' && secondCard == '2' ) || 
            firstCard == '2' && secondCard == '9' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseEightSeven() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == '8' && secondCard == '7' ) || 
            firstCard == '7' && secondCard == '8' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseEightSix() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == '8' && secondCard == '6' ) || 
            firstCard == '6' && secondCard == '8' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseEightFive() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == '8' && secondCard == '5' ) || 
            firstCard == '5' && secondCard == '8' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseEightFour() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == '8' && secondCard == '4' ) || 
            firstCard == '4' && secondCard == '8' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseEightThree() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == '8' && secondCard == '3' ) || 
            firstCard == '3' && secondCard == '8' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseEightTwo() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == '8' && secondCard == '2' ) || 
            firstCard == '2' && secondCard == '8' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseSevenSix() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == '7' && secondCard == '6' ) || 
            firstCard == '6' && secondCard == '7' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseSevenFive() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == '7' && secondCard == '5' ) || 
            firstCard == '5' && secondCard == '7' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseSevenFour() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == '7' && secondCard == '4' ) || 
            firstCard == '4' && secondCard == '7' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseSevenThree() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == '7' && secondCard == '3' ) || 
            firstCard == '3' && secondCard == '7' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseSevenTwo() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == '7' && secondCard == '2' ) || 
            firstCard == '2' && secondCard == '7' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseSixFive() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == '6' && secondCard == '5' ) || 
            firstCard == '5' && secondCard == '6' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseSixFour() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == '6' && secondCard == '4' ) || 
            firstCard == '4' && secondCard == '6' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseSixThree() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == '6' && secondCard == '3' ) || 
            firstCard == '3' && secondCard == '6' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseSixTwo() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == '6' && secondCard == '2' ) || 
            firstCard == '2' && secondCard == '6' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseFiveFour() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == '5' && secondCard == '4' ) || 
            firstCard == '4' && secondCard == '5' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseFiveThree() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == '5' && secondCard == '3' ) || 
            firstCard == '3' && secondCard == '5' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseFiveTwo() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == '5' && secondCard == '2' ) || 
            firstCard == '2' && secondCard == '5' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseFourThree() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == '4' && secondCard == '3' ) || 
            firstCard == '3' && secondCard == '4' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseFourTwo() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == '4' && secondCard == '2' ) || 
            firstCard == '2' && secondCard == '4' ) {
        return true;
      }
    }
    return false;
  }

  public boolean fullHouseThreeTwo() {
    fullHouseTwoFirst();
    fullHouseThreeFirst();
    if( this.processedCards.size() > 4 ) {
      char firstCard = this.processedCards.get( 0 ).charAt( 0 );
      char secondCard = this.processedCards.get( 4 ).charAt( 0 );
      if( ( firstCard == '3' && secondCard == '2' ) || 
            firstCard == '2' && secondCard == '3' ) {
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

  public boolean royalStraight() {
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

        if( firstCard == '1' && secondCard == 'A' && thirdCard == 'J' 
          && fourthCard == 'K' && fifthCard == 'Q' ) {
          return true;
      }
    }
  return false;
  }

  public boolean straightNine() {
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

      if( firstCard == '1' && secondCard == '9' && thirdCard == 'J' 
        && fourthCard == 'K' && fifthCard == 'Q' ) {
        return true;
      }
    }
  return false;
  }

  public boolean straightEight() {
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

      if( firstCard == '1' && secondCard == '8' && thirdCard == '9' 
        && fourthCard == 'J' && fifthCard == 'Q' ) {
        return true;
      }
    }
  return false;
  }

  public boolean straightSeven() {
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

      if( firstCard == '1' && secondCard == '7' && thirdCard == '8' 
        && fourthCard == '9' && fifthCard == 'J' ) {
        return true;
      }
    }
  return false;
  }

  public boolean straightSix() {
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

      if( firstCard == '1' && secondCard == '6' && thirdCard == '7' 
        && fourthCard == '8' && fifthCard == '9' ) {
        return true;
      }
    }
  return false;
  }

  public boolean straightFive() {
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
      if( firstCard == '5' && secondCard == '6' && thirdCard == '7' 
        && fourthCard == '8' && fifthCard == '9' ) {
        return true;
      }
    }
  return false;
  }

  public boolean straightFour() {
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
      if( firstCard == '4' && secondCard == '5' && thirdCard == '6' 
        && fourthCard == '7' && fifthCard == '8' ) {
        return true;
      }
    }
  return false;
  }

  public boolean straightThree() {
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
      if( firstCard == '3' && secondCard == '4' && thirdCard == '5' 
        && fourthCard == '6' && fifthCard == '7' ) {
        return true;
      }
    }
  return false;
  }

  public boolean straightTwo() {
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
      if( firstCard == '2' && secondCard == '3' && thirdCard == '4' 
        && fourthCard == '5' && fifthCard == '6' ) {
        return true;
      }
    }
  return false;
  }

  public boolean straightAce() {
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
      if( firstCard == '2' && secondCard == '3' && thirdCard == '4' 
        && fourthCard == '5' && fifthCard == 'A' ) {
        return true;
      }
    }
  return false;
  }

  public boolean royalFlush() {
    if( royalStraight() && flush() ) {
      return true;
    }
    return false;
  }

  public boolean straightFlushNine() {
    if( straightNine() && flush() ) {
      return true;
    }
    return false;
  }

  public boolean straightFlushEight() {
    if( straightEight() && flush() ) {
      return true;
    }
    return false;
  }

  public boolean straightFlushSeven() {
    if( straightSeven() && flush() ) {
      return true;
    }
    return false;
  }

  public boolean straightFlushSix() {
    if( straightSix() && flush() ) {
      return true;
    }
    return false;
  }

  public boolean straightFlushFive() {
    if( straightFive() && flush() ) {
      return true;
    }
    return false;
  }

  public boolean straightFlushFour() {
    if( straightFour() && flush() ) {
      return true;
    }
    return false;
  }

  public boolean straightFlushThree() {
    if( straightThree() && flush() ) {
      return true;
    }
    return false;
  }

  public boolean straightFlushTwo() {
    if( straightTwo() && flush() ) {
      return true;
    }
    return false;
  }

  public boolean straightFlushAce() {
    if( straightAce() && flush() ) {
      return true;
    }
    return false;
  }

  public void setScore() {

    if( royalFlush() ) {
      this.awardScore = 1000;

    } else if( straightFlushNine() ) {
      this.awardScore = 990;
    } else if( straightFlushEight() ) {
      this.awardScore = 980;
    } else if( straightFlushSeven() ) {
      this.awardScore = 970;
    } else if( straightFlushSix() ) {
      this.awardScore = 960;
    } else if( straightFlushFive() ) {
      this.awardScore = 950;
    } else if( straightFlushFour() ) {
      this.awardScore = 940;
    } else if( straightFlushThree() ) {
      this.awardScore = 930;
    } else if( straightFlushTwo() ) {
      this.awardScore = 920;
    } else if( straightFlushAce() ) {
      this.awardScore = 910;

    } else if ( fourAce() ) {
      this.awardScore = 800;
    } else if ( fourKing() ) {
      this.awardScore = 800;
    } else if ( fourQueen() ) {
      this.awardScore = 800;
    } else if ( fourJack() ) {
      this.awardScore = 800;
    } else if ( fourTen() ) {
      this.awardScore = 800;
    } else if ( fourNine() ) {
      this.awardScore = 800;
    } else if ( fourEight() ) {
      this.awardScore = 800;
    } else if ( fourSeven() ) {
      this.awardScore = 800;
    } else if ( fourSix() ) {
      this.awardScore = 800;
    } else if ( fourFive() ) {
      this.awardScore = 800;
    } else if ( fourFour() ) {
      this.awardScore = 800;
    } else if ( fourThree() ) {
      this.awardScore = 800;
    } else if ( fourTwo() ) {
      this.awardScore = 800;

    } else if ( fullHouseAceKing() ) {
      this.awardScore = 799;
    } else if ( fullHouseAceQueen() ) {
      this.awardScore = 798;
    } else if ( fullHouseAceJack() ) {
      this.awardScore = 797;
    } else if ( fullHouseAceTen() ) {
      this.awardScore = 796;
    } else if ( fullHouseAceNine() ) {
      this.awardScore = 795;
    } else if ( fullHouseAceEight() ) {
      this.awardScore = 794;
    } else if ( fullHouseAceSeven() ) {
      this.awardScore = 793;
    } else if ( fullHouseAceSix() ) {
      this.awardScore = 792;
    } else if ( fullHouseAceFive() ) {
      this.awardScore = 791;
    } else if ( fullHouseAceFour() ) {
      this.awardScore = 790;
    } else if ( fullHouseAceThree() ) {
      this.awardScore = 789;
    } else if ( fullHouseAceTwo() ) {
      this.awardScore = 788;

    } else if ( fullHouseKingQueen() ) {
      this.awardScore = 787;
    } else if ( fullHouseKingJack() ) {
      this.awardScore = 786;
    } else if ( fullHouseKingTen() ) {
      this.awardScore = 785;
    } else if ( fullHouseKingNine() ) {
      this.awardScore = 784;
    } else if ( fullHouseKingEight() ) {
      this.awardScore = 783;
    } else if ( fullHouseKingSeven() ) {
      this.awardScore = 782;
    } else if ( fullHouseKingSix() ) {
      this.awardScore = 781;
    } else if ( fullHouseKingFive() ) {
      this.awardScore = 780;
    } else if ( fullHouseKingFour() ) {
      this.awardScore = 779;
    } else if ( fullHouseKingThree() ) {
      this.awardScore = 778;
    } else if ( fullHouseKingTwo() ) {
      this.awardScore = 777;

    } else if ( fullHouseQueenJack() ) {
      this.awardScore = 776;
    } else if ( fullHouseQueenTen() ) {
      this.awardScore = 775;
    } else if ( fullHouseQueenNine() ) {
      this.awardScore = 774;
    } else if ( fullHouseQueenEight() ) {
      this.awardScore = 773;
    } else if ( fullHouseQueenSeven() ) {
      this.awardScore = 772;
    } else if ( fullHouseQueenSix() ) {
      this.awardScore = 771;
    } else if ( fullHouseQueenFive() ) {
      this.awardScore = 770;
    } else if ( fullHouseQueenFour() ) {
      this.awardScore = 769;
    } else if ( fullHouseQueenThree() ) {
      this.awardScore = 768;
    } else if ( fullHouseQueenTwo() ) {
      this.awardScore = 767;

    } else if ( fullHouseJackTen() ) {
      this.awardScore = 766;
    } else if ( fullHouseJackNine() ) {
      this.awardScore = 765;
    } else if ( fullHouseJackEight() ) {
      this.awardScore = 764;
    } else if ( fullHouseJackSeven() ) {
      this.awardScore = 763;
    } else if ( fullHouseJackSix() ) {
      this.awardScore = 762;
    } else if ( fullHouseJackFive() ) {
      this.awardScore = 761;
    } else if ( fullHouseJackFour() ) {
      this.awardScore = 760;
    } else if ( fullHouseJackThree() ) {
      this.awardScore = 759;
    } else if ( fullHouseJackTwo() ) {
      this.awardScore = 758;

    } else if ( fullHouseTenNine() ) {
      this.awardScore = 757;
    } else if ( fullHouseTenEight() ) {
      this.awardScore = 756;
    } else if ( fullHouseTenSeven() ) {
      this.awardScore = 755;
    } else if ( fullHouseTenSix() ) {
      this.awardScore = 754;
    } else if ( fullHouseTenFive() ) {
      this.awardScore = 753;
    } else if ( fullHouseTenFour() ) {
      this.awardScore = 752;
    } else if ( fullHouseTenThree() ) {
      this.awardScore = 751;
    } else if ( fullHouseTenTwo() ) {
      this.awardScore = 750;

    } else if ( fullHouseNineEight() ) {
      this.awardScore = 749;
    } else if ( fullHouseNineSeven() ) {
      this.awardScore = 748;
    } else if ( fullHouseNineSix() ) {
      this.awardScore = 747;
    } else if ( fullHouseNineFive() ) {
      this.awardScore = 746;
    } else if ( fullHouseNineFour() ) {
      this.awardScore = 745;
    } else if ( fullHouseNineThree() ) {
      this.awardScore = 744;
    } else if ( fullHouseNineTwo() ) {
      this.awardScore = 743;

    } else if ( fullHouseEightSeven() ) {
      this.awardScore = 742;
    } else if ( fullHouseEightSix() ) {
      this.awardScore = 741;
    } else if ( fullHouseEightFive() ) {
      this.awardScore = 740;
    } else if ( fullHouseEightFour() ) {
      this.awardScore = 739;
    } else if ( fullHouseEightThree() ) {
      this.awardScore = 738;
    } else if ( fullHouseEightTwo() ) {
      this.awardScore = 737;

    } else if ( fullHouseSevenSix() ) {
      this.awardScore = 736;
    } else if ( fullHouseSevenFive() ) {
      this.awardScore = 735;
    } else if ( fullHouseSevenFour() ) {
      this.awardScore = 734;
    } else if ( fullHouseSevenThree() ) {
      this.awardScore = 733;
    } else if ( fullHouseSevenTwo() ) {
      this.awardScore = 732;

    } else if ( fullHouseSixFive() ) {
      this.awardScore = 731;
    } else if ( fullHouseSixFour() ) {
      this.awardScore = 730;
    } else if ( fullHouseSixThree() ) {
      this.awardScore = 729;
    } else if ( fullHouseSixTwo() ) {
      this.awardScore = 728;

    } else if ( fullHouseFiveFour() ) {
      this.awardScore = 727;
    } else if ( fullHouseFiveThree() ) {
      this.awardScore = 726;
    } else if ( fullHouseFiveTwo() ) {
      this.awardScore = 725;

    } else if ( fullHouseFourThree() ) {
      this.awardScore = 724;
    } else if ( fullHouseFourTwo() ) {
      this.awardScore = 723;

    } else if ( fullHouseThreeTwo() ) {
      this.awardScore = 722;

    } else if ( flush() ) {
      this.awardScore = 600;
        
    } else if ( royalStraight() ) {
      this.awardScore = 590;
    } else if ( straightNine() ) {
      this.awardScore = 580;
    } else if ( straightEight() ) {
      this.awardScore = 570;
    } else if ( straightSeven() ) {
      this.awardScore = 570;
    } else if ( straightSix() ) {
      this.awardScore = 560;
    } else if ( straightFive() ) {
      this.awardScore = 570;
    } else if ( straightFour() ) {
      this.awardScore = 570;
    } else if ( straightThree() ) {
      this.awardScore = 570;
    } else if ( straightTwo() ) {
      this.awardScore = 540;
    } else if ( straightAce() ) {
      this.awardScore = 570;

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
      countPoints();
    }
  }



}











