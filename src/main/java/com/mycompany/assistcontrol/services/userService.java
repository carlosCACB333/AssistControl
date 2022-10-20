package com.mycompany.assistcontrol.services;

import com.mycompany.assistcontrol.Conexion;
import com.mycompany.assistcontrol.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author carlos
 */
public class userService {

        public static final Connection conexion = Conexion.conect();

        public static User findByDni(String dni) {
                User user = null;
                try {
                        PreparedStatement ps = conexion.prepareStatement("select * from users where dni=?");
                        ps.setString(1, dni);
                        ResultSet rs = ps.executeQuery();

                        if (rs.next()) {
                                user = new User(rs.getInt("id"), rs.getString("dni"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("section"));

                        }

                } catch (Exception e) {
                        System.out.println("Error al obtener los datos" + e.getMessage());
                }

                return user;
        }

}
