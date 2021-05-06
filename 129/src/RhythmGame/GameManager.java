package RhythmGame;

import java.util.ArrayList;
import java.util.Iterator;

public class GameManager implements NoteKeeper {

	// TODO Game gets harder over time
	// TODO Penalize the player somehow for hitting keys when a note isn't capture
	// TODO more precticable and rhythmic spawning
	// TODO BUG hitzones don't move when the screen is resized

	// FINALS
	public static final int NUMBER_OF_HITZONES = 4;

	// GAMEPLAY LISTS
	HitZone[] hitZones = new HitZone[NUMBER_OF_HITZONES];
	double[] laneLocation = new double[NUMBER_OF_HITZONES];
	ArrayList<Note> notes = new ArrayList<Note>();

	// UI LINKAGE
	Display display;

	// ANIMATION AND SIMULATION
	int ticks = 0;

	// GAMEPLAY LOGIC
	int misses = 0, score = 0;
	int currentDifficulty = Settings.TICKS_BETWEEN_NOTES_INITIAL;

	public GameManager(Display display) {
		this.display = display;
		double spacing = (display.getWidth() - Settings.HITZONE_SIZE * 4) / 5;
		double x = spacing;
		double y = display.getHeight() - Settings.HITZONE_Y_POS;
		for (int i = 0; i < hitZones.length; i++) {
			hitZones[i] = new HitZone(x, y);
			laneLocation[i] = x + Settings.HITZONE_SIZE / 2 - Settings.NOTE_SIZE / 2;
			x += spacing + Settings.HITZONE_SIZE;
			display.addDrawable(hitZones[i]);
		}
	}

	/**
	 * Advance the game state by one frame
	 */
	public void tick() {
		ticks++;

		spawnNote();

		moveNotes();

		tickAnimations();

		raiseDifficulty();

		checkMisses();
	}

	/**
	 * Periodically increase the difficulty, lowering {@link #currentDifficulty}
	 * (the spawn time between notes) to a minimum of
	 * {@link Settings#TICKS_BETWEEN_NOTES_MINIMUM}
	 */
	public void raiseDifficulty() {
		if (ticks % Settings.TICKS_BETWEEN_DIFFICULTY_INCREASES == 0) {
			if (currentDifficulty - Settings.DIFFICULTY_INCREASE_PER_ITERATION > Settings.TICKS_BETWEEN_NOTES_MINIMUM) {
				currentDifficulty -= Settings.DIFFICULTY_INCREASE_PER_ITERATION;
			} else {
				currentDifficulty = Settings.TICKS_BETWEEN_NOTES_MINIMUM;
			}
		}
	}

	/**
	 * Periodically spawns a new note. See
	 * {@link Settings#TICKS_BETWEEN_NOTES_INITIAL} for the number of frames between
	 * notes being spawned initially. <br>
	 * <br>
	 * Difficulty goes up over time, to a minimum spawn time of:
	 * {@link Settings#TICKS_BETWEEN_NOTES_MINIMUM}
	 */
	public void spawnNote() {
		if (ticks % currentDifficulty == 0) {
			spawnNote((int) (Math.random() * NUMBER_OF_HITZONES));
		}
	}

	/**
	 * Advances all of the animations of objects in this game by one frame
	 */
	public void tickAnimations() {
		// TODO BUG: Occasionally triggers concurrent exception when a Note removes
		// itself!
		try {
			for (Note n : notes) {
				n.tickAnimation();
			}
		} catch (Exception e) {
			System.err.println("Concurrency issue...");
		}

		for (HitZone h : hitZones) {
			h.tickAnimation();
		}
	}

	/**
	 * Check if any note has been successfully captured in this lane and responds
	 * accordingly
	 * 
	 * @param lane - which of the "hitzone" lanes (0 is the first and leftmost lane)
	 */
	public void checkHits(int lane) {
		for (Note n : notes) {
			if (hitZones[lane].contains(n.display)) {
				if (!n.isHit()) {
					n.hitNote();
					hitZones[lane].startHitAnimation();
					score++;
				}
			}
		}
	}

	/**
	 * Checks if a shape has crossed the threshold to count as a miss
	 */
	public void checkMisses() {
		Iterator<Note> itr = notes.iterator();

		while (itr.hasNext()) {
			Note n = itr.next();
			if (!n.isMiss()) {
				if (n.display.y > display.getHeight()) {
					n.miss();
					display.removeDrawable(n);
					itr.remove();
					misses++;
				}
			}
		}
	}

	/**
	 * Creates a new Note with a random drop speed and begins dropping it from the
	 * sky
	 * 
	 * @param lane - which of the "hitzone" lanes to spawn (0 is the first and
	 *             leftmost lane)
	 */
	public void spawnNote(int lane) {
		Note n = new Note(laneLocation[lane], -Settings.NOTE_SIZE,
				Math.random() * Settings.NOTE_SPEED_RANGE + Settings.MIN_NOTE_SPEED, this);
		notes.add(n);
		display.addDrawable(n);
	}

	/**
	 * Creates a new Note with a the given drop speed and begins dropping it from
	 * the sky
	 * 
	 * @param lane      - which of the "hitzone" lanes to spawn (0 is the first and
	 *                  leftmost lane)
	 * @param dropSpeed
	 */
	public void spawnNote(int lane, double dropSpeed) {
		Note n = new Note(laneLocation[lane], -Settings.NOTE_SIZE, dropSpeed, this);
		notes.add(n);
		display.addDrawable(n);
	}

	/**
	 * Advances all the notes on the screen
	 */
	public void moveNotes() {
		for (Note n : notes) {
			n.move(0, n.dropSpeed);
		}
	}

	/**
	 * Prints the color of all notes to the console
	 */
	public void printAllNotes() {
		System.out.println("Notes");
		for (Note n : notes) {
			System.out.println(n.color);
		}
		System.out.println();
	}

	@Override
	public void removeNote(Note n) {
		notes.remove(n);
		display.removeDrawable(n);
	}

	@Override
	public ArrayList<Note> getNotes() {
		return notes;
	}

}
