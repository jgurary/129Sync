package RhythmGame;

public class Settings {

	public static final double HITZONE_SIZE = 75;
	public static final double NOTE_SIZE = 50;

	/**
	 * Distance from the bottom of the screen
	 */
	public static final double HITZONE_Y_POS = 200;

	public static final double MIN_NOTE_SPEED = 1;
	/**
	 * Range of values note drop speeds can take (between {@link #MIN_NOTE_SPEED}
	 * and ({@link #MIN_NOTE_SPEED} + this range)
	 */
	public static final double NOTE_SPEED_RANGE = 5;

	public static final int FPS = 60;
	public static final int NOTE_DEATH_ANIMATION_DURATION = (int) (FPS * 1.5);
	public static final int TICKS_BETWEEN_NOTES = FPS * 3;

}
