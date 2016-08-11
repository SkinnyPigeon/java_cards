package Game;
import java.util.*;

public class Game {

  private ArrayList< Player > players;
  
  public Game(){
    this.players = new ArrayList<Player>();
  }


  public void takeTurn(){
  } 

  public void addPlayer(Player player){
    this.players.add(player);
  }

  public int countPlayers(){
    return this.players.size();
  }

}
