import static org.junit.Assert.*;
import org.junit.*;
import org.mockito.*;
import static org.mockito.Mockito.*;
import Game.*;

public class GameTest {

  Cards cards;
  Player jeff;

  @Before
  public void before() {
    cards = new Cards();
    jeff = new Player( "Jeff" );
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

  // @Test
  // public void hasCard() {
  //   cards.deal();
  //   jeff.takeCard( cards.dealtCards );
  //   assertEquals( "A♠️", jeff.hand() );
  // }


}



