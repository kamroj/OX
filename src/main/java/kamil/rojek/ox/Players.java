package kamil.rojek.ox;

import kamil.rojek.ox.CustomExceptions.PlayerSeedTypeException;
import java.util.HashMap;

public class Players {
    private HashMap<Integer, Player> players;
    private int playerIndex = 1;

    public Players() {
        initializePlayers();
    }

    public int getAllPlayers() {
        return players.size();
    }

    public Player getCurrentPlayer() {
        return players.get(playerIndex);
    }

    private void initializePlayers() {
        try {
            players = new HashMap();
            players.put(1, new Player("Kamil", SeedType.Cross));
            players.put(2, new Player("Monika", SeedType.Nought));
        }
        catch (PlayerSeedTypeException e) {
            e.getMessage();
        }
    }

    public Player getNextPlayer() {
        playerIndex = playerIndex == 2 ? 1 : 2;
        return players.get(playerIndex);
    }
}
