package code;
import java.util.Locale;

// Immutable data object. Raw height is in decimeters; weight is in hectograms.
public class Pokemon {
    private final int id;
    private final String name;
    private final int heightDm;
    private final int weightHg;
    private final int baseExperience;

    public Pokemon(int id, String name, int heightDm, int weightHg, int baseExperience) {
        this.id = id;
        this.name = name;
        this.heightDm = heightDm;
        this.weightHg = weightHg;
        this.baseExperience = baseExperience;
    }

    public String getName() { 
    	return name; 
    }

    @Override
    public String toString() {
        return String.format(Locale.US,
            "#%d %s | Height: %.1f m | Weight: %.1f kg | Base experience: %d",
            id, name, heightDm / 10.0, weightHg / 10.0, baseExperience);
    }
}
