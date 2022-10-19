//Obviously this needs to go in a class.... probably the drvier...

	public static void main(String args[]) {
		CustomColor red = new CustomColor(255, 0, 0);
		CustomColor green = new CustomColor(0, 255, 0);
		CustomColor blue = new CustomColor(0, 0, 255);
		CustomColor white = new CustomColor(255, 255, 255);
		CustomColor black = new CustomColor(0, 0, 0);
		CustomColor tealish = new CustomColor(50, 150, 150);
		
		CustomColor orange = red.blend(green);
		System.out.println(orange.toString());
		System.out.println();
		
		CustomColor purple = green.blend(blue);
		System.out.println(purple.toString());
		System.out.println();
		
		CustomColor darkPurple = purple.darken();
		System.out.println(darkPurple);
		System.out.println("Is lighter than purple: " + darkPurple.isLighter(purple));
		System.out.println();
		
		Palette lightToDark = new Palette(white, black);
		lightToDark.printPalette();
		
		Palette variety = new Palette();
		variety.printPalette(); //all white (255, 255, 255)
		
		variety.colors[1] = variety.colors[1].blend(darkPurple);
		variety.colors[2] = orange.darken();
		variety.colors[3] = purple.lighten();
		variety.colors[4] = black;
		variety.printPalette();
		
		Palette monochromeTealish = new Palette(
				new CustomColor[] {
					tealish,
					tealish.lighten(),
					tealish.lighten().lighten(),
					tealish.lighten().lighten().lighten(),
					tealish.lighten().lighten().lighten().lighten()
				}
				);
		monochromeTealish.printPalette();
		System.out.println(monochromeTealish.getAverageColor().toString());
	}
