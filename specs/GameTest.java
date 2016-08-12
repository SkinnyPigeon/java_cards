import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;
import org.mockito.*;
import static org.mockito.Mockito.*;
import Game.*;

public class GameTest {

  ArrayList expected;
  Cards cards;
  Player jeff;
  Player steve;
  Player dave;
  Game game;
  Logic logic;

  @Before
  public void before() {
    cards = new Cards();
    jeff = new Player( "Jeff", 1 );
    dave = new Player( "Dave", 2 );
    steve = new Player( "Steve", 3 );
    game = new Game( 3 );
  }

  @Test
  public void checkCards() {
    assertEquals( 7, cards.cardLength() );
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
  public void logicCanSeePair() {
    jeff.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    logic = new Logic( jeff.seeHand(), steve.seeHand() );
    logic.combineCards();
    assertEquals( true, logic.pair() );
  }

  @Test
  public void logicReturnsFalseToNonMatchedPair() {
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
  public void canSeeThreeOfAKind() {
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    jeff.takeCard( cards.deal() );
    steve.takeCard( cards.deal() );
    logic = new Logic( steve.seeHand(), jeff.seeHand() );
    logic.combineCards();
    assertEquals( true, logic.three() );
  }

}















