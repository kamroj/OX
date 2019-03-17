package kamil.rojek.ox;

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
}
