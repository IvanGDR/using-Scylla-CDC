package com.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetConfigValue {

    public String GetCDCContactPoint(){
        try (InputStream input = GetConfigValue.class.getResourceAsStream("/config.properties")) {
            Properties prop = new Properties();
            // load a properties file
            prop.load(input);
            // get the property value and print it out
            return prop.getProperty("cdccontactpoint");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public String GetCDCKeyspace(){
        try (InputStream input = GetConfigValue.class.getResourceAsStream("/config.properties")) {
            Properties prop = new Properties();
            // load a properties file
            prop.load(input);
            // get the property value and print it out
            return prop.getProperty("cdckeyspace");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public String GetCDCTable(){
        try (InputStream input = GetConfigValue.class.getResourceAsStream("/config.properties")) {
            Properties prop = new Properties();
            // load a properties file
            prop.load(input);
            // get the property value and print it out
            return prop.getProperty("cdctable");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public String GetCol1(){
        try (InputStream input = GetConfigValue.class.getResourceAsStream("/config.properties")) {
            Properties prop = new Properties();
            // load a properties file
            prop.load(input);
            // get the property value and print it out
            return prop.getProperty("col1");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public String GetCol2(){
        try (InputStream input = GetConfigValue.class.getResourceAsStream("/config.properties")) {
            Properties prop = new Properties();
            // load a properties file
            prop.load(input);
            // get the property value and print it out
            return prop.getProperty("col2");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public String GetCol3(){
        try (InputStream input = GetConfigValue.class.getResourceAsStream("/config.properties")) {
            Properties prop = new Properties();
            // load a properties file
            prop.load(input);
            // get the property value and print it out
            return prop.getProperty("col3");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}