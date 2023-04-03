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
        aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4,56);
    }

    @Test
    public void testCreatePokemon() throws PokedexException {
        Assert.assertEquals(aquali.getName(), pokemonFactory.createPokemon(133, 2729, 202, 5000, 4).getName());
        Assert.assertEquals(aquali.getAttack(), pokemonFactory.createPokemon(133, 2729, 202, 5000, 4).getAttack());
        Assert.assertEquals(aquali.getDefense(), pokemonFactory.createPokemon(133, 2729, 202, 5000, 4).getDefense());
        Assert.assertEquals(aquali.getStamina(), pokemonFactory.createPokemon(133, 2729, 202, 5000, 4).getStamina());
        Assert.assertEquals(aquali.getIndex(), pokemonFactory.createPokemon(133, 2729, 202, 5000, 4).getIndex());
        Assert.assertEquals(aquali.getCp(), pokemonFactory.createPokemon(133, 2729, 202, 5000, 4).getCp());
        Assert.assertEquals(aquali.getHp(), pokemonFactory.createPokemon(133, 2729, 202, 5000, 4).getHp());
        Assert.assertEquals(aquali.getDust(), pokemonFactory.createPokemon(133, 2729, 202, 5000, 4).getDust());
        Assert.assertEquals(aquali.getCandy(), pokemonFactory.createPokemon(133, 2729, 202, 5000, 4).getCandy());
        Assert.assertEquals(aquali.getIv(), pokemonFactory.createPokemon(133, 2729, 202, 5000, 4).getIv());
    }
}
