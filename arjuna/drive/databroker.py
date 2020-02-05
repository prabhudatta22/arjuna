'''
This file is a part of Arjuna
Copyright 2015-2020 Rahul Verma

Website: www.RahulVerma.net

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
'''

import os
from .source import *

class DataBroker:

    def __init__(self):
        self.__data_sources = {}

    def create_file_data_source(self, data_dir, file_name, record_format="MAP", delimiter="\t"):
        ds = None
        ext = file_name.lower()
        path = os.path.join(data_dir, file_name)
        rformat = record_format.upper()
        if ext.endswith(".csv") or ext.endswith(".txt"):
            if rformat == "LIST":
                ds = DsvFileListDataSource(path, delimiter)
            else:
                ds = DsvFileMapDataSource(path, delimiter)
        elif ext.endswith(".xls"):
            if rformat == "LIST":
                ds = ExcelFileListDataSource(path)
            else:
                ds = ExcelFileMapDataSource(path)
        elif ext.endswith(".ini"):
            ds = IniFileDataSource(path)
        else:
            raise Exception("This is not a default file format supported as a data source: " + path)
        self.__data_sources[ds.setu_id] = ds
        return ds.setu_id

    def get_next_record(self, ds_setu_id):
        ds = self.__data_sources[ds_setu_id]
        return ds.next().record

    def get_all_records(self, ds_setu_id):
        ds = self.__data_sources[ds_setu_id]
        out = []
        while True:
            try:
                record = ds.next().record
                out.append(record)
            except:
                break
        return out

    def reset(self, ds_setu_id):
        ds = self.__data_sources[ds_setu_id]
        return ds.reset()