package THUBPROJECT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import THUBPROJECT.dto.PrivMessage;
import THUBPROJECT.service.PrivMessageService;

@RestController // Rest controller
@RequestMapping("/api")
public class PrivMessageController {

	// Implement service
	@Autowired
	PrivMessageService privMessageService;

	// Get Mappings
	@GetMapping("/privMessages")
	public List<PrivMessage> listPrivMessages() {
		return privMessageService.listprivMessages();
	}

	@GetMapping("/privMessages/{id}")
	public PrivMessage privMessageById(@PathVariable(name = "id") Long id) {
		PrivMessage privMessagesxID = new PrivMessage();
		privMessagesxID = privMessageService.privMessageById(id);
		return privMessagesxID;
	}

	// Post Mappings
	@PostMapping("/privMessages")
	public PrivMessage savePrivMessage(@RequestBody PrivMessage privMessage) {
		return privMessageService.savePrivMessage(privMessage);
	}

	// Put Mappings
	@PutMapping("/privMessages/{id}")
	public PrivMessage updatePrivMessage(@PathVariable(name = "id") Long id, @RequestBody PrivMessage privMessage) {
		PrivMessage selectedPrivMessage = new PrivMessage(id, privMessage.getContent(), privMessage.getTimestamp(), privMessage.getSender(), privMessage.getReceiver());
		PrivMessage updatedPrivMessage = new PrivMessage();
		updatedPrivMessage = privMessageService.updatePrivMessage(selectedPrivMessage);
		return updatedPrivMessage;
	}

	// Delete Mappings
	@DeleteMapping("/privMessages/{id}")
	public void deletePrivMessage(@PathVariable(name = "id") Long id) {
		privMessageService.deletePrivMessage(id);
	}

}

