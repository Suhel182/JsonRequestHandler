package np.com.rts.JsonRequestHandler.helpers;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Suhel 182 on 6/17/2016.
 */
public class DateAndTimeTest {
    @Test
    public void testAnswers(){
        DateAndTime dateAndTime = new DateAndTime();
        Assert.assertEquals("20:00:00",dateAndTime.standardizeTime("8","PM"));
    }
}
