package np.com.rts.JsonRequestHandler.lexicon;

import junit.framework.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * Created by Suhel 182 on 6/17/2016.
 */
public class LexerTest {
    @Test
    public void testAnswers(){
        HashMap<String,String> hmap = new HashMap<String,String>();
        String[] str = {"AFTER","4","HOURS"};
        Lexer lexer= new Lexer();
        Assert.assertEquals("AFTER",lexer.lex(str).get(Lexer.Type.Qualifier));
        Assert.assertEquals("4",lexer.lex(str).get(Lexer.Type.Time));
        Assert.assertEquals("HOURS",lexer.lex(str).get(Lexer.Type.Hours));
    }
}
