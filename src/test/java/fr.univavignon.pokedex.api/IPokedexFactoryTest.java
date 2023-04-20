package fr.univavignon.pokedex.api;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

public class IPokedexFactoryTest {

    IPokedexFactory pokedexFactory;
    IPokedex pokedex;
    IPokemonFactory pokemonFactory;
    IPokemonMetadataProvider pokemonMetadataProvider;

    @Before
    public void init(){
        pokemonMetadataProvider = new PokemonMetadataProvider();
        pokedexFactory = new PokedexFactory();
        pokemonFactory = new PokemonFactory();
        pokedex = new Pokedex();
    }

    @Test
    public void PokedexFactoryTest(){
        pokedex = pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory);
        Assert.assertEquals(pokedex.size(), 0);
    }
}
