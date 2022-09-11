package com.nidib.jiraiya.database.services;

import com.nidib.jiraiya.database.entities.Board;
import com.nidib.jiraiya.database.repositories.BoardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
	@Autowired
	private BoardRepository boardRepository;

	public void saveBoard(Board board) {
		boardRepository.save(board);
	}
}