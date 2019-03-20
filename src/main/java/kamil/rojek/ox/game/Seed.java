package kamil.rojek.ox.game;

/**
 * field with types that fill fields
 *
 * @author Kamil Rojek
 */
class Seed {
    SeedType type;

    Seed(SeedType type) {
        this.type = type;
    }

    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        Seed seed = (Seed) obj;
        return type.equals(seed.type);
    }
}
