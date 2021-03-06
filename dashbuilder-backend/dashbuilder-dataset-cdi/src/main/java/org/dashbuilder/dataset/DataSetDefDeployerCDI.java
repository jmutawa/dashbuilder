/*
 * Copyright 2014 Red Hat, Inc. and/or its affiliates.
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
package org.dashbuilder.dataset;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.dashbuilder.DataSetCore;
import org.dashbuilder.config.Config;

@ApplicationScoped
public class DataSetDefDeployerCDI extends DataSetDefDeployer {

    public DataSetDefDeployerCDI() {
    }

    @Inject
    public DataSetDefDeployerCDI(@Config("") String directory,
                                 @Config("3000") int scanIntervalInMillis,
                                 DataSetDefRegistryCDI dataSetDefRegistry) {

        super(DataSetCore.get().getDataSetDefJSONMarshaller(), dataSetDefRegistry);
        super.setScanIntervalInMillis(scanIntervalInMillis);
    }

    @PostConstruct
    public void init() {
        if (!StringUtils.isBlank(directory)) {
            deploy(directory);
        }
    }

    @PreDestroy
    public synchronized void stop() {
        super.stop();
    }
}
