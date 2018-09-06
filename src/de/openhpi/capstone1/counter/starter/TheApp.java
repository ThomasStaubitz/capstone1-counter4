package de.openhpi.capstone1.counter.starter;


import de.openhpi.capstone1.counter.controller.CounterControllerStrategy;
import de.openhpi.capstone1.counter.model.Counter;
import de.openhpi.capstone1.counter.view.CounterViewColor;
import de.openhpi.capstone1.counter.view.CounterViewMove;
import de.openhpi.capstone1.counter.view.CounterViewNumber;
import processing.core.PApplet;

public class TheApp extends PApplet {

	CounterViewMove counterViewMove;
	CounterViewColor counterViewColor;
	CounterViewNumber counterViewNumber;
	CounterControllerStrategy counterControllerStrategy;
	Counter counter;

	@Override
	public void settings() {
		size(200, 200);
	}

	@Override
	public void setup() {  // setup() runs once
		frameRate(30);
		counter = new Counter();
		counterControllerStrategy = new CounterControllerStrategy(counter);
		counterViewMove = new CounterViewMove(this, counter);
		counterViewColor = new CounterViewColor(this, counter);
		counterViewNumber = new CounterViewNumber(this, counter);
	}

	@Override
	public void draw() {  // draw() loops forever, until stopped
		background(204);
		fill(255);
		rect(random(100),random(100), 10, 10);
		counterViewMove.update(); 
		counterViewColor.update(); 
		counterViewNumber.update();
	}
	
	@Override
	public void mouseClicked() {
		counterControllerStrategy.handleEvent();
	}
}
