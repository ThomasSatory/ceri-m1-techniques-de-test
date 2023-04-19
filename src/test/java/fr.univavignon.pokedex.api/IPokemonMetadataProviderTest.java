package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

//est chargé pour un index donné de retourner les métadonnées d’une espèce.
public class IPokemonMetadataProviderTest {

    IPokemonMetadataProvider pokemonMetadataProvider;
    Pokemon aquali; //pokemon de test

    @Before
    public void init() {
        aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4,56);
        pokemonMetadataProvider = new PokemonMetadataProvider();
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        Assert.assertEquals(aquali.getIndex(), pokemonMetadataProvider.getPokemonMetadata(133).getIndex());
        Assert.assertEquals(aquali.getAttack(), pokemonMetadataProvider.getPokemonMetadata(133).getAttack());
        Assert.assertEquals(aquali.getDefense(), pokemonMetadataProvider.getPokemonMetadata(133).getDefense());
        Assert.assertEquals(aquali.getStamina(), pokemonMetadataProvider.getPokemonMetadata(133).getStamina());
        Assert.assertEquals(aquali.getName(), pokemonMetadataProvider.getPokemonMetadata(133).getName());
    }

    @Test
    public void testGetPokemonMetadataException() throws PokedexException {
        Assert.assertThrows(PokedexException.class, () -> {
            pokemonMetadataProvider.getPokemonMetadata(1000);
        });
    }
}
