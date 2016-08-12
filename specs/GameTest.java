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
    assertEquals( 4, cards.cardLength() );
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

}















