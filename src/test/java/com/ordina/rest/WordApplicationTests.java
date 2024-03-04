package com.ordina.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.microshed.testing.SharedContainerConfig;
import org.microshed.testing.jaxrs.RESTClient;
import org.microshed.testing.jupiter.MicroShedTest;

import com.ordina.rest.analyzer.WordFrequencyAnalyzer;
import com.ordina.word.analyzer.WordFrequency;

@MicroShedTest
@SharedContainerConfig(SampleApplicationConfig.class)
class WordApplicationTests {

	@RESTClient
	WordFrequencyAnalyzer analyzer;

	private final String text = "Dat doen we door technologie, businessuitdagingen en mensen slim met elkaar te verbinden. We helpen onze klanten om hun snelheid te vergroten, slimme toepassingen te ontwikkelen, nieuwe digitale diensten te lanceren en te zorgen dat mensen ze omarmen.";
	
	@Test
	@DisplayName("test highest frequency")
	void testCalculateHighestFrequency() {
		try {
		assertEquals(5, analyzer.calculateHighestFrequency(text), " Highest frequency word is 'te' with 5 times");
		}catch(Exception ex) {
			
		}
	}

	@Test
	@DisplayName("test word frequency")
	void testCalculateFrequencyForWord() {
		assertEquals(2, analyzer.calculateFrequencyForWord(text, "Dat"), "Word of 'Dat' frequency is 2");
	}

	@Test
	@DisplayName("test most frequent words")
	void testCalculateMostFrequentNWords() {
		WordFrequency[] result = (WordFrequency[]) analyzer.calculateMostFrequentNWords(text, 2);
		assertEquals("te", result[0].getWord(), "Highest frequent word is 'te' with 5");
		assertEquals(5, result[0].getFrequency(), "Highest frequent word is 'te' with 5");
		assertEquals("dat", result[1].getWord(), "Second frequent word is 'dat' with 2");
		assertEquals(2, result[1].getFrequency(), "Second frequent word is 'dat' with 2");
	}

}
