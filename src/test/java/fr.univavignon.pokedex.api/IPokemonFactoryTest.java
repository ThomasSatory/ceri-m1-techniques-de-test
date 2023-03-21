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
        pokemonFactory = Mockito.mock(IPokemonFactory.class);
        aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4,56);
        Mockito.when(pokemonFactory.createPokemon(133, 2729, 202, 5000, 4)).thenReturn(aquali);
    }

    @Test
    public void testCreatePokemon(){
        Assert.assertEquals(aquali.getIndex(), pokemonFactory.createPokemon(133, 2729, 202, 5000, 4).getIndex());
        Assert.assertEquals(aquali.getCp(), pokemonFactory.createPokemon(133, 2729, 202, 5000, 4).getCp());
        Assert.assertEquals(aquali.getHp(), pokemonFactory.createPokemon(133, 2729, 202, 5000, 4).getHp());
        Assert.assertEquals(aquali.getDust(), pokemonFactory.createPokemon(133, 2729, 202, 5000, 4).getDust());
        Assert.assertEquals(aquali.getCandy(), pokemonFactory.createPokemon(133, 2729, 202, 5000, 4).getCandy());
    }
}
