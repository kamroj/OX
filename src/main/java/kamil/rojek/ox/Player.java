package kamil.rojek.ox;

import kamil.rojek.ox.CustomExceptions.PlayerSeedTypeException;

public class Player {
    private String name;
    private SeedType type;
    private int score = 0;

    public Player(String name, SeedType type) throws PlayerSeedTypeException {
        if (type == null || type.equals(SeedType.None)){
            throw new PlayerSeedTypeException("Player seed type cannot be null or NONE!");
        }

        this.name = name;
        this.type = type;
    }

    SeedType getSeedType() {
        return type;
    }

    public String toString(){
        return "Player name: " + name + " SeedType: " + type;
    }

    public void addPoint() {
        score++;
    }

    public int getScore() {
        return score;
    }
}
