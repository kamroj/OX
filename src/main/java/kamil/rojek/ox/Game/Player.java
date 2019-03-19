package kamil.rojek.ox.Game;

import kamil.rojek.ox.CustomExceptions.PlayerSeedTypeException;

class Player {
    private String name;
    private SeedType type;
    private int score = 0;

    Player(String name, SeedType type) throws PlayerSeedTypeException {
        if (type == null || type.equals(SeedType.None)){
            throw new PlayerSeedTypeException("Player seed type cannot be null or NONE!");
        }

        this.name = name;
        this.type = type;
    }

    SeedType getSeedType() {
        return type;
    }

    void addPoint() {
        score++;
    }

    int getScore() {
        return score;
    }

    public String toString(){
        return "Player name: " + name + " SeedType: " + type;
    }

    public boolean equals(Object obj){
        if (obj == null)
            return false;

        return this.toString().equals(obj.toString());
    }
}
