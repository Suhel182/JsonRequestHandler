package np.com.rts.JsonRequestHandler.lexicon.qualifiers;

import junit.framework.Assert;
import np.com.rts.JsonRequestHandler.helpers.DateAndTime;
import np.com.rts.JsonRequestHandler.lexicon.qualifiers.BeforeQualifier;
import org.testng.annotations.Test;

/**
 * Created by Suhel 182 on 6/16/2016.
 */
public class BeforeQualifierTest {
    @Test
    public void testAnswers(){
        BeforeQualifier beforeQualifier = new BeforeQualifier();
        beforeQualifier.calculate("4","","hours");
        String to = (new DateAndTime().getCurrentHour()-4)+":00:00";
        Assert.assertEquals(to,beforeQualifier.getTo());
    }
}
