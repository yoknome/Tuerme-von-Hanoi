package com.company;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// load necessary stuff
		var in = new Scanner(System.in);
		var var = new Variables();

		// show fresh game and rules
		System.out.println(var.TITLE);
		var.setGame(var.GAME_DEFAULT);
		printGame(var.getGame());
		System.out.println(var.RULES);
		System.out.println(var.DESCR);
		System.out.println(var.ZIEL);

		// play until user won the game
		while(var.getGame()[1][2]==0) {
			System.out.print(var.MOVE);
			if(in.hasNext("[123],[123]")) {
				changeGame(var.getGame(), in.next());
			} else {
				in.next();
				System.out.println(var.INVALID_ENTRY);
			}
		}

		System.out.println(var.WON);

	}

	private static void changeGame(int[][] game, String s) {
		var var = new Variables();
		String[] move = s.split(",",2);
		int towerFrom = Integer.parseInt(move[0])-1;
		int towerTo = Integer.parseInt(move[1])-1;
		int discFrom = 0; int discSize = 0;

		// get the size of the disc and remember it's placement
		for(int i=1;i<game.length;i++) {
			if(game[i][towerFrom]!=0) {
				discFrom = i;
				discSize = game[discFrom][towerFrom];
				break;
			}
		}
		if(discSize==0) {
			System.out.println(var.NO_DISC);
			return;
		}

		//
		if(game[game.length-1][towerTo]==0) {
			game[discFrom][towerFrom] = 0;
			game[game.length-1][towerTo] = discSize;
			var.setGame(game);
			printGame(var.getGame());
			return;
		} else {
			for(int i=1;i<game.length;i++) {
				if(game[i][towerTo]!=0) {
					if(game[i][towerTo]<discSize) {
						System.out.println(var.INVALID_MOVE);
					} else if (game[i][Integer.parseInt(move[1])-1]>discSize) {
						game[discFrom][towerFrom] = 0;
						game[i-1][towerTo] = discSize;
						var.setGame(game);
						printGame(var.getGame());
						return;
					} else {
						System.out.println(var.ERROR);
					}
					break;
				}
			}
		}
	}

	private static void printGame(int[][] game) {
		String[] part = {
				"     |     ",
				"    ■|■    ",
				"   ■■|■■   ",
				"  ■■■|■■■  "};

		for(int i=0;i<game.length;i++) {
			String gameRow = "";
			for(int j=0;j<game[i].length;j++) {
				gameRow = gameRow + part[game[i][j]];
			}
			System.out.println(gameRow);
		}
		String floor = "████ 1 ████████ 2 ████████ 3 ████";
		System.out.println(floor);
	}
}
