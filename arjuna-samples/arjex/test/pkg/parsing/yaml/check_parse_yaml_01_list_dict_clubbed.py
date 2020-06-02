# This file is a part of Arjuna
# Copyright 2015-2020 Rahul Verma

# Website: www.RahulVerma.net

# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at

#   http://www.apache.org/licenses/LICENSE-2.0

# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

# The tests are based on tests for jsonpath-rw-ext in https://github.com/wolverdude/GenSON

import yaml
from arjuna import *
from arjuna.tpi.parser.yaml import Yaml

@test
def check_dict(request):
    test = '''
name: sample
age: sample
'''

    test2 = '''
- name: sample
- age: sample
'''

    # Raw
    out = yaml.safe_load(test)
    print(out, type(out))
    out = yaml.safe_load(test2)
    print(out, type(out))

    # With Arjuna
    yaml_node = Yaml.from_str(test, name="test")
    print(yaml_node)
