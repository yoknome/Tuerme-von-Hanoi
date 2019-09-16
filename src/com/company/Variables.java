package com.company;

class Variables {

	final String TITLE = "\n\tDie Türme von Hanoi\n";
	final String RULES = "\nRegeln\n1. Nur die oberste Scheibe eines Turmes kann bewegt werden.\n2. Scheiben dürfen nur über größeren plaziert werden.";
	final String DESCR = "Gebe deine Züge im Muster \"1,3\" ohne die Anführungszeichen ein, \nwobei die erste Zahl den Turm darstellt, von dem eine Scheibe genommen werden soll, \nund die zweite, auf welchen Turm die Scheibe gelegt werden Soll.";
	final String ZIEL = "Ziel ist es, alle Scheiben auf den dritten Turm zu stapeln.\n";
	final String DESCR_MULT = "Mehrere Züge können mit Semikolon getrennt eingegeben werden.";
	final String MOVE = "Gebe deinen nächsten zug ein:";
	final String WON = "YOU WON!";
	final String ERROR = "error";
	final String INVALID_ENTRY = "Gebe deine Züge im Muster \"1,3\" ohne die Anführungszeichen ein.";
	final String INVALID_MOVE = "Die Scheibe ist zu groß um sie dort abzulegen.";
	final String NO_DISC= "Auf dem Turm lag keine Scheibe zum bewegen.";
	final int[][] GAME_DEFAULT = {
			{0, 0, 0},
			{1, 0, 0},
			{2, 0, 0},
			{3, 0, 0}
	};
	private int[][] game;

	void setGame(int[][] game) {
		this.game = game;
	}

	int[][] getGame() {
		return game;
	}
}
