package kamil.rojek.ox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Kamil Rojek
 */
public class BoardCreatorTest {
    
    @Test
    public void testCreatingNewBoard(){
        BoardCreator boardCreator = new BoardCreator();
        Board board = boardCreator.createNewBoard(5, 5);
        Assert.assertEquals(board, new Board(5,5));
    }
}
