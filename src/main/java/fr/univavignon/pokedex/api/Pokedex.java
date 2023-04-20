package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/**
 * Pokedex implementation .
 */
public class Pokedex implements IPokedex {

    /**
     * List of pokemon.
     */
    public List<Pokemon> pokedex;

    /**
     * Pokemon factory.
     */
    public IPokemonFactory ipokemonfactory = new PokemonFactory();

    /**
     * Pokemon metadata provider.
     */
    public IPokemonMetadataProvider ipokemonmetadataprovider = new PokemonMetadataProvider();


    /**
     * Default constructor.
     */
    public Pokedex() {
        pokedex = new ArrayList<>();
    }


    /**
     * Constructor with parameters.
     * @param metadataProvider
     * @param pokemonFactory
     */
    public Pokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        pokedex = new ArrayList<>();
        this.ipokemonfactory = pokemonFactory;
        this.ipokemonmetadataprovider = metadataProvider;
    }

    /**
     * Returns the number of pokemon this pokedex contains.
     *
     * @return Number of pokemon in this pokedex.
     */
    @Override
    public int size() {
        return pokedex.size();
    }

    /**
     * Adds the given <code>pokemon</code> to this pokedex and returns
     * it unique index.
     *
     * @param pokemon Pokemon to add to this pokedex.
     * @return Index of this pokemon relative to this pokedex.
     */
    @Override
    public int addPokemon(Pokemon pokemon) {
        pokedex.add(pokemon);
        return size()-1;
    }

    /**
     * Locates the pokemon identified by the given <code>id</code>.
     *
     * @param id Unique pokedex relative identifier.
     * @return Pokemon denoted by the given identifier.
     * @throws PokedexException If the given <code>index</code> is not valid.
     */
    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        for (Pokemon pokemon : pokedex) {
            if (pokemon.getIndex() == id) {
                return pokemon;
            }
        }
        throw new PokedexException("Pokemon not found");
    }

    /**
     * Returns an unmodifiable list of all pokemons this pokedex contains.
     *
     * @return Unmodifiable list of all pokemons.
     */
    @Override
    public List<Pokemon> getPokemons() {
        final List<Pokemon> unmodifiableList = new ArrayList<>(pokedex);
        return unmodifiableList;
    }

    /**
     * Returns an unmodifiable list of all pokemons this pokedex contains.
     * The list view will be sorted using the given <code>order</code>.
     *
     * @param order Comparator instance used for sorting the created view.
     * @return Sorted unmodifiable list of all pokemons.
     */
    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        final List<Pokemon> unmodifiableList = new ArrayList<>(pokedex);
        unmodifiableList.sort(order);
        return unmodifiableList;
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
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
        return ipokemonfactory.createPokemon(index, cp, hp, dust, candy);
    }

    /**
     * Retrieves and returns the metadata for the pokemon
     * denoted by the given <code>index</code>.
     *
     * @param index Index of the pokemon to retrieve metadata for.
     * @return Metadata of the pokemon.
     * @throws PokedexException If the given <code>index</code> is not valid.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return ipokemonmetadataprovider.getPokemonMetadata(index);
    }
}
