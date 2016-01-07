package de.unidue.langtech.teaching.pp.example.newType;


import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.jcas.JCas;

import de.unidue.langtech.teaching.pp.type.MyType;
import de.unidue.langtech.teaching.pp.type.MyType2;

public class LetterAnnotator
    extends JCasAnnotator_ImplBase
{

    @Override
    public void process(JCas jcas)
        throws AnalysisEngineProcessException
    {
        String documentText = jcas.getDocumentText();

        int countLetterE = 0;
        for (char c : documentText.toCharArray()) {
            if (c == 'e' || c == 'E') {
                countLetterE++;
            }
        }

        int countLetterA = 0;
        for (char c2 : documentText.toCharArray()) {
            if (c2 == 'a' || c2 == 'A') {
                    countLetterA++;
            }
        }

        //Set this integer value to the property of the new type 'MyType'
        MyType myType = new MyType(jcas);
        myType.setCountLetterE(countLetterE);
        myType.addToIndexes();

        System.out.println("Letter E: " + countLetterE);

        MyType2 myType2 = new MyType2(jcas);
        myType2.setLetterACounter(countLetterA);
        myType2.addToIndexes();

        System.out.println("Letter A: " + countLetterA);

    }
}

