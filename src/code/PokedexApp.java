//Abraham Gonzalez 11/11/2026
package code;
import java.io.IOException;
import java.util.Scanner;

public class PokedexApp {
	
	public static ChainingHashTable<String, Pokemon> pokedex = new ChainingHashTable<>(11);
	
    public static void main(String[] args) {
    	
        
        String filename = args.length == 0 ? "pokemon.csv" : args[0];
        try {
            int loaded = PokemonLoader.load(filename, pokedex);
            System.out.println("Loaded " + loaded + " Pokemon records.");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Could not load CSV: " + e.getMessage());
            System.out.println("Put pokemon.csv in the project root (working directory).");
            return;
        }

        Scanner input = new Scanner(System.in);
        boolean running = true;
        while (running && input.hasNextLine()) {
            System.out.println("\n1. Search\n2. Add/update\n3. Remove\n4. Show buckets\n0. Exit");
            System.out.print("Choice: ");
            String choice = input.nextLine().trim();
            switch (choice) {
                case "1": searchPokemon(input); break;
                case "2": addOrUpdatePokemon(input); break;
                case "3": removePokemon(input); break;
                case "4": pokedex.printTable(); break;
                case "0": running = false; break;
                default: System.out.println("Choose 0 through 4.");
            }
        }
    }

    private static void searchPokemon(Scanner input) {
        System.out.println("Pokemon name: ");

        String name = PokemonLoader.normalizeName(input.nextLine());

        Pokemon pokemon = pokedex.get(name);

        if (pokemon == null){
            System.out.println("Pokemon not found.");
        } else {
            System.out.println(pokemon);
        }
    }

    private static void addOrUpdatePokemon(Scanner input) {

        System.out.println("Pokemon name: ");

        String name =
            PokemonLoader.normalizeName(
                    input.nextLine());

        if (name.isEmpty()) {
            System.out.println(
                    "Name cannot be blank.");
            return;
        }

        boolean exists =
                pokedex.get(name) != null;

        int id =
                readNonNegativeInt(
                        input,
                        "ID: ");

        int heightDm =
                readNonNegativeInt(
                        input,
                        "Height (dm): ");

        int weightHg =
                readNonNegativeInt(
                        input,
                        "Weight (hg): ");

        int baseExperience =
                readNonNegativeInt(
                        input,
                        "Base experience: ");

        Pokemon pokemon =
                new Pokemon(
                        id,
                        name,
                        heightDm,
                        weightHg,
                        baseExperience);

        pokedex.insert(name, pokemon);

        if (exists){
            System.out.println("Pokemon updated.");
        } else {
            System.out.println("Pokemon added.");
        }

    }

    private static void removePokemon(Scanner input) {
        
        System.out.println("Pokemon name: ");

        String name = PokemonLoader.normalizeName(input.nextLine());

        boolean removed = pokedex.remove(name);

        if(removed){
            System.out.println("Pokemon removed.");
        } else {
            System.out.println("Pokemon not found.");
        }
    }

    // Provided: reads a non-negative integer using nextLine(), avoiding leftover newlines.
    private static int readNonNegativeInt(Scanner input, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(input.nextLine().trim());
                if (value >= 0) { return value; }
            } catch (NumberFormatException e) {
                // Explain the error and ask again.
            }
            System.out.println("Enter a whole number of zero or more.");
        }
    }
}
