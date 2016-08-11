import static org.junit.Assert.*;
import org.junit.*;
import org.mockito.*;
import static org.mockito.Mockito.*;
import Game.*;

public class GameTest {

  Cards cards;

  @Before
  public void before() {
    cards = new Cards();
  }

  @Test
  public void checkCards() {
    assertEquals( 4, cards.cardLength() );
  }

  @Test
  public void checkShuffle() {
    assertEquals( "Shuffled 😀", cards.shuffle() );
  }


}