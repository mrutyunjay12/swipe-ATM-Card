package com.api.context;

import java.util.HashMap;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class UserTestContext {
	final public static StringBuilder loggers = new StringBuilder();
	private Logger appLog = Logger.getLogger("MDES LOG");
	private Logger dbLog = Logger.getLogger("Query LOG");

	protected HashMap<String, HashMap<String, Object>> contextMap;
	private String storyName = null;

	public String getStoryName() {
	return storyName;
	}

	public void setStoryName(String storyName) {
	this.storyName = storyName;
	}

	public UserTestContext() {
	contextMap = new HashMap<String, HashMap<String, Object>>();
	}

	public void put(String storyName, String key, Object value) throws IllegalArgumentException {
	if (contextMap.get(storyName) == null) {
	HashMap<String, Object> newMap = new HashMap<>();
	newMap.put(key, value);
	contextMap.put(storyName, newMap);

	} else {
	HashMap<String, Object> eMap = contextMap.get(storyName);
	eMap.put(key, value);
	contextMap.put(storyName, eMap);

	}

	}

	public void put(String storyName, HashMap<String, Object> hMap) throws IllegalArgumentException {

	if (contextMap.get(storyName) == null) {
	contextMap.put(storyName, hMap);

	} else {
	HashMap<String, Object> eMap = contextMap.get(storyName);

	for (String key : hMap.keySet()) {
	eMap.put(key, hMap.get(key));

	}
	contextMap.put(storyName, eMap);
	}

	}

	@SuppressWarnings("unchecked")
	public <T> T get(String storyName, String key) throws IllegalArgumentException {

	HashMap<String, Object> eMap = contextMap.get(storyName);

	return (T) eMap.get(key);

	}

	public HashMap<String, Object> get(String storyName) throws IllegalArgumentException {

	return contextMap.get(storyName);

	}

	public void clear() {
	contextMap.clear();
	}

	public HashMap<String, HashMap<String, Object>> getContextMap() {
	return contextMap;
	}

	public void setContextMap(HashMap<String, HashMap<String, Object>> contextMap) {
	this.contextMap = contextMap;
	}

	public Logger getAppLog() {
	return appLog;
	}

	public void setAppLog(Logger appLog) {
	this.appLog = appLog;
	}

	public Logger getDbLog() {
	return dbLog;
	}

	public void setDbLog(Logger dbLog) {
	this.dbLog = dbLog;
	}

	public static StringBuilder getLoggers() {
	return loggers;
	}
	}



