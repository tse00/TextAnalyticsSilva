package de.unidue.langtech.teaching.pp.example;

import static org.junit.Assert.assertEquals;

import org.apache.uima.collection.CollectionReaderDescription;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.JCasIterable;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.junit.Test;

import de.unidue.langtech.teaching.pp.type.GoldLanguage;

public class ReaderProjectTest {

	public void testReaderExample() throws Exception {
		CollectionReaderDescription reader = CollectionReaderFactory
				.createReaderDescription(ReaderExample.class, ReaderExample.PARAM_INPUT_FILE,
						"src/test/resources/test/randomtext.txt");
	}
}
