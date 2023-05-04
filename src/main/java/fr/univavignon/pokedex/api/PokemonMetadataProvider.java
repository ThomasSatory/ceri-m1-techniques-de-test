package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;


/**
 * Pokemon metadata provider implementation.
 * @author ts
 */
public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    /**
     * List of pokemon metadata.
     */
    private List<PokemonMetadata> pokemonMetadatas;
    /**
     * Getter for the list of pokemon metadata.
     * @return pokemonMetadatas
     */
    public List<PokemonMetadata> getPokemonMetadatas() {
        return pokemonMetadatas;
    }

    /**
     * Setter for the list of pokemon metadata.
     * @param pokemonMetadatas
     */
    public void setPokemonMetadatas(List<PokemonMetadata> pokemonMetadatas) {
        this.pokemonMetadatas = pokemonMetadatas;
    }

    /**
     * Default constructor where we create 2 pokemons.
     */
    public PokemonMetadataProvider() {
        this.pokemonMetadatas = new ArrayList<>();
        pokemonMetadatas.add(new PokemonMetadata(0,
                "Bulbizarre",
                126,
                126,
                90));
        pokemonMetadatas.add(new PokemonMetadata(133,
                "Aquali",
                186,
                168,
                260));
    }


    /**
     * Retrieves and returns the metadata for the pokemon
     * denoted by the given <code>index</code>.
     *
     * @param index Index of the pokemon to retrieve metadata for.
     * @return Metadata of the pokemon.
     * @throws PokedexException If the given
     * <code>index</code> is not valid.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(final int index) throws PokedexException {
        for (PokemonMetadata metadata : pokemonMetadatas) {
            if (metadata.getIndex() == index) {
                return metadata;
            }
        }
        throw new PokedexException("L'index du pokémon n'existe pas");
    }
}
