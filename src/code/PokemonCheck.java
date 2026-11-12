package code;

public class PokemonCheck {
    public static void main(String[] args){
        Pokemon p1 = new Pokemon(25, "Pikachu", 4, 60, 112);

        Pokemon p2 = new Pokemon(25, "Pikachu", 4, 60, 112);

        System.out.println("=== Equality Test ===");
        System.out.println("p1.equals(p2): " + p1.equals(p2));

        System.out.println("p1 hashCode: " + p1.hashCode());

        System.out.println("p2 hashCode: "
                + p2.hashCode());

        System.out.println();

        System.out.println("=== Getter Test ===");
        System.out.println("ID: "
                + p1.getId());

        System.out.println("Name: "
                + p1.getName());

        System.out.println("Height: "
                + p1.getHeightDm());

        System.out.println("Weight: "
                + p1.getWeightHg());

        System.out.println("Base Exp: "
                + p1.getBaseExperience());

        System.out.println();

        System.out.println("=== Name Setter Test ===");

        Pokemon test =
                new Pokemon(1,
                        "Bulbasaur",
                        7,
                        69,
                        64);

        test.setName("  IVYSAUR  ");

        System.out.println(
                "Normalized name: "
                        + test.getName());

        System.out.println();

        System.out.println(
                "=== Change Base Experience ===");

        p2.setBaseExperience(200);

        System.out.println(
                "p1.equals(p2): "
                        + p1.equals(p2));

        System.out.println();

        System.out.println("=== Null Test ===");
        System.out.println(p1.equals(null));

        System.out.println();

        System.out.println("=== Different Type Test ===");
        System.out.println(
                p1.equals("pikachu"));

        System.out.println();

        System.out.println(
                "=== Invalid Setter Input ===");
        
        try {
            test.setHeightDm(-1);
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        try {
            test.setWeightHg(-1);
        }
        catch (IllegalArgumentException e) {
            System.out.println(
                    e.getMessage());
        }

        try {
            test.setBaseExperience(-1);
        }
        catch (IllegalArgumentException e) {
            System.out.println(
                    e.getMessage());
        }

        try {
            test.setName(null);
        }
        catch (IllegalArgumentException e) {
            System.out.println(
                    e.getMessage());
        }
    }
}