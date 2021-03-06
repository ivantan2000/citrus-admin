/*
 * Copyright 2006-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.consol.citrus.admin.converter.action;

import com.consol.citrus.admin.converter.ObjectConverter;
import com.consol.citrus.admin.model.TestAction;

/**
 * @author Christoph Deppisch
 */
public interface TestActionConverter<S, T extends com.consol.citrus.TestAction> extends ObjectConverter<TestAction, S> {


    @Override
    TestAction convert(S model);

    /**
     * Gets the action type name.
     * @return
     */
    String getActionType();

    /**
     * Converts raw test action Java model to JaxB object model source.
     * @param model
     * @return
     */
    S convertModel(T model);

    /**
     * Gets the test action model class.
     * @return
     */
    Class<T> getActionModelClass();
}
