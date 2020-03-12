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

from arjuna import *

@test
def check_multielement(request, logged_in_wordpress):
    wordpress = logged_in_wordpress
    wordpress.posts.click()
    wordpress.categories.click()

    check_boxes = wordpress.cat_checkboxes
    check_boxes[1].check()
    check_boxes[1].uncheck()
    check_boxes.get_first_element().uncheck()
    check_boxes.get_last_element().uncheck()
    check_boxes.get_random_element().uncheck()