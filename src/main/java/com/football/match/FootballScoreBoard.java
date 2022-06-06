package com.football.match;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.dto.TeamDto;

public class FootballScoreBoard {

	public static List<TeamDto> matchList = new ArrayList<>();
	private static TeamDto teamDto;
	private static boolean matchStatus = false;

	/**
	 * Initial call to invoke the Football World Cup Score Board
	 * 
	 * Choices 
	 * 1. To start the game :- Press 'S' 
	 * 2. To update the score of the game :- Press 'U'
	 * 3. To finish the game :- Press 'F' 
	 * 4. To get the summary of game :- Press 'R'
	 * 5. To quit the game :- Press 'Q'
	 */
	private static String scoreBoardMenu() throws IOException {

		InputStreamReader inputStreamReader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String matchChoice;

		while (true) {

			System.out.println("Select your choice: \n");

			matchChoice = bufferedReader.readLine();

			switch (matchChoice) {

			case "S":
				if (matchStatus) {
					System.out.println("Match is in progress, You have to finish the current match \n");
				} else {
					System.out.println("Enter home team \n");
					String homeTeam = bufferedReader.readLine();
					System.out.println("Enter away team \n");
					String awayTeam = bufferedReader.readLine();
					startGame(homeTeam, awayTeam);

				}
				break;

			case "F":
				if (!matchStatus) {
					System.out.println("Start the game. Then only you can finish a game \n");
				} else {
					finishGame();
				}
				break;

			case "U":
				if (!matchStatus) {
					System.out.println("Start the game. Then only you can finish a game \n");
				} else {
					System.out.println("Enter home team score \n");
					int homeTeamScore = Integer.parseInt(bufferedReader.readLine());
					System.out.println("Enter away team score \n");
					int awayTeamScore = Integer.parseInt(bufferedReader.readLine());

					updateGame(homeTeamScore, awayTeamScore);

				}
				break;

			case "R":
				if (!matchList.isEmpty()) {

					getMatchSummary();

					for (TeamDto teamDto : matchList) {
						showMatchSummary(teamDto);
					}

				} else {
					System.out.println("There are no matches. Please start a game. \n");

				}

				break;

			case "Q":
				System.exit(0);

			default:
				System.out.println("Invalid match choice \n");
			}

		}

	}

	/**
	 * Method to start game. If matchStatus = true, live match is going on Else will
	 * call the start game method
	 *
	 * @param homeTeam Home Team name.
	 * @param awayTeam Away Team name.
	 * @return
	 */
	public static String startGame(String homeTeam, String awayTeam) {
		teamDto = new TeamDto();
		teamDto.setHomeTeam(homeTeam);
		teamDto.setAwayTeam(awayTeam);
		teamDto.setHomeTeamScore(0);
		teamDto.setAwayTeamScore(0);

		matchStatus = true;
		showMatchScore();

		return "Match Live Score :- " + teamDto.getHomeTeam() + " " + teamDto.getHomeTeamScore() + " - "
				+ teamDto.getAwayTeam() + " " + teamDto.getAwayTeamScore();
	}

	/**
	 * Method to finish game. If matchStatus = false, no match is started Else will
	 * call the finish game method Add all the finished match details to a list
	 *
	 * @return
	 */
	public static String finishGame() {
		matchStatus = false;
		matchList.add(teamDto);
		System.out.println("Game finished. \n");

		return "Game finished.";
	}

	/**
	 * Method to update game. If matchStatus = false, no match to update the score
	 * Else will call the update game method
	 * 
	 * @param homeTeamScore Home Team score.
	 * @param awayTeamScore Away Team score.
	 * @return
	 */
	public static String updateGame(int homeTeamScore, int awayTeamScore) {
		teamDto.setHomeTeamScore(homeTeamScore);
		teamDto.setAwayTeamScore(awayTeamScore);
		showMatchScore();

		return "Match Live Score :- " + teamDto.getHomeTeam() + " " + teamDto.getHomeTeamScore() + " - "
				+ teamDto.getAwayTeam() + " " + teamDto.getAwayTeamScore();
	}

	/**
	 * Method to get summary of the match. 
	 * If match list is not empty call getMatchSummary method
	 * Else no matches are going on. Start the game
	 * Get the match list which holds the details of matches which is completed
	 * Reverse the list, since we need last completed match should come in the list first 
	 * Sort the list based on the total goal scored in the match 
	 * Show the match summary with the sorted list
	 * 
	 * @return
	 */
	public static List<TeamDto> getMatchSummary() {
		System.out.println("Summary Of Games By Total Score \n");

		Collections.reverse(matchList);

		matchList.sort((o1, o2) -> {
			if ((o1.getHomeTeamScore() + o1.getAwayTeamScore()) < (o2.getHomeTeamScore() + o2.getAwayTeamScore())) {
				return 1;
			} else if ((o1.getHomeTeamScore() + o1.getAwayTeamScore()) > (o2.getHomeTeamScore()
					+ o2.getAwayTeamScore())) {
				return -1;
			}
			return 0;
		});

		return matchList;

	}

	/**
	 * Method to show the match live score
	 */
	private static void showMatchScore() {
		System.out.println("Match Live Score :- " + teamDto.getHomeTeam() + " " + teamDto.getHomeTeamScore() + " - "
				+ teamDto.getAwayTeam() + " " + teamDto.getAwayTeamScore() + "\n");

	}

	/**
	 * Method to show the match summary
	 * 
	 * @param teamDto contains all the match details
	 */
	public static void showMatchSummary(TeamDto teamDto) {

		System.out.println(teamDto.getHomeTeam() + " " + teamDto.getHomeTeamScore() + " - " + teamDto.getAwayTeam()
				+ " " + teamDto.getAwayTeamScore() + "\n");

	}

	public static void main(String args[]) throws IOException {
		System.out.println("Football World Cup \n");
		System.out.println("Press 'S' to start a game");
		System.out.println("Press 'F' to finish current game.");
		System.out.println("Press 'U' to update current game score");
		System.out.println("Press 'R' to get a summary.");
		System.out.println("Press 'Q' to quit \n");

		scoreBoardMenu();
	}

}
