
/* First created by JCasGen Thu Nov 19 11:06:30 CET 2015 */
package de.unidue.langtech.teaching.pp.type;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Thu Nov 19 11:06:30 CET 2015
 * @generated */
public class MyType2_Type extends Annotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (MyType2_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = MyType2_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new MyType2(addr, MyType2_Type.this);
  			   MyType2_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new MyType2(addr, MyType2_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = MyType2.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("de.unidue.langtech.teaching.pp.type.MyType2");
 
  /** @generated */
  final Feature casFeat_LetterACounter;
  /** @generated */
  final int     casFeatCode_LetterACounter;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getLetterACounter(int addr) {
        if (featOkTst && casFeat_LetterACounter == null)
      jcas.throwFeatMissing("LetterACounter", "de.unidue.langtech.teaching.pp.type.MyType2");
    return ll_cas.ll_getIntValue(addr, casFeatCode_LetterACounter);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setLetterACounter(int addr, int v) {
        if (featOkTst && casFeat_LetterACounter == null)
      jcas.throwFeatMissing("LetterACounter", "de.unidue.langtech.teaching.pp.type.MyType2");
    ll_cas.ll_setIntValue(addr, casFeatCode_LetterACounter, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public MyType2_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_LetterACounter = jcas.getRequiredFeatureDE(casType, "LetterACounter", "uima.cas.Integer", featOkTst);
    casFeatCode_LetterACounter  = (null == casFeat_LetterACounter) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_LetterACounter).getCode();

  }
}



    