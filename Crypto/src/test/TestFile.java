
import main.java.FileConverter;
import main.java.ROT;
import main.java.ROT13;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;

public class TestFile {
    @Test
    public void testEncryptFileROT13() throws IOException {
            //Given
            ROT rot = new ROT13();
            FileConverter fileReader = new FileConverter(rot);
            fileReader.readInFile("/Users/eleonorbart/Projects/IntelliJ/SimpleCrypt/sonnet18.txt");
            fileReader.encryptFile("sonnet1813.enc");
            //When
            String actual = FileUtils.readFileToString(
                    new File("/Users/eleonorbart/Projects/IntelliJ/SimpleCrypt/sonnet1813.enc"), Charset.defaultCharset());
            //Then
            String expected = "Funyy V pbzcner gurr gb n fhzzre’f qnl?\n" +
                    "Gubh neg zber ybiryl naq zber grzcrengr:\n" +
                    "Ebhtu jvaqf qb funxr gur qneyvat ohqf bs Znl,\n" +
                    "Naq fhzzre’f yrnfr ungu nyy gbb fubeg n qngr;\n" +
                    "Fbzrgvzr gbb ubg gur rlr bs urnira fuvarf,\n" +
                    "Naq bsgra vf uvf tbyq pbzcyrkvba qvzz'q;\n" +
                    "Naq rirel snve sebz snve fbzrgvzr qrpyvarf,\n" +
                    "Ol punapr be angher’f punatvat pbhefr hagevzz'q;\n" +
                    "Ohg gul rgreany fhzzre funyy abg snqr,\n" +
                    "Abe ybfr cbffrffvba bs gung snve gubh bj’fg;\n" +
                    "Abe funyy qrngu oent gubh jnaqre’fg va uvf funqr,\n" +
                    "Jura va rgreany yvarf gb gvzr gubh tebj’fg:\n" +
                    "   Fb ybat nf zra pna oerngur be rlrf pna frr,\n" +
                    "   Fb ybat yvirf guvf, naq guvf tvirf yvsr gb gurr.\n";
            Assert.assertEquals(expected, actual);
    }

    @Test
    public void testEncryptFileROTNot13() throws IOException {
        //Given
        ROT rot = new ROT('a', 'g');
        FileConverter fileReader = new FileConverter(rot);
        fileReader.readInFile("/Users/eleonorbart/Projects/IntelliJ/SimpleCrypt/sonnet18.txt");
        fileReader.encryptFile("sonnet18Not13.enc");
        //When
        String actual = FileUtils.readFileToString(
                new File("/Users/eleonorbart/Projects/IntelliJ/SimpleCrypt/sonnet18Not13.enc"), Charset.defaultCharset());
        //Then
        String expected = "Yngrr O iusvgxk znkk zu g yasskx’y jge?\n" +
                "Znua gxz suxk rubkre gtj suxk zksvkxgzk:\n" +
                "Xuamn cotjy ju yngqk znk jgxrotm hajy ul Sge,\n" +
                "Gtj yasskx’y rkgyk ngzn grr zuu ynuxz g jgzk;\n" +
                "Yuskzosk zuu nuz znk kek ul nkgbkt ynotky,\n" +
                "Gtj ulzkt oy noy murj iusvrkdout joss'j;\n" +
                "Gtj kbkxe lgox lxus lgox yuskzosk jkirotky,\n" +
                "He ingtik ux tgzaxk’y ingtmotm iuaxyk atzxoss'j;\n" +
                "Haz zne kzkxtgr yasskx yngrr tuz lgjk,\n" +
                "Tux ruyk vuyykyyout ul zngz lgox znua uc’yz;\n" +
                "Tux yngrr jkgzn hxgm znua cgtjkx’yz ot noy yngjk,\n" +
                "Cnkt ot kzkxtgr rotky zu zosk znua mxuc’yz:\n" +
                "   Yu rutm gy skt igt hxkgznk ux keky igt ykk,\n" +
                "   Yu rutm robky znoy, gtj znoy mobky rolk zu znkk.\n";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testEncryptFileROT13Decrypt() throws IOException {
        //Given
        ROT rot = new ROT13();
        FileConverter fileReader = new FileConverter(rot);
        fileReader.readInFile("/Users/eleonorbart/Projects/IntelliJ/SimpleCrypt/sonnet1813.enc");
        fileReader.decryptFile("sonnet1813Decrypted.enc");
        //When
        String actual = FileUtils.readFileToString(
                new File("/Users/eleonorbart/Projects/IntelliJ/SimpleCrypt/sonnet1813Decrypted.enc"), Charset.defaultCharset());
        //Then
        String expected = "Shall I compare thee to a summer’s day?\n" +
                "Thou art more lovely and more temperate:\n" +
                "Rough winds do shake the darling buds of May,\n" +
                "And summer’s lease hath all too short a date;\n" +
                "Sometime too hot the eye of heaven shines,\n" +
                "And often is his gold complexion dimm'd;\n" +
                "And every fair from fair sometime declines,\n" +
                "By chance or nature’s changing course untrimm'd;\n" +
                "But thy eternal summer shall not fade,\n" +
                "Nor lose possession of that fair thou ow’st;\n" +
                "Nor shall death brag thou wander’st in his shade,\n" +
                "When in eternal lines to time thou grow’st:\n" +
                "   So long as men can breathe or eyes can see,\n" +
                "   So long lives this, and this gives life to thee.\n";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testEncryptFileROTNot13Decrypt() throws IOException {
        //Given
        ROT rot = new ROT('i', 'p');
        FileConverter fileReader = new FileConverter(rot);
        fileReader.readInFile("/Users/eleonorbart/Projects/IntelliJ/SimpleCrypt/sonnet18Not13.enc");
        fileReader.decryptFile("sonnet18Not13Decrypted.enc");
        //When
        String actual = FileUtils.readFileToString(
                new File("/Users/eleonorbart/Projects/IntelliJ/SimpleCrypt/sonnet1813Decrypted.enc"), Charset.defaultCharset());
        //Then
        String expected = "Shall I compare thee to a summer’s day?\n" +
                "Thou art more lovely and more temperate:\n" +
                "Rough winds do shake the darling buds of May,\n" +
                "And summer’s lease hath all too short a date;\n" +
                "Sometime too hot the eye of heaven shines,\n" +
                "And often is his gold complexion dimm'd;\n" +
                "And every fair from fair sometime declines,\n" +
                "By chance or nature’s changing course untrimm'd;\n" +
                "But thy eternal summer shall not fade,\n" +
                "Nor lose possession of that fair thou ow’st;\n" +
                "Nor shall death brag thou wander’st in his shade,\n" +
                "When in eternal lines to time thou grow’st:\n" +
                "   So long as men can breathe or eyes can see,\n" +
                "   So long lives this, and this gives life to thee.\n";
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = FileNotFoundException.class)
    public void testMissingFile() throws IOException {
        //Given
        ROT rot = new ROT('i', 'p');
        FileConverter fileReader = new FileConverter(rot);
        //When
        fileReader.readInFile("/Users/eleonorbart/Projects/IntelliJ/SimpleCrypt/nothing.enc");
        //Then
        //Exception is thrown
    }

    @Test(expected = FileNotFoundException.class)
    public void testMissingFileEncrypt() throws IOException {
        //Given
        ROT rot = new ROT('i', 'p');
        FileConverter fileReader = new FileConverter(rot);
        //When
        fileReader.encryptFile("Something.txt");

        //Then
        //Exception is thrown
    }

    @Test(expected = FileNotFoundException.class)
    public void testMissingFileDecrypt() throws IOException {
        //Given
        ROT rot = new ROT('i', 'p');
        FileConverter fileReader = new FileConverter(rot);
        //When
        fileReader.decryptFile("Something.txt");

        //Then
        //Exception is thrown
    }

    @Test(expected = FileNotFoundException.class)
    public void testMissingFile2() throws IOException {
        //Given
        ROT rot = new ROT('i', 'p');
        FileConverter fileReader = new FileConverter(rot);
        //When
        fileReader.decryptFile(null);

        //Then
        //Exception is thrown
    }

}
