
/* First created by JCasGen Thu Mar 10 12:09:11 CET 2016 */
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
 * Updated by JCasGen Thu Mar 10 12:09:11 CET 2016
 * @generated */
public class ShowDocument_Type extends Annotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (ShowDocument_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = ShowDocument_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new ShowDocument(addr, ShowDocument_Type.this);
  			   ShowDocument_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new ShowDocument(addr, ShowDocument_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = ShowDocument.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("de.unidue.langtech.teaching.pp.type.ShowDocument");
 
  /** @generated */
  final Feature casFeat_ShowDoc;
  /** @generated */
  final int     casFeatCode_ShowDoc;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public boolean getShowDoc(int addr) {
        if (featOkTst && casFeat_ShowDoc == null)
      jcas.throwFeatMissing("ShowDoc", "de.unidue.langtech.teaching.pp.type.ShowDocument");
    return ll_cas.ll_getBooleanValue(addr, casFeatCode_ShowDoc);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setShowDoc(int addr, boolean v) {
        if (featOkTst && casFeat_ShowDoc == null)
      jcas.throwFeatMissing("ShowDoc", "de.unidue.langtech.teaching.pp.type.ShowDocument");
    ll_cas.ll_setBooleanValue(addr, casFeatCode_ShowDoc, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public ShowDocument_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_ShowDoc = jcas.getRequiredFeatureDE(casType, "ShowDoc", "uima.cas.Boolean", featOkTst);
    casFeatCode_ShowDoc  = (null == casFeat_ShowDoc) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_ShowDoc).getCode();

  }
}



    