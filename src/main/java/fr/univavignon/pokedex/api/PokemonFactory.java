package fr.univavignon.pokedex.api;


/**
 * Pokemon factory interface implementation.
 *
 * @author ts
 */
public class PokemonFactory implements IPokemonFactory {


    /**
     * Pokemon metadata provider.
     */
    private IPokemonMetadataProvider pokemonMetadataProvider;


    /**
     * Getter for the pokemon metadata provider.
     * @return pokemonMetadataProvider
     */
    public IPokemonMetadataProvider getPokemonMetadataProvider() {
        return pokemonMetadataProvider;
    }

    /**
     * Setter for the pokemon metadata provider.
     * @param pokemonMetadataProvider
     */
    public void setPokemonMetadataProvider(IPokemonMetadataProvider pokemonMetadataProvider) {
        this.pokemonMetadataProvider = pokemonMetadataProvider;
    }

    /**
     * Default constructor.
     */
    public PokemonFactory() {
        pokemonMetadataProvider = new PokemonMetadataProvider();
    }


    /**
     * Creates a pokemon instance computing it IVs.
     *
     * @param index Pokemon index.
     * @param cp    Pokemon CP.
     * @param hp    Pokemon HP.
     * @param dust  Required dust for upgrading pokemon.
     * @param candy Required candy for upgrading pokemon.
     * @return Created pokemon instance.
     */
    @Override
    public Pokemon createPokemon(final int index,
                                 final int cp,
                                 final int hp,
                                 final int dust,
                                 final int candy)
            throws PokedexException {
        PokemonMetadata pokemonMetadata = pokemonMetadataProvider.getPokemonMetadata(index);
        return new Pokemon(index, pokemonMetadata.getName(), pokemonMetadata.getAttack(), pokemonMetadata.getDefense(), pokemonMetadata.getDefense(), cp, hp, dust, candy, 100);
    }
}
