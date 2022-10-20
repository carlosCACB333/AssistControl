/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assistcontrol;

import java.sql.Connection;
import javax.swing.WindowConstants;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author carlos
 */
public class Report {

        private final static Connection connection = Conexion.conect();

        public static void showReport(String path) {

                try {
                        var report = (JasperReport) JRLoader.loadObjectFromFile(path);
                        var jPrint = JasperFillManager.fillReport(report, null, connection);
                        var view = new JasperViewer(jPrint, false);
                        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                        view.setVisible(true);

                } catch (Exception ex) {
                        System.out.println("Error al generar el reporte: " + ex.getMessage());
                }

        }

}
