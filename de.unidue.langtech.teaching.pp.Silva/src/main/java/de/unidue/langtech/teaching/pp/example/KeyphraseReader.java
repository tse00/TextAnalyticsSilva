package de.unidue.langtech.teaching.pp.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.apache.uima.UimaContext;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.fit.component.JCasCollectionReader_ImplBase;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceConfigurationException;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Level;
import org.apache.uima.util.Progress;
import org.apache.uima.util.ProgressImpl;

import de.tudarmstadt.ukp.dkpro.core.api.metadata.type.DocumentMetaData;

public class KeyphraseReader extends JCasCollectionReader_ImplBase{


	   private static final String DEFAULT_LANGUAGE = "en";

	    public static final String PARAM_INPUTDIR = "InputDirectory";
	    @ConfigurationParameter(name=PARAM_INPUTDIR, mandatory=true)
	    private String mInputDirectory;

	    public static final String PARAM_DATA_SUFFIX = "DataSuffix";
	    @ConfigurationParameter(name=PARAM_DATA_SUFFIX, mandatory=true)
	    private String mDataSuffix;

	    public static final String PARAM_LANGUAGE = "Language";
	    @ConfigurationParameter(name=PARAM_LANGUAGE, mandatory=false, defaultValue=DEFAULT_LANGUAGE)
	    private String mLanguage;

	    public static final String PARAM_ENCODING = "Encoding";
	    @ConfigurationParameter(name=PARAM_ENCODING, mandatory=false, defaultValue="UTF-8")
	    private String mEncoding;

	    private Map<String,File> mDataFiles;
	    private int mCurrentIndex;

	    private Iterator<String> filenameIterator;

	    @Override
	    public void initialize(UimaContext aContext) throws ResourceInitializationException {
	        File directory = new File(mInputDirectory.trim());

	        // if input directory does not exist or is not a directory, throw exception
	        if (!directory.exists() || !directory.isDirectory()) {
	            throw new ResourceInitializationException(ResourceConfigurationException.DIRECTORY_NOT_FOUND, new Object[] { PARAM_INPUTDIR,
	                    this.getMetaData().getName(), directory.getPath() });
	        }

	        // get list of files (not subdirectories) in the specified directory
	        mInputDirectory = directory.toURI().toString();
	        mDataFiles = new TreeMap<String,File>();
	        File[] files = directory.listFiles();
	        for (int i = 0; i < files.length; i++) {
	            if (!files[i].isDirectory()) {
	                String filename = files[i].getName();
	                // get suffix
	                String[] parts = filename.split("\\.");
	                if (parts.length < 1) {
	                    continue;
	                }
	                String suffix = parts[parts.length-1];
	                String nameWithoutSuffix = filename.substring(0, filename.length() - suffix.length());

	                if (suffix.equals(mDataSuffix)) {
	                    mDataFiles.put(nameWithoutSuffix, files[i]);
	                }
	            }
	        }

	        mCurrentIndex = 0;
	        filenameIterator = mDataFiles.keySet().iterator();
	    }

		public boolean hasNext() throws IOException, CollectionException {

			return filenameIterator.hasNext();
		}

		public Progress[] getProgress() {
			return new Progress[] { new ProgressImpl(mCurrentIndex, mDataFiles.size(), Progress.ENTITIES) };
		}

		@Override
		public void getNext(JCas jCas) throws IOException, CollectionException {

			String filename = filenameIterator.next();
	        File dataFile = mDataFiles.get(filename);
	        getUimaContext().getLogger().log(Level.INFO, "Processing file " + dataFile.getName());
	        InputStream is = new FileInputStream(dataFile);
	        {
	            byte[] contents = new byte[(int) dataFile.length()];
	            is.read(contents);
	            String text;
	            if (mEncoding != null) {
	                text = new String(contents, mEncoding);
	            } else {
	                text = new String(contents);
	            }
	            text = text.replaceAll(System.getProperty("line.separator"), " ");
	            text = text.replaceAll("\\s{2,}"," ");
	            jCas.setDocumentText(text);
	        }
	        if (is != null) {
	            is.close();

	        }

	        // set language if it was explicitly specified as a configuration parameter
	        if (mLanguage != null) {
	            jCas.setDocumentLanguage(mLanguage);
	        }

	        DocumentMetaData docMetaData = DocumentMetaData.create(jCas);
	        docMetaData.setDocumentTitle(dataFile.getName());
	        docMetaData.setDocumentUri(dataFile.toURI().toString());
	        docMetaData.setDocumentId(new Integer(mCurrentIndex).toString());
	        docMetaData.setCollectionId(mInputDirectory);
	        docMetaData.addToIndexes();

	        mCurrentIndex++;
		}

}
