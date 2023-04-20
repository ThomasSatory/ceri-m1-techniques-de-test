package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
        PokemonTrainer pokemonTrainer = pokemonTrainerFactory.createTrainer("Toam",Team.VALOR,new PokedexFactory());
        PokemonTrainer trainer = new PokemonTrainer("Toam",Team.VALOR,new PokedexFactory().createPokedex(new PokemonMetadataProvider(),new PokemonFactory()));
        Assert.assertEquals(trainer.getName(),pokemonTrainer.getName());
        Assert.assertEquals(trainer.getTeam(),pokemonTrainer.getTeam());
        Assert.assertEquals(trainer.getPokedex().getPokemons(),pokemonTrainer.getPokedex().getPokemons());
    }
}
