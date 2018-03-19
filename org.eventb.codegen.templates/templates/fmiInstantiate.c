//## <addToHeader>
fmiComponent fmiInstantiateSlave(fmiString instanceName, fmiString fmuGUID,
		fmiString fmuResourceLocation, const fmiCallbackFunctions* functions,
		fmiBoolean visible, fmiBoolean loggingOn) {
	// create a fmiComponent and allocate storage space
	ModelInstance *c = malloc(sizeof(*c));
	if (!(conInstanceCount <= (MaxFMUInstances - 1))) {
		c->validInstance = fmiFalse;
		return c;
	} else {
		c->validInstance = fmiTrue;
		// set the name etc
		c->instanceName = instanceName;
		c->GUID = fmuGUID;
		//add instance to collection;
		modelInstances[conInstanceCount] = *c;
		conInstanceCount = conInstanceCount + 1;
		return (fmiComponent) c;
	}
}


