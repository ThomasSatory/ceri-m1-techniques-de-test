package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

//permet de créer un individu.
public class IPokemonFactoryTest {

    IPokemonFactory pokemonFactory;
    Pokemon aquali;


    @Before
    public void init(){
        pokemonFactory = new PokemonFactory();
        aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4,100);
    }

    @Test
    public void testCreatePokemon() throws PokedexException {
        Pokemon aqualibis = pokemonFactory.createPokemon(133,2729,202,5000,4);

        Assert.assertEquals(aquali.getIndex(),aqualibis.getIndex());
        Assert.assertEquals(aquali.getCp(),aqualibis.getCp());
        Assert.assertEquals(aquali.getHp(), aqualibis.getHp());
        Assert.assertEquals(aquali.getDust(), aqualibis.getDust());
        Assert.assertEquals(aquali.getCandy(),aqualibis.getCandy());
        Assert.assertEquals(aquali.getIv(), aqualibis.getIv(),0.01);
    }
}
