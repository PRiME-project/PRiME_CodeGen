package org.eventb.codegen.il1.translator.java;

import org.eventb.codegen.il1.translator.IL1TranslationManager;

public class PackagePath {

	private String coreLanguage = "";
	private String specificLanguage = "";

	public PackagePath(IL1TranslationManager il1TranslationManager) {
		coreLanguage = il1TranslationManager.getCurrentTranslationTarget()
				.getCoreLanguage();
		specificLanguage = il1TranslationManager.getCurrentTranslationTarget()
				.getSpecificLanguage();
	}

	public String getCoreLanguage() {
		return coreLanguage;
	}

	public String getSpecificLanguage() {
		return specificLanguage;
	}

	public String getPackageName() {
		if (specificLanguage.equals("default")) {
			return coreLanguage;
		} else {
			return coreLanguage + "_" + specificLanguage;
		}
	}
}
