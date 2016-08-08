package np.com.rts.JsonRequestHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by Dell on 6/6/2016.
 */
public class RequestListener extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String inputText = request.getParameter("inputText");
        MainClass mainClass = new MainClass();
        try {
            JSONObject jsonObject = new JSONObject(inputText);
            JSONObject responseJson = mainClass.getJsonWithValues(jsonObject);
            PrintWriter out = response.getWriter();
            out.println(responseJson.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
