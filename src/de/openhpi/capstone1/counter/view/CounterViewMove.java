package de.openhpi.capstone1.counter.view;

import de.openhpi.capstone1.counter.model.Counter;
import processing.core.PApplet;

public class CounterViewMove extends AbstractCounterView {
		
	public CounterViewMove(PApplet display, Counter counter) {
		super(display, counter);
	}
	
	@Override
	public void update() {
		try {
			int x = counter.getCount();
			display.fill(0);
			display.rect(x, 10, 10, 10);
			display.redraw();
		} catch (ClassCastException e) {
			System.out.println(e.getMessage());
		}
	}
}
