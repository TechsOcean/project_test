package com.messaging;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tweet {
	private Integer id;
	
	private String content;
	
	private String author;
	
	private LocalDateTime timeStamp;
	
	private int like;
	
	private Map<String, List<String>> reply;
	
	public Tweet(Integer id, String content, String author, LocalDateTime timeStamp) {
		super();
		this.id = id;
		this.content = content;
		this.author = author;
		this.timeStamp = timeStamp;
		this.like = 0;
		this.reply = new HashMap<>();
	}

	@Override
	public String toString() {
//		return "Tweet [content=" + content + ", timeStamp=" + timeStamp + "]";
		return author
				.concat("  like:" + like +"   " + timeStamp)
				.concat("\n")
				.concat("    tweet--> \"" +content + "\"")
				.concat("\n");
	}

	public void reTweet(String reply) {
		
	}
	
	public int like() {
		this.like++;
		return this.like;
	}
	
	public String reply() {
		return null;
	}
	
	
	/*
	 * getters and setters;
	 */
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	public Map<String, List<String>> getReply() {
		return reply;
	}

	public void setReply(Map<String, List<String>> reply) {
		this.reply = reply;
	}

}
