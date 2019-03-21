package kamil.rojek.ox.game;

import kamil.rojek.ox.customExceptions.BoardCreatorException;
import kamil.rojek.ox.customExceptions.PlayerSeedTypeException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameValidatorTest {

    @Test
    public void testGameValidatorCreation() throws BoardCreatorException {
        //Arrange
        Board board = new BoardCreator().createNewBoard(3,3);
        GameValidator gameValidator = new GameValidator(board);

        //Assert
        Assert.assertNotNull(gameValidator);
    }

    @DataProvider
    public static Object[][] dataFeeldsValidationReturnTrue(){
        return new Object[][]{
                {0,0},{0,1},{0,2},
                {1,0},{2,0},{1,1},
                {2,1},{2,2},{1,2}
        };
    }

    @Test(dataProvider = "dataFeeldsValidationReturnTrue")
    public void testValidateIfSeedIsFreeToTake(int rowNumber, int columnNumber) throws BoardCreatorException {
        //Arrange
        Board board = new BoardCreator().createNewBoard(3,3);
        GameValidator gameValidator = new GameValidator(board);

        //Act & Assert
        Assert.assertTrue(gameValidator.validateSeed(rowNumber, columnNumber));
    }

    @DataProvider
    public static Object[][] testFeeldsValidationReturnFalse(){
        return new Object[][]{
                {0,0, SeedType.Nought},{0,1, SeedType.Cross},{0,2, SeedType.Cross},
                {1,0, SeedType.Nought},{2,0, SeedType.Nought},{1,1, SeedType.Cross},
                {2,1, SeedType.Cross},{2,2, SeedType.Cross},{1,2, SeedType.Nought}
        };
    }

    @Test(dataProvider = "testFeeldsValidationReturnFalse")
    public void testValidateIfSeedIsNotAvaibleToTakeByPlayer(int rowNumber, int columnNumber, SeedType type) throws BoardCreatorException {
        //Arrange
        Board board = new BoardCreator().createNewBoard(3,3);
        board.fields[rowNumber][columnNumber].type = type;
        GameValidator gameValidator = new GameValidator(board);

        //Act & Assert
        Assert.assertFalse(gameValidator.validateSeed(rowNumber, columnNumber));
    }

    @Test
    public void testValidationIfPlayerWonRoundHorizontalyRight() throws BoardCreatorException, PlayerSeedTypeException {
        //Arrange
        Board board = new BoardCreator().createNewBoard(3,3);

        board.fields[0][0].type = SeedType.Cross;
        board.fields[0][1].type = SeedType.Cross;
        board.fields[0][2].type = SeedType.Cross;

        GameValidator gameValidator = new GameValidator(board);

        //Act && Assert
        Assert.assertTrue(gameValidator.validateWin(0, 0));
    }

    @Test
    public void testValidationIfPlayerWonRoundHorizontalyLeft() throws BoardCreatorException, PlayerSeedTypeException {
        //Arrange
        Board board = new BoardCreator().createNewBoard(3,3);
        board.fields[0][0].type = SeedType.Cross;
        board.fields[0][1].type = SeedType.Cross;
        board.fields[0][2].type = SeedType.Cross;

        //Act && Assert
        GameValidator gameValidator = new GameValidator(board);
        Assert.assertTrue(gameValidator.validateWin(0, 2));
    }

    @Test
    public void testValidationIfPlayerWonRoundHorizontaly() throws BoardCreatorException, PlayerSeedTypeException {
        //Arrange
        Board board = new BoardCreator().createNewBoard(3,3);
        board.fields[0][0].type = SeedType.Cross;
        board.fields[0][1].type = SeedType.Cross;
        board.fields[0][2].type = SeedType.Cross;

        GameValidator gameValidator = new GameValidator(board);

        //Act && Assert
        Assert.assertTrue(gameValidator.validateWin(0, 1));
    }

    @Test
    public void testValidationIfPlayerWonRoundVerticlyDown() throws BoardCreatorException, PlayerSeedTypeException {
        //Arrange
        Board board = new BoardCreator().createNewBoard(3,3);
        board.fields[0][0].type = SeedType.Cross;
        board.fields[1][0].type = SeedType.Cross;
        board.fields[2][0].type = SeedType.Cross;

        GameValidator gameValidator = new GameValidator(board);

        //Act && Assert
        Assert.assertTrue(gameValidator.validateWin(0, 0));
    }

    @Test
    public void testValidationIfPlayerWonRoundVerticlyUp() throws BoardCreatorException, PlayerSeedTypeException {
        //Arrange
        Board board = new BoardCreator().createNewBoard(3,3);
        board.fields[0][0].type = SeedType.Cross;
        board.fields[1][0].type = SeedType.Cross;
        board.fields[2][0].type = SeedType.Cross;

        GameValidator gameValidator = new GameValidator(board);

        //Act && Assert
        Assert.assertTrue(gameValidator.validateWin(2, 0));
    }

    @Test
    public void testValidationIfPlayerWonRoundDiagonallyLeftDown() throws BoardCreatorException, PlayerSeedTypeException {
        //Arrange
        Board board = new BoardCreator().createNewBoard(3,3);
        board.fields[0][0].type = SeedType.Cross;
        board.fields[1][1].type = SeedType.Cross;
        board.fields[2][2].type = SeedType.Cross;

        GameValidator gameValidator = new GameValidator(board);

        //Act && Assert
        Assert.assertTrue(gameValidator.validateWin(0, 0));
    }

    @Test
    public void testValidationIfPlayerWonRoundDiagonallyLeftUp() throws BoardCreatorException, PlayerSeedTypeException {
        //Arrange
        Board board = new BoardCreator().createNewBoard(3,3);
        board.fields[0][0].type = SeedType.Cross;
        board.fields[1][1].type = SeedType.Cross;
        board.fields[2][2].type = SeedType.Cross;

        GameValidator gameValidator = new GameValidator(board);

        //Act && Assert
        Assert.assertTrue(gameValidator.validateWin(2, 2));
    }

    @Test
    public void testValidationIfPlayerWonRoundDiagonallyRightDown() throws BoardCreatorException, PlayerSeedTypeException {
        //Arrange
        Board board = new BoardCreator().createNewBoard(3,3);
        board.fields[0][2].type = SeedType.Cross;
        board.fields[1][1].type = SeedType.Cross;
        board.fields[2][0].type = SeedType.Cross;

        GameValidator gameValidator = new GameValidator(board);

        //Act && Assert
        Assert.assertTrue(gameValidator.validateWin(1, 1));
    }

    @Test
    public void testValidationIfPlayerWonRoundDiagonallyRightUp() throws BoardCreatorException, PlayerSeedTypeException {
        //Arrange
        Board board = new BoardCreator().createNewBoard(3,3);
        board.fields[2][0].type = SeedType.Cross;
        board.fields[1][1].type = SeedType.Cross;
        board.fields[0][2].type = SeedType.Cross;

        GameValidator gameValidator = new GameValidator(board);

        //Act && Assert
        Assert.assertTrue(gameValidator.validateWin(1, 1));
    }

    @Test
    public void test() throws BoardCreatorException, PlayerSeedTypeException {
        //Arrange
        Board board = new BoardCreator().createNewBoard(3,3);
        board.fields[0][0].type = SeedType.Cross;
        board.fields[1][0].type = SeedType.Nought;
        board.fields[1][1].type = SeedType.Cross;

        GameValidator gameValidator = new GameValidator(board);

        //Act && Assert
        Assert.assertFalse(gameValidator.validateWin(0, 0));
    }

    @DataProvider
    public static Object[][] dataFillBoardWithSeedsWithWinCombination() throws BoardCreatorException {
        return new Object[][]{
                {createBoardWithPresetOfFields(3,3,
                                new ArrayList<>(Arrays.asList(
                                new Mark(2,2, SeedType.Cross),
                                new Mark(1,1, SeedType.Cross),
                                new Mark(0,0, SeedType.Cross)))),
                                2, 2, true},

                {createBoardWithPresetOfFields(5,5,
                                new ArrayList<>(Arrays.asList(
                                new Mark(1,1, SeedType.Nought),
                                new Mark(2,2, SeedType.Nought),
                                new Mark(3,3, SeedType.Nought)))),
                                2, 2, true},

                {createBoardWithPresetOfFields(5,5,
                        new ArrayList<>(Arrays.asList(
                                new Mark(0,3, SeedType.Nought),
                                new Mark(1,2, SeedType.Nought),
                                new Mark(2,1, SeedType.Nought)))),
                        2, 1, true},

                {createBoardWithPresetOfFields(10,10,
                                new ArrayList<>(Arrays.asList(
                                new Mark(1,1, SeedType.Cross),
                                new Mark(2,2, SeedType.Nought),
                                new Mark(3,3, SeedType.Cross),
                                new Mark(2,3, SeedType.Cross),
                                new Mark(1,3, SeedType.Nought),
                                new Mark(2,4, SeedType.Cross),
                                new Mark(4,3, SeedType.Nought),
                                new Mark(4,2, SeedType.Cross),
                                new Mark(2,1, SeedType.Cross),
                                new Mark(7,2, SeedType.Nought),
                                new Mark(3,1, SeedType.Cross),
                                new Mark(6,4, SeedType.Nought)))),
                                3, 1, true}
        };
    }

    @Test(dataProvider = "dataFillBoardWithSeedsWithWinCombination")
    public void testValidationIfPlayerWon(Board board, int rowNumber, int columnNumber, boolean result){
        //Arrange
        GameValidator gameValidator = new GameValidator(board);

        //Act && Assert
        Assert.assertEquals(gameValidator.validateWin(rowNumber, columnNumber), result);
    }


    @DataProvider
    public static Object[][] dataFillBoardWithSeedsWithDrawCombination() throws BoardCreatorException {
        return new Object[][]{
                {createBoardWithPresetOfFields(3, 3,
                        new ArrayList<>(Arrays.asList(
                                new Mark(0, 0, SeedType.Cross),
                                new Mark(1, 0, SeedType.Nought),
                                new Mark(2, 0, SeedType.Cross),
                                new Mark(0, 1, SeedType.Nought),
                                new Mark(1, 1, SeedType.Cross),
                                new Mark(2, 1, SeedType.Nought),
                                new Mark(0, 2, SeedType.Cross),
                                new Mark(1, 2, SeedType.Nought),
                                new Mark(2, 2, SeedType.Cross))))},
        };
    }

    @Test(dataProvider = "dataFillBoardWithSeedsWithDrawCombination")
    public void testGameValidatorDraw(Board board){
        //Arrange
        GameValidator gameValidator = new GameValidator(board);

        //Act && Assert
        Assert.assertTrue(gameValidator.isDraw());
    }

    //helpers
    private static Board createBoardWithPresetOfFields(int rowNumbers, int columnNumbers, List<Mark> points) throws BoardCreatorException {
        Board board = new BoardCreator().createNewBoard(rowNumbers,columnNumbers);
        for (Mark point : points) {
            board.fields[point.row][point.column].type = point.type;
        }
        return board;
    }

    protected static class Mark {
        int row;
        int column;
        SeedType type;

        Mark(int row, int column, SeedType type){
            this.row = row;
            this.column = column;
            this.type = type;
        }
    }
}
