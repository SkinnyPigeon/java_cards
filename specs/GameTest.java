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
  Game game;

  @Before
  public void before() {
    cards = new Cards();
    jeff = new Player( "Jeff" );
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

}



