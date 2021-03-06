# ABOUT OX
OX (Tic tac toe) is a game for two players, X and O, who take turns marking the spaces in a specific grid.
The player who succeeds in placing e.g. three marks in a horizontal, vertical or diagonal row wins the game.
For more information: https://en.wikipedia.org/wiki/Tic-tac-toe

## PREREQUISITES
- Java 11
- Please use default console font.

## RUNNING
Info:
- to run project without tests run bash script "runProject.sh" from OX/ folder.
- to run project with tests run bash script "runProjectWithTests.sh" from OX/ folder.
- to run test that validates input taken from file run bash script from OX/folder "runProjectWithTestFromOutput.sh $1"
where $1 is path to test cases e.g. ./runProjectWithTestFromOutput.sh TestCases/TC_2_6x6_3_OW.

To change parameters of automated test from file open WinValidatorTestCase.
If you have problems with permissions try to set chmod 755 in bash to file that you want to run.

Game config info:
- game is for two players (Player 1 (X), Player 2 (O)), first is always Player 1
- you can change size of board where 3x3 is minimum 30x30 maximum dimensions
- you can change winning condition limit where minimum is 3 maximum is bigger dimension length
- you can change number of rounds where min 1 max 10
- two languages are available English (default) and Polish

Thank you for game! Feel free to send me any feedback.
