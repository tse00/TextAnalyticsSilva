package de.unidue.langtech.teaching.pp.example.pipeline;

import de.tudarmstadt.ukp.dkpro.core.io.text.TextReader;

import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.SimplePipeline;

import de.tudarmstadt.ukp.dkpro.core.api.lexmorph.type.pos.ADJ;
import de.tudarmstadt.ukp.dkpro.core.api.lexmorph.type.pos.N;
import de.tudarmstadt.ukp.dkpro.core.stanfordnlp.StanfordParser;
import de.tudarmstadt.ukp.dkpro.core.tokit.BreakIteratorSegmenter;
import de.unidue.langtech.teaching.pp.Keyphrase_TextRank.BaselineSelection;
import de.unidue.langtech.teaching.pp.Keyphrase_TextRank.CooccurrenceGraph;
import de.unidue.langtech.teaching.pp.Keyphrase_TextRank.KeyphraseMerger;
import de.unidue.langtech.teaching.pp.Keyphrase_TextRank.KeyphraseWriter;
import de.unidue.langtech.teaching.pp.Keyphrase_TextRank.NodeDegreeRanking;

//import de.tudarmstadt.ukp.dkpro.core.stopwordremover.StopWordRemover;

public class ExtendedPipeline
{

		 public static void main(String[] args)
			        throws Exception
			    {
					SimplePipeline.runPipeline(
			                CollectionReaderFactory.createReader(
			                		TextReader.class,
			                		TextReader.PARAM_SOURCE_LOCATION, "src/test/resources/test2/marketing.txt",
			                		TextReader.PARAM_LANGUAGE, "en"
			                		/*KeyphraseReader.PARAM_INPUTDIR, "src/test/resources/test2/",
			                		KeyphraseReader.PARAM_LANGUAGE, "en",
			                		KeyphraseReader.PARAM_DATA_SUFFIX, "txt"*/
			                ),

			                // Tokenization
			                AnalysisEngineFactory.createEngineDescription(BreakIteratorSegmenter.class),

			                // Parser
			                AnalysisEngineFactory.createEngineDescription(StanfordParser.class, StanfordParser.PARAM_LANGUAGE, "en"),

			                // Nouns and Adjectives output
			                AnalysisEngineFactory.createEngineDescription(BaselineSelection.class),

			                // Builds Graph - Nouns
			                AnalysisEngineFactory.createEngineDescription(CooccurrenceGraph.class,
			                		CooccurrenceGraph.PARAM_FEATURE_PATH, N.class),

			                // Builds Graph - Adjectives
			                AnalysisEngineFactory.createEngineDescription(CooccurrenceGraph.class,
			                		CooccurrenceGraph.PARAM_FEATURE_PATH, ADJ.class),

			                // Score Degree
			                AnalysisEngineFactory.createEngineDescription(NodeDegreeRanking.class, NodeDegreeRanking.PARAM_WEIGHTED, true),

			                // Adjective corresponding an Noun as one Keyphrase
			                AnalysisEngineFactory.createEngineDescription(KeyphraseMerger.class, KeyphraseMerger.PARAM_KEEP_PARTS, true),

			                // No need of Stopword
			                /*AnalysisEngineFactory.createEngineDescription(StopWordRemover.class,
		            		   StopWordRemover.PARAM_MODEL_LOCATION, "src/main/resources/stopwords/english_keyphrase_stopwords.txt"),*/

			                // Writes Keyphrases
			                AnalysisEngineFactory.createEngineDescription(KeyphraseWriter.class,
			                		KeyphraseWriter.PARAM_N, 10, KeyphraseWriter.PARAM_FILE_NAME, "src/test/resources/test2/output.txt",
			                		KeyphraseWriter.PARAM_WRITE_TO_FILE, true, KeyphraseWriter.PARAM_LOWERCASE, true, KeyphraseWriter.PARAM_REMOVE_CONTAINED, true)

			        );

			    }
	}