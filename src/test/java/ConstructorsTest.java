import org.crazytracks.model.Coin;
import org.crazytracks.model.Position;
import org.crazytracks.model.PowerUp;
import org.crazytracks.model.Wagon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConstructorsTest {

    @Test
    public void testCoinConstructor() {
        Coin coin = new Coin(new Position(0, 0));
        Assertions.assertEquals(0, coin.getPosition().getX());
        Assertions.assertEquals(0, coin.getPosition().getY());
    }

    @Test
    public void testPowerUpConstructor() {
        PowerUp powerUp = new PowerUp(new Position(0, 0));
        Assertions.assertEquals(0, powerUp.getPosition().getX());
        Assertions.assertEquals(0, powerUp.getPosition().getY());
    }

    @Test
    public void testWagonConstructor() {
        Wagon wagon = new Wagon(new Position(0, 0));
        Assertions.assertEquals(0, wagon.getPosition().getX());
        Assertions.assertEquals(0, wagon.getPosition().getY());
    }
}
