/**
 *
 */
package org.eventb.codegen.il1.translator.internal.provider;

import org.eventb.codegen.il1.translator.TargetLanguage;
import org.eventb.codegen.il1.translator.provider.ITranslationRule;
import org.eventb.core.ast.Formula;
import org.eventb.core.ast.ITypeEnvironment;

/**
 * @author renatosilva
 *
 */
public class TranslationRule implements ITranslationRule {

	private Formula<?> formula;
	private String translation;
	private String name;
	private String targetLanguage;
	private ITypeEnvironment typeEnvironment;

	/*	Reminder on new TargetLanguage class from Chris.
	 * 
	 * 	The Theory plug-in translation rules should use the core language only (this will be C, Ada etc.).
	 * 	The specific language is used for implementation issues such as C using OpenMP or PThreads.
	 * 
	 * 	
	 */
	
	public TranslationRule(TargetLanguage target, ITypeEnvironment typeEnvironment) {
		super();
		targetLanguage = target.getCoreLanguage();
		this.typeEnvironment = typeEnvironment;
	}

	/* (non-Javadoc)
	 * @see org.eventb.codegen.il1.translator.provider.ITranslationRule#getFormula()
	 */
	@Override
	public Formula<?> getFormula() {
		return formula;
	}

	/* (non-Javadoc)
	 * @see org.eventb.codegen.il1.translator.provider.ITranslationRule#getTranslation()
	 */
	@Override
	public String getTranslation() {
		return translation;
	}

	/* (non-Javadoc)
	 * @see org.eventb.codegen.il1.translator.provider.ITranslationRule#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see org.eventb.codegen.il1.translator.provider.ITranslationRule#getTargetLanguage()
	 */
	@Override
	public String getTargetLanguage() {
		return targetLanguage;
	}

	@Override
	public void setFormula(Formula<?> formula) {
		this.formula = formula;
	}

	@Override
	public void setTranslation(String translation) {
		this.translation = translation;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public ITranslationRule getTranslationRule() {
		return this;
	}

	@Override
	public String toString() {
		return "TranslationRule [formula=" + formula + ", translation="
				+ translation + ", name=" + name + ", targetLanguage="
				+ targetLanguage + "]";
	}

	@Override
	public ITypeEnvironment getTypeEnvironment() {
		return typeEnvironment;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((formula == null) ? 0 : formula.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((targetLanguage == null) ? 0 : targetLanguage.hashCode());
		result = prime * result
				+ ((translation == null) ? 0 : translation.hashCode());
//		result = prime * result
//				+ ((typeEnvironment == null) ? 0 : typeEnvironment.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof TranslationRule)) {
			return false;
		}
		TranslationRule other = (TranslationRule) obj;
		if (formula == null) {
			if (other.formula != null) {
				return false;
			}
		} else if (!formula.equals(other.formula)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (targetLanguage == null) {
			if (other.targetLanguage != null) {
				return false;
			}
		} else if (!targetLanguage.equals(other.targetLanguage)) {
			return false;
		}
		if (translation == null) {
			if (other.translation != null) {
				return false;
			}
		} else if (!translation.equals(other.translation)) {
			return false;
		}
//		if (typeEnvironment == null) {
//			if (other.typeEnvironment != null) {
//				return false;
//			}
//		} else if (!typeEnvironment.equals(other.typeEnvironment)) {
//			return false;
//		}
		return true;
	}


}
