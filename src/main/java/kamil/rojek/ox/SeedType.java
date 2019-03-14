package kamil.rojek.ox;

/**
 * @author Kamil Rojek
 */
public enum SeedType {
    Nought("O"),
    Cross("X"),
    None(" ");

    private String type;

    SeedType(String type){
        this.type = type;
    }
}
