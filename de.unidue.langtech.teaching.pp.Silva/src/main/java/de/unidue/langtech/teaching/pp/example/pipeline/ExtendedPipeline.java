package de.unidue.langtech.teaching.pp.example.pipeline;

import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngineDescription;

import org.apache.uima.analysis_engine.AnalysisEngineDescription;

import de.unidue.langtech.teaching.pp.example.BaselineSumm;

import org.apache.uima.fit.component.CasDumpWriter;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.SimplePipeline;

import de.tudarmstadt.ukp.dkpro.core.api.lexmorph.type.pos.ADJ;
import de.tudarmstadt.ukp.dkpro.core.api.lexmorph.type.pos.N;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;
import de.tudarmstadt.ukp.dkpro.core.io.conll.Conll2006Writer;
import de.tudarmstadt.ukp.dkpro.core.languagetool.LanguageToolLemmatizer;
import de.tudarmstadt.ukp.dkpro.core.maltparser.MaltParser;
import de.tudarmstadt.ukp.dkpro.core.opennlp.OpenNlpChunker;
import de.tudarmstadt.ukp.dkpro.core.opennlp.OpenNlpNameFinder;
import de.tudarmstadt.ukp.dkpro.core.opennlp.OpenNlpPosTagger;
import de.tudarmstadt.ukp.dkpro.core.opennlp.OpenNlpSegmenter;
import de.tudarmstadt.ukp.dkpro.core.snowball.SnowballStemmer;
import de.tudarmstadt.ukp.dkpro.core.stanfordnlp.StanfordParser;
import de.tudarmstadt.ukp.dkpro.core.stanfordnlp.StanfordSegmenter;
import de.tudarmstadt.ukp.dkpro.core.stopwordremover.StopWordRemover;
import de.tudarmstadt.ukp.dkpro.core.tokit.BreakIteratorSegmenter;
import de.tudarmstadt.ukp.dkpro.keyphrases.core.candidate.CandidateAnnotator;
import de.tudarmstadt.ukp.dkpro.keyphrases.core.filter.factory.StopwordFilterFactory;
import de.tudarmstadt.ukp.dkpro.keyphrases.core.ranking.TfBackgroundIdfRanking;
import de.tudarmstadt.ukp.dkpro.keyphrases.core.ranking.TfRanking;
import de.tudarmstadt.ukp.dkpro.keyphrases.core.wrapper.Candidate;
import de.tudarmstadt.ukp.dkpro.keyphrases.core.wrapper.CooccurrenceGraphExtractor;
import de.unidue.langtech.teaching.pp.example.BaselineExample;
import de.unidue.langtech.teaching.pp.example.BaselineSelection;
import de.unidue.langtech.teaching.pp.example.BaselineStopWord;
import de.unidue.langtech.teaching.pp.example.BaselineSumm;
import de.unidue.langtech.teaching.pp.example.EvaluatorExample;
import de.unidue.langtech.teaching.pp.example.KeyphraseReader;
import de.unidue.langtech.teaching.pp.example.ReaderExample;
import de.unidue.langtech.teaching.pp.example.newType.CooccurrenceGraph;
import de.tudarmstadt.ukp.dkpro.core.posfilter.PosFilter;

public class ExtendedPipeline
{

		 public static void main(String[] args)
			        throws Exception
			    {

					SimplePipeline.runPipeline(
			                CollectionReaderFactory.createReader(
			                		KeyphraseReader.class,
			                		KeyphraseReader.PARAM_INPUTDIR, "src/test/resources/test2/",
			                		KeyphraseReader.PARAM_LANGUAGE, "en",
			                		KeyphraseReader.PARAM_DATA_SUFFIX, "txt"
			                ),

			                //Tokenization
			                AnalysisEngineFactory.createEngineDescription(BreakIteratorSegmenter.class),

			                /*AnalysisEngineFactory.createEngineDescription(BaselineExample.class),
			                AnalysisEngineFactory.createEngineDescription(EvaluatorExample.class),

			                //Stemming - works on single words. Tokenization required
			                AnalysisEngineFactory.createEngineDescription(SnowballStemmer.class, SnowballStemmer.PARAM_LANGUAGE, "en"),

			                //POS
			                AnalysisEngineFactory.createEngineDescription(OpenNlpPosTagger.class, SnowballStemmer.PARAM_LANGUAGE, "en"),

			                //Noun Phrases
			                AnalysisEngineFactory.createEngineDescription(OpenNlpChunker.class, OpenNlpChunker.PARAM_LANGUAGE, "en"),
*/
			                //Display Information
			               // AnalysisEngineFactory.createEngineDescription(CasDumpWriter.class),

			               // AnalysisEngineFactory.createEngineDescription(BaselineSumm.class),

			                AnalysisEngineFactory.createEngineDescription(StanfordParser.class, StanfordParser.PARAM_LANGUAGE, "en"),

			                AnalysisEngineFactory.createEngineDescription(BaselineSelection.class),

			                /*AnalysisEngineFactory.createEngineDescription(CandidateAnnotator.class, CandidateAnnotator.PARAM_FEATURE_PATH,
			         "/de.unidue.langtech.teaching.pp.Silva/src/main/resources/FeaturePath Graph",
			                		CandidateAnnotator.PARAM_RESOLVE_OVERLAPS, true)
*/
			                AnalysisEngineFactory.createEngineDescription(CooccurrenceGraph.class,
			                		CooccurrenceGraph.PARAM_FEATURE_PATH, N.class, CooccurrenceGraph.PARAM_FEATURE_PATH, ADJ.class),

			               AnalysisEngineFactory.createEngineDescription(StopWordRemover.class,
			            		   StopWordRemover.PARAM_MODEL_LOCATION, "src/main/resources/stopwords/english_keyphrase_stopwords.txt",
			            		   StopWordRemover.PARAM_PATHS, Token.class.getName()) // + "keyphrase")

			        );
			    }
	}