package code;
import java.util.Locale;

// Raw height is in decimeters; weight is in hectograms.
public class Pokemon {
    private int id;
    private String name;
    private int heightDm;
    private int weightHg;
    private int baseExperience;

    public Pokemon(int id, String name, int heightDm, int weightHg, int baseExperience) {
        this.id = id;
        this.name = name;
        this.heightDm = heightDm;
        this.weightHg = weightHg;
        this.baseExperience = baseExperience;
    }
    public int getId() { 
    	return Id; 
    }

    public String getName() { 
    	return name; 
    }

    public int getHeightDm() { 
    	return heightDm; 
    }

    public int getWeightHg() { 
    	return wightHg;; 
    }

    public int getBaseExperience() { 
    	return baseExperience; 
    }

    public void setId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException(
                    "ID cannot be negative.");
        }
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Name cannot be null or blank.");
        }

        this.name = name.trim().toLowerCase();
    }

    public void setHeightDm(int heightDm) {
        if (heightDm < 0) {
            throw new IllegalArgumentException(
                    "Height cannot be negative.");
        }

        this.heightDm = heightDm;
    }

    public void setWeightHg(int weightHg) {
        if (weightHg < 0) {
            throw new IllegalArgumentException(
                    "Weight cannot be negative.");
        }

        this.weightHg = weightHg;
    }

    public void setBaseExperience(int baseExperience) {
        if (baseExperience < 0) {
            throw new IllegalArgumentException(
                    "Base experience cannot be negative.");
        }

        this.baseExperience = baseExperience;
    }

    @Override
    public boolean equal(object obj){
        if (this == obj){
            return true;
        }
        if (obj == null || get class() != obj.getClass()){
            return false;
        }

        Pokemon other = (Pokemon) obj;

        return id == other.id && heightDm == other.heightDm && weightHg == other.weightHg && baseExperience == other.baseExperience && name.equals(other.name);
    }

    @Override
    public int hashCode() {

        int result = 17;

        result = 31 * result + id;
        result = 31 * result + name.hashCode();
        result = 31 * result + heightDm;
        result = 31 * result + weightHg;
        result = 31 * result + baseExperience;

        return result;
    }

    @Override
    public String toString() {
        return String.format(Locale.US,
            "#%d %s | Height: %.1f m | Weight: %.1f kg | Base experience: %d",
            id, name, heightDm / 10.0, weightHg / 10.0, baseExperience);
    }
}
