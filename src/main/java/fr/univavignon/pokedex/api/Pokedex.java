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
    private List<Pokemon> pokedex;

    /**
     * Pokemon factory.
     */
    private IPokemonFactory ipokemonfactory = new PokemonFactory();

    /**
     * Pokemon metadata provider.
     */
    private IPokemonMetadataProvider provider = new PokemonMetadataProvider();


    /**
     * Default constructor.
     */
    public Pokedex() {
        pokedex = new ArrayList<>();
    }


    /**
     * Getter for the pokedex.
     * @return pokedex
     */
    public List<Pokemon> getPokedex() {
        return pokedex;
    }

    /**
     * Setter for the pokedex.
     * @param pokedex
     */
    public void setPokedex(List<Pokemon> pokedex) {
        this.pokedex = pokedex;
    }

    /**
     * Getter for the pokemon factory.
     * @return ipokemonfactory
     */
    public IPokemonFactory getIpokemonfactory() {
        return ipokemonfactory;
    }

    /**
     * Setter for the pokemon factory.
     * @param ipokemonfactory
     */
    public void setIpokemonfactory(IPokemonFactory ipokemonfactory) {
        this.ipokemonfactory = ipokemonfactory;
    }


    /**
     * Getter for the pokemon metadata provider.
     * @return provider
     */
    public IPokemonMetadataProvider getProvider() {
        return provider;
    }

    /**
     * Setter for the pokemon metadata provider.
     * @param provider
     */
    public void setProvider(IPokemonMetadataProvider provider) {
        this.provider = provider;
    }

    /**
     * Constructor with parameters.
     * @param metadataProvider
     * @param pokemonFactory
     */
    public Pokedex(final IPokemonMetadataProvider metadataProvider,final IPokemonFactory pokemonFactory) {
        pokedex = new ArrayList<>();
        this.ipokemonfactory = pokemonFactory;
        this.provider = metadataProvider;
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
    public int addPokemon(final Pokemon pokemon) {
        pokedex.add(pokemon);
        return size() - 1;
    }

    /**
     * Locates the pokemon identified by the given <code>id</code>.
     *
     * @param id Unique pokedex relative identifier.
     * @return Pokemon denoted by the given identifier.
     * @throws PokedexException If the given <code>index</code> is not valid.
     */
    @Override
    public Pokemon getPokemon(final int id) throws PokedexException {
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
    public List<Pokemon> getPokemons(final Comparator<Pokemon> order) {
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
    public Pokemon createPokemon(final int index,final int cp,final int hp,final int dust,final int candy) throws PokedexException {
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
    public PokemonMetadata getPokemonMetadata(final int index) throws PokedexException {
        return provider.getPokemonMetadata(index);
    }
}
