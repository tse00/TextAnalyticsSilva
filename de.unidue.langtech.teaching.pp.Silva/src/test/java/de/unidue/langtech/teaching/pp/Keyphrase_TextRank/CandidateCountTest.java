package de.unidue.langtech.teaching.pp.Keyphrase_TextRank;

import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngine;
import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngineDescription;
import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.apache.uima.UIMAException;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.fit.factory.JCasFactory;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.junit.Test;

import de.tudarmstadt.ukp.dkpro.core.stanfordnlp.StanfordParser;
import de.tudarmstadt.ukp.dkpro.core.tokit.BreakIteratorSegmenter;
import de.unidue.langtech.teaching.pp.type.CountPosCandidate;
import de.tudarmstadt.ukp.dkpro.core.api.lexmorph.type.pos.ADJ;
import de.tudarmstadt.ukp.dkpro.core.api.lexmorph.type.pos.N;
import de.tudarmstadt.ukp.dkpro.core.api.lexmorph.type.pos.V;
import de.tudarmstadt.ukp.dkpro.core.maltparser.MaltParser;
import de.tudarmstadt.ukp.dkpro.core.opennlp.OpenNlpPosTagger;


public class CandidateCountTest {

	@Test
	public void testCountCandidate1() throws UIMAException {


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

		AnalysisEngineDescription count1 = createEngineDescription(CandidateCount.class,
				CandidateCount.PARAM_FEATURE_PATH, N.class);
		AnalysisEngine countselected1 = createEngine(count1);
		countselected1.process(jcas);


        CountPosCandidate countN = JCasUtil.selectSingle(jcas,
        		CountPosCandidate.class);

		assertEquals(2, countN.getCountCandidate());

	}

	@Test
	public void testCountCandidate2() throws UIMAException {

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

		System.out.println("------Adjectives------");

		AnalysisEngineDescription count1 = createEngineDescription(CandidateCount.class,
				CandidateCount.PARAM_FEATURE_PATH, ADJ.class);
		AnalysisEngine countselected1 = createEngine(count1);
		countselected1.process(jcas);

        CountPosCandidate countADJ = JCasUtil.selectSingle(jcas,
        		CountPosCandidate.class);

		assertEquals(1, countADJ.getCountCandidate());

	}

	@Test
	public void testCountCandidate3() throws UIMAException {

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

		System.out.println("------Verbs------");

		AnalysisEngineDescription count1 = createEngineDescription(CandidateCount.class,
				CandidateCount.PARAM_FEATURE_PATH, V.class);
		AnalysisEngine countselected1 = createEngine(count1);
		countselected1.process(jcas);

        CountPosCandidate countV = JCasUtil.selectSingle(jcas,
        		CountPosCandidate.class);

		assertEquals(1, countV.getCountCandidate());

	}
}
