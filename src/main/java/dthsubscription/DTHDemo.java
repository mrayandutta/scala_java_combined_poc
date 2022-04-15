package dthsubscription;

import pizza.decorator.LargeSizeDecorator;
import pizza.decorator.MediumSizeDecorator;
import pizza.decorator.NonVegPizza;
import pizza.decorator.Pizza;
import pizza.decorator.VegPizza;

public class DTHDemo {
	public static void main(String[] args) {
		Subscription musicSubscription = new MusicSubscription();
		Subscription sportsSubscription = new SportsSubscription();
		Subscription bengaliSports = new BengaliLanguageDecorator(sportsSubscription);
		Subscription englishMusic = new EnglishLanguageDecorator(musicSubscription);
		
		
		System.out.println(bengaliSports.getDescription()+","+bengaliSports.getPrice());
		System.out.println(englishMusic.getDescription()+","+englishMusic.getPrice());
	}

}
