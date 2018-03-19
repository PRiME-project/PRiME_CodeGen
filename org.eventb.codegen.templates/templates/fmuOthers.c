 /* ---------------------------------------------------------------------------*
 * Implementation of the FMU interface based on functions and macros to
 * be defined by the includer of this file.
 * (c) 2010 QTronic GmbH
 * ---------------------------------------------------------------------------*/

#define NUMBER_OF_EVENT_INDICATORS 0



// ---------------------------------------------------------------------------
// Private helpers used below to validate function arguments
// ---------------------------------------------------------------------------

//static fmiBoolean invalidNumber(fmiComponent c, const char* f, const char* arg, int n, int nExpected){
//	ModelInstance* comp = (ModelInstance*) c;
//    if (n != nExpected) {
//        comp->state = modelError;
//        comp->functions.logger(comp, comp->instanceName, fmiError, "error",
//                "%s: Invalid argument %s = %d. Expected %d.", f, arg, n, nExpected);
//        return fmiTrue;
//    }
//    return fmiFalse;
//}

static fmiBoolean invalidState(fmiComponent c, const char* f, int statesExpected){
	ModelInstance* comp = (ModelInstance*) c;
    if (!comp)
        return fmiTrue;
    if (!(comp->state & statesExpected)) {
        comp->state = modelError;
        comp->functions.logger(comp, comp->instanceName, fmiError, "error",
                "%s: Illegal call sequence.", f);
        return fmiTrue;
    }
    return fmiFalse;
}

static fmiBoolean nullPointer(fmiComponent c, const char* f, const char* arg, const void* p){
	ModelInstance* comp = (ModelInstance*) c;
    if (!p) {
        comp->state = modelError;
        comp->functions.logger(comp, comp->instanceName, fmiError, "error",
                "%s: Invalid argument %s = NULL.", f, arg);
        return fmiTrue;
    }
    return fmiFalse;
}

static fmiBoolean vrOutOfRange(fmiComponent c, const char* f, fmiValueReference vr, int end) {
	ModelInstance* comp = (ModelInstance*) c;
    if (vr >= end) {
        comp->functions.logger(comp, comp->instanceName, fmiError, "error",
                "%s: Illegal value reference %u.", f, vr);
        comp->state = fmiError;
        return fmiTrue;
    }
    return fmiFalse;
}

// ---------------------------------------------------------------------------
// FMI functions: class methods not depending of a specific model instance
// ---------------------------------------------------------------------------

const char* fmiGetTypesPlatform() {
    return fmiModelTypesPlatform;
}

const char* fmiGetVersion() {
    return fmiVersion;
}

// ---------------------------------------------------------------------------
// FMI functions: creation and destruction of a model instance
// ---------------------------------------------------------------------------

// TODO complete the body
fmiStatus fmiResetSlave(fmiComponent c){
	return fmiOK;
}

// TODO complete the body if required
fmiStatus fmiSetRealInputDerivatives(fmiComponent c, const fmiValueReference vr[],
		size_t nvr, const fmiInteger order[], const fmiReal value[]){
	return fmiOK;
}

// TODO complete the body if required
fmiStatus fmiGetRealOutputDerivatives (fmiComponent c, const fmiValueReference vr[],
		size_t nvr, const fmiInteger order[], fmiReal value[]){
	return fmiOK;
}

// TODO complete the body if required
fmiStatus fmiCancelStep(fmiComponent c){
	return fmiOK;
}

// TODO complete the body if required
fmiStatus fmiGetStatus(fmiComponent c, const fmiStatusKind s, fmiStatus* value){
	return fmiOK;
}

// TODO complete the body if required
fmiStatus fmiGetRealStatus(fmiComponent c, const fmiStatusKind s, fmiReal* value){
	return fmiOK;
}

// TODO complete the body if required
fmiStatus fmiGetIntegerStatus(fmiComponent c, const fmiStatusKind s, fmiInteger* value){
	return fmiOK;
}

// TODO complete the body if required
fmiStatus fmiGetBooleanStatus(fmiComponent c, const fmiStatusKind s, fmiBoolean* value){
	return fmiOK;
}

// TODO complete the body if required
fmiStatus fmiGetStringStatus(fmiComponent c, const fmiStatusKind s, fmiString* value){
	return fmiOK;
}


fmiStatus fmiSetDebugLogging(fmiComponent c, fmiBoolean loggingOn) {
    ModelInstance* comp = (ModelInstance*)c;
    if (invalidState(comp, "fmiSetDebugLogging", not_modelError))
         return fmiError;
//    if (comp->loggingOn) comp->functions.logger(c, comp->instanceName, fmiOK, "log",
//            "fmiSetDebugLogging: loggingOn=%d", loggingOn);
//    comp->loggingOn = loggingOn;
    return fmiOK;
}

void fmiFreeSlaveInstance(fmiComponent c) {
	ModelInstance* comp = (ModelInstance*)c;
    if (!comp) return;
//    if (comp->loggingOn) comp->functions.logger(c, comp->instanceName, fmiOK, "log",
//            "fmiFreeSlaveInstance");
//    if (comp->r) comp->functions.freeMemory(comp->r);
//    if (comp->i) comp->functions.freeMemory(comp->i);
//    if (comp->b) comp->functions.freeMemory(comp->b);
//    if (comp->s) comp->functions.freeMemory(comp->s);
//    comp->functions.freeMemory(comp);
}

// ---------------------------------------------------------------------------
// FMI functions: set variable values in the FMU
// ---------------------------------------------------------------------------

fmiStatus fmiSetReal(fmiComponent c, const fmiValueReference vr[], size_t nvr, const fmiReal value[]){
    int i;
    ModelInstance* comp = (ModelInstance*)c;
    if (invalidState(comp, "fmiSetReal", modelInstantiated|modelInitialized))
         return fmiError;
    if (nvr>0 && nullPointer(comp, "fmiSetReal", "vr[]", vr))
         return fmiError;
    if (nvr>0 && nullPointer(comp, "fmiSetReal", "value[]", value))
         return fmiError;
//    if (comp->loggingOn) comp->functions.logger(c, comp->instanceName, fmiOK, "log",
//            "fmiSetReal: nvr = %d", nvr);
    // no check wether setting the value is allowed in the current state
    for (i=0; i<nvr; i++) {
       if (vrOutOfRange(comp, "fmiSetReal", vr[i], NUMBER_OF_REALS))
           return fmiError;
//       if (comp->loggingOn) comp->functions.logger(c, comp->instanceName, fmiOK, "log",
//            "fmiSetReal: #r%d# = %.16g", vr[i], value[i]);
       comp->r[vr[i]] = value[i];
    }
    return fmiOK;
}

fmiStatus fmiSetInteger(fmiComponent c, const fmiValueReference vr[], size_t nvr, const fmiInteger value[]){
    int i;
    ModelInstance* comp = (ModelInstance*)c;
//    if (invalidState(comp, "fmiSetInteger", modelInstantiated|modelInitialized))
//         return fmiError;
//    if (nvr>0 && nullPointer(comp, "fmiSetInteger", "vr[]", vr))
//         return fmiError;
//    if (nvr>0 && nullPointer(comp, "fmiSetInteger", "value[]", value))
//         return fmiError;
//    if (comp->loggingOn)
//        comp->functions.logger(c, comp->instanceName, fmiOK, "log", "fmiSetInteger: nvr = %d",  nvr);
    for (i=0; i<nvr; i++) {
//       if (vrOutOfRange(comp, "fmiSetInteger", vr[i], NUMBER_OF_INTEGERS))
//           return fmiError;
//       if (comp->loggingOn) comp->functions.logger(c, comp->instanceName, fmiOK, "log",
//            "fmiSetInteger: #i%d# = %d", vr[i], value[i]);
        comp->i[vr[i]] = value[i];
    }
    return fmiOK;
}

fmiStatus fmiSetBoolean(fmiComponent c, const fmiValueReference vr[], size_t nvr, const fmiBoolean value[]){
    int i;
    ModelInstance* comp = (ModelInstance*)c;
    if (invalidState(comp, "fmiSetBoolean", modelInstantiated|modelInitialized))
         return fmiError;
    if (nvr>0 && nullPointer(comp, "fmiSetBoolean", "vr[]", vr))
         return fmiError;
    if (nvr>0 && nullPointer(comp, "fmiSetBoolean", "value[]", value))
         return fmiError;
//    if (comp->loggingOn)
//        comp->functions.logger(c, comp->instanceName, fmiOK, "log", "fmiSetBoolean: nvr = %d",  nvr);
    for (i=0; i<nvr; i++) {
        if (vrOutOfRange(comp, "fmiSetBoolean", vr[i], NUMBER_OF_BOOLEANS))
            return fmiError;
//       if (comp->loggingOn) comp->functions.logger(c, comp->instanceName, fmiOK, "log",
//            "fmiSetBoolean: #b%d# = %s", vr[i], value[i] ? "true" : "false");
        comp->b[vr[i]] = value[i]; 
    }
    return fmiOK;
}

fmiStatus fmiSetString(fmiComponent c, const fmiValueReference vr[], size_t nvr, const fmiString value[]){
    int i;
    ModelInstance* comp = (ModelInstance*)c;
    if (invalidState(comp, "fmiSetString", modelInstantiated|modelInitialized))
         return fmiError;
    if (nvr>0 && nullPointer(comp, "fmiSetString", "vr[]", vr))
         return fmiError;
    if (nvr>0 && nullPointer(comp, "fmiSetString", "value[]", value))
         return fmiError;
//    if (comp->loggingOn)
//        comp->functions.logger(c, comp->instanceName, fmiOK, "log", "fmiSetString: nvr = %d",  nvr);
    for (i=0; i<nvr; i++) {
        if (vrOutOfRange(comp, "fmiSetString", vr[i], NUMBER_OF_STRINGS))
            return fmiError;
//       if (comp->loggingOn) comp->functions.logger(c, comp->instanceName, fmiOK, "log",
//            "fmiSetString: #s%d# = '%s'", vr[i], value[i]);
        comp->s[vr[i]] = value[i];
    }
    return fmiOK;
}

//fmiStatus fmiSetTime(fmiComponent c, fmiReal time) {
//	ModelInstance* comp = (ModelInstance*)c;
//    if (invalidState(comp, "fmiSetTime", modelInstantiated|modelInitialized))
//         return fmiError;
//    if (comp->loggingOn) comp->functions.logger(c, comp->instanceName, fmiOK, "log",
//            "fmiSetTime: time=%.16g", time);
//    comp->time = time;
//    return fmiOK;
//}

//fmiStatus fmiSetContinuousStates(fmiComponent c, const fmiReal x[], size_t nx){
//    return fmiOK;
//}

// ---------------------------------------------------------------------------
// FMI functions: get variable values from the FMU
// ---------------------------------------------------------------------------

// called by fmiGetReal, fmiGetContinuousStates and fmiGetDerivatives
// This should not be called in current implementations
fmiReal getReal(fmiComponent comp, fmiValueReference vr){
   return 0;
 }

fmiStatus fmiGetReal(fmiComponent c, const fmiValueReference vr[], size_t nvr, fmiReal value[]) {
	ModelInstance* comp = (ModelInstance*)c;
    if (invalidState(comp, "fmiGetReal", not_modelError))
        return fmiError;
    if (nvr>0 && nullPointer(comp, "fmiGetReal", "vr[]", vr))
         return fmiError;
    if (nvr>0 && nullPointer(comp, "fmiGetReal", "value[]", value))
         return fmiError;
#if NUMBER_OF_REALS>0
    int i;
    for (i=0; i<nvr; i++) {
        if (vrOutOfRange(comp, "fmiGetReal", vr[i], NUMBER_OF_REALS))
            return fmiError;
        value[i] = getReal(comp, vr[i]); // to be implemented by the includer of this file
//        if (comp->loggingOn) comp->functions.logger(c, comp->instanceName, fmiOK, "log",
//                "fmiGetReal: #r%u# = %.16g", vr[i], value[i]);
    }
#endif
    return fmiOK;
}

fmiStatus fmiGetInteger(fmiComponent c, const fmiValueReference vr[], size_t nvr, fmiInteger value[]) {
    int i;
    ModelInstance* comp = (ModelInstance*)c;
    if (invalidState(comp, "fmiGetInteger", not_modelError))
        return fmiError;
    if (nvr>0 && nullPointer(comp, "fmiGetInteger", "vr[]", vr))
         return fmiError;
    if (nvr>0 && nullPointer(comp, "fmiGetInteger", "value[]", value))
         return fmiError;
    for (i=0; i<nvr; i++) {
        if (vrOutOfRange(comp, "fmiGetInteger", vr[i], NUMBER_OF_INTEGERS))
           return fmiError;
        value[i] = comp->i[vr[i]];
//        if (comp->loggingOn) comp->functions.logger(c, comp->instanceName, fmiOK, "log",
//                "fmiGetInteger: #i%u# = %d", vr[i], value[i]);
    }
    return fmiOK;
}

fmiStatus fmiGetBoolean(fmiComponent c, const fmiValueReference vr[], size_t nvr, fmiBoolean value[]) {
    int i;
    ModelInstance* comp = (ModelInstance*)c;
    if (invalidState(comp, "fmiGetBoolean", not_modelError))
        return fmiError;
    if (nvr>0 && nullPointer(comp, "fmiGetBoolean", "vr[]", vr))
         return fmiError;
    if (nvr>0 && nullPointer(comp, "fmiGetBoolean", "value[]", value))
         return fmiError;
    for (i=0; i<nvr; i++) {
        if (vrOutOfRange(comp, "fmiGetBoolean", vr[i], NUMBER_OF_BOOLEANS))
           return fmiError;
        value[i] = comp->b[vr[i]];
//        if (comp->loggingOn) comp->functions.logger(c, comp->instanceName, fmiOK, "log",
//                "fmiGetBoolean: #b%u# = %s", vr[i], value[i]? "true" : "false");
    }
    return fmiOK;
}

fmiStatus fmiGetString(fmiComponent c, const fmiValueReference vr[], size_t nvr, fmiString  value[]) {
    int i;
    ModelInstance* comp = (ModelInstance*)c;
    if (invalidState(comp, "fmiGetString", not_modelError))
        return fmiError;
    if (nvr>0 && nullPointer(comp, "fmiGetString", "vr[]", vr))
         return fmiError;
    if (nvr>0 && nullPointer(comp, "fmiGetString", "value[]", value))
         return fmiError;
    for (i=0; i<nvr; i++) {
        if (vrOutOfRange(comp, "fmiGetString", vr[i], NUMBER_OF_STRINGS))
           return fmiError;
        value[i] = comp->s[vr[i]];
//        if (comp->loggingOn) comp->functions.logger(c, comp->instanceName, fmiOK, "log",
//                "fmiGetString: #s%u# = '%s'", vr[i], value[i]);
    }
    return fmiOK;
}

//fmiStatus fmiGetStateValueReferences(fmiComponent c, fmiValueReference vrx[], size_t nx){
//    return fmiOK;
//}

//fmiStatus fmiGetContinuousStates(fmiComponent c, fmiReal states[], size_t nx){
//    return fmiOK;
//}

//fmiStatus fmiGetNominalContinuousStates(fmiComponent c, fmiReal x_nominal[], size_t nx){
//    return fmiOK;
//}

//fmiStatus fmiGetDerivatives(fmiComponent c, fmiReal derivatives[], size_t nx) {
//    return fmiOK;
//}

//fmiStatus fmiGetEventIndicators(fmiComponent c, fmiReal eventIndicators[], size_t ni) {
//    ModelInstance* comp = (ModelInstance*)c;
//    if (invalidState(comp, "fmiGetEventIndicators", not_modelError))
//        return fmiError;
//    if (invalidNumber(comp, "fmiGetEventIndicators", "ni", ni, NUMBER_OF_EVENT_INDICATORS))
//        return fmiError;
//#if NUMBER_OF_EVENT_INDICATORS>0
//    int i;
//    for (i=0; i<ni; i++) {
//        eventIndicators[i] = getEventIndicator(comp, i); // to be implemented by the includer of this file
//        if (comp->loggingOn) comp->functions.logger(c, comp->instanceName, fmiOK, "log",
//            "fmiGetEventIndicators: z%d = %.16g", i, eventIndicators[i]);
//    }
//#endif
//    return fmiOK;
//}

// ---------------------------------------------------------------------------
// FMI functions: initialization, event handling, stepping and termination
// ---------------------------------------------------------------------------

//fmiStatus fmiInitialize(fmiComponent c, fmiBoolean toleranceControlled, fmiReal relativeTolerance,
//    fmiEventInfo* eventInfo) {
//    ModelInstance* comp = (ModelInstance*)c;
//    if (invalidState(comp, "fmiInitialize", modelInstantiated))
//         return fmiError;
//    if (nullPointer(comp, "fmiInitialize", "eventInfo", eventInfo))
//         return fmiError;
//    if (comp->loggingOn) comp->functions.logger(c, comp->instanceName, fmiOK, "log",
//        "fmiInitialize: toleranceControlled=%d relativeTolerance=%g",
//        toleranceControlled, relativeTolerance);
//    eventInfo->iterationConverged  = fmiTrue;
//    eventInfo->stateValueReferencesChanged = fmiFalse;
//    eventInfo->stateValuesChanged  = fmiFalse;
//    eventInfo->terminateSimulation = fmiFalse;
//    eventInfo->upcomingTimeEvent   = fmiFalse;
//    initialize(comp, eventInfo); // to be implemented by the includer of this file
//    comp->state = modelInitialized;
//    return fmiOK;
//}

//fmiStatus fmiEventUpdate(fmiComponent c, fmiBoolean intermediateResults, fmiEventInfo* eventInfo) {
//    ModelInstance* comp = (ModelInstance*)c;
//    if (invalidState(comp, "fmiEventUpdate", modelInitialized))
//        return fmiError;
//    if (nullPointer(comp, "fmiEventUpdate", "eventInfo", eventInfo))
//         return fmiError;
//    if (comp->loggingOn) comp->functions.logger(c, comp->instanceName, fmiOK, "log",
//        "fmiEventUpdate: intermediateResults = %d", intermediateResults);
//    eventInfo->iterationConverged  = fmiTrue;
//    eventInfo->stateValueReferencesChanged = fmiFalse;
//    eventInfo->stateValuesChanged  = fmiFalse;
//    eventInfo->terminateSimulation = fmiFalse;
//    eventInfo->upcomingTimeEvent   = fmiFalse;
//    // Not used in here.
//    // eventUpdate(comp, eventInfo); // to be implemented by the includer of this file
//    return fmiOK;
//}

//fmiStatus fmiCompletedIntegratorStep(fmiComponent c, fmiBoolean* callEventUpdate){
//    ModelInstance* comp = (ModelInstance*)c;
//    if (invalidState(comp, "fmiCompletedIntegratorStep", modelInitialized))
//         return fmiError;
//    if (nullPointer(comp, "fmiCompletedIntegratorStep", "callEventUpdate", callEventUpdate))
//         return fmiError;
//    if (comp->loggingOn) comp->functions.logger(c, comp->instanceName, fmiOK, "log",
//            "fmiCompletedIntegratorStep");
//    *callEventUpdate = fmiFalse;
//    return fmiOK;
//}

fmiStatus fmiTerminateSlave(fmiComponent c){
//    ModelInstance* comp = (ModelInstance*)c;
//    if (invalidState(comp, "fmiTerminate", modelInitialized))
//         return fmiError;
//    if (comp->loggingOn) comp->functions.logger(c, comp->instanceName, fmiOK, "log",
//        "fmiTerminate");
//    comp->state = modelTerminated;
    return fmiOK;
}

