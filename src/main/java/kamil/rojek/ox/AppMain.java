package kamil.rojek.ox;

public class AppMain {
    public static void main(String[] args) {
        Players players = new Players();
        Game game = new Game(players);

        game.startGame();
    }
}
