package org.eventb.codegen.il1.translator;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eventb.codegen.il1.IL1Element;

/**
 * Extension point friendly definition of a target language
 * @author Chris
 *
 */
public class TargetLanguage {
	private String coreLanguage;		//	The base language, eg. C, Ada, Java
	private String specificLanguage;	//	Optional additional information about how the language is being used. eg. pthread, OpenMP. "Default" by default...
	
	//	The extension point mapping to the translators
	private Map<EClass, AbstractIL1Translator> emfMapping = new HashMap<EClass, AbstractIL1Translator>();
	
	public TargetLanguage()
	{
		coreLanguage = "undefined";
		specificLanguage = "default";				
	}
	
	public TargetLanguage(String coreLanguage)
	{
		this.coreLanguage = coreLanguage.toLowerCase();
		this.specificLanguage = "default";
	}
	
	public TargetLanguage(String coreLanguage, String specificLanguage)
	{
		this.coreLanguage = coreLanguage.toLowerCase();
		
		if (specificLanguage != null)
			this.specificLanguage = specificLanguage.toLowerCase();
		else
			this.specificLanguage = "default";
	}
	
	public void addMapping(EClass source, AbstractIL1Translator translator)
	{
		emfMapping.put(source, translator);
	}
	
	/**
	 * The core language. Eg. C or Ada.
	 * This is the language string that the TranslationRules and Theory stuff should use.
	 * @return
	 */
	public String getCoreLanguage()
	{
		return coreLanguage;
	}
	
	/**
	 * Any language specifics that these translators will handle.
	 * Eg. Using OpenMP or PThreads in C.
	 * The TranslationRules and Theory stuff should not need to use this one.
	 * @return
	 */
	public String getSpecificLanguage()
	{
		return specificLanguage;
	}
	
	AbstractIL1Translator getTranslator(IL1Element element)
	{
		return emfMapping.get(element.eClass());
	}
	
	public boolean isCoreLanguage(String coreLanguage)
	{
		return this.coreLanguage.equalsIgnoreCase(coreLanguage);
	}
	
	public boolean isSpecificLanguage(String specificLanguage)
	{
		return this.specificLanguage.equalsIgnoreCase(specificLanguage);
	}
	
	public boolean isTargetLanguage(String coreLanguage, String specificLanguage)
	{
		return isCoreLanguage(coreLanguage) && isSpecificLanguage(specificLanguage);
	}
	
	public boolean isTargetLanguage(TargetLanguage targetLanguage)
	{
		return targetLanguage.isTargetLanguage(coreLanguage, specificLanguage);
	}
	
	public boolean equals(Object targetLanguage)
	{
		if (targetLanguage instanceof TargetLanguage)
			return isTargetLanguage((TargetLanguage)targetLanguage);
		else
			return super.equals(targetLanguage);
		
	}
}
