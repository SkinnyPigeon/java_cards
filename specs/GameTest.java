import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;
import org.mockito.*;
import static org.mockito.Mockito.*;
import Game.*;

public class GameTest {

  ArrayList expected;
  TestCards cards;
  Player jeff;
  Player steve;
  Player dave;
  Player bob;
  Game game;
  Logic logic;
  Logic logic2;

  @Before
  public void before() {
    cards = new TestCards();
    jeff = new Player( "Jeff", 1 );
    dave = new Player( "Dave", 2 );
    steve = new Player( "Steve", 3 );
    game = new Game( 3 );
  }

  @Test
  public void checkCards() {
    assertEquals( 18, cards.cardLength() );
  }

  @Test
  public void checkShuffle() {
    assertEquals( "Shuffled 😀", cards.shuffle() );
  }

  @Test
  public void canDeal() {
    assertEquals( "A♠️", cards.deal() );
  }

  @Test
  public void hasName() {
    assertEquals( "Jeff", jeff.name() );
  }

  @Test
  public void hasNumber() {
    assertEquals( 3, steve.number() );
  }

  @Test
  public void hasNoScoreToStart() {
    Integer expected = 0;
    assertEquals( expected, steve.seeScore() );
  }

  @Test
  public void hasCard() {
    jeff.takeCard(  cards.deal() );
    assertEquals( "A♠️", jeff.seeHand().get(0) );
  }

  @Test
  public void hasTwoCards() {
    jeff.takeCard(  cards.deal() );
    jeff.takeCard(  cards.deal() );
    assertEquals( "A♥️", jeff.seeHand().get(1) );
  }

  @Test
  public void playerStartsWithChips() {
    assertEquals( 500, jeff.countChips() );
  }

  @Test
  public void gameStartsWithNoPot() {
    assertEquals( 0, game.showPot() );
  }

  @Test
  public void playerLosesChipsWhenBetting() {
    jeff.placeBet( 50 );
    assertEquals( 450, jeff.countChips() );
  }

  @Test
  public void gameKnowsHowManyPlayers() {
    assertEquals( 3, game.numberOfPlayers() );
  }

  @Test
  public void gameCanTakeTurns() {
    game.nextTurn();
    assertEquals( 2, game.turn() );
  }

  @Test
  public void gameGoesBackToPlayerOne() {
    game.nextTurn();
    game.nextTurn();
    game.nextTurn();
    assertEquals( 1, game.turn() );
  }

  @Test
  public void gameCanOnlyTakeBetsFromRightPlayer() {
    game.nextTurn();
    steve.placeBet( 50 );
    game.addBet( steve );    
    dave.placeBet( 50 );
    game.addBet( dave );
    assertEquals( 50, game.showPot() );
  }

  @Test
  public void gamePotIncreasesWhenPlayerBets() {
    jeff.placeBet( 50 );
    game.addBet( jeff );
    assertEquals( 50, game.showPot() );
  }

  @Test
  public void gameCanTakeMulitpleBets() {
    jeff.placeBet( 50 );
    game.addBet( jeff );
    game.nextTurn();
    dave.placeBet( 50 );
    game.addBet( dave );
    assertEquals( 100, game.showPot() );
  }

  @Test
  public void multipleBetsAndTurns() {
    jeff.placeBet( 50 );
    game.addBet( jeff );
    game.nextTurn();
    dave.placeBet( 50 );
    game.addBet( dave );
    game.nextTurn();
    steve.placeBet( 50 );
    game.addBet( steve );
    game.nextTurn();
    jeff.placeBet( 55 );
    game.addBet( jeff );
    assertEquals( 205, game.showPot() );
  }

  @Test
  public void playerCannotBetMoreThanTheyHave() {
    jeff.placeBet( 475 );
    game.addBet( jeff );
    jeff.placeBet( 50 );
    game.addBet( jeff );
    assertEquals( 475, game.showPot() );
  }

  @Test
  public void playerMustAtLeastEqualLastBet() {
    jeff.placeBet( 50 );
    game.addBet( jeff );
    game.nextTurn();
    dave.placeBet( 25 );
    game.addBet( dave );
    assertEquals( 50 , game.showPot() );
  }

  @Test
  public void gameWillPayPlayerPotOnWin() {
    jeff.placeBet( 50 );
    game.addBet( jeff );
    game.handWon( steve );
    assertEquals( 550, steve.countChips() );
  }

  @Test
  public void logicWillTakeCards() {
    jeff.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    logic = new Logic( jeff.seeHand(), steve.seeHand() );
    logic.combineCards();
    assertEquals( "A♠️", logic.seeHand().get(0) );
  }

  @Test
  public void trueWhenPair() {
    jeff.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    logic = new Logic( jeff.seeHand(), steve.seeHand() );
    logic.combineCards();
    assertEquals( true, logic.pair() );
  }

  @Test
  public void falseWhenNotPair() {
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    dave.takeCard( cards.deal() );
    dave.takeCard( cards.deal() );
    logic = new Logic( steve.seeHand(), dave.seeHand() );
    logic.combineCards();
    assertEquals( false, logic.pair() );
  }

  @Test
  public void logicReturnsTrueToCardsAddedInRandomOrder() {
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    dave.takeCard( cards.deal() );
    dave.takeCard( cards.deal() );
    dave.takeCard( cards.deal() );
    logic = new Logic( steve.seeHand(), dave.seeHand() );
    logic.combineCards();
    assertEquals( true, logic.pair() );
  }

  @Test
  public void trueWhenThreeOfAKind() {
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    logic = new Logic( steve.seeHand(), jeff.seeHand() );
    logic.combineCards();
    assertEquals( true, logic.three() );
  }

  @Test
  public void falseWhenNotThreeOfAKind() {
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    dave.takeCard( cards.deal() );
    logic = new Logic( steve.seeHand(), dave.seeHand() );
    logic.combineCards();
    assertEquals( false, logic.three() );
  }

  @Test
  public void trueWhenFourOfAKind() {
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    logic = new Logic( steve.seeHand(), jeff.seeHand() );
    logic.combineCards();
    assertEquals( true, logic.four() );
  }

  @Test
  public void trueWhenTwoPairs() {
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    dave.takeCard( cards.deal() );
    dave.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    logic = new Logic( steve.seeHand(), jeff.seeHand() );
    logic.combineCards();
    assertEquals( true, logic.twoPair() );
  }

  @Test
  public void falseWhenNotFourOfAKind() {
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    dave.takeCard( cards.deal() );
    logic = new Logic( steve.seeHand(), dave.seeHand() );
    logic.combineCards();
    assertEquals( false, logic.four() );
  }

  @Test
  public void trueWhenNumbersAreInAStraight() {
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    dave.takeCard( cards.deal() );
    logic = new Logic( steve.seeHand(), dave.seeHand() );
    logic.combineCards();
    assertEquals( true, logic.straightTwo() );
  }

  @Test
  public void falseWhenNumbersAreNotInAStraight() {
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    dave.takeCard( cards.deal() );
    logic = new Logic( steve.seeHand(), dave.seeHand() );
    logic.combineCards();
    assertEquals( false, logic.straightTwo() );
  }

  @Test
  public void trueWhenNumbersAreInAFlush() {
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    dave.takeCard( cards.deal() );
    logic = new Logic( steve.seeHand(), dave.seeHand() );
    logic.combineCards();
    assertEquals( true, logic.flush() );
  }

  @Test
  public void falseWhenNumbersAreInNotAFlush() {
    dave.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    logic = new Logic( steve.seeHand(), dave.seeHand() );
    logic.combineCards();
    assertEquals( false, logic.flush() );
  }

  @Test
  public void trueWhenStraighFlush() {
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    dave.takeCard( cards.deal() );
    logic = new Logic( steve.seeHand(), dave.seeHand() );
    logic.combineCards();
    assertEquals( true, logic.straightFlushTwo() );
  }

  @Test
  public void falseWhenNotAStraighFlush() {
    dave.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    logic = new Logic( steve.seeHand(), dave.seeHand() );
    logic.combineCards();
    assertEquals( false, logic.straightFlushTwo() );
  }

  @Test
  public void trueWhenFullHouse() {
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    dave.takeCard( cards.deal() );
    logic = new Logic( jeff.seeHand(), dave.seeHand() );
    logic.combineCards();
    assertEquals( true, logic.fullHouseThreeFirst() );
  }

  @Test
  public void pointsAreAwarded() {
    game.takeCard( cards.deal() );
    game.takeCard( cards.deal() );
    game.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    dave.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    dave.takeCard( cards.deal() );
    logic = new Logic( game.seeHand(), dave.seeHand() );
    logic.combineCards();
    logic.setScore();
    dave.awardScore( logic.seeScore() );
    Integer expected = 799;
    assertEquals( expected, dave.seeScore() );
  }

  @Test
  public void falseWhenNotFullHouse() {
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    dave.takeCard( cards.deal() );
    logic = new Logic( steve.seeHand(), dave.seeHand() );
    logic.combineCards();
    assertEquals( false, logic.fullHouseThreeFirst() );
  }

  @Test
  public void falseWhenCardsCouldBeCountedTwice() {
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    logic = new Logic( steve.seeHand(), jeff.seeHand() );
    logic.combineCards();
    assertEquals( false, logic.fullHouseThreeFirst() );
  }



  @Test
  public void tableCanHaveCards() {
    game.takeCard( cards.deal() );
    game.takeCard( cards.deal() );
    assertEquals( "A♥️", game.seeHand().get(1) );
  }

  @Test
  public void canSeeARoyalFlush() {
    game.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    game.takeCard( cards.deal() );
    game.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    logic = new Logic( steve.seeHand(), game.seeHand() );
    logic.combineCards();
    assertEquals( true, logic.royalFlush() );
  }

  @Test
  public void canSeeAnAlmostRoyalFlush() {
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    game.takeCard( cards.deal() );
    game.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    game.takeCard( cards.deal() );
    logic = new Logic( steve.seeHand(), game.seeHand() );
    logic.combineCards();
    assertEquals( true, logic.straightFlushNine() );
  }

  @Test
  public void canSeeALowStraight() {
    jeff.takeCard( cards.deal() );
    game.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    game.takeCard( cards.deal() );
    game.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    logic = new Logic( steve.seeHand(), game.seeHand() );
    logic.combineCards();
    assertEquals( true, logic.straightAce() );
  }

  @Test
  public void canSeeAFurtherRoyalStraight() {
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    game.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    game.takeCard( cards.deal() );
    game.takeCard( cards.deal() );
    logic = new Logic( steve.seeHand(), game.seeHand() );
    logic.combineCards();
    assertEquals( true, logic.straightEight() );
  }

  @Test
  public void canBarelySeeARoyalStraight() {
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    game.takeCard( cards.deal() );
    game.takeCard( cards.deal() );
    game.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    logic = new Logic( steve.seeHand(), game.seeHand() );
    logic.combineCards();
    assertEquals( true, logic.straightSeven() );
  }

  @Test
  public void canBarelySeeTheTen() {
    jeff.takeCard( cards.deal() ); //Ace
    jeff.takeCard( cards.deal() ); //Ace
    jeff.takeCard( cards.deal() ); //Ace
    jeff.takeCard( cards.deal() ); //Ace
    jeff.takeCard( cards.deal() ); //King
    jeff.takeCard( cards.deal() ); //Queen
    jeff.takeCard( cards.deal() ); //King
    jeff.takeCard( cards.deal() ); //Two
    jeff.takeCard( cards.deal() ); //Three
    jeff.takeCard( cards.deal() ); //Four
    jeff.takeCard( cards.deal() ); //Five
    jeff.takeCard( cards.deal() ); //Six
    jeff.takeCard( cards.deal() ); //Jack
    steve.takeCard( cards.deal() ); //Ten
    game.takeCard( cards.deal() ); //Nine
    game.takeCard( cards.deal() ); //Eight
    game.takeCard( cards.deal() ); //Seven
    steve.takeCard( cards.deal() ); //Six
    logic = new Logic( steve.seeHand(), game.seeHand() );
    logic.combineCards();
    assertEquals( true, logic.straightSix() );
  }

  @Test
  public void checkThatFoursHaveScores() {
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    game.takeCard( cards.deal() );
    logic = new Logic( jeff.seeHand(), game.seeHand() );
    logic.combineCards();
    logic.setScore();
    jeff.awardScore( logic.seeScore() );
    Integer expected = 800;
    assertEquals( expected, jeff.seeScore() );
  }

  @Test
  public void gameCanPickWinningPlayer() {
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    dave.takeCard( cards.deal() );
    game.takeCard( cards.deal() );
    dave.takeCard( cards.deal() );
    game.takeCard( cards.deal() );
    game.takeCard( cards.deal() );

    logic = new Logic( steve.seeHand(), game.seeHand() );
    logic.combineCards();
    logic.setScore();
    jeff.awardScore( logic.seeScore() );

    logic = new Logic( dave.seeHand(), game.seeHand() );
    logic.combineCards();
    logic.setScore();
    dave.awardScore( logic.seeScore() );

    game.addPlayer( jeff );
    game.addPlayer( dave );
    game.pickWinner();
    assertEquals( jeff, game.seeWinner() );
  }

  @Test
  public void slimChanceTwoPairsAddTheirScore() {
    jeff.takeCard( cards.deal() ); //Ace
    jeff.takeCard( cards.deal() ); //Ace
    dave.takeCard( cards.deal() ); //Ace
    dave.takeCard( cards.deal() ); //Ace
    jeff.takeCard( cards.deal() ); //King
    game.takeCard( cards.deal() ); //Queen
    game.takeCard( cards.deal() ); //King

    logic = new Logic( jeff.seeHand(), game.seeHand() );
    logic.combineCards();
    logic.setScore();
    jeff.awardScore( logic.seeScore() );

    Integer expected = 449;
    assertEquals( expected, jeff.seeScore() );
  }

  @Test
  public void willGivePointsForThrees() {
    jeff.takeCard( cards.deal() ); //Ace
    jeff.takeCard( cards.deal() ); //Ace
    game.takeCard( cards.deal() ); //Ace
    dave.takeCard( cards.deal() ); //Ace
    game.takeCard( cards.deal() ); //King
    game.takeCard( cards.deal() ); //Queen
    dave.takeCard( cards.deal() ); //King

    logic = new Logic( jeff.seeHand(), game.seeHand() );
    logic.combineCards();
    logic.setScore();
    jeff.awardScore( logic.seeScore() );

    Integer expected = 512;
    assertEquals( expected, jeff.seeScore() );
  }

  @Test
  public void testAcesOverSix() {
    jeff.takeCard( cards.deal() ); //Ace
    jeff.takeCard( cards.deal() ); //Ace
    game.takeCard( cards.deal() ); //Ace
    dave.takeCard( cards.deal() ); //Ace
    dave.takeCard( cards.deal() ); //King
    dave.takeCard( cards.deal() ); //Queen
    dave.takeCard( cards.deal() ); //King
    dave.takeCard( cards.deal() ); //Two
    dave.takeCard( cards.deal() ); //Three
    dave.takeCard( cards.deal() ); //Four
    dave.takeCard( cards.deal() ); //Five
    game.takeCard( cards.deal() ); //Six
    dave.takeCard( cards.deal() ); //Jack
    dave.takeCard( cards.deal() ); //Ten
    dave.takeCard( cards.deal() ); //Nine
    dave.takeCard( cards.deal() ); //Eight
    dave.takeCard( cards.deal() ); //Seven
    game.takeCard( cards.deal() ); //Six

    logic = new Logic( jeff.seeHand(), game.seeHand() );
    logic.combineCards();
    logic.setScore();
    jeff.awardScore( logic.seeScore() );

    Integer expected = 792;
    assertEquals( expected, jeff.seeScore() );
  }

  @Test
  public void kickerCanAdd() {
      jeff.takeCard( cards.deal() ); //Ace
      game.takeCard( cards.deal() ); //Ace
      game.takeCard( cards.deal() ); //Ace
      game.takeCard( cards.deal() ); //Ace
      jeff.takeCard( cards.deal() ); //King

      logic = new Logic( jeff.seeHand(), game.seeHand() );
      logic.combineCards();

      logic.setKicker( 50 );
      Integer expected = 50;
      assertEquals( expected, logic.seeKicker() );
  }

  @Test
  public void kickerCanAddMultipleThings() {
      jeff.takeCard( cards.deal() ); //Ace
      game.takeCard( cards.deal() ); //Ace
      game.takeCard( cards.deal() ); //Ace
      game.takeCard( cards.deal() ); //Ace
      jeff.takeCard( cards.deal() ); //King

      logic = new Logic( jeff.seeHand(), game.seeHand() );
      logic.combineCards();

      logic.setKicker( 50 );
      logic.setKicker( 50 );
      Integer expected = 100;
      assertEquals( expected, logic.seeKicker() );
  }


  @Test
  public void aceAndKingGetPastToKicker() {
    jeff.takeCard( cards.deal() ); //Ace
    dave.takeCard( cards.deal() ); //Ace
    dave.takeCard( cards.deal() ); //Ace
    dave.takeCard( cards.deal() ); //Ace
    game.takeCard( cards.deal() ); //King

    logic = new Logic( jeff.seeHand(), game.seeHand() );
    logic.combineCards();
    logic.setScore();

    Integer expected = 6244;
    assertEquals( expected, logic.seeKicker() );
  }

  @Test
  public void gameWillPickWinByKicker() {
    game.takeCard( cards.deal() ); //Ace
    game.takeCard( cards.deal() ); //Ace
    game.takeCard( cards.deal() ); //Ace
    steve.takeCard( cards.deal() ); //Ace
    jeff.takeCard( cards.deal() ); //King
    dave.takeCard( cards.deal() ); //Queen

    logic = new Logic( jeff.seeHand(), game.seeHand() );
    logic.combineCards();
    logic.setScore();
    jeff.awardScore( logic.seeScore() );
    jeff.awardKicker( logic.seeKicker() );

    logic = new Logic( dave.seeHand(), game.seeHand() );
    logic.combineCards();
    logic.setScore();
    dave.awardScore( logic.seeScore() );
    dave.awardKicker( logic.seeKicker() );

    game.addPlayer( dave );
    game.addPlayer( jeff );
    game.pickWinner();
    assertEquals( jeff, game.seeWinner() );
  }

  @Test
  public void gameWillPayOutToTheHandWinner() {
    game.takeCard( cards.deal() ); //Ace
    game.takeCard( cards.deal() ); //Ace
    game.takeCard( cards.deal() ); //Ace
    steve.takeCard( cards.deal() ); //Ace
    jeff.takeCard( cards.deal() ); //King
    dave.takeCard( cards.deal() ); //Queen

    jeff.placeBet( 50 );
    game.addBet( jeff );
    game.nextTurn();
    dave.placeBet( 250 );
    game.addBet( dave );

    logic = new Logic( jeff.seeHand(), game.seeHand() );
    logic.combineCards();
    logic.setScore();
    jeff.awardScore( logic.seeScore() );
    jeff.awardKicker( logic.seeKicker() );

    logic = new Logic( dave.seeHand(), game.seeHand() );
    logic.combineCards();
    logic.setScore();
    dave.awardScore( logic.seeScore() );
    dave.awardKicker( logic.seeKicker() );

    game.addPlayer( jeff );
    game.addPlayer( dave );
    game.pickWinner();
    game.handWon( game.seeWinner() );
    assertEquals( 750, jeff.countChips() );

  }

  @Test
  public void flushCanBeWonTheRightWay() {
    jeff.takeCard( cards.deal() ); //Ace
    dave.takeCard( cards.deal() ); //Ace
    dave.takeCard( cards.deal() ); //Ace
    dave.takeCard( cards.deal() ); //Ace
    steve.takeCard( cards.deal() ); //King
    dave.takeCard( cards.deal() ); //Queen
    dave.takeCard( cards.deal() ); //King
    dave.takeCard( cards.deal() ); //Two
    dave.takeCard( cards.deal() ); //Three
    dave.takeCard( cards.deal() ); //Four
    dave.takeCard( cards.deal() ); //Five
    dave.takeCard( cards.deal() ); //Six
    dave.takeCard( cards.deal() ); //Jack
    game.takeCard( cards.deal() ); //Ten
    game.takeCard( cards.deal() ); //Nine
    game.takeCard( cards.deal() ); //Eight
    jeff.takeCard( cards.deal() ); //Seven
    steve.takeCard( cards.deal() ); //Six

    logic = new Logic( jeff.seeHand(), game.seeHand() );
    logic.combineCards();
    logic.setScore();
    jeff.awardScore( logic.seeScore() );
    jeff.awardKicker( logic.seeKicker() );

    logic = new Logic( steve.seeHand(), game.seeHand() );
    logic.combineCards();
    logic.setScore();
    steve.awardScore( logic.seeScore() );
    steve.awardKicker( logic.seeKicker() );

    game.addPlayer( steve );
    game.addPlayer( jeff );
    game.pickWinner();
    assertEquals( jeff, game.seeWinner() );
    
  }

  @Test
  public void pushingMyLuckWithThreePlayers() {
    bob = new Player( "Bob", 4 );

    game.takeCard( cards.deal() ); //Ace
    dave.takeCard( cards.deal() ); //Ace
    dave.takeCard( cards.deal() ); //Ace
    dave.takeCard( cards.deal() ); //Ace
    game.takeCard( cards.deal() ); //King
    game.takeCard( cards.deal() ); //Queen
    dave.takeCard( cards.deal() ); //King
    dave.takeCard( cards.deal() ); //Two
    dave.takeCard( cards.deal() ); //Three
    dave.takeCard( cards.deal() ); //Four
    dave.takeCard( cards.deal() ); //Five
    dave.takeCard( cards.deal() ); //Six
    bob.takeCard( cards.deal() ); //Jack
    bob.takeCard( cards.deal() ); //Ten
    jeff.takeCard( cards.deal() ); //Nine
    steve.takeCard( cards.deal() ); //Eight
    jeff.takeCard( cards.deal() ); //Seven
    steve.takeCard( cards.deal() ); //Six

    logic = new Logic( bob.seeHand(), game.seeHand() );
    logic.combineCards();
    logic.setScore();
    bob.awardScore( logic.seeScore() );
    bob.awardKicker( logic.seeKicker() );

    logic = new Logic( jeff.seeHand(), game.seeHand() );
    logic.combineCards();
    logic.setScore();
    jeff.awardScore( logic.seeScore() );
    jeff.awardKicker( logic.seeKicker() );

    logic = new Logic( steve.seeHand(), game.seeHand() );
    logic.combineCards();
    logic.setScore();
    steve.awardScore( logic.seeScore() );
    steve.awardKicker( logic.seeKicker() );

    game.addPlayer( steve );
    game.addPlayer( bob );
    game.addPlayer( jeff );
    game.pickWinner();
    assertEquals( bob, game.seeWinner() );
  }

  @Test
  public void playersCanCheckCardsBeforeFlop() {
    jeff.takeCard( cards.deal() ); //Ace
    jeff.takeCard( cards.deal() ); //Ace
    logic = new Logic( jeff.seeHand(), game.seeHand() );
    logic.combineCards();
    logic.setScore();
    jeff.awardScore( logic.seeScore() );
    jeff.awardKicker( logic.seeKicker() );

    Integer expected = 212;
    assertEquals( expected, jeff.seeScore() );
  }

  @Test
  public void playersCanPostSmallBlinds() {
    jeff.smallBlind();
    assertEquals( 495, jeff.countChips() );
  }

  @Test
  public void playersCanPostBigBlinds() {
    jeff.bigBlind();
    assertEquals( 490, jeff.countChips() );
  }

  @Test
  public void playerKnowsTheyveFolded() {
    jeff.fold();
    assertEquals( true, jeff.status() );
  }

  @Test
  public void gameKnowsWhenSomeoneHasFolded() {
    jeff.fold();
    game.nextTurn();
    game.nextTurn();
    game.nextTurn();
    game.foldCheck( jeff );
    assertEquals( 2, game.turn() );
  }

  @Test
  public void gameWillPayOutWhenAllPlayersHaveFolded() {
    jeff.placeBet( 50 );
    game.addBet( jeff );
    jeff.fold();
    dave.fold();
    game.nextTurn();
    game.foldCheck( dave );
    game.foldCheck( jeff );
    game.foldCheck( steve );
    game.foldWin( dave );
    game.foldWin( jeff );
    game.foldWin( steve );
    assertEquals( 550, steve.countChips() );
  }

  @Test
  public void foldMasterIsWorking() {
    jeff.placeBet( 50 );
    game.addBet( jeff );
    jeff.fold();
    dave.fold();
    game.foldMaster( jeff );
    game.foldMaster( dave );
    game.foldMaster( steve );
    assertEquals( 550, steve.countChips() );
  }





}















