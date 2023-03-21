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

    @Before
    public void init() throws PokedexException {

        // mock all the interfaces
        pokedex = Mockito.mock(IPokedex.class);
        aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4,56);
        pokemons = new ArrayList<Pokemon>();

        // mock the behavior of the methodss
        Mockito.when(pokedex.size()).thenReturn(0);
        Mockito.when(pokedex.addPokemon(aquali)).thenReturn(0);
        Mockito.when(pokedex.getPokemon(0)).thenReturn(aquali);
        Mockito.when(pokedex.getPokemon(-1)).thenThrow(new PokedexException("Index out of bounds"));
        Mockito.when(pokedex.getPokemons()).thenReturn(pokemons);
    }

    // Test all the methods of the IPokedex interface

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
    }

    @Test
    public void testGetPokemons(){
        Assert.assertEquals(pokedex.getPokemons(), pokemons);
    }

    @Test
    public void testGetPokemonsOrder(){
        Assert.assertEquals(pokedex.getPokemons(comparator), pokemons);
    }
}
