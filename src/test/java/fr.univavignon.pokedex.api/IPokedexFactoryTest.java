package fr.univavignon.pokedex.api;


import fr.univavignon.pokedex.api.*;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

public class IPokedexFactoryTest {

    IPokedexFactory pokedexFactory;
    IPokedex pokedex;
    IPokemonFactory pokemonFactory;
    IPokemonMetadataProvider pokemonMetadataProvider;

    @Before
    public void init(){

        // mock all the interfaces
        pokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        pokedexFactory = Mockito.mock(IPokedexFactory.class);
        pokemonFactory = Mockito.mock(IPokemonFactory.class);
        pokedex = Mockito.mock(IPokedex.class);

        // mock the behavior of the methods
        when(pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory)).thenReturn(pokedex);
        when(pokedex.size()).thenReturn(0);
    }

    @Test
    public void PokedexFactoryTest(){
        pokedex = pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory);
        Assert.assertEquals(pokedex.size(), 0);
    }
}
