//## <addToHeader>
fmiStatus fmiInitializeSlave(fmiComponent c, fmiReal tStart,
		fmiBoolean StopTimeDefined, fmiReal tStop) {

	ModelInstance* mc = (ModelInstance*) c;
		//## <initialisationsList>

		//## <stateMachineProgramCounterIni>

		return fmiOK;

}
