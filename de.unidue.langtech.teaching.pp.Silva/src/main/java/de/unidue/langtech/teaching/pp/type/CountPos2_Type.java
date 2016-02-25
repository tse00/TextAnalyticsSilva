
/* First created by JCasGen Thu Feb 25 09:32:51 CET 2016 */
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
 * Updated by JCasGen Thu Feb 25 09:32:51 CET 2016
 * @generated */
public class CountPos2_Type extends Annotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (CountPos2_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = CountPos2_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new CountPos2(addr, CountPos2_Type.this);
  			   CountPos2_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new CountPos2(addr, CountPos2_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = CountPos2.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("de.unidue.langtech.teaching.pp.type.CountPos2");
 
  /** @generated */
  final Feature casFeat_CountADJ;
  /** @generated */
  final int     casFeatCode_CountADJ;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getCountADJ(int addr) {
        if (featOkTst && casFeat_CountADJ == null)
      jcas.throwFeatMissing("CountADJ", "de.unidue.langtech.teaching.pp.type.CountPos2");
    return ll_cas.ll_getIntValue(addr, casFeatCode_CountADJ);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setCountADJ(int addr, int v) {
        if (featOkTst && casFeat_CountADJ == null)
      jcas.throwFeatMissing("CountADJ", "de.unidue.langtech.teaching.pp.type.CountPos2");
    ll_cas.ll_setIntValue(addr, casFeatCode_CountADJ, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public CountPos2_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_CountADJ = jcas.getRequiredFeatureDE(casType, "CountADJ", "uima.cas.Integer", featOkTst);
    casFeatCode_CountADJ  = (null == casFeat_CountADJ) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_CountADJ).getCode();

  }
}



    