package fr.univavignon.pokedex.api;

/**
 * Factory for creating PokemonTrainer instances.
 *
 * @author ts
 */
public class PokemonTrainerFactory implements IPokemonTrainerFactory {
    /**
     * Creates and returns a PokemonTrainer instance.
     *
     * @param name           Name of the created trainer.
     * @param team           Team of the created trainer.
     * @param pokedexFactory Factory to use for creating associated pokedex instance.
     * @return Created trainer instance.
     */
    @Override
    public PokemonTrainer createTrainer(final String name,final Team team,final IPokedexFactory pokedexFactory) {
        IPokedex pokedex = pokedexFactory.createPokedex(null, new PokemonFactory());
        return new PokemonTrainer(name, team, pokedex);
    }
}
