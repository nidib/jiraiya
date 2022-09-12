package com.nidib.jiraiya.controllers;

import com.nidib.jiraiya.apps.updater.BasicInfoUpdater;
import com.nidib.jiraiya.responses.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/update")
public class UpdateController {
	private final BasicInfoUpdater basicInfoUpdater;

	@Autowired
	public UpdateController(BasicInfoUpdater basicInfoUpdater) {
		this.basicInfoUpdater = basicInfoUpdater;
	}

	@GetMapping()
	public ResponseObject<Void> update(@RequestParam(required = false) String board) {
		if (board == null) {
			throw new RuntimeException("Query parameter 'board' is required");
		}

		this.basicInfoUpdater.update(board);

		return new ResponseObject<>("Board " + board + " updated!");
	}
}