package com.ordina.rest;


import com.ordina.rest.analyzer.WordFrequencyAnalyzer;
import com.ordina.word.analyzer.WordFrequencyAnalyzerImpl;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

@Path("check")
@RequestScoped
public class WordFrequency {

	@Inject
	WordFrequencyAnalyzer analyzer;
	
	@GET
	@Path("/calculateHighestFrequency")
	public int calculateHighestFrequency(@QueryParam("text") String text) {
		return analyzer.calculateHighestFrequency(text);
	}

	@GET
	@Path("/calculateFrequencyForWord")
	public int calculateFrequencyForWord(@QueryParam("text") String text, @QueryParam("word") String word) {
		return analyzer.calculateFrequencyForWord(text, word);
	}

	@GET
	@Path(value = "/calculateMostFrequentNWords")
	public WordFrequency[] calculateMostFrequentNWords(@QueryParam("text") String text,
			@QueryParam("number") int number) {
		return (WordFrequency[]) analyzer.calculateMostFrequentNWords(text, number);
	}
}
