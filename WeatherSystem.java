/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.weathersystem;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zohaib khan
 */
class FreezingTemperatureException extends Exception{
String message;
public  FreezingTemperatureException()
{
    this.message="Freezing Temperature !!";
    
}
}
class HighTemperatureException extends Exception{
String message;
public  HighTemperatureException()
{
    this.message="High Temperature !!";
    
}
}
class LowHumidityException extends Exception{
String message;
public  LowHumidityException()
{
    this.message="Low Humidity !!";
    
}
}
class HighHumidityException extends Exception{
String message;
public  HighHumidityException()
{
    this.message="High Humidity !!";
    
}
}
class NegativeWindSpeedException extends Exception{
String message;
public  NegativeWindSpeedException()
{
    this.message="Negative Wind Speed !!";
   
}
}
class HighWindSpeedException extends Exception{
String message;
public  HighWindSpeedException()
{
    this.message="High Wind Speed !!";
    
}
}
class WeatherStation {
    private double temperature;
    private double humidity;
    private double windspeed;
    public void WeatherStation()
    {
        this.temperature=12;
        this.humidity=60;
        this.windspeed=18;
    }

    public WeatherStation(double temperature, double humidity, double windspeed) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.windspeed = windspeed;
    }
   

    public double getTemperature() {
        return temperature;
    }

    public void updateTemperature(double t) throws FreezingTemperatureException, HighTemperatureException  {
        if(t<-10)
        {
            throw new FreezingTemperatureException();
        }
        else if(t>40)
        {
            throw new HighTemperatureException();
        }
        else
        {
        
        this.temperature = t; }
    }

    public double getHumidity() {
        return humidity;
    }

    public void updateHumidity(double h) throws HighHumidityException, LowHumidityException {
        if(h<20)
                {
                  throw new LowHumidityException();
                }
        else if(h>90)
        {
            throw new HighHumidityException();
        }
        
        else{
        
        this.humidity = h;
    }}

    public double getWindspeed() {
        return windspeed;
    }

    public void updateWindspeed(double w) throws NegativeWindSpeedException, HighWindSpeedException {
        if(w<0)
        {
            throw new NegativeWindSpeedException();
        }
        else if(w>200)
        {
              throw new HighWindSpeedException();
        }
        else{
        this.windspeed = w;
        }
    }
    
}
public class WeatherSystem {
    public static void main(String[] args) {
        
        WeatherStation weather=new WeatherStation(12,16,18);
        try {
            weather.updateTemperature(55);
        } catch (FreezingTemperatureException | HighTemperatureException ex) {
            Logger.getLogger(WeatherSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            weather.updateHumidity(15);
        } catch (HighHumidityException | LowHumidityException ex) {
            Logger.getLogger(WeatherSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            weather.updateWindspeed(250);
        } catch (NegativeWindSpeedException | HighWindSpeedException ex) {
            System.out.println(ex.toString());
            Logger.getLogger(WeatherSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        System.out.println("Temperature " + weather.getTemperature());
        System.out.println("Humidity: " + weather.getHumidity());
        System.out.println("Wind Pressure: " + weather.getWindspeed());

    }
}
