package np.com.rts.JsonRequestHandler.helpers;

import junit.framework.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;
import org.apache.commons.io.IOUtils;
import static org.testng.TestNGAntTask.Mode.junit;

public class ValueCalculatorTest {

    @Test
    public void testAnswer() throws IOException {
        ValueCalculator valueCalculator = new ValueCalculator();
        ArrayList<Float> list = new ArrayList<Float>();
        String[] numbers = IOUtils.toString(getClass().getClassLoader().getResourceAsStream("numbers"),"UTF-8").split("\\s+");
        for(String s:numbers){
            list.add(Float.parseFloat(s));
        }
        Assert.assertEquals(list.stream().mapToLong(i->i.longValue()).sum(),valueCalculator.calculate(list,"sum"),0);
        Assert.assertEquals(list.stream().mapToLong(value -> value.longValue()).average().getAsDouble(),valueCalculator.calculate(list,"avg"),0.01);
        Assert.assertEquals(list.stream().mapToLong(value -> value.longValue()).max().getAsLong(),valueCalculator.calculate(list,"max"),0.01);
        Assert.assertEquals(list.stream().mapToLong(value -> value.longValue()).min().getAsLong(),valueCalculator.calculate(list,"min"),0.01);
    }
}
