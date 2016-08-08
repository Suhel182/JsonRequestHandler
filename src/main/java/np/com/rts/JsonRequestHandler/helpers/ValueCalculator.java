package np.com.rts.JsonRequestHandler.helpers;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Dell on 6/8/2016.
 */
public class ValueCalculator {
    public static float calculate(ArrayList<Float> list, String dataRetrivalType) {
        float value = 0,sum=0;
        for (float f : list) {
            sum += f;
        }
        if (dataRetrivalType.equalsIgnoreCase("sum")) {
            return sum;
        }
        if (sum != 0) {
            if (dataRetrivalType.equalsIgnoreCase("avg")) {
                value = sum / list.size();
            } else if (dataRetrivalType.equalsIgnoreCase("max")) {
                value = Collections.max(list);
            } else if (dataRetrivalType.equalsIgnoreCase("min")) {
                value = Collections.min(list);
            }
        }
        return value;
    }
}
