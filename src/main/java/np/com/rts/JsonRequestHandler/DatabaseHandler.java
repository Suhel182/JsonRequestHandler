package np.com.rts.JsonRequestHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class DatabaseHandler {

    private Connection con;
    private PreparedStatement pstmt;

    public DatabaseHandler() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String str = ("jdbc:mysql://192.168.0.30/wscada_bhutan");
        con = DriverManager.getConnection(str, "data_user", "data_user_passes");
    }

    public String getStationId(String code) throws SQLException {
        pstmt = con.prepareStatement("SELECT `id` FROM `wscada_device` WHERE code=?");
        pstmt.setString(1,code);
        ResultSet rs = pstmt.executeQuery();
        String stationId = null;
        while(rs.next()){
            stationId= rs.getString(1);
        }
        return stationId;
    }
    public String getParameterId(String code) throws SQLException {
        pstmt = con.prepareStatement("SELECT `id` FROM `wscada_data_category` WHERE code=?");
        pstmt.setString(1,code);
        ResultSet rs = pstmt.executeQuery();
        String parameterId = null;
        while(rs.next()){
            parameterId = rs.getString(1);
        }
        return parameterId;
    }
    public ArrayList<Float> getValue(String stationId, String parameterId, String starting, String ending) throws SQLException {
        pstmt = con.prepareStatement("SELECT `value` FROM `wscada_real_time_data` WHERE `wscada_data_category_id`=? and `wscada_device_id`=? and `time` between ? and ?");
        pstmt.setString(1,parameterId);
        pstmt.setString(2,stationId);
        pstmt.setString(3, starting);
        pstmt.setString(4, ending);
        ResultSet rs = pstmt.executeQuery();
        ArrayList<Float> list = new ArrayList<Float>();
        while(rs.next()){
            list.add(rs.getFloat("value"));
        }
        return list;
    }
}
