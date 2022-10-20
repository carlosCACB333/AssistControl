/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assistcontrol;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class Camera {

        private Webcam webcam = null;
        private WebcamPanel panel = null;

        public Camera(JPanel jpanel) {
                Dimension size = WebcamResolution.VGA.getSize();
                webcam = Webcam.getDefault();
                webcam.setViewSize(size);
                panel = new WebcamPanel(webcam);
                panel.setPreferredSize(size);
                panel.setFPSDisplayed(true);
                jpanel.add(panel);
                System.out.println(size);

        }

        public void close() {
                webcam.close();

        }

        public String getQRText() {

                try {

                        Result result = null;
                        BufferedImage image = null;

                        if (webcam.isOpen()) {

                                if ((image = webcam.getImage()) == null) {
                                        return null;
                                }

                                LuminanceSource source = new BufferedImageLuminanceSource(image);
                                BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

                                try {
                                        result = new MultiFormatReader().decode(bitmap);
                                } catch (NotFoundException e) {
                                        // fall thru, it means there is no QR code in image
                                }
                        }

                        if (result != null) {
                                return (result.getText());
                        }
                        return null;

                } catch (Exception e) {
                        System.out.println(e.getMessage());
                        return null;
                }

        }

}
