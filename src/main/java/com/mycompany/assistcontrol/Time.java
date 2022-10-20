/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assistcontrol;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JLabel;

/**
 *
 * @author carlos
 */
public class Time implements Runnable {

        String hour, min, seg, ampm;
        Thread h1;
        JLabel clockLabel;

        public Time(JLabel jlabel) {
                this.clockLabel = jlabel;
                h1 = new Thread(this);
                h1.start();
        }

        private void setValues() {
                Calendar calendar = new GregorianCalendar();
                Date dateNow = new Date();
                calendar.setTime(dateNow);
                ampm = calendar.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";
                if (ampm.equals("PM")) {
                        int h = calendar.get(Calendar.HOUR_OF_DAY) - 12;
                        hour = h > 9 ? "" + h : "0" + h;
                        if (h == 00) {
                                hour = "12";
                        } else {
                                hour = h > 9 ? "" + h : "0" + h;
                        }
                } else {
                        hour = calendar.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendar.get(Calendar.HOUR_OF_DAY) : "0" + calendar.get(Calendar.HOUR_OF_DAY);
                }
                min = calendar.get(Calendar.MINUTE) > 9 ? "" + calendar.get(Calendar.MINUTE) : "0" + calendar.get(Calendar.MINUTE);
                seg = calendar.get(Calendar.SECOND) > 9 ? "" + calendar.get(Calendar.SECOND) : "0" + calendar.get(Calendar.SECOND);
        }

        @Override
        public void run() {
                Thread ct = Thread.currentThread();
                while (ct == h1) {
                        setValues();
                        clockLabel.setText(hour + ":" + min + ":" + seg + " " + ampm);
                        try {
                                Thread.sleep(1000);
                        } catch (InterruptedException error) {
                                System.out.println(error.getMessage());
                        }
                }
        }

}
