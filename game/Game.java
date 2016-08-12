package Game;
import java.util.*;

public class Game {

  private ArrayList< Player > players;
  private int pot;
  
  public Game(){
    this.players = new ArrayList<Player>();
    this.pot = 0;
  }


  public void takeTurn(){
  } 

  public void addPlayer(Player player){
    this.players.add(player);
  }

  public int countPlayers(){
    return this.players.size();
  }

  public int showPot() {
    return this.pot;
  }

  public void addBet() {

  }

}
