package kamil.rojek.ox;

import kamil.rojek.ox.CustomExceptions.BoardCreatorException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Kamil Rojek
 */
public class BoardCreatorTest {

    @DataProvider
    public static Object[][] dataBoardValidParameters(){
        return new Object[][] {
                {3,3}, {5,5}, {10,10}, {100,100}, {985,985},
                {3,12}, {23,4}, {5,200}, {232,323}, {121,11},
                {999,899}, {223,423}, {7,4}, {3,1231}, {23,3},
        };
    }

    @Test(dataProvider = "dataBoardValidParameters")
    public void creatingBoardWithValidParameters(int rowsNumber, int columnsNumber) throws BoardCreatorException {
        BoardCreator bc = new BoardCreator();
        Board board = bc.createNewBoard(rowsNumber,columnsNumber);
    }

    @DataProvider
    public static Object[][] dataBoardInvalidParameters(){
        return new Object[][] {
                {0,0}, {1,1}, {2,2}, {0,1}, {0,2},
                {1,0}, {2,0}, {-1,4}, {3,-3}, {-123,-11},
                {Integer.MIN_VALUE, 3}, {3,Integer.MIN_VALUE}, {-12,12}, {-3,1231}, {-233,0},
        };
    }

    @Test(dataProvider = "dataBoardInvalidParameters", expectedExceptions = BoardCreatorException.class)
    public void testInvalidParametersPassedToBoardCreator(int rowsNumber, int columnsNumber) throws BoardCreatorException {
        BoardCreator bc = new BoardCreator();
        Board board = bc.createNewBoard(rowsNumber,columnsNumber);
    }

    @Test(dataProvider = "dataBoardValidParameters")
    public void testIfBoardCreatedByBoardCreatorIsFilledWithNoneSeeds(int rowsNumber, int columnsNumber) throws BoardCreatorException {
        BoardCreator boardCreator = new BoardCreator();
        Board board = boardCreator.createNewBoard(rowsNumber, rowsNumber);

        for (int i = 0; i < board.fields.length; i++){
            for (int j = 0; j < board.fields[i].length; j++){
                Assert.assertTrue(board.fields[i][j].type.equals(SeedType.None));
            }
        }
    }
}
