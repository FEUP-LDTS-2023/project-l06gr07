import org.crazytracks.gui.PositionAdapter;
import org.crazytracks.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PositionAdapterTest {
    @Test
    public void adaptPosition(){
        Position position = new Position(15, 5);
        Position expected = new Position(20, 7);

        PositionAdapter positionAdapter = new PositionAdapter(5, 2);
        Position guiPos = positionAdapter.adaptPosition(position);

        Assertions.assertEquals(guiPos.getX(), expected.getX());
        Assertions.assertEquals(guiPos.getY(), expected.getY());

    }
}
