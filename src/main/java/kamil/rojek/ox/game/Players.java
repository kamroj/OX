package kamil.rojek.ox.game;

import kamil.rojek.ox.customExceptions.PlayerSeedTypeException;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;


/**
 * Container for players
 * @author Kamil Rojek
 */
public class Players implements IPlayers{
    private HashMap<Integer, Player> players;
    private int playerIndex = 1;


    /**
     * Initialize two players
     */
    public Players() {
        initializePlayers();
    }

    public Player getCurrentPlayer() {
        return players.get(playerIndex);
    }

    public Player getNextPlayer() {
        playerIndex = playerIndex == 2 ? 1 : 2;
        return players.get(playerIndex);
    }

    public List<Player> getAllPlayers() {
        List<Player> playersList = new ArrayList<>();

        for (Integer playerIndex : players.keySet()){
            playersList.add(players.get(playerIndex));
        }

        return playersList;
    }

    private void initializePlayers() {
        try {
            players = new HashMap();
            players.put(1, new Player("Player 1", SeedType.Cross));
            players.put(2, new Player("Player 2", SeedType.Nought));
        }
        catch (PlayerSeedTypeException e) {
            e.getMessage();
        }
    }
}
