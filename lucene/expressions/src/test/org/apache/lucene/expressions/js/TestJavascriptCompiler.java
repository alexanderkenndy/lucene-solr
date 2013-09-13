package org.apache.lucene.expressions.js;
/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.text.ParseException;

import org.apache.lucene.util.LuceneTestCase;

public class TestJavascriptCompiler extends LuceneTestCase {
  
  public void testValidCompiles() throws Exception {
    assertNotNull(JavascriptCompiler.compile("100"));
    assertNotNull(JavascriptCompiler.compile("valid0+100"));
    assertNotNull(JavascriptCompiler.compile("logn(2, 20+10-5.0)"));
  }
  
  public void testInvalidCompiles() throws Exception {
    try {
      JavascriptCompiler.compile("100 100");
      fail();
    } catch (ParseException expected) {
      // expected exception
    }
    
    try {
      JavascriptCompiler.compile("7*/-8");
      fail();
    } catch (ParseException expected) {
      // expected exception
    }
  }
}