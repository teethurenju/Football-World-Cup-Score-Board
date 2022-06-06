package com.test;

import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Test;
import com.dto.TeamDto;
import com.football.match.FootballScoreBoard;

public class FootballScoreBoardTest {

	@Test
	public void testStartGame() {
		String expectedOutput = "Match Live Score :- Mexico 0 - Canada 0";
		String actualOutput = null;
		actualOutput = FootballScoreBoard.startGame("Mexico", "Canada");
		assertEquals(expectedOutput, actualOutput);

	}

	@Test
	public void testFinishGame() {
		String expectedOutput = "Game finished.";
		String actualOutput = null;
		actualOutput = FootballScoreBoard.finishGame();
		assertEquals(expectedOutput, actualOutput);

	}

	@Test
	public void testUpdateGame() {
		String expectedOutput = "Match Live Score :- Spain 10 - Brazil 2";
		String actualOutput = null;
		FootballScoreBoard.startGame("Spain", "Brazil");
		actualOutput = FootballScoreBoard.updateGame(10, 2);
		assertEquals(expectedOutput, actualOutput);

	}

	@Test
	public void testSummaryGame() {

		FootballScoreBoard.startGame("Mexico", "Canada");
		FootballScoreBoard.updateGame(0, 2);
		FootballScoreBoard.updateGame(0, 1);
		FootballScoreBoard.updateGame(0, 2);
		FootballScoreBoard.finishGame();

		FootballScoreBoard.startGame("Spain", "Brazil");
		FootballScoreBoard.updateGame(2, 0);
		FootballScoreBoard.updateGame(3, 1);
		FootballScoreBoard.updateGame(4, 1);
		FootballScoreBoard.updateGame(1, 0);
		FootballScoreBoard.finishGame();

		FootballScoreBoard.startGame("Germany", "France");
		FootballScoreBoard.updateGame(1, 0);
		FootballScoreBoard.updateGame(0, 0);
		FootballScoreBoard.finishGame();

		List<TeamDto> actualOutput = FootballScoreBoard.getMatchSummary();
		assertEquals(3, actualOutput.size());
		assertEquals("Mexico", actualOutput.get(0).getHomeTeam());
		assertEquals(0, actualOutput.get(0).getHomeTeamScore());
		assertEquals("Spain", actualOutput.get(1).getHomeTeam());
		assertEquals("Germany", actualOutput.get(2).getHomeTeam());

	}

}
