package np.com.rts.JsonRequestHandler;

import np.com.rts.JsonRequestHandler.lexicon.LexiconInterpretor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.SQLException;

public class MainClass {
    public JSONObject getJsonWithValues(JSONObject requestJson) throws JSONException, SQLException, ClassNotFoundException {
        JSONArray stations = requestJson.names();
        for (int i=0; i < stations.length(); i++) {
            JSONObject singleStationObject = requestJson.getJSONObject((String) stations.get(i)).getJSONObject("param");
            JSONArray parameters = singleStationObject.names();
            for(int j=0; j<parameters.length(); j++){
                JSONObject singleParameterObject = singleStationObject.getJSONObject((String) parameters.get(j));
                JSONArray dataRetrivalTypes = singleParameterObject.names();
                for(int k=0; k<dataRetrivalTypes.length(); k++){
                    JSONObject intervalsObject = singleParameterObject.getJSONObject((String) dataRetrivalTypes.get(k));
                    JSONArray intervals = intervalsObject.names();
                    for(int l=0; l<intervals.length(); l++){
                        LexiconInterpretor lexiconInterpretor = new LexiconInterpretor();
                        float value = lexiconInterpretor.getValueForLexicon((String) stations.get(i),(String) parameters.get(j),(String) dataRetrivalTypes.get(k),(String) intervals.get(l));
                        requestJson.getJSONObject((String) stations.get(i)).getJSONObject("param").getJSONObject((String) parameters.get(j)).getJSONObject((String) dataRetrivalTypes.get(k)).put((String) intervals.get(l),String.valueOf(value));
                    }
                }
            }
        }
        return requestJson;
    }
}
