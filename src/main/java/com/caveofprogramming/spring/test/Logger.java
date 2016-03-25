package com.caveofprogramming.spring.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import javax.annotation.*;

/*
 * Dummy implementation of logger.
 */

public class Logger {

	// @Autowired
	private ConsoleWriter consoleWriter;
	// @Autowired
	private LogWriter fileWriter;

	/*
	 * @Autowired public Logger(ConsoleWriter consoleWriter, FileWriter
	 * fileWriter) { this.consoleWriter = consoleWriter; this.fileWriter =
	 * fileWriter; }
	 */
/*	@Autowired
	@Qualifier("toconsole")
*/	
	@Resource
	public void setConsoleWriter(ConsoleWriter writer) {
		this.consoleWriter = writer;
	}

/*	@Autowired
	@Qualifier("filewriter")
*/	
	@Resource(name="squirrel")
	public void setFileWriter(LogWriter fileWriter) {
		this.fileWriter = fileWriter;
	}

	public void writeFile(String text) {
		fileWriter.write(text);
	}

	public void writeConsole(String text) {
		if (consoleWriter != null) {
			consoleWriter.write(text);
		}
	}

	@PostConstruct
	public void init() {
		System.out.println("init");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("destroy");
	}
}
