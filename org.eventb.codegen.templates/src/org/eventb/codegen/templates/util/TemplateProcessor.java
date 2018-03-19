package org.eventb.codegen.templates.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eventb.codegen.il1.Program;
import org.eventb.codegen.il1.impl.ProtectedImpl;
import org.eventb.codegen.templates.IGeneratorData;
import org.rodinp.core.IRodinProject;
import org.rodinp.core.RodinDBException;

// The TemplateProcessor initialises is a singleton.
// During processing there is only one target File.
// The TemplateHelper class has instances containing
// the (multiples of) source file information.
public class TemplateProcessor {
	private static TemplateProcessor templateProcessor = null;
	private IFolder templateSourceFolder = null;
	private IFolder targetFolder = null;
	private IGeneratorData data = null;
	private String targetName;
	private List<String> codeArray;
	private String targetFolderPath;
	private String fileExtension = ".c"; // the default file extension
	private String language = "fmi_c"; // the default language setting
	

	public static TemplateProcessor getDefault() {
		if (templateProcessor == null) {
			templateProcessor = new TemplateProcessor();
		}
		return templateProcessor;
	}

	// Given a Project set the target folder with that name.
	public IFolder initialiseTarget(IProject project, String folderName) {
		targetFolder = project.getFolder(folderName);
		return targetFolder;
	}

	
	// Given a Rodin Project find the (non-Rodin) folder with that name.
	// We use it to find the templates source folder;
	// Also store the bufferedWriter for later use.
	public void initialiseTarget(IRodinProject rodinProject, String folderName)
			throws RodinDBException, TemplateException {
		List<IResource> nonRodinResources = Arrays.asList(rodinProject
				.getNonRodinResources());
		for (IResource resource : nonRodinResources) {
			if (resource.getType() == IResource.FOLDER
					&& resource.getName().equals(folderName)) {
				targetFolder = (IFolder) resource;
				// we've found it, let's return.
				return;
			}
		}
		// we got here so we've been unable to initialise the reader
		throw new TemplateException(
				"could not initialise Template Reader with: "
						+ rodinProject.getElementName() + "/" + folderName);
	}

	
	// Given a Rodin Project find the (non-Rodin) folder with that name.
	// We use it to find the templates source folder;
	// Also store the bufferedWriter for later use.
	public void initialiseSource(IRodinProject rodinProject, String folderName)
			throws RodinDBException, TemplateException {
		List<IResource> nonRodinResources = Arrays.asList(rodinProject
				.getNonRodinResources());
		for (IResource resource : nonRodinResources) {
			if (resource.getType() == IResource.FOLDER
					&& resource.getName().equals(folderName)) {
				templateSourceFolder = (IFolder) resource;
				// we've found it, let's return.
				return;
			}
		}
		// we got here so we've been unable to initialise the reader
		throw new TemplateException(
				"could not initialise Template Reader with: "
						+ rodinProject.getElementName() + "/" + folderName);
	}

	
	// This is the method that should go through each line, and replace the
	// tag with generated code. Then write the output to a file.
	public void instantiateTemplate(String templateName, IGeneratorData data_)
			throws Exception {
		data = data_;
		List<IResource> folderMembers = Arrays.asList(templateSourceFolder
				.members());
		File templateFile = null;
		HashMap<String, File> templateFolderContentMap = new HashMap<String, File>();
		for (IResource member : folderMembers) {
			if (member.getType() == IResource.FILE) {
				IFile resourceFile = (IFile) member;
				URI uri = resourceFile.getRawLocationURI();
				File iFile = new File(uri);
				IPath path = new Path(uri.getPath());
				String fileName = path.lastSegment();
				if (fileName.equals(templateName)) {
					// We've found the template resource, so log it,
					// but continue looping to add remaining folder contents.
					templateFile = iFile;
					templateFolderContentMap.put(fileName, iFile);
				} else {
					templateFolderContentMap.put(fileName, iFile);
				}
			}
		}
		if (templateFile == null) {
			throw new TemplateException("Template (" + templateName
					+ ") not found in templates folder");
		}
		// Let's enable reading of the template.
		FileReader reader = new FileReader(templateFile);
		BufferedReader bufferedReader = new BufferedReader(reader);

		codeArray = internalInstantiateTemplate(bufferedReader,
				templateFolderContentMap);

		targetName = "";
		for (Object d : data.getDataList()) {
			if (d instanceof ProtectedImpl) {
				targetName = ((ProtectedImpl) d).getName();
				break;
			}
			else if (d instanceof Program) {
				targetName = ((Program) d).getName();
				break;
			}
		}
		targetFolderPath = targetFolder.getRawLocation().addTrailingSeparator()
				.toString();
		doPostProcess();
		doSave();
	}

	private void doPostProcess() {
		List<String> tmpCodeArray = new ArrayList<String>();
		for (String s : codeArray) {
			tmpCodeArray.add(s.replace("modelID", targetName));
		}
		// replace the old array with the new one
		codeArray = tmpCodeArray;
	}

	private void doSave() {
		File dir = new File(targetFolderPath);
		if(!dir.exists()){
			try {
				dir.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		File f = new File(targetFolderPath + targetName + "." + fileExtension);
		if(!f.exists()){
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		CodeFiler.getDefault().save(codeArray, targetFolderPath,
				targetName + "." +fileExtension, language);
	}

	// This takes a buffered reader (pointing to a template), and list of child
	// templates. Returning a generated list of lines, for output.
	public List<String> internalInstantiateTemplate(
			BufferedReader bufferedReader,
			HashMap<String, File> templateFolderContentMap) throws Exception {
		// write all lines to a temporary store for processing
		List<String> tempArrayList = new ArrayList<String>();
		// Get a line and copy it. If it has the 'begin
		// markup' tag, then mark it as a template and we will
		// pass it on for special handling.
		boolean finished = false;
		while (!finished) {
			String line = bufferedReader.readLine();
			if (line == null) {
				finished = true; // we are at the end of the file.
			} else {
				List<String> newLines = null;

				// if we have a keyword, pass it on the the TemplateHelper
				boolean foundComment = line
						.contains(TemplateHelper.TAG_COMMENT_CHARS);
				if (foundComment) {
					String tagword = getTagword(line);
					TemplateHelper templateHelper = new TemplateHelper(data);
					
					templateHelper
							.setChildTemplateMap(templateFolderContentMap);
					// add the reader to the data - so it can be used down
					// stream
					data.getDataList().add(bufferedReader);
					newLines = templateHelper.generate(tagword);
					// remove the reader when done
					data.getDataList().remove(bufferedReader);
				}
				if (foundComment) {
					if(newLines != null){
						tempArrayList.addAll(newLines);
					}
				} else {
					tempArrayList.add(line);
				}
			}
		}
		bufferedReader.close();
		return tempArrayList;
	}

	private String getTagword(String line) {
		int firstDelimiter = line.indexOf("<") + 1;
		int lastDelimiter = line.indexOf(">");
		String keyword = line.substring(firstDelimiter, lastDelimiter);
		return keyword;
	}

	public String getFileExtension() {
		return fileExtension;
	}

	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

}
