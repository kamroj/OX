package kamil.rojek.ox.game;

import kamil.rojek.ox.customExceptions.PlayerSeedTypeException;
import kamil.rojek.ox.inputOutput.LocalizationKey;
import kamil.rojek.ox.inputOutput.SoutWrapper;


/**
 * @author Kamil Rojek
 */
class Player {
    private String name;
    private SeedType type;
    private int score = 0;


    /**
     *
     * @param name takes String as player name
     * @param type takes SeedType as player type (Cross, Nought)
     * @throws PlayerSeedTypeException
     */
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
        SoutWrapper.getInstance().getMsg(LocalizationKey.ADDIDNG_POINT, this.toString());
        score++;
    }

    int getScore() {
        return score;
    }

    public String toString(){
        return name + " (" + type.getValue() +")";
    }

    public boolean equals(Object obj){
        if (obj == null)
            return false;

        return this.toString().equals(obj.toString());
    }
}
