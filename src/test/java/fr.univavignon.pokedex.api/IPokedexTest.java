package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Comparator;

public class IPokedexTest {
    IPokedex pokedex;
    Pokemon aquali;
    ArrayList<Pokemon> pokemons;
    Comparator<Pokemon> comparator;
    IPokemonMetadataProvider pokemonMetadataProvider;

    @Before
    public void init() throws PokedexException {
        pokedex = new Pokedex();
        aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4,56);
        pokemons = new ArrayList<Pokemon>();
        pokemonMetadataProvider = new PokemonMetadataProvider();
    }

    // Test all the methods of the IPokedex interface
    @Test
    public void testSize() {
        Assert.assertEquals(pokedex.size(), 0);
    }

    @Test
    public void testAddPokemon() throws PokedexException {
        pokedex.addPokemon(aquali);
        Assert.assertEquals(pokedex.size(), 1);
        Assert.assertEquals(pokedex.getPokemon(0), aquali);

    }

    @Test
    public void testGetPokemon() throws PokedexException {
        pokedex.addPokemon(aquali);
        Assert.assertEquals(pokedex.getPokemon(0), aquali);

        Assert.assertThrows(PokedexException.class, () -> {
            pokedex.getPokemon(-10);
        });
    }

    @Test
    public void testGetPokemons(){
        Assert.assertEquals(pokedex.getPokemons(), pokemons);
    }

    @Test
    public void testGetPokemonsOrder(){
        Assert.assertEquals(pokedex.getPokemons(comparator), pokemons);
    }

    @Test
    public void testCreatePokemon() throws PokedexException {
        Pokemon localaquali = pokedex.createPokemon(133, 2729, 202, 5000, 4);
        Assert.assertEquals(localaquali.getName(), aquali.getName());
        Assert.assertEquals(localaquali.getAttack(), aquali.getAttack());
        Assert.assertEquals(localaquali.getDefense(), aquali.getDefense());
        Assert.assertEquals(localaquali.getStamina(), aquali.getStamina());
        Assert.assertEquals(localaquali.getIndex(), aquali.getIndex());
        Assert.assertEquals(localaquali.getCp(), aquali.getCp());
        Assert.assertEquals(localaquali.getHp(), aquali.getHp());
        Assert.assertEquals(localaquali.getDust(), aquali.getDust());
        Assert.assertEquals(localaquali.getCandy(), aquali.getCandy());
        Assert.assertEquals(localaquali.getIv(), aquali.getIv());
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        Assert.assertEquals(pokedex.getPokemonMetadata(133).getName(),pokemonMetadataProvider.getPokemonMetadata(133).getName());
        Assert.assertEquals(pokedex.getPokemonMetadata(133).getAttack(),pokemonMetadataProvider.getPokemonMetadata(133).getAttack());
        Assert.assertEquals(pokedex.getPokemonMetadata(133).getDefense(),pokemonMetadataProvider.getPokemonMetadata(133).getDefense());
        Assert.assertEquals(pokedex.getPokemonMetadata(133).getStamina(),pokemonMetadataProvider.getPokemonMetadata(133).getStamina());
        Assert.assertEquals(pokedex.getPokemonMetadata(133).getIndex(),pokemonMetadataProvider.getPokemonMetadata(133).getIndex());
    }
}
