package kamil.rojek.ox;

import kamil.rojek.ox.CustomExceptions.PlayerSeedTypeException;
import java.util.HashMap;

class Players {
    private HashMap<Integer, Player> players;
    private int playerIndex = 1;

    Players() {
        initializePlayers();
    }

    int getAllPlayers() {
        return players.size();
    }

    Player getCurrentPlayer() {
        return players.get(playerIndex);
    }

    Player getNextPlayer() {
        playerIndex = playerIndex == 2 ? 1 : 2;
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
}
