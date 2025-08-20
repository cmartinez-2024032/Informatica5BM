package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ZapatoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    public List<Zapato> listar() {
        String sql = "call sp_ListarZapato()";
        List<Zapato> listaZapato = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Zapato z = new Zapato();
                z.setCodigoZapato(rs.getInt(1));
                z.setModelo(rs.getString(2));
                z.setTalla(rs.getInt(3));
                z.setColor(rs.getString(4));
                z.setPrecio(rs.getDouble(5));
                z.setStock(rs.getInt(6));
                listaZapato.add(z);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaZapato;
    }

    public int agregar(Zapato zap) {
        String sql = "call sp_AgregarZapato(?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, zap.getModelo());
            ps.setInt(2, zap.getTalla());
            ps.setString(3, zap.getColor());
            ps.setDouble(4, zap.getPrecio());
            ps.setInt(5, zap.getStock());
            resp = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    public Zapato listarCodigoPorZapato(int codigoZapato) {
        Zapato z = new Zapato();
        String sql = "SELECT * FROM Zapato WHERE codigozapato = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigoZapato);
            rs = ps.executeQuery();
            if (rs.next()) {
                z.setCodigoZapato(rs.getInt("codigozapato"));
                z.setModelo(rs.getString("modelo"));
                z.setTalla(rs.getInt("talla"));
                z.setColor(rs.getString("color"));
                z.setPrecio(rs.getDouble("precio"));
                z.setStock(rs.getInt("stock"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return z;
    }

    public int actualizar(Zapato zapato) {
        String sql = "CALL sp_EditarZapato(?, ?, ?, ?, ?, ?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, zapato.getCodigoZapato());
            ps.setString(2, zapato.getModelo());
            ps.setInt(3, zapato.getTalla());
            ps.setString(4, zapato.getColor());
            ps.setDouble(5, zapato.getPrecio());
            ps.setInt(6, zapato.getStock());
            resp = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

 public void eliminar(int codigoZapato) {
    String sql = "CALL sp_EliminarZapato(?)";
    try {
        con = cn.Conexion();
        ps = con.prepareStatement(sql);
        ps.setInt(1, codigoZapato);
        ps.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

}
