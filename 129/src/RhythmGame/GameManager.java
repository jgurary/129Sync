package RhythmGame;

import java.util.ArrayList;

public class GameManager {

	// TODO miss counter
	// TODO hit detection for notes
	// TODO more precticable and rhythmic spawning
	// TODO remove notes from the list when they leave the screen...

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
	int misses = 0;

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
		if (ticks % Settings.TICKS_BETWEEN_NOTES == 0) {
			spawnNote((int) (Math.random() * NUMBER_OF_HITZONES));
		}
		moveNotes();
		for (Note n : notes) {
			n.tickAnimation();
		}
		checkMisses();
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
					// TODO do some stuff with the score and whatever....
				}
			}
		}
	}

	/**
	 * Checks if a shape has crossed the threshold to count as a miss
	 */
	public void checkMisses() {
		for (Note n : notes) {
			if (!n.isMiss()) {
				if (n.display.y > display.getHeight()) {
					n.miss();
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
				Math.random() * Settings.NOTE_SPEED_RANGE + Settings.MIN_NOTE_SPEED);
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
		Note n = new Note(laneLocation[lane], -Settings.NOTE_SIZE, dropSpeed);
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

}
