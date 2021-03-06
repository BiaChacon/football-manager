package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Time;

public class TimeDAO {

    private ConnectionDatabase c = new ConnectionDatabase();

    private final String LOGIN = "SELECT * FROM TEAM WHERE usuario = ? AND senha = ?;";

    private final String INSERT = "INSERT INTO TEAM(usuario, senha, nome, dataFundacao, patrimonio) VALUES (?, ?, ?, ?, ?);";

    private final String UPDATE = "UPDATE TEAM  SET usuario = ?, senha = ?, nome = ?, dataFundacao = ?, patrimonio = ? WHERE id = ?;";

    private final String DELETE = "DELETE FROM TEAM WHERE id = ?;";

    private final String LISTTIME = "SELECT * FROM TEAM";

    private final String VERIFICAR = "SELECT * FROM TEAM WHERE usuario = ?;";

    public Boolean verificarTime(String user) {
        try {
            c.dbConnection();

            PreparedStatement pst = c.getConnection().prepareStatement(VERIFICAR);

            pst.setString(1, user);

            ResultSet rst = pst.executeQuery();

            if (rst.next()) {
                c.dbConnectionClose();
                return true;
            }

            c.dbConnectionClose();

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Time loginTime(Time t) {
        try {

            c.dbConnection();

            System.out.println(t.toString());

            PreparedStatement pst = c.getConnection().prepareStatement(LOGIN);

            pst.setString(1, t.getUsuario());
            pst.setString(2, t.getSenha());

            ResultSet rst = pst.executeQuery();

            System.out.println(rst.toString());
            if (rst.next()) {
                Time tr = new Time(
                        rst.getInt("id"),
                        rst.getString("usuario"),
                        rst.getString("senha"),
                        rst.getString("nome"),
                        rst.getDate("dataFundacao"),
                        rst.getDouble("patrimonio")
                );
                c.dbConnectionClose();
                return tr;
            }

            c.dbConnectionClose();

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    public void insertIntoTime(Time t) {
        c.dbConnection();
        try {
            PreparedStatement pst = c.getConnection().prepareStatement(INSERT);
            pst.setString(1, t.getUsuario());
            pst.setString(2, t.getSenha());
            pst.setString(3, t.getNome());
            pst.setDate(4, t.getDataFundacao());
            pst.setDouble(5, t.getPatrimonio());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDatabase.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erro" + ex);
        }
        c.dbConnectionClose();

    }

    public void UpdateIntoTime(Time t) {
        c.dbConnection();
        try {
            PreparedStatement pst = c.getConnection().prepareStatement(UPDATE);
            pst.setString(1, t.getUsuario());
            pst.setString(2, t.getSenha());
            pst.setString(3, t.getNome());
            pst.setDate(4, t.getDataFundacao());
            pst.setDouble(5, t.getPatrimonio());
            pst.setInt(6, t.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        c.dbConnectionClose();

    }

    public void deleteFromTime(int idTime) {
        try {
            System.out.println(idTime);
            c.dbConnection();
            PreparedStatement pst = c.getConnection().prepareStatement(DELETE);
            pst.setInt(1, idTime);
            pst.execute();
            System.out.println("executou");
            c.dbConnectionClose();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Time> readTime() {
        ArrayList<Time> listaTime = new ArrayList<>();
        try {
            c.dbConnection();
            PreparedStatement ps;
            ps = c.getConnection().prepareStatement(LISTTIME);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Time t = new Time(
                        rs.getInt("id"),
                        rs.getString("usuario"),
                        rs.getString("senha"),
                        rs.getString("nome"),
                        rs.getDate("dataFundacao"),
                        rs.getDouble("patrimonio")
                );
                listaTime.add(t);
            }
            c.dbConnectionClose();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaTime;
    }

}
