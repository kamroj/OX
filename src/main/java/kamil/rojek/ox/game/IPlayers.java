package kamil.rojek.ox.game;

import java.util.List;

/**
 * @author Kamil Rojek
 */
public interface IPlayers {
    Player getCurrentPlayer();
    Player getNextPlayer();
    List<Player> getAllPlayers();
}
