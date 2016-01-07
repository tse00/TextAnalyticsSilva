package de.unidue.langtech.teaching.pp.example;

import de.tudarmstadt.ukp.dkpro.core.api.frequency.util.FrequencyDistribution;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;

public class BaselineSumm extends JCasAnnotator_ImplBase{


	/*public static List<String> shorten (JCas jcas, int n)
		throws Exception
	{
		Collection<Token> tokens = JCasUtil.select(jcas, Token.class);
		FrequencyDistribution<String> fd = new FrequencyDistribution<String>();
		Set<String> mostFrequent = new HashSet<String>(fd.getMostFrequentSamples(n));

		List<String> filteredTokens = new ArrayList<String>();
		for (Token t : tokens) {
			String w = t.getCoveredText();
			if (!mostFrequent.contains(w)) {
				filteredTokens.add(w);
			}
		}
		return filteredTokens;
	}*/

	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {

		Collection<Token> tokens = JCasUtil.select(jcas, Token.class);

		FrequencyDistribution<String> fd = new FrequencyDistribution<String>();

		int n = 500;

		Set<String> mostFrequent = new HashSet<String>(fd.getMostFrequentSamples(n));

		List<String> filteredTokens = new ArrayList<String>();
		for (Token t : tokens) {
			String w = t.getCoveredText();
			if (!mostFrequent.contains(w)) {
				filteredTokens.add(w);
			}
		}

		System.out.println(filteredTokens);

	}
}
