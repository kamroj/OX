package kamil.rojek.ox.Game;

/**
 * @author Kamil Rojek
 */
enum SeedType {
    Nought("O"),
    Cross("X"),
    None(" ");

    private String type;

    SeedType(String type){
        this.type = type;
    }

    public String getValue(){
        return type;
    }
}
