package com.codepumpkin.behavioral.mediator;

import java.util.ArrayList;

public class ObserverDesignPatternDemo {

	public static void main(String[] args) {
		Celebrity amirkhan = new Celebrity("Amirkhan");
		Celebrity selenaGomez = new Celebrity("Selena Gomez");

		Follower amar = new Follower("Amar");
		Follower juhi = new Follower("Juhi");
		Follower urja = new Follower("Urja");
		Follower malay = new Follower("Malay");
		Follower ankit = new Follower("Ankit");
		Follower harsh = new Follower("Harsh");

		amirkhan.register(amar);
		amirkhan.register(juhi);
		amirkhan.register(urja);

		selenaGomez.register(malay);
		selenaGomez.register(ankit);
		selenaGomez.register(harsh);

		amirkhan.tweet("Hey guys, came across this interesting trailer, check it out.");
		selenaGomez.tweet("Good Morning..!!");

		amirkhan.unregister(juhi);

		amirkhan.tweet("Teaser of Secret Superstar has been released..!!");

	}

}

/**
 * This interface handles adding, deleting and updating all observers
 */
interface Subject {
	public void register(Observer o);

	public void unregister(Observer o);

	public void notifyAllObservers(String s);
}

/**
 * The Observers update method is called when the Subject changes
 */
interface Observer {
	public void update(String name, String s);
}

/**
 * This class extends Subject interface.
 */
class Celebrity implements Subject {

	private String celebrityName; // name of the celebrity
	private ArrayList<Observer> followers; // list of followers

	public Celebrity(String celebrityName) {
		this.celebrityName = celebrityName;
		followers = new ArrayList<Observer>();
	}

	/**
	 * add follower to the celebrity's registered follower list
	 */
	@Override
	public void register(Observer o) {
		followers.add(o);
		System.out.println(o + " has started following " + celebrityName);
	}

	/**
	 * remove follower from celebrity's registered follower list
	 */
	@Override
	public void unregister(Observer o) {
		followers.remove(o);
		System.out.println(o + " has stopped following " + celebrityName);
	}

	/**
	 * Notify all the registered followers
	 */
	@Override
	public void notifyAllObservers(String tweet) {
		for (Observer follower : followers) {
			follower.update(celebrityName, tweet);
		}
		System.out.println();
	}

	/**
	 * This method updates the tweet. It will internally call
	 * notifyAllObservers(tweet) method after updating the tweet.
	 * 
	 */
	public void tweet(String tweet) {

		System.out.println("\n" + celebrityName + " has tweeted :: " + tweet + "\n");

		notifyAllObservers(tweet);
	}

}

/**
 * This class extends Observer interface.
 */
class Follower implements Observer {

	private String followerName;

	public Follower(String followerName) {
		this.followerName = followerName;
	}

	/**
	 * This method will be called to update all followers regarding the new
	 * tweet posted by celebrity.
	 */
	@Override
	public void update(String celebrityName, String tweet) {
		System.out.println(followerName + " has received " + celebrityName + "'s tweet :: " + tweet);

	}

	@Override
	public String toString() {
		return followerName;
	}

}
