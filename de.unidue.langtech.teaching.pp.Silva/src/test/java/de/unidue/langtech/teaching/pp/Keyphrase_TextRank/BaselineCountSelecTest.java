package de.unidue.langtech.teaching.pp.Keyphrase_TextRank;

import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngine;
import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngineDescription;
import static org.junit.Assert.assertEquals;

import org.apache.uima.UIMAException;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.fit.factory.JCasFactory;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.junit.Test;

import de.tudarmstadt.ukp.dkpro.core.stanfordnlp.StanfordParser;
import de.tudarmstadt.ukp.dkpro.core.tokit.BreakIteratorSegmenter;
import de.unidue.langtech.teaching.pp.type.CountPos1;
import de.unidue.langtech.teaching.pp.type.CountPos2;
import de.unidue.langtech.teaching.pp.type.MyType;


public class BaselineCountSelecTest {

	//Count the Number of Nouns and Adjectives

	@Test
	public void testCountSelec() throws UIMAException {

		String text = "example sentence funny. second example";

		JCas jcas = JCasFactory.createJCas();

		jcas.setDocumentText(text);

		AnalysisEngineDescription segmenter = createEngineDescription(BreakIteratorSegmenter.class);
		AnalysisEngine segEngine = createEngine(segmenter);
		segEngine.process(jcas);

		AnalysisEngineDescription parser = createEngineDescription(StanfordParser.class,
				StanfordParser.PARAM_LANGUAGE, "en", StanfordParser.PARAM_WRITE_POS, true);
		AnalysisEngine parse = createEngine(parser);
		parse.process(jcas);

		AnalysisEngineDescription selection = createEngineDescription(BaselineCountSelect.class);
		AnalysisEngine select = createEngine(selection);
		select.process(jcas);

		// Test the number of Nouns
		CountPos1 countN = JCasUtil.selectSingle(jcas,
				CountPos1.class);

		assertEquals(3, countN.getCountN());

		// Test the number of Adjectives
		CountPos2 countADJ = JCasUtil.selectSingle(jcas,
				CountPos2.class);

		assertEquals(2, countADJ.getCountADJ());
	}

}
