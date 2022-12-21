package ru.netology.manager;

import ru.netology.domain.NotRegisteredException;
import ru.netology.domain.Player;

import java.util.ArrayList;
import java.util.List;

public class Tournament {

    private List<Player> players = new ArrayList<>();

    public void register(Player player) {
        this.players.add(player);
    }

    public int round(String playerName1, String playerName2) {
        var first = findPlayer(playerName1);
        var second = findPlayer(playerName2);
        if (first == null || second == null) {
            throw new NotRegisteredException("Один из игроков не зарегистрирован");
        }
        var result = first.getStrength() - second.getStrength();
        if (result > 0) {
            return 1;
        } else if (result < 0) {
            return 2;
        }
        return 0;
    }

    private Player findPlayer(String name) {
        for (Player player : players) {
            if (player.getName().equalsIgnoreCase(name)) {
                return player;
            }
        }
        return null;
    }
}