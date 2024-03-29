/*

   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */
package org.apache.batik.test;

/**
 * Exception which Tests can throw when a specific assertion fails.
 *
 * @author <a href="mailto:vhardy@apache.org">Vincent Hardy</a>
 * @version $Id: AssertException.java 475477 2006-11-15 22:44:28Z cam $
 */
public abstract class AssertException extends TestErrorConditionException {
    public static final String ENTRY_KEY_ASSERTION_TYPE 
        = "AssertException.entry.key.assertion.type";

    /**
     * <tt>TestErrorConditionException</tt> implementation.
     */
    public TestReport getTestReport(Test test){
        report.setErrorCode(TestReport.ERROR_ASSERTION_FAILED);
        report.addDescriptionEntry(ENTRY_KEY_ASSERTION_TYPE,
                                   getAssertionType());
        addDescription(report);
        addStackTraceDescription(report);  
        report.setPassed(false);
        return report;
    }

    /**
     * Requests that the exception populates the TestReport with the
     * relevant information.
     */
    public abstract void addDescription(TestReport report);

    /**
     * Returns the type of assertion which failed. e.g., "assertEquals"
     */
    public abstract String getAssertionType();
}
