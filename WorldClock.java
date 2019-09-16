//package clockdemo;

/**
 * Title: Assignment 3-WorldClock.java 
 * Semester: COP3337 – Summer 2019
 *
 * @author Moises Feliz
 *
 * I affirm that this program is entirely my own work and none of it is the work
 * of any other person.
 * 
 * This class was made to show the time for the offset value. It first gets the 
 * the offset value from the ClockDemo class then saves it in this program
 * as a integer. The worldclock method is the constructor and also where it 
 * gets the offset value. This program is a subclass of the clock class so 
 * all the values from that class can be used here. This is used in getMinutes
 * method since the offset is in hours not minutes so it should be the same 
 * minutes as the superclass. The gethour first gets the hours from the super
 * class makes it an integer first then adds the off set time. After it gets
 * the new value makes it an string and returns it. The getTime method makes
 * a string time and initialize it first then adds the new hours and minutes to 
 * it.
 *
 *
 * PART II. Provide a subclass of Clock namded WorldClock whose constructor
 * accepts a time offset. For example, if you live in California, a new
 * WorldClock(3) should show the time in New York, three time zones ahead. You
 * should not override getTime.
 */
public class WorldClock extends Clock 
{

    int offset;

     /**
     * sets offset value
     *
     * @doesnt return any value but is the construct class and sets the offset
     * value.
     */
    public WorldClock(int offset) 
    {
        this.offset = offset;
    }

     /**
     * gets hours
     *
     * @return hours of current time after offset value is added in string
     */
    @Override
    public String getHours() 
    {
        int hr = Integer.parseInt(super.getHours());
        int newhr = (hr + offset) % 24;
        String hour = Integer.toString(newhr);
        return hour;
    }

     /**
     * gets minutes
     *
     * @return minutes of new time in string
     */
    public String getMinutes() 
    {
        return super.getMinutes();
    }

    /**
     * gets current time composed of hours and minutes after adding the offset
     * of hours
     *
     * @return time in string;
     */
    public String getTime() 
    {
        // Complete this method
        String time = "";
        time += this.getHours();
        time += ":";
        time += this.getMinutes();
        return time;
    }
}
