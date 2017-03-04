package com.autocognite.pvt.unitee.core.lib.testvars;

import com.autocognite.arjuna.enums.TestObjectType;
import com.autocognite.arjuna.interfaces.TestObjectProperties;
import com.autocognite.batteries.databroker.DataRecord;
import com.autocognite.batteries.databroker.ReadOnlyDataRecord;
import com.autocognite.batteries.value.Value;
import com.autocognite.pvt.arjuna.enums.TestObjectAttribute;
import com.autocognite.pvt.batteries.container.ValueContainer;
import com.autocognite.pvt.batteries.value.IntValue;
import com.autocognite.pvt.batteries.value.StringValue;
import com.autocognite.pvt.batteries.value.ValueType;

public interface InternalTestObjectProperties 
				extends TestObjectProperties, ValueContainer<TestObjectAttribute>{
	
	void setObjectId(String name) throws Exception;
	
	void setObjectType(Value value) throws Exception;

	void setObjectType(TestObjectType type) throws Exception;
	
	void setParentName(Value value) throws Exception;
	
	void setParentQualifiedName(String name) throws Exception;
	
	void setClassInstanceNumber(Value value) throws Exception;
	
	void setClassInstanceNumber(int num) throws Exception;
	
	void setName(Value value) throws Exception;
	
	void setName(String name) throws Exception;
	
	void setMethodInstanceNumber(Value value) throws Exception;
	
	void setMethodInstanceNumber(int num) throws Exception;

	void setTestNumber(Value value) throws Exception;
	
	void setTestNumber(int num) throws Exception;
	
	void setSessionName(Value value) throws Exception;
	
	void setSessionName(String name) throws Exception;

	ValueType valueType(TestObjectAttribute propType);

	ValueType valueType(String strKey);

	TestObjectAttribute key(String strKey);

	Class valueEnumType(String strKey);

	void populateDefaults() throws Exception;

	void setGroupName(String groupName) throws Exception;

	void setThreadId(String id) throws Exception;
	
	void setDataRecord(DataRecord dataRecord) throws Exception;
	
	void setSessionNodeName(Value value) throws Exception;	
	void setSessionNodeName(String name) throws Exception;		
	void setSessionNodeId(Value value) throws Exception;	
	void setSessionNodeId(int id) throws Exception;		
	void setSessionSubNodeId(Value value) throws Exception;	
	void setSessionSubNodeId(int id) throws Exception;

	void setBeginTstamp() throws Exception;
	void setEndTstamp() throws Exception;	
}
