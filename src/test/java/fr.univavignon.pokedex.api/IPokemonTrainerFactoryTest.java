package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonTrainerFactoryTest {
    IPokemonTrainerFactory pokemonTrainerFactory;
    IPokedexFactory pokedexFactory;
    IPokedex pokedex;

    @Before
    public void init(){
        pokedexFactory = Mockito.mock(IPokedexFactory.class);
        pokemonTrainerFactory = Mockito.mock(IPokemonTrainerFactory.class);

        Mockito.when(pokemonTrainerFactory.createTrainer("test", Team.MYSTIC, pokedexFactory)).thenReturn(new PokemonTrainer("test", Team.MYSTIC, pokedex));
    }

    @Test
    public void testCreateTrainer(){
        Assert.assertEquals("test", pokemonTrainerFactory.createTrainer("test", Team.MYSTIC, pokedexFactory).getName());
        Assert.assertEquals(Team.MYSTIC, pokemonTrainerFactory.createTrainer("test", Team.MYSTIC, pokedexFactory).getTeam());
    }
}
