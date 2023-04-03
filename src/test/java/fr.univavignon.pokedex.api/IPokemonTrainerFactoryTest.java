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
        pokedexFactory = new PokedexFactory();
        pokemonTrainerFactory = new PokemonTrainerFactory();
        pokedex = new Pokedex();
    }

    @Test
    public void testCreateTrainer(){
        Assert.assertEquals("test", pokemonTrainerFactory.createTrainer("test", Team.MYSTIC, pokedexFactory).getName());
        Assert.assertEquals(Team.MYSTIC, pokemonTrainerFactory.createTrainer("test", Team.MYSTIC, pokedexFactory).getTeam());
        Assert.assertEquals(0, pokemonTrainerFactory.createTrainer("test", Team.MYSTIC, pokedexFactory).getPokedex().size());
    }
}
