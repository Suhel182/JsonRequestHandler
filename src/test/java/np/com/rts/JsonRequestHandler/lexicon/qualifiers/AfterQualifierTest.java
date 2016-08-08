package np.com.rts.JsonRequestHandler.lexicon.qualifiers;

import junit.framework.Assert;
import np.com.rts.JsonRequestHandler.helpers.DateAndTime;
import np.com.rts.JsonRequestHandler.lexicon.qualifiers.AfterQualifier;
import org.testng.annotations.Test;

/**
 * Created by Suhel 182 on 6/16/2016.
 */
public class AfterQualifierTest {
    @Test
    public void testAnswers(){
        AfterQualifier afterQualifier = new AfterQualifier();
        afterQualifier.calculate("4","","hours");
        String to = (new DateAndTime().getCurrentHour()+4)+":00:00";
        Assert.assertEquals(to,afterQualifier.getTo());
    }
}
