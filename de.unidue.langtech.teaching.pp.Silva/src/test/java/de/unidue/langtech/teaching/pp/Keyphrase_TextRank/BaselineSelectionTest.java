package de.unidue.langtech.teaching.pp.Keyphrase_TextRank;

import org.apache.uima.UIMAException;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.JCasFactory;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.junit.Test;

import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineDescription;

import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngine;
import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngineDescription;
import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;


import de.tudarmstadt.ukp.dkpro.core.stanfordnlp.StanfordParser;
import de.tudarmstadt.ukp.dkpro.core.tokit.BreakIteratorSegmenter;
import de.tudarmstadt.ukp.dkpro.keyphrases.core.type.Keyphrase;
import de.unidue.langtech.teaching.pp.type.MyType;
import de.unidue.langtech.teaching.pp.type.MyType2;

public class BaselineSelectionTest {

    //Both Nouns and Adjectives must be presented on the text and will be displayed

	@Test
	public void testSelection() throws UIMAException {

		String text = "example sentence funny. second example";

		Set<String> expectedResults = new HashSet<String>();
        expectedResults.add("example");
        expectedResults.add("sentece");
        expectedResults.add("funny");
        expectedResults.add("second");


		JCas jcas = JCasFactory.createJCas();

		jcas.setDocumentText(text);

		AnalysisEngineDescription segmenter = createEngineDescription(BreakIteratorSegmenter.class);
		AnalysisEngine segEngine = createEngine(segmenter);
		segEngine.process(jcas);

		AnalysisEngineDescription parser = createEngineDescription(StanfordParser.class,
				StanfordParser.PARAM_LANGUAGE, "en", StanfordParser.PARAM_WRITE_POS, true);
		AnalysisEngine parse = createEngine(parser);
		parse.process(jcas);

		AnalysisEngineDescription selection = createEngineDescription(BaselineSelection.class);
		AnalysisEngine select = createEngine(selection);
		select.process(jcas);

		int i=0;
        for (Keyphrase candidate : JCasUtil.select(jcas, Keyphrase.class)) {

            assertTrue(expectedResults.contains(candidate.getKeyphrase()));
            i++;
        }

        // Nouns + Adjectives = 2
		assertEquals(2, i);

	}
}
