package com.autocognite.pvt.unitee.reporter.lib.issue;

import com.autocognite.pvt.unitee.core.lib.testvars.InternalTestVariables;
import com.autocognite.pvt.unitee.reporter.lib.reportable.ResultDeserializer;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonObject;

public class IssueDeserializer extends ResultDeserializer<Issue> implements JsonDeserializer<Issue> {
	
	public Issue process(JsonObject root){
		IssueBuilder builder = null;
		InternalTestVariables testVars = getTestVars(root);
		Issue outResult = null;

		try{
			builder = new IssueBuilder();

			//Deserialize autoProps
			JsonObject resultPropsObj = root.get("resultProps").getAsJsonObject();
			IssueProperties resultProps = new IssueProperties();
			processJsonObjectForEnumMap(resultPropsObj, resultProps);
	
			outResult = builder.resultProps(resultProps).testVariables(testVars).build();
		} catch (Exception e){
			e.printStackTrace();
		}

		return outResult;		
	}

}
