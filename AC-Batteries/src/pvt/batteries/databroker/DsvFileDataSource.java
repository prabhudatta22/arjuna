/*******************************************************************************
 * Copyright 2015-16 AutoCognite Testing Research Pvt Ltd
 * 
 * Website: www.AutoCognite.com
 * Email: support [at] autocognite.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package pvt.batteries.databroker;

import com.arjunapro.ddt.datarecord.DefaultDataRecord;
import com.arjunapro.ddt.interfaces.DataRecord;
import com.arjunapro.ddt.interfaces.DataSource;
import com.arjunapro.testauto.exceptions.DataSourceFinishedException;

import pvt.batteries.filehandler.FileLine2ArrayReader;

public class DsvFileDataSource implements DataSource {
	FileLine2ArrayReader reader = null;
	String[] headers = null;

	public DsvFileDataSource(String path, String delimiter) throws Exception {
		reader = new FileLine2ArrayReader(path, delimiter);
		headers = reader.getHeaders();
	}

	public DsvFileDataSource(String path) throws Exception {
		this(path, "\\t");
	}

	public synchronized DataRecord next() throws DataSourceFinishedException {
		String[] dataRecord = reader.next();

		if (dataRecord == null) {
			throw new DataSourceFinishedException("Records Finished.");
		} else {
			return new DefaultDataRecord(this.headers, dataRecord);
		}
	}

}