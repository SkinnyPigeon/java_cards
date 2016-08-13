package Game;
import java.util.*;

public class PlayerComparator implements Comparator<Player> {

  public int compare( Player self, Player other ) {
    return self.seeScore().compareTo( other.seeScore() );
  }

}


