package HW7;

import java.awt.Graphics2D;

public class Tower {

	Block[] blocks = new Block[40];
	int nextBlock = 0;

	/**
	 * Adds a block to the tower. If the tower is full, does nothing.
	 * 
	 * @param b
	 */
	public void addBlock(Block b) {
		if (nextBlock > blocks.length - 1) {
			return;
		}
		blocks[nextBlock] = b;
		nextBlock++;
	}

	/**
	 * Checks the load capacity of all blocks in the tower against the blocks above
	 * them
	 */
	public void checkBlocks() {
		for (int i = 0; i < blocks.length; i++) {
			if (blocks[i] != null) {
				int totalWeight = 0;
				for (int k = i + 1; k < blocks.length; k++) {
					if (blocks[k] != null) {
						totalWeight += blocks[k].weight;
					}
				}
				blocks[i].checkFailed(totalWeight);
			}
		}
	}

	/**
	 * Draws all the blocks in the tower
	 * 
	 * @param g
	 */
	public void draw(Graphics2D g) {
		for (int i = 0; i < blocks.length; i++) {
			if (blocks[i] != null) {
				blocks[i].draw(g);
			}
		}
	}

	/**
	 * Places the display elements of the tower's blocks using the given x and y
	 * location as the top-left corner of the bottom block. Note that index 0 of
	 * {@link #blocks} is the bottom, and the last index is the top
	 * 
	 * @param xStart
	 * @param yStart
	 */
	public void placeBlockDisplays(double xStart, double yStart) {
		double y = yStart;
		for (int i = 0; i < blocks.length; i++) {
			if (blocks[i] != null) {
				blocks[i].setDisplayLocation(xStart, y);
				y -= Block.BLOCK_HEIGHT;
			}
		}
	}

}
