package ru.netology.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.NotRegisteredException;
import ru.netology.domain.Player;
import ru.netology.manager.Tournament;

import static org.junit.jupiter.api.Assertions.*;

class TournamentTest {

    private Tournament game = new Tournament();
    private Player first = new Player(1, "First", 1);
    private Player second = new Player(2, "Second", 20);
    private Player third = new Player(3, "Third", 30);
    private Player forth = new Player(4, "Forth", 30);
    private Player fifth = new Player(5, "Fifth", 80);
    private Player sixth = new Player(6, "Sixth", 100);

    @BeforeEach
    void setUp() {
        game.register(first);
        game.register(second);
        game.register(third);
        game.register(forth);
    }

    @Test
    void shouldFirstPlayerWin() {
        int actual = game.round(forth.getName(), second.getName());

        assertEquals(1, actual);
    }

    @Test
    void shouldSecondPlayerWIn() {
        int actual = game.round(first.getName(), "SECOND");

        assertEquals(2, actual);
    }

    @Test
    void shouldDraw() {
        int actual = game.round(forth.getName(), third.getName());

        assertEquals(0, actual);
    }

    @Test
    void shouldThrowExceptionOnePlayerUnregistered() {
        assertThrows(NotRegisteredException.class,
                () -> game.round(third.getName(), fifth.getName()));
    }

    @Test
    void shouldThrowExceptionTwoPlayersUnregistered() {
        assertThrows(NotRegisteredException.class,
                () -> game.round(fifth.getName(), sixth.getName()));
    }
}