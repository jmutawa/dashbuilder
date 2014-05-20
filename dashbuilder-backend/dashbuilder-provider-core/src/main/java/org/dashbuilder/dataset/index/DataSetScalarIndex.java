/**
 * Copyright (C) 2014 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dashbuilder.dataset.index;

import org.dashbuilder.dataset.index.stats.SizeEstimator;

/**
 * An scalar value index
 */
public class DataSetScalarIndex extends DataSetIndexElement {

    Double value = null;

    public DataSetScalarIndex(Double value, long buildTime) {
        super(buildTime);
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public long getEstimatedSize() {
        long result = super.getEstimatedSize();
        if (value != null) {
            result += SizeEstimator.sizeOfDouble;
        }
        return result;
    }
}
