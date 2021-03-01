package timeofday_oop;

//Abstract State Invariants. (The clients can see this, talk about the values of the getters)
/**
 * Each instance of this class represents a time of day.
 * 
 * @invar | 0 <= getHours() && getHours() <=23
 * @invar | 0 <= getMinutes() && getMinutes() <=59
 * 
 */
public class TimeOfDay {

	//Here are the concrete state invariants, ot visible to the clients, talk about the values of the fields
	//@invar | 0 <= minutesSinceMidnight
	//@invar | minutesSinceMidnight < 24 * 60
	//private final int minutesSinceMidnight
	/**
	 * @invar | 0 <= hours && hours <= 23
	 * @invar | 0 <= minutes && minutes <= 59
	 */
	private int hours;
	private int minutes;

	/**
	 * @basic
	 */
	public int getHours() {return hours;} //return minutesSinceMidnight/60;

	/**
	 * @basic
	 */
	public int getMinutes() {return minutes;} //return minutesSinceMidnight % 60


	/**
	 * @post | result == getHours() *60 + getMinutes()
	 */
	public int getMinutesSinceMidnight() {
		return hours * 60 + minutes ;
	}

	/**
	 * Initializes this object so that it represents the time of day given by the given hours and minutes
	 * 
	 * @throws IllegalArgumentException | hours < 0 || 23 < hours
	 * @throws IllegalArgumentException | minutes < 0 || 59 < minutes
	 * 
	 * @post | getHours() == hours
	 * @post | getMinutes() == minutes
	 */
	public TimeOfDay(int hours, int minutes) {
		if (hours < 0 || 23 < hours)
			throw new IllegalArgumentException("`hours` is invalid");
		if (minutes <0 || 59 < minutes)
			throw new IllegalArgumentException("'minutes` is invalid");

		this.hours = hours;
		this.minutes = minutes;
		
		//this.minutesSinceMidnight = hours * 60 + minutes
		
		//Even though change to minutesSinceMidnight, documentation dont change 
	}
	
	/**
	 * Sets this object's hours to the given hours.
	 * 
	 * @mutates | this
	 * 
	 * @pre | 0 <= newHours && newHours <= 23
	 * 
	 * @post | getHours() == newHours
	 * @post | getMinutes() == old(getMinutes())
	 * 
	 */
	public void setHours(int newHours) {
		this.hours = newHours;
	}
	
	/**
	 * Sets this object's minutes to the given minutes.
	 * 
	 * @mutates | this
	 * 
	 * @pre | 0 <= newMinutes && newMinutes <= 59
	 * 
	 * @post | getHours() == old(getHours())
	 * @post | getMinutes() == newMinutes
	 */
	public void setMinutes(int newMinutes) {
		this.minutes = newMinutes;
	}
}
