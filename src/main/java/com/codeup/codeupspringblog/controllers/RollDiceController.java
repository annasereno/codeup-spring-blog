package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller

public class RollDiceController {


	@GetMapping ("/roll-dice")
		public String rollDice() {
		return "roll-dice";
	}

	@GetMapping("/roll-dice/{guess}")
	public String numberGuessed(@PathVariable int guess){
		Random rnd = new Random();
		//generate a random number from 1 to 6
		int roll = rnd.nextInt(6);//returns a number from 0 - 5
		roll ++; // shift it to 1-6
		String message = String.format("you guessed %d. The correct number is %d" + guess, roll);
		if (guess == roll){
			message = "your numbers match";
		} else {
			message = "you lost";
		}
		return "You guessed the number " + guess;
	}

//	@PostMapping("/roll-dice/{n}")
//	public String selectNumberGuess(@PathVariable String n, Model model){
//		model.addAttribute("numberGuess", n);
//		return "roll-dice/{n}";
//	}


}
