package org.eventb.codegen.templates.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.TextEdit;

public class CodeFiler {
	// the default filer
	protected static CodeFiler filer = new CodeFiler();

	// in-built eclipse formatter types
	protected enum FormatterType {
		JAVA, C
	};

	protected FormatterType formatterType = null;

	// Return the default instance
	public static CodeFiler getDefault() {
		return filer;
	}

	// Save the code to file given a directory path and filename.
	// Use this if there is a translation manager.
	public void save(List<String> codeToSave, String directoryPath,
			String filename, String language) {
		if (language.equalsIgnoreCase("fmi_c"))
			formatterType = FormatterType.C;
		else if (language.equalsIgnoreCase("java"))
			formatterType = FormatterType.JAVA;
		else
			formatterType = null;
		// use an in-built formatter if required
		if (formatterType != null) {
			formatAndSave(codeToSave, directoryPath, filename, formatterType);
		} else {
			simpleSave(codeToSave, directoryPath, filename);
		}
	}

	// save without further formatting
	private void simpleSave(List<String> codeToSave, String directoryPath,
			String filename) {
		String fullName = directoryPath + filename;
		try {
			BufferedWriter out = new BufferedWriter(
					new FileWriter(fullName));
			for (String line : codeToSave) {
				out.write(line+"\n");
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace(System.out);
		}
	}

	protected void formatAndSave(List<String> codeToSave, String directoryName,
			String filename, FormatterType formatterType) {
		StringBuffer code = new StringBuffer();
		for (String s : codeToSave) {
			code.append(s + "\n");
		}
		TextEdit textEdit = null;
		Properties properties = System.getProperties();
		boolean isLinux = properties.get("os.name").equals("Linux");
		// case of Linux with C formatting
		
		// Begin: comment the following code for a windows build of the VHDL Generator
		////!!!!!!>>>>>
		if(isLinux){
				if (formatterType == FormatterType.C) {
					org.eclipse.cdt.core.formatter.CodeFormatter C_CodeFormatter = org.eclipse.cdt.core.ToolFactory
							.createCodeFormatter(null);
					textEdit = C_CodeFormatter.format(
							org.eclipse.cdt.core.formatter.CodeFormatter.K_UNKNOWN,
							code.toString(), 0, code.length(), 0, null);
				}		
		}
		////!!!!!!<<<<<<<
		// End: comment the following code for a windows build of the VHDL Generator
		
		
		// case of any OS with Java
		if (formatterType == FormatterType.JAVA) {
			org.eclipse.jdt.core.formatter.CodeFormatter javaCodeFormatter = org.eclipse.jdt.core.ToolFactory
					.createCodeFormatter(null);
			textEdit = javaCodeFormatter.format(
					org.eclipse.jdt.core.formatter.CodeFormatter.K_UNKNOWN,
					code.toString(), 0, code.length(), 0, null);
		} 
		IDocument doc = new Document(code.toString());
		try {
			if (textEdit != null) {
				textEdit.apply(doc);
			} else {
				System.out
						.println("Tried To format code in CodeFiler.java but failed.");
			}
		} catch (MalformedTreeException e) {
			e.printStackTrace();
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		// End of Formatting
		String formattedCode = doc.get();
		// write to the file
		String fullName = directoryName + filename;
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(fullName));
			out.write(formattedCode);
			out.close();
		} catch (IOException e) {
			e.printStackTrace(System.out);
		}
	}
}