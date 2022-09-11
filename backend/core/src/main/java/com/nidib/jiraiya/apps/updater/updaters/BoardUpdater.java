package com.nidib.jiraiya.apps.updater.updaters;

import com.nidib.jiraiya.apis.jira.repositories.JiraBoardRepository;
import com.nidib.jiraiya.database.entities.Board;
import com.nidib.jiraiya.database.services.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoardUpdater {
	@Autowired
	private JiraBoardRepository jiraBoardRepository;
	@Autowired
	private BoardService boardService;

	public void update(String boardId) {
		Board board = this.jiraBoardRepository.getBoardById(boardId).toEntity();

		this.boardService.saveBoard(board);
		System.out.println("Board: ✅");
	}
}