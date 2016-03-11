package de.unidue.langtech.teaching.pp.Keyphrase_TextRank;

import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngine;
import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngineDescription;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.apache.uima.UIMAException;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.fit.factory.JCasFactory;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.junit.Test;

import de.tudarmstadt.ukp.dkpro.core.api.lexmorph.type.pos.ADJ;
import de.tudarmstadt.ukp.dkpro.core.api.lexmorph.type.pos.N;
import de.tudarmstadt.ukp.dkpro.core.api.lexmorph.type.pos.V;
import de.tudarmstadt.ukp.dkpro.core.stanfordnlp.StanfordParser;
import de.tudarmstadt.ukp.dkpro.core.tokit.BreakIteratorSegmenter;
import de.tudarmstadt.ukp.dkpro.keyphrases.core.type.Keyphrase;

public class CandidateSelectTest {

	// Nouns
	@Test
	public void testCandidateSelec1() throws UIMAException {

		String text = "A fly loves a good joke!";

		Set<String> expectedResults = new HashSet<String>();
        expectedResults.add("fly");
        expectedResults.add("loves");
        expectedResults.add("good");
        expectedResults.add("joke");


		JCas jcas = JCasFactory.createJCas();

		jcas.setDocumentText(text);

		AnalysisEngineDescription segmenter = createEngineDescription(BreakIteratorSegmenter.class);
		AnalysisEngine segEngine = createEngine(segmenter);
		segEngine.process(jcas);

		AnalysisEngineDescription parser = createEngineDescription(StanfordParser.class,
				StanfordParser.PARAM_LANGUAGE, "en", StanfordParser.PARAM_WRITE_POS, true);
		AnalysisEngine parse = createEngine(parser);
		parse.process(jcas);

		AnalysisEngineDescription showText = createEngineDescription(ShowDocumentText.class,
				ShowDocumentText.PARAM_SHOWTEXT, true);
		AnalysisEngine  show = createEngine(showText);
		show.process(jcas);

		System.out.println("------Nouns------");

        AnalysisEngineDescription selection2 = createEngineDescription(CandidateSelect.class,
				CandidateSelect.PARAM_FEATURE_PATH, N.class);
		AnalysisEngine select2 = createEngine(selection2);
        select2.process(jcas);

		int i=0;
        for (Keyphrase candidate : JCasUtil.select(jcas, Keyphrase.class)) {
        		assertTrue(expectedResults.contains(candidate.getKeyphrase()));
        		i++;
        }
		assertEquals(2, i);
	}

	//Adjectives
	@Test
	public void testCandidateSelec2() throws UIMAException {

		String text = "A fly loves a good joke";

		Set<String> expectedResults = new HashSet<String>();
		expectedResults.add("A");
        expectedResults.add("fly");
        expectedResults.add("loves");
        expectedResults.add("good");
        expectedResults.add("joke");


		JCas jcas = JCasFactory.createJCas();

		jcas.setDocumentText(text);

		AnalysisEngineDescription segmenter = createEngineDescription(BreakIteratorSegmenter.class);
		AnalysisEngine segEngine = createEngine(segmenter);
		segEngine.process(jcas);

		AnalysisEngineDescription parser = createEngineDescription(StanfordParser.class,
				StanfordParser.PARAM_LANGUAGE, "en", StanfordParser.PARAM_WRITE_POS, true);
		AnalysisEngine parse = createEngine(parser);
		parse.process(jcas);

		AnalysisEngineDescription showText = createEngineDescription(ShowDocumentText.class,
				ShowDocumentText.PARAM_SHOWTEXT, true);
		AnalysisEngine  show = createEngine(showText);
		show.process(jcas);

		System.out.println("------Adjectives------");

        AnalysisEngineDescription selection2 = createEngineDescription(CandidateSelect.class,
				CandidateSelect.PARAM_FEATURE_PATH, ADJ.class);
		AnalysisEngine select2 = createEngine(selection2);
        select2.process(jcas);

		int i=0;
        for (Keyphrase candidate : JCasUtil.select(jcas, Keyphrase.class)) {
        		assertTrue(expectedResults.contains(candidate.getKeyphrase()));
        		i++;
        }
		assertEquals(1, i);
	}

	//Verbs
	@Test
	public void testCandidateSelec3() throws UIMAException {

		String text = "A fly loves a good joke";

		Set<String> expectedResults = new HashSet<String>();
		expectedResults.add("A");
        expectedResults.add("fly");
        expectedResults.add("loves");
        expectedResults.add("good");
        expectedResults.add("joke");


		JCas jcas = JCasFactory.createJCas();

		jcas.setDocumentText(text);

		AnalysisEngineDescription segmenter = createEngineDescription(BreakIteratorSegmenter.class);
		AnalysisEngine segEngine = createEngine(segmenter);
		segEngine.process(jcas);

		AnalysisEngineDescription parser = createEngineDescription(StanfordParser.class,
				StanfordParser.PARAM_LANGUAGE, "en", StanfordParser.PARAM_WRITE_POS, true);
		AnalysisEngine parse = createEngine(parser);
		parse.process(jcas);

		AnalysisEngineDescription showText = createEngineDescription(ShowDocumentText.class,
				ShowDocumentText.PARAM_SHOWTEXT, true);
		AnalysisEngine  show = createEngine(showText);
		show.process(jcas);

		System.out.println("------Adjectives------");

		System.out.println("");
        AnalysisEngineDescription selection2 = createEngineDescription(CandidateSelect.class,
				CandidateSelect.PARAM_FEATURE_PATH, V.class);
		AnalysisEngine select2 = createEngine(selection2);
        select2.process(jcas);

		int i=0;
        for (Keyphrase candidate : JCasUtil.select(jcas, Keyphrase.class)) {
        		assertTrue(expectedResults.contains(candidate.getKeyphrase()));
        		i++;
        }
		assertEquals(1, i);
	}
}
