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
import de.unidue.langtech.teaching.pp.type.ShowDocument;

public class ShowDocumentTest {

	@Test
	public void testShowDoc() throws UIMAException {

		String text = "A fly loves a good joke!";

		JCas jcas = JCasFactory.createJCas();

		jcas.setDocumentText(text);

		AnalysisEngineDescription segmenter = createEngineDescription(BreakIteratorSegmenter.class);
		AnalysisEngine segEngine = createEngine(segmenter);
		segEngine.process(jcas);

		AnalysisEngineDescription parser = createEngineDescription(StanfordParser.class,
				StanfordParser.PARAM_LANGUAGE, "en", StanfordParser.PARAM_WRITE_POS, true);
		AnalysisEngine parse = createEngine(parser);
		parse.process(jcas);

		AnalysisEngineDescription showDoc = createEngineDescription(ShowDocumentText.class,
				ShowDocumentText.PARAM_SHOWTEXT, true);
		AnalysisEngine show = createEngine(showDoc);
		show.process(jcas);

		ShowDocument doc = JCasUtil.selectSingle(jcas,
				ShowDocument.class);

		// The essential part of a test - the test itself - are expected and
		// actual result the same?
		assertEquals(true, doc.getShowDoc());

	}

}
