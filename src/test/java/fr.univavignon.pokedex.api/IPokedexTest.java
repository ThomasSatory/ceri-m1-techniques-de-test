package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;

public class IPokedexTest {
    IPokedex ipokedex;
    Pokemon aquali;
    ArrayList<Pokemon> pokemons;
    Comparator<Pokemon> comparator;
    IPokemonMetadataProvider pokemonMetadataProvider;

    @Before
    public void init() throws PokedexException {
        ipokedex = new Pokedex();
        aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4,56);
        pokemons = new ArrayList<Pokemon>();
        pokemonMetadataProvider = new PokemonMetadataProvider();
    }

    // Test all the methods of the IPokedex interface
    @Test
    public void testSize() {
        Assert.assertEquals(ipokedex.size(), 0);
    }

    @Test
    public void testAddPokemon() throws PokedexException {
        ipokedex.addPokemon(aquali);
        Assert.assertEquals(ipokedex.size(), 1);
        Assert.assertEquals(ipokedex.getPokemon(0), aquali);

    }

    @Test
    public void testGetPokemon() throws PokedexException {
        ipokedex.addPokemon(aquali);
        Assert.assertEquals(ipokedex.getPokemon(0), aquali);

        Assert.assertThrows(PokedexException.class, () -> {
            ipokedex.getPokemon(-10);
        });
    }

    @Test
    public void testGetPokemons(){
        Assert.assertEquals(ipokedex.getPokemons(), pokemons);
    }

    @Test
    public void testGetPokemonsOrder(){
        Assert.assertEquals(ipokedex.getPokemons(comparator), pokemons);
    }

    @Test
    public void testCreatePokemon() throws PokedexException {
        Pokemon localaquali = ipokedex.createPokemon(133, 2729, 202, 5000, 4);
        Assert.assertEquals(localaquali.getIndex(), aquali.getIndex());
        Assert.assertEquals(localaquali.getCp(), aquali.getCp());
        Assert.assertEquals(localaquali.getHp(), aquali.getHp());
        Assert.assertEquals(localaquali.getDust(), aquali.getDust());
        Assert.assertEquals(localaquali.getCandy(), aquali.getCandy());
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        Assert.assertEquals(ipokedex.getPokemonMetadata(133).getName(),pokemonMetadataProvider.getPokemonMetadata(133).getName());
        Assert.assertEquals(ipokedex.getPokemonMetadata(133).getAttack(),pokemonMetadataProvider.getPokemonMetadata(133).getAttack());
        Assert.assertEquals(ipokedex.getPokemonMetadata(133).getDefense(),pokemonMetadataProvider.getPokemonMetadata(133).getDefense());
        Assert.assertEquals(ipokedex.getPokemonMetadata(133).getStamina(),pokemonMetadataProvider.getPokemonMetadata(133).getStamina());
        Assert.assertEquals(ipokedex.getPokemonMetadata(133).getIndex(),pokemonMetadataProvider.getPokemonMetadata(133).getIndex());
    }
}
