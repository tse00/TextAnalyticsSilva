package de.unidue.langtech.teaching.pp.example.pipeline;

import de.tudarmstadt.ukp.dkpro.core.io.text.TextReader;

import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.SimplePipeline;

import de.tudarmstadt.ukp.dkpro.core.api.lexmorph.type.pos.ADJ;
import de.tudarmstadt.ukp.dkpro.core.api.lexmorph.type.pos.N;

import de.tudarmstadt.ukp.dkpro.core.stanfordnlp.StanfordParser;
import de.tudarmstadt.ukp.dkpro.core.tokit.BreakIteratorSegmenter;
import de.tudarmstadt.ukp.dkpro.keyphrases.core.postprocessing.KeyphraseMerger;
import de.tudarmstadt.ukp.dkpro.keyphrases.core.reader.KeyphraseReader;
import de.tudarmstadt.ukp.dkpro.keyphrases.ranking.NodeDegreeRanking;
import de.tudarmstadt.ukp.dkpro.keyphrases.textgraphs.CooccurrenceGraph;
import de.tudarmstadt.ukp.dkpro.keyphrases.core.evaluator.KeyphraseDatasetStatistics;
import de.tudarmstadt.ukp.dkpro.keyphrases.core.evaluator.KeyphraseEvaluator;

import de.unidue.langtech.teaching.pp.Keyphrase_TextRank.BaselineSelection;
import de.unidue.langtech.teaching.pp.Keyphrase_TextRank.KeyphraseWriter;


public class ExtendedPipeline
{

		 public static void main(String[] args)
			        throws Exception
			    {
					SimplePipeline.runPipeline(
			                CollectionReaderFactory.createReader(
			                		TextReader.class,
			                		TextReader.PARAM_SOURCE_LOCATION, "src/test/resources/KeyTest/1001.abstr",
			                		TextReader.PARAM_LANGUAGE, "en"
			                		/*KeyphraseReader.class,
			                		KeyphraseReader.PARAM_INPUTDIR, "src/test/resources/KeyTest/",
			                		KeyphraseReader.PARAM_LANGUAGE, "en",
			                		KeyphraseReader.PARAM_DATA_SUFFIX, ".abstr"*/
			                ),

			                // Tokenization
			                AnalysisEngineFactory.createEngineDescription(BreakIteratorSegmenter.class),

			                // Parser
			                AnalysisEngineFactory.createEngineDescription(StanfordParser.class, StanfordParser.PARAM_LANGUAGE, "en"),

			                // Nouns and Adjectives output
			                AnalysisEngineFactory.createEngineDescription(BaselineSelection.class),

			                // Builds Graph - Nouns
			                AnalysisEngineFactory.createEngineDescription(CooccurrenceGraph.class,
			                		CooccurrenceGraph.PARAM_FEATURE_PATH, N.class, CooccurrenceGraph.PARAM_WINDOW_SIZE, 2),

			                // Builds Graph - Adjectives
			                AnalysisEngineFactory.createEngineDescription(CooccurrenceGraph.class,
			                		CooccurrenceGraph.PARAM_FEATURE_PATH, ADJ.class, CooccurrenceGraph.PARAM_WINDOW_SIZE, 2),

			                // Score Degree
			                AnalysisEngineFactory.createEngineDescription(NodeDegreeRanking.class, NodeDegreeRanking.PARAM_WEIGHTED, true),

			                // Adjective corresponding an Noun as one Keyphrase
			                AnalysisEngineFactory.createEngineDescription(KeyphraseMerger.class, KeyphraseMerger.PARAM_KEEP_PARTS, true),

			                //Evaluation
			                AnalysisEngineFactory.createEngineDescription(KeyphraseEvaluator.class, KeyphraseEvaluator.PARAM_N,  10,
			                		KeyphraseEvaluator.PARAM_GOLD_SUFFIX, ".uncontr", KeyphraseEvaluator.PARAM_MATCHING_TYPE, "Exact",
			                		KeyphraseEvaluator.PARAM_LOWERCASE, true, KeyphraseEvaluator.PARAM_EVAL_TYPE, "Token"),

			                AnalysisEngineFactory.createEngineDescription(KeyphraseDatasetStatistics.class,
			                		KeyphraseDatasetStatistics.PARAM_GOLD_SUFFIX, ".uncontr"),

			                // Writes Keyphrases
			                AnalysisEngineFactory.createEngineDescription(KeyphraseWriter.class,
			                		KeyphraseWriter.PARAM_N, 10,
			                		KeyphraseWriter.PARAM_LOWERCASE, true, KeyphraseWriter.PARAM_REMOVE_CONTAINED, true,
			                		KeyphraseWriter.PARAM_SHOULD_WRITE_DOCUMENT, false)
			        );

			    }
	}