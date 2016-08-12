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
    jeff = new Player( "Jeff" );
    dave = new Player( "Dave" );
    steve = new Player( "Steve" );
    game = new Game();
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
  public void hasCard() {
    jeff.takeCard(  cards.deal() );
    assertEquals( "A♠️", jeff.seeHand().get(0) );
  }

  @Test
  public void checkPlayers(){
    game.addPlayer(jeff);
    assertEquals(1, game.countPlayers());
  }

  @Test
  public void gameHasMultiplePlayers() {
    game.addPlayer( jeff );
    game.addPlayer( steve );
    game.addPlayer( dave );
    assertEquals( 3, game.countPlayers() );
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
  public void gamePotIncreasesWhenPlayerBets() {
    jeff.placeBet( 50 );
    game.addBet( jeff.giveBet() );
    assertEquals( 50, game.showPot() );
  }

  @Test
  public void gameCanTakeMulitpleBets() {
    steve.placeBet( 50 );
    game.addBet( steve.giveBet() );    
    jeff.placeBet( 50 );
    game.addBet( jeff.giveBet() );
    assertEquals( 100, game.showPot() );
  }



}















