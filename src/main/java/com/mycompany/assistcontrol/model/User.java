
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assistcontrol.model;

/**
 *
 * @author carlos
 */
public class User {

        private int id;
        private String dni;
        private String firstName;
        private String lastName;
        private String section;

        public User(int id, String dni, String firstName, String lastName, String section) {
                this.id = id;
                this.dni = dni;
                this.firstName = firstName;
                this.lastName = lastName;
                this.section = section;
        }

        public String getFullname() {
                return this.firstName + " " + this.lastName;
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getDni() {
                return dni;
        }

        public void setDni(String dni) {
                this.dni = dni;
        }

        public String getFirstName() {
                return firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        public String getSection() {
                return section;
        }

        public void setSection(String section) {
                this.section = section;
        }

}
