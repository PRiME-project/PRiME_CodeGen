#include <string.h>
#include "common.h"

ModelInstance modelInstances[MaxFMUInstances]; // start of with an empty array of components
int conInstanceCount = 0;

//## <fmuOthers.c> 			-- expand the SDKs (remember it's FMU version 1) functions

//## <variableDeclarations>  -- generate variable declarations here

//## <fmiInstantiate.c>     -- expand template here

//## <fmiInitializeSlave.c> -- expand template here

// Subroutines Generated from Events

//## <subroutineList>		-- generate subroutine implementations here
