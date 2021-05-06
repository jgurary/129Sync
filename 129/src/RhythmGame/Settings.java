package RhythmGame;

public class Settings {

	public static final double HITZONE_SIZE = 100;
	public static final double NOTE_SIZE = 50;

	/**
	 * Distance from the bottom of the screen
	 */
	public static final double HITZONE_Y_POS = 200;

	// TODO possibly increase difficulty by raising this over time as well?
	public static final double MIN_NOTE_SPEED = 1;
	/**
	 * Range of values note drop speeds can take (between {@link #MIN_NOTE_SPEED}
	 * and ({@link #MIN_NOTE_SPEED} + this range)
	 */
	public static final double NOTE_SPEED_RANGE = 5;

	public static final int FPS = 60;
	public static final int NOTE_DEATH_ANIMATION_DURATION = (int) (FPS * 1.5);
	public static final int HITBOX_HIT_ANIMATION_DURATION = (int) (FPS * .5);

	// Difficulty-related
	public static final int TICKS_BETWEEN_NOTES_INITIAL = (int) (FPS * 3);
	/**
	 * This is the hardest difficulty (fastest note spawn rate)
	 */
	public static final int TICKS_BETWEEN_NOTES_MINIMUM = (int) (FPS);
	public static final int DIFFICULTY_INCREASE_PER_ITERATION = (int) (FPS * .25);
	public static final int TICKS_BETWEEN_DIFFICULTY_INCREASES = (int) (FPS * 10);

}
