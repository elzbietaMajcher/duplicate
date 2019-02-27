package duplicate;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ObjectFileTest {

    //given
    String given = "objectFile.file2.txt";
    String given2 = "objectFile.file2.name.txt";


    @Test
    public void givenExtractType() {
        //when
        String result =  ObjectFile.extractType(given);
        //then
        assertEquals("txt",result);
    }

    @Test
    public void given2ExtractType() {
        //when
        String result =  ObjectFile.extractType(given2);
        //then
        assertEquals("txt",result);
    }

    @Test
    public void givenExtractName() {
       //when
        String result = ObjectFile.extractName(given);
        //then
        assertEquals("objectFile.file2", result );
    }


}
