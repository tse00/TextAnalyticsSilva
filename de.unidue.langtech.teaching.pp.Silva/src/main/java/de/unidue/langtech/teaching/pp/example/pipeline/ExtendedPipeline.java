package de.unidue.langtech.teaching.pp.example.pipeline;

import de.tudarmstadt.ukp.dkpro.core.io.text.TextReader;
import de.tudarmstadt.ukp.dkpro.core.stanfordnlp.StanfordParser;

import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.SimplePipeline;

import de.tudarmstadt.ukp.dkpro.core.api.lexmorph.type.pos.ADJ;
import de.tudarmstadt.ukp.dkpro.core.api.lexmorph.type.pos.N;
import de.tudarmstadt.ukp.dkpro.core.api.lexmorph.type.pos.V;
import de.tudarmstadt.ukp.dkpro.core.tokit.BreakIteratorSegmenter;
import de.tudarmstadt.ukp.dkpro.keyphrases.core.postprocessing.KeyphraseMerger;
import de.tudarmstadt.ukp.dkpro.keyphrases.ranking.NodeDegreeRanking;
import de.tudarmstadt.ukp.dkpro.keyphrases.textgraphs.CooccurrenceGraph;
import de.tudarmstadt.ukp.dkpro.keyphrases.core.evaluator.KeyphraseDatasetStatistics;
import de.tudarmstadt.ukp.dkpro.keyphrases.core.evaluator.KeyphraseEvaluator;
import de.tudarmstadt.ukp.dkpro.keyphrases.core.evaluator.KeyphraseWriter;
import de.unidue.langtech.teaching.pp.Keyphrase_TextRank.BaselineN_ADJ;
import de.unidue.langtech.teaching.pp.Keyphrase_TextRank.CandidateCount;
import de.unidue.langtech.teaching.pp.Keyphrase_TextRank.CandidateSelect;
import de.unidue.langtech.teaching.pp.Keyphrase_TextRank.CountN_ADJ;
import de.unidue.langtech.teaching.pp.Keyphrase_TextRank.KeyphraseReader;
import de.unidue.langtech.teaching.pp.Keyphrase_TextRank.ShowDocumentText;

import de.tudarmstadt.ukp.dkpro.core.maltparser.MaltParser;
import de.tudarmstadt.ukp.dkpro.core.opennlp.OpenNlpPosTagger;
import de.tudarmstadt.ukp.dkpro.core.opennlp.OpenNlpSegmenter;

public class ExtendedPipeline
{

		 public static void main(String[] args)
			        throws Exception
			    {
					SimplePipeline.runPipeline(
			                CollectionReaderFactory.createReader(
			                		TextReader.class,
			                		TextReader.PARAM_SOURCE_LOCATION, "src/test/resources/KeyTest/1005.abstr",
			                		TextReader.PARAM_LANGUAGE, "en"
			                	/*	KeyphraseReader.class,
			                		KeyphraseReader.PARAM_INPUTDIR, "src/test/resources/testKey_Reader/",
			                		KeyphraseReader.PARAM_LANGUAGE, "en",
			                		KeyphraseReader.PARAM_DATA_SUFFIX, "abstr"*/
			                ),

			                // Tokenization
			                AnalysisEngineFactory.createEngineDescription(BreakIteratorSegmenter.class),

			                //POS tagger for MaltParser
			                AnalysisEngineFactory.createEngineDescription(OpenNlpPosTagger.class),

			                //Parser
			                AnalysisEngineFactory.createEngineDescription(MaltParser.class),

			             /*   // Parser
			                AnalysisEngineFactory.createEngineDescription(StanfordParser.class, StanfordParser.PARAM_LANGUAGE, "en",
			                		StanfordParser.PARAM_WRITE_POS, true),*/

			                // Document output
			                AnalysisEngineFactory.createEngineDescription(ShowDocumentText.class, ShowDocumentText.PARAM_SHOWTEXT, true),

			                // Number of Nouns and Adjectives
			                AnalysisEngineFactory.createEngineDescription(CountN_ADJ.class),

			                // Nouns and Adjectives output
			                AnalysisEngineFactory.createEngineDescription(BaselineN_ADJ.class),

			                //Selected POS (PARAM_FEATURE_PATH) output
			               AnalysisEngineFactory.createEngineDescription(CandidateSelect.class, CandidateSelect.PARAM_FEATURE_PATH, N.class),

			                // Count selected POS output
			                AnalysisEngineFactory.createEngineDescription(CandidateCount.class, CandidateCount.PARAM_FEATURE_PATH, N.class),

			                AnalysisEngineFactory.createEngineDescription(CandidateSelect.class, CandidateSelect.PARAM_FEATURE_PATH, ADJ.class),

			                AnalysisEngineFactory.createEngineDescription(CandidateCount.class, CandidateCount.PARAM_FEATURE_PATH, ADJ.class),


			                // Builds Graph - Nouns
			                AnalysisEngineFactory.createEngineDescription(CooccurrenceGraph.class,
			                		CooccurrenceGraph.PARAM_FEATURE_PATH, N.class, CooccurrenceGraph.PARAM_WINDOW_SIZE, 5),

			                // Builds Graph - Adjectives
			                AnalysisEngineFactory.createEngineDescription(CooccurrenceGraph.class,
			                		CooccurrenceGraph.PARAM_FEATURE_PATH, ADJ.class, CooccurrenceGraph.PARAM_WINDOW_SIZE, 5),

			                // Score Degree - Keyphrases with the highest score will be selected
			                AnalysisEngineFactory.createEngineDescription(NodeDegreeRanking.class, NodeDegreeRanking.PARAM_WEIGHTED, true),

			                // Two keyphrases are directly adjacent, they can be joined to form a larger keyphrase.
			                AnalysisEngineFactory.createEngineDescription(KeyphraseMerger.class),

			               // TODO : All Keyphrases + score

			                // Writes Keyphrases
			                AnalysisEngineFactory.createEngineDescription(KeyphraseWriter.class,
			                		KeyphraseWriter.PARAM_N, 10,
			                		KeyphraseWriter.PARAM_LOWERCASE, true, KeyphraseWriter.PARAM_REMOVE_CONTAINED, true,
			                		KeyphraseWriter.PARAM_SHOULD_WRITE_DOCUMENT, false),

			                // Evaluation
			                AnalysisEngineFactory.createEngineDescription(KeyphraseEvaluator.class, KeyphraseEvaluator.PARAM_N,  10,
			                		KeyphraseEvaluator.PARAM_GOLD_SUFFIX, ".uncontr", KeyphraseEvaluator.PARAM_MATCHING_TYPE, "Approximate",
			                		KeyphraseEvaluator.PARAM_LOWERCASE, false , KeyphraseEvaluator.PARAM_EVAL_TYPE, "Token",
			                		KeyphraseEvaluator.PARAM_RESULT_FILE, "src/test/resources/Output/OutputEval.txt")

			                /*    AnalysisEngineFactory.createEngineDescription(KeyphraseDatasetStatistics.class,
			                		KeyphraseDatasetStatistics.PARAM_GOLD_SUFFIX, ".uncontr")*/


			        );

			    }
	}