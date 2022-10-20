/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assistcontrol;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author carlos
 */
public class Conexion {

        public static Connection conect() {
                Connection con = null;

                try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "mysql");
                } catch (Exception e) {
                        System.out.println("Tuvimos un error al conectar la base de datos :: " + e.getMessage());
                }
                return con;
        }
}
