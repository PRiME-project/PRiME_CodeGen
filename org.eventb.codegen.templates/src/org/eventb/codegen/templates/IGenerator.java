package org.eventb.codegen.templates;

import java.util.List;

public interface IGenerator {
	public List<String> generate(IGeneratorData data) throws Exception;
}
