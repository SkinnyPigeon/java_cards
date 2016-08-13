package Game;
import java.util.*;

public class PlayerComparator implements Comparator<Player> {

  // public int compare( Player self, Player other ) {
  //   return self.seeScore().compareTo( other.seeScore() );
  // }

  public int compareKickers( Player self, Player other ) {
    return self.seeKicker().compareTo( other.seeKicker() );
  }

  public int compareScores( Player self, Player other ) {
    return self.seeScore().compareTo( other.seeScore() );
  }

}


