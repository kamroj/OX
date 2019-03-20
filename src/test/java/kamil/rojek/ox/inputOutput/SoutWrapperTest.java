package kamil.rojek.ox.inputOutput;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;


/**
 * @author Kamil Rojek
 */
public class SoutWrapperTest {

    @Test
    public void testIfSoutWrapperIsntNull(){
        SoutWrapper soutWrapper = new SoutWrapper();
        Assert.assertNotNull(soutWrapper);
    }

    @DataProvider
    public static Object[][] dataForInput(){
        return new Object[][] {
            {"test"}, {"test2"},
            {"test test"}, {" ASDSADAS ASDWQ1 1231 k@%$@##"},
            {"test xE2 asd2"}, {"test xE2 asd2 [][][_)_012387987/-*/"},
            {""}, {"                          "},
            {"~12123. .123. 1. 1.2 .31122 weqw EWew121"}, {"1234567890"},
            {" . "},{"!@#$%^&*()_+"},
            {". / /n/",}, {"bnjasd**^@!$jh!@ i@!u#*!@ jh !nmnsmandm HEQOHE12 HASKDJH 3U4H1          "},
            {"test dDd asd as21 213 asd 123123W    123 Sad 21312 SADasdasdasd"},
            {"te123`` st"}, {"asd 123 satest2"},
            {"testss as asd"}, {"AAAAAAAAAA test2"},
            {"te23123 123szxct"}, {"taaaa a a a a a a a a a est2"},
            {"test"}, {"te123 1231 st2"},
            {"     _ta sest"}, {"tXxxest2"},
            {"test12312 "}, {" t1 e s t12 2"},
            {"sad1 2 1wd1 21 wqd1 2test"}, {"tes1231231 121 22  1t2"}
        };
    }

    @Test(dataProvider = "dataForInput")
    public void testValidInputPrinting(String input) throws IOException {
        PrintStream ps = new PrintStream(new FileOutputStream("logTest.txt"));
        SoutWrapper.printMsg(input, ps);
        BufferedReader reader = new BufferedReader(new FileReader("logTest.txt"));

        String line;
        while ((line = reader.readLine()) != null) {
            Assert.assertEquals(input, line);
        }
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidInputPrinting() throws IOException {
        PrintStream ps = new PrintStream(new FileOutputStream("logTest.txt"));
        SoutWrapper.printMsg(null, ps);
        BufferedReader reader = new BufferedReader(new FileReader("logTest.txt"));

        String line;
        while ((line = reader.readLine()) != null) {
            Assert.assertEquals(null, line);
        }
    }
}