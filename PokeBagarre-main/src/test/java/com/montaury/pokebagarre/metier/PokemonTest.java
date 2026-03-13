/**
 * Explication du fichier :
 *      Fais les test nécessaires sur la fonction estVainqueuerContre() de la classe Pokemon.java
 *
 *  Liste des Tests :
 *  -Si ATK1 > ATK2 alors atk1 gagne
 *  -SI ATK2 > ATK1 alors atk2 gagne
 *  -Si ATK1 = ATK2 et DEF1 > DEF2 alors def1 < gagne
 *  -Si ATK1 = ATK2 et DEF2 > DEF1 alors def1 < gagne
 *  -Si ATK1 = ATK2 et DEF1 = DEF2 alors 1er gagne
 */

package com.montaury.pokebagarre.metier;

import com.montaury.pokebagarre.fixtures.ConstructeurDePokemon;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PokemonTest {
    @Test
    void verifier_si_pokemon_avec_le_plus_d_attaque_gagne(){

        // GIVEN
        Pokemon pokemonLePlusFort = ConstructeurDePokemon.unPokemon().avecAttaque(150).construire();
        Pokemon pokemonLeMoinsFort = ConstructeurDePokemon.unPokemon().avecAttaque(10).construire();
        // WHEN
        boolean result = pokemonLePlusFort.estVainqueurContre(pokemonLeMoinsFort);

        //THEN
        assertThat(result).isTrue();
    }

    @Test
    void verifier_si_pokemon_avec_le_moins_d_attaque_perd(){

        // GIVEN
        Pokemon pokemonLePlusFort = ConstructeurDePokemon.unPokemon().avecAttaque(150).construire();
        Pokemon pokemonLeMoinsFort = ConstructeurDePokemon.unPokemon().avecAttaque(10).construire();

        // WHEN
        boolean result = pokemonLeMoinsFort.estVainqueurContre(pokemonLePlusFort);

        // THEN
        assertThat(result).isFalse();

    }

    @Test
    void verifier_si_les_deux_attaques_sont_egales_si_le_pokemon_avec_le_plus_de_defense_gagne() {

        // GIVEN
        Pokemon pokemonLePlusFort = ConstructeurDePokemon.unPokemon().avecAttaque(150).avecDefense(200).construire();
        Pokemon pokemonLeMoinsFort = ConstructeurDePokemon.unPokemon().avecAttaque(150).avecDefense(10).construire();

        // WHEN
        boolean result = pokemonLePlusFort.estVainqueurContre(pokemonLeMoinsFort);

        // THEN
        assertThat(result).isTrue();    }

    @Test
    void verifier_si_les_deux_attaques_sont_egales_si_le_pokemon_avec_le_moins_de_defense_perd() {

        // GIVEN
        Pokemon pokemonLePlusFort = ConstructeurDePokemon.unPokemon().avecAttaque(150).avecDefense(200).construire();
        Pokemon pokemonLeMoinsFort = ConstructeurDePokemon.unPokemon().avecAttaque(150).avecDefense(10).construire();
        // WHEN
        boolean result = pokemonLeMoinsFort.estVainqueurContre(pokemonLePlusFort);

        // THEN
        assertThat(result).isFalse();
    }

    @Test
    void verifier_si_les_deux_attaques_et_les_deux_defenses_sont_egales_alors_le_premier_pokemon_gagne() {

        // GIVEN
        Pokemon premierPokemon = ConstructeurDePokemon.unPokemon().avecAttaque(150).avecDefense(200).construire();
        Pokemon deuxiemePokemon = ConstructeurDePokemon.unPokemon().avecAttaque(150).avecDefense(200).construire();

        // WHEN
        boolean result = premierPokemon.estVainqueurContre(deuxiemePokemon);

        // THEN
        assertThat(result).isTrue();
    }
}