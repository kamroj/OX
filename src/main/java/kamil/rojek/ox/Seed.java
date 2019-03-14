package kamil.rojek.ox;

/**
 * field with types that fill fields
 *
 * @author Kamil Rojek
 */
public class Seed {
    SeedType type;

    public Seed(SeedType type) {
        this.type = type;
    }

    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        Seed seed = (Seed) obj;
        return type.equals(seed.type);
    }
}
