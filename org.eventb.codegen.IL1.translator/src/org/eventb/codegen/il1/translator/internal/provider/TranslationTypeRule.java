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
public class TranslationTypeRule implements ITranslationRule {

	private Formula<?> typeFormula;
	private String translation;
	private String name;
	private String targetLanguage;
	private ITypeEnvironment typeEnvironment;

	public TranslationTypeRule(TargetLanguage target, ITypeEnvironment typeEnvironment) {
		super();
		targetLanguage = target.getCoreLanguage();		//	This will be C, Ada etc.
		this.typeEnvironment = typeEnvironment;
	}

	/* (non-Javadoc)
	 * @see org.eventb.codegen.il1.translator.provider.ITranslationRule#getFormula()
	 */
	@Override
	public Formula<?> getFormula() {
		return typeFormula;
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
		this.typeFormula = formula;
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
		return "TranslationTypeRule [formula=" + typeFormula + ", translation="
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
		result = prime * result + ((typeFormula == null) ? 0 : typeFormula.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((targetLanguage == null) ? 0 : targetLanguage.hashCode());
		result = prime * result
				+ ((translation == null) ? 0 : translation.hashCode());
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
		if (!(obj instanceof TranslationTypeRule)) {
			return false;
		}
		TranslationTypeRule other = (TranslationTypeRule) obj;
		if (typeFormula == null) {
			if (other.typeFormula != null) {
				return false;
			}
		} else if (!typeFormula.equals(other.typeFormula)) {
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
		return true;
	}


}
