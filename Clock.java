//package clockdemo;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Title: Assignment 3-Clock.java 
 * Semester: COP3337 – Summer 2019
 *
 * @author Moises Feliz
 *
 * I affirm that this program is entirely my own work and none of it is the 
 * work of any other person.
 *
 * The program gets the current time of your location. It makes the current 
 * time a string, then the getMinutes and the getHour method splits them 
 * into substrings such that hours is a substring and so is minutes could be 
 * returned by each class. The SetAlarm() sets the hour and minutes of the 
 * alarm by getting them from the Clockdemo program and saving their values
 * in this program. The getTime method gets the current time string and 
 * returns it while also setting the alarm if there is one.
 * 
 * Part I: Implement a class Clock whose getHours, getMinutes and getTime
 * methods return the current time at your location. Return the time as a
 * string.
 *
 * There are two ways to retrieve the current time as a String:
 *
 * 1) Before Java 8 use new Date().toString() 2) With Java 8, you can use 3
 * classes in the java.time package: Instant, LocalDateTime and ZoneId. Here's
 * how you do it: String timeString = LocalDateTime.ofInstant(Instant.now(),
 * ZoneId.systemDefault()).toString()
 *
 * With either method, you'll need to extract the hours and minutes as a
 * substring.
 *
 *
 * Add an alarm feature to the Clock class. When setAlarm(hours, minutes) is
 * called, the clock stores the alarm. When you call getTime, and the alarm time
 * has been reached or exceeded, return the time followed by the string "Alarm"
 * and clear the alarm.
 */
public class Clock 
{

    int alarm_hr = 0;
    int alarm_min = 0;
    LocalDateTime dateTime;

    /**
     * Sets the alarm.
     *
     * @param hours hours for alarm
     * @param minutes minutes for alarm
     */
    public void setAlarm(int hours, int minutes) 
    {
        // Complete this method
        alarm_hr = hours;
        alarm_min = minutes;
    }

    /**
     * gets current time composed of hours and minutes
     *
     * @return time in string;
     */
    public String getTime() 
    {
        // Complete this method
        String time = currentTime().split("T")[1];
        time = time.substring(0, 5);
        time = time.substring(0, 5);
        //checking for alarm
        if (alarm_hr != 0) {
            if (Integer.parseInt(getHours()) >= alarm_hr) 
            {
                if (Integer.parseInt(getMinutes()) >= alarm_min) 
                {
                    //alarm found, resetting it
                    alarm_hr = 0;
                    alarm_min = 0;
                    //returning time with prefix 'Alarm'
                    return "Alarm " + time;
                }
            }
        }
        return time;
    }

    /**
     * gets hours
     *
     * @return hours of current time in string
     */
    public String getHours() 
    {
        //getting time string
        String time = currentTime().split("T")[1];
        time = time.substring(0, 5);
        //taking and returning the hours part only
        return time.substring(0, 2);
    }

    /**
     * gets minutes
     *
     * @return minutes of current time in string
     */
    public String getMinutes() 
    {
        String time = currentTime().split("T")[1];
        time = time.substring(0, 5);
        //taking and returning the minutes part only
        return time.substring(3, 5);
    }

    /**
     * Returns the current Date and Time as a String.
     */
    private String currentTime() 
    {
        return LocalDateTime.ofInstant(Instant.now(),
                ZoneId.systemDefault()).toString();
    }
}
