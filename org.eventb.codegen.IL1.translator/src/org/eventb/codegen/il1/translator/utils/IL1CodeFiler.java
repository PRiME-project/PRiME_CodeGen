package org.eventb.codegen.il1.translator.utils;

import java.util.List;

import org.eventb.codegen.il1.translator.IL1TranslationManager;
import org.eventb.codegen.templates.util.CodeFiler;

public class IL1CodeFiler extends CodeFiler {
	
	protected static IL1CodeFiler filer = new IL1CodeFiler();

	// Return the default instance
	public static IL1CodeFiler getDefault() {
		return filer;
	}
	
	// Save the code to file given a directory path and filename.
	// Use this if there is a translation manager.
	public void save(List<String> codeToSave, String directoryPath,
			String filename, IL1TranslationManager translationManager) {
		
		boolean isJava = translationManager.getCurrentTranslationTarget().isCoreLanguage("java");
		boolean isC = translationManager.getCurrentTranslationTarget().isCoreLanguage("fmi_c");
		isC = isC || translationManager.getCurrentTranslationTarget().isCoreLanguage("c");
		if(isJava) formatterType = FormatterType.JAVA;
		else if(isC) formatterType = FormatterType.C;
		// Format the code and save
		formatAndSave(codeToSave, directoryPath, filename, formatterType);
	}

}