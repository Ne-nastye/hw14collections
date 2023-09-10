import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void test1PlayerWin() {
        Player ilya = new Player(1, "Илья", 200);
        Player roma = new Player(2, "Рома", 100);

        Game game = new Game();
        game.register(ilya);
        game.register(roma);
        int actual = game.round("Илья", "Рома");
        int expected = 1;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void test2PlayerWin() {
        Player ilya = new Player(1, "Илья", 200);
        Player roma = new Player(2, "Рома", 300);

        Game game = new Game();
        game.register(ilya);
        game.register(roma);
        int actual = game.round("Илья", "Рома");
        int expected = 2;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testPlayerDraw() {
        Player ilya = new Player(1, "Илья", 200);
        Player roma = new Player(2, "Рома", 200);

        Game game = new Game();
        game.register(ilya);
        game.register(roma);
        int actual = game.round("Илья", "Рома");
        int expected = 0;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testPlayerNotExist() {
        Player ilya = new Player(1, "Илья", 200);
        Player roma = new Player(2, "Рома", 200);

        Game game = new Game();
        game.register(ilya);
        game.register(roma);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Настя", "Илья")
                );

    }

    @Test
    public void testPlayerNotExist2() {
        Player ilya = new Player(1, "Илья", 200);
        Player roma = new Player(2, "Рома", 200);

        Game game = new Game();
        game.register(ilya);
        game.register(roma);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Илья", "Настя")
        );

    }
}
