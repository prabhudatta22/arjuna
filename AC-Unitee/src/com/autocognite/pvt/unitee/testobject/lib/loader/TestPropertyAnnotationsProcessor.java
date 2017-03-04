package com.autocognite.pvt.unitee.testobject.lib.loader;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

import com.autocognite.arjuna.annotations.TestClass;
import com.autocognite.arjuna.annotations.TestMethod;
import com.autocognite.batteries.util.DataBatteries;
import com.autocognite.pvt.unitee.core.lib.testvars.InternalTestVariables;
import com.autocognite.pvt.unitee.testobject.lib.definitions.JavaTestClassDefinition;
import com.autocognite.pvt.unitee.testobject.lib.definitions.JavaTestMethodDefinition;

public class TestPropertyAnnotationsProcessor {

	public static void populateTestProps(JavaTestClassDefinition classDef, InternalTestVariables testVars) throws Exception {
		if (classDef.getUserTestClass().isAnnotationPresent(TestClass.class)){
			Annotation annotation = classDef.getUserTestClass().getAnnotation(TestClass.class);
			TestClass testProps = (TestClass) annotation;
			setAnnotatedProperties(testVars, testProps);
		
			if (testVars.testProps().priority() < 1){
				System.err.println(String.format("You must provide prioriy >=1. Correction needed for: %s", classDef.getQualifiedName()));
				System.err.println("Exiting...");
				System.exit(1);
			}
		}
	}
	
	public static void populateTestProps(JavaTestMethodDefinition methodDef, InternalTestVariables testVars) throws Exception {
		if (methodDef.getMethod().isAnnotationPresent(TestMethod.class)){
			Annotation annotation = methodDef.getMethod().getAnnotation(TestMethod.class);
			TestMethod testProps = (TestMethod) annotation;
			setAnnotatedProperties(testVars, testProps);
		}
	}
	
	private static void setId(InternalTestVariables testVars, String id) throws Exception{
		if (!id.equals("NOT_SET")){
			testVars.rawTestProps().setId(id);
		}
	}
	
	private static void setName(InternalTestVariables testVars, String name) throws Exception{
		if (!name.equals("NOT_SET")){
			testVars.rawTestProps().setName(name);
		}
	}
	
	private static void setIdea(InternalTestVariables testVars, String idea) throws Exception{
		if (!idea.equals("NOT_SET")){
			testVars.rawTestProps().setIdea(idea);
		}
	}
	
	private static void setPriority(InternalTestVariables testVars, int priority) throws Exception{
		if (priority >= 1){
			testVars.rawTestProps().setPriority(priority);
		} else if ((priority < 1) && (priority != -51111)){
			System.err.println(String.format("Provided priority: %d", priority));
			System.err.println(String.format("You must provide prioriy >=1. Correction needed for: %s", testVars.objectProps().qualifiedName()));
			System.err.println("Exiting...");
			System.exit(1);
		}
	}
	
	private static void setAnnotatedProperties(InternalTestVariables testVars, TestClass testProps) throws Exception{
		setId(testVars, testProps.id());
		setName(testVars, testProps.name());
		setIdea(testVars, testProps.idea());
		setPriority(testVars, testProps.priority());
		setCustomProps(testVars, testProps.customProps());
	}
	
	private static void setAnnotatedProperties(InternalTestVariables testVars, TestMethod testProps) throws Exception{
		setId(testVars, testProps.id());
		setName(testVars, testProps.name());
		setIdea(testVars, testProps.idea());
		setPriority(testVars, testProps.priority());
		setCustomProps(testVars, testProps.customProps());
	}
	
	private static void setCustomProps(InternalTestVariables testVars, String[] customProps) throws Exception{
		for (String kv: customProps){
			ArrayList<String> pKV = DataBatteries.split(kv, "=");
			String propName = pKV.get(0);
			String propValue = pKV.get(1);
			testVars.customProps().add(propName, propValue);
		}		
	}
}
