package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VentaDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    public List<Venta> listar() {
        List<Venta> listaVentas = new ArrayList<>();
        String sql = "CALL sp_ListarVenta()";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Venta venta = new Venta();
                venta.setCodigoVenta(rs.getInt(1));
                venta.setCodigoZapato(rs.getInt(2));
                listaVentas.add(venta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaVentas;
    }

public int agregar(Venta venta) {
    String sql = "CALL sp_AgregarVenta(?)";
    try {
        con = cn.Conexion();
        ps = con.prepareStatement(sql);
        ps.setInt(1, venta.getCodigoZapato());
        resp = ps.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return resp;
}


    public Venta listarCodigoPorVenta(int codigoVenta) {
        Venta venta = new Venta();
        String sql = "SELECT * FROM Venta WHERE codigoVenta = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigoVenta);
            rs = ps.executeQuery();
            if (rs.next()) {
                venta.setCodigoVenta(rs.getInt("codigoVenta"));
                venta.setCodigoZapato(rs.getInt("codigoZapato"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return venta;
    }

public int actualizar(Venta venta) {
    String sql = "CALL sp_EditarVenta(?, ?)";
    try {
        con = cn.Conexion();
        ps = con.prepareStatement(sql);
        ps.setInt(1, venta.getCodigoVenta());
        ps.setInt(2, venta.getCodigoZapato());
        resp = ps.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return resp;
}

    public void eliminar(int codigoVenta) {
        String sql = "CALL sp_EliminarVenta(?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigoVenta);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
