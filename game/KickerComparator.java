package Game;
import java.util.*;

public class KickerComparator implements Comparator<Player> {

  public int compare( Player self, Player other ) {
    return self.seeKicker().compareTo( other.seeKicker() );
  }

}


