package np.com.rts.JsonRequestHandler.lexicon.qualifiers;

import junit.framework.Assert;
import np.com.rts.JsonRequestHandler.helpers.DateAndTime;
import np.com.rts.JsonRequestHandler.lexicon.qualifiers.WithinQualifier;
import org.testng.annotations.Test;

/**
 * Created by Suhel 182 on 6/16/2016.
 */
public class WithinQualifierTest {
    @Test
    public void testAnswers(){
        WithinQualifier withinQualifier = new WithinQualifier();
        withinQualifier.calculate("4","","hours");
        String from,to;
        DateAndTime dateAndTime =new DateAndTime();
        int currentHour = dateAndTime.getCurrentHour();
        if(currentHour-4<0){
            from="00:00:00";
        }else {
            from = dateAndTime.standardizeTime(String.valueOf(currentHour-4),"HOURS");
        }
        Assert.assertEquals(from,withinQualifier.getFrom());
    }
}
